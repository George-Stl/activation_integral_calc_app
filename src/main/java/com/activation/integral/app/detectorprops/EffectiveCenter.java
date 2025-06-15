package com.activation.integral.app.detectorprops;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EffectiveCenter {

    private List<Double> sourceDetectorDistance;

    @Getter
    private Map<Double, Double> registrationEffectiveness;

    @Getter
    private double effectiveCenterDist;

    @Getter
    private double crystalDiameter;

}
