package com.activation.integral.app.coeff;

import com.activation.integral.app.detectorprops.EffectiveCenter;
import com.activation.integral.app.elements.Element;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Arip {

    @Getter
    private double aripValue;

    public Arip(EffectiveCenter effectiveCenter, Element element) {
        double lambda = Math.log(2) / element.getHalfLife();
        final double avogadro = 6.022 * Math.pow(10, 23);
        double energyForEffectiveness = 10; // TODO энергия для которой из мапы берется эффективность регистрации
        double effectiveness = effectiveCenter.getRegistrationEffectiveness().get(energyForEffectiveness);
        this.aripValue = element.getMolarMass() /
                (element.getIsotopeConcentration() * lambda * avogadro * effectiveness * element.getNumOfGammaOnOneDecay());
    }
}
