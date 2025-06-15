package com.activation.integral.app.coeff;

import com.activation.integral.app.elements.Element;
import lombok.Getter;
import lombok.Setter;

public class DetectorProps {

    @Getter
    @Setter
    private double radius;

    @Getter
    @Setter
    private double thickness; // миллиметры

    @Getter
    private double thicknessGramsOnCentims = element.get;

    @Getter
    @Setter
    private Element element;
}
