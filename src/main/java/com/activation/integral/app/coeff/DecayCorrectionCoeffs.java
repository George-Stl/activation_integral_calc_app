package com.activation.integral.app.coeff;

import com.activation.integral.app.elements.Element;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DecayCorrectionCoeffs {

    @Getter
    private List<Double> exposureTimeCoeff = new ArrayList<>();

    @Getter
    private List<Double> downTimeCoeff = new ArrayList<>();

    @Getter
    private List<Double> decayTimeCoeff = new ArrayList<>();

    DecayCorrectionCoeffs(Element element, UsersTable table) {
        double lambda = Math.log(2) / element.getHalfLife();
        // вычисление коэффициента распада во время облучения
        for (Integer exposureTime : table.exposureTimes) {
            exposureTimeCoeff.add((lambda * exposureTime) / (1 - Math.exp(-lambda * exposureTime)));
        }

        for (Integer downTime : table.downTimes) {
            downTimeCoeff.add(1 / (Math.exp(-lambda * downTime)));
        }

        for (Integer decayTime : table.realDecayTimes) {
            decayTimeCoeff.add((lambda * decayTime) / (1 - Math.exp(-lambda * decayTime)));
        }
    }
}
