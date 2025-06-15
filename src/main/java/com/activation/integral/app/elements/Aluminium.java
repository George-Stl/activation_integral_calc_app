package com.activation.integral.app.elements;

import java.util.List;
import java.util.Map;

public class Aluminium extends Element {

    public Aluminium(Map<Integer, Double> crossSection,
                     List<Double> gammaLines,
                     int halfLife,
                     List<Double> massAbsorpCoeff,
                     double density,
                     double molarMass,
                     double isotopeConcentration,
                     short numOfGammaOnOneDecay) {
        setCrossSection(crossSection);
        setGammaLines(gammaLines);
        setHalfLife(halfLife);
        setMassAbsorpCoeff(massAbsorpCoeff);
        setDensity(density);
        setMolarMass(molarMass);
        setIsotopeConcentration(isotopeConcentration);
        setNumOfGammaOnOneDecay(numOfGammaOnOneDecay);
    }
}
