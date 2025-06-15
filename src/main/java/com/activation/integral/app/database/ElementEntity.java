package com.activation.integral.app.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "elements")
public class ElementEntity {
    @Id
    private Long id;

    @Getter
    private String name;

    @Getter
    @Column(columnDefinition = "json")
    private String crossSection;

    @Getter
    @Column(columnDefinition = "json")
    private String gammaLines;

    @Getter
    private int halfLife;

    @Getter
    @Column(columnDefinition = "json")
    private String massAbsorpCoeff;

    @Getter
    private double density;

    @Getter
    private double molarMass;

    @Getter
    private double isotopeConcentration;

    @Getter
    private short numOfGammaOnOneDecay;
}
