package com.activation.integral.app.service;

import com.activation.integral.app.coeff.CommonCorrectionCoeffs;
import com.activation.integral.app.coeff.DecayCorrectionCoeffs;
import com.activation.integral.app.coeff.DetectorProps;
import com.activation.integral.app.elements.Element;
import javafx.scene.control.TableRow;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntegralCalculation {

    public CalculationResult calculateNumberOfReactions(Element element, DetectorProps detector, DecayCorrectionCoeffs decayCorrectionCoeffs,
                                             CommonCorrectionCoeffs commonCorrectionCoeffs, List<Integer> peakAreas) {
        CalculationResult result = new CalculationResult();
        List<TableRow> tableData = new ArrayList<>();
        DecayCorrectionCoeffs decayCorrectionCoeffs = decayCorrectionCoeffs;
        for (int i = 0; i < peakAreas.size(); i++) {
            double K1 = DecayCorrectionCoeffs.ExposureTimeCoeff
            double actIntegral = peakArea * K1 * K2 * K3
            tableData.add(new TableRow())
        }

    }


    public class CalculationResult {

        @Setter
        @Getter
        private double reactions;

        @Setter
        @Getter
        private List<TableRow> tableData;
    }
}

