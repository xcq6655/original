package com.xcq.original.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Production {

    private Integer id;

    private String productName;

    private String specifications;

    private String model;

    private Double size;

    private Integer factory;

    private String voltage;

    private String inspector;

    private LocalDate dateOfManufacture;

    private String productStandard;
}
