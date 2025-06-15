package com.activation.integral.app.elements;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

public abstract class Element {

    @Getter
    @Setter
    private Map<Integer, Double> crossSection;

    @Getter
    @Setter
    private List<Double> gammaLines;

    @Getter
    @Setter
    private int halfLife;

    @Getter
    @Setter
    private List<Double> massAbsorpCoeff; // массовый коэффициент поглощения фотонов в материале ДНА см2/г

    @Getter
    @Setter
    private double density; // плотность в г/см2

    @Getter
    @Setter
    private double molarMass; // молярн масс г/моль

    @Getter
    @Setter
    private double isotopeConcentration; // содерж изотоп в элем. в долях единицы

    @Getter
    @Setter
    private short numOfGammaOnOneDecay; // кол-во гамма-квантов на 1 распад
}
