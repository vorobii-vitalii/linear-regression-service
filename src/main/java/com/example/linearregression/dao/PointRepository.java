package com.example.linearregression.dao;

import com.example.linearregression.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PointRepository extends JpaRepository<Point, Double> {

  @Query(value = "SELECT regr_slope(Y, X) slope FROM POINT", nativeQuery = true)
  Double findSlope();

  @Query(value = "SELECT regr_intercept(Y, X) intercept FROM POINT", nativeQuery = true )
  Double findIntercept();

}
