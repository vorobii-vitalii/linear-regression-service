package com.example.linearregression.service.impl;

import com.example.linearregression.dao.PointRepository;
import com.example.linearregression.domain.Point;
import com.example.linearregression.service.EstimationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstimationServiceImpl implements EstimationService {
  private final PointRepository pointRepository;

  @Override
  public void addDataForEstimation(List<Double[]> data) {
    if (Objects.isNull(data)) {
      throw new IllegalArgumentException();
    }
    var pointsToSave = data.stream()
      .filter(Objects::nonNull)
      .map(doubleArray ->
        Point.builder()
          .x(doubleArray[0])
          .y(doubleArray[1])
          .build())
      .collect(Collectors.toList());

    pointRepository.saveAll(pointsToSave);
  }

  @Override
  public Double calculateEstimation(Double x) {
    var intercept = pointRepository.findIntercept();
    var slope = pointRepository.findSlope();

    return x * slope + intercept;
  }

}
