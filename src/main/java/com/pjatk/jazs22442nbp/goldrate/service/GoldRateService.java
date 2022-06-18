package com.pjatk.jazs22442nbp.goldrate.service;

import com.pjatk.jazs22442nbp.goldrate.model.GoldRate;
import com.pjatk.jazs22442nbp.goldrate.model.GoldRateRequest;
import com.pjatk.jazs22442nbp.goldrate.model.GoldType;
import com.pjatk.jazs22442nbp.goldrate.repository.GoldRateRepository;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GoldRateService {
    private final GoldRateRepository goldRateRepository;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String NBP_URL = "https://api.nbp.pl/api/cenyzlota/";
    private final RestTemplate restTemplate;

    GoldRateService(GoldRateRepository goldRateRepository, RestTemplate restTemplate) {
        this.goldRateRepository = goldRateRepository;
        this.restTemplate = restTemplate;
    }

    public Double getGoldRateByDates(String startDateStr, String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr, this.dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(endDateStr, this.dateTimeFormatter);
        LocalDate requestDate = LocalDate.now();

        GoldRate[] goldRates = this.restTemplate.exchange(NBP_URL + startDateStr + "/" + endDateStr, HttpMethod.GET, null, GoldRate[].class).getBody();

        Double averageRate = Double.valueOf(0);
        for (GoldRate goldRate : goldRates) {
            averageRate += goldRate.getCena();
        }
        averageRate /= goldRates.length;

        GoldRateRequest goldRateRequest = new GoldRateRequest(GoldType.NORMAL, startDate, endDate, averageRate, requestDate);

        this.goldRateRepository.save(goldRateRequest);

        return averageRate;
    }
}
