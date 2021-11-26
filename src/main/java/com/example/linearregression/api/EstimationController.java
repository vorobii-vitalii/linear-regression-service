package com.example.linearregression.api;

import com.example.linearregression.service.EstimationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estimation")
@RequiredArgsConstructor
public class EstimationController {
  private final EstimationService estimationService;

  @GetMapping("/{x}")
  public Double getEstimation(@PathVariable("x") Double x) {
    return estimationService.calculateEstimation(x);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping
  public void addData(@RequestBody List<Double[]> data) {
    estimationService.addDataForEstimation(data);
  }

}
