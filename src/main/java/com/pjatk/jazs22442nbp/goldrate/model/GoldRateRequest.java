package com.pjatk.jazs22442nbp.goldrate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ApiModel(value = "Gold Rate Request", description = "A request of gold rate")
public class GoldRateRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "The unique identifier of the given request")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "The type of the requested gold")
    private GoldType goldType;

    @ApiModelProperty(value = "The start date of requested time period")
    private LocalDate startDate;

    @ApiModelProperty(value = "The end date of requested time period")
    private LocalDate endDate;

    @ApiModelProperty(value = "The calculated average gold rate")
    private Double averageRate;

    @ApiModelProperty(value = "The date of the request")
    private LocalDateTime requestDate;

    public GoldRateRequest() {
    }

    public GoldRateRequest(GoldType goldType, LocalDate startDate, LocalDate endDate, Double averageRate, LocalDateTime requestDate) {
        this.goldType = goldType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.averageRate = averageRate;
        this.requestDate = requestDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GoldType getGoldType() {
        return goldType;
    }

    public void setGoldType(GoldType goldType) {
        this.goldType = goldType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(Double averageRate) {
        this.averageRate = averageRate;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }
}
