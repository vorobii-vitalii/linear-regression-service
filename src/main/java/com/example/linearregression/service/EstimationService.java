package com.example.linearregression.service;

import java.util.List;

public interface EstimationService {
  void addDataForEstimation(List<Double[]> data);
  Double calculateEstimation(Double x);
}
