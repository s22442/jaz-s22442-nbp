package com.pjatk.jazs22442nbp.goldrate.controller;

import com.pjatk.jazs22442nbp.goldrate.service.GoldRateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GoldRateController {

    public GoldRateService goldRateService;

    GoldRateController(GoldRateService goldRateService) {
        this.goldRateService = goldRateService;
    }

    @GetMapping("/gold/{startDate}/{endDate}")
    @ApiOperation(value = "Get average gold rate", notes = "Get average gold rate of the given time period", response = Double.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Double.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")

    })
    public ResponseEntity<Double> getMovieById(@PathVariable String startDate, @PathVariable String endDate) {
        return ResponseEntity.ok(goldRateService.getGoldRateByDates(startDate, endDate));
    }
}
