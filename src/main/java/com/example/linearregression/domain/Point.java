package com.example.linearregression.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POINT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Point {

  @Id
  @Column(name = "X")
  @Basic(optional = false)
  private Double x;

  @Column(name = "Y")
  @Basic(optional = false)
  private Double y;

}
