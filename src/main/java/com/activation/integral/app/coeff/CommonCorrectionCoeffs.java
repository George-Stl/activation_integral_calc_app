package com.activation.integral.app.coeff;

import com.activation.integral.app.detectorprops.EffectiveCenter;
import lombok.Getter;

public class CommonCorrectionCoeffs {

    private GammaSelfAbsorpCorrection gammaSelfAbsorpCorrection;
    private final double H = 10;
    private final double efd;

    public CommonCorrectionCoeffs(EffectiveCenter effectiveCenter) {
        this.efd = effectiveCenter.getEffectiveCenterDist();
    }

    public class GammaSelfAbsorpCorrection {

        @Getter
        private double gammaSelfCorrValue;
        private double globalMassCoeff;

        public GammaSelfAbsorpCorrection(PhotonMassCoeff photonMassCoeff,
                                         DetectorProps detectorProps) {
            this.globalMassCoeff = photonMassCoeff.massCoeffValue;
            double thickness = detectorProps.getThickness();
            this.gammaSelfCorrValue = (globalMassCoeff * thickness) / (1 - Math.exp(-globalMassCoeff * thickness));
        }

        private class PhotonMassCoeff {
            private double massCoeffValue;

            private PhotonMassCoeff(CosAlpha cosAlpha) {
                double cosAlphaValue = cosAlpha.cosAlphaValue;
                this.massCoeffValue = globalMassCoeff * (Math.log(cosAlphaValue) / (cosAlphaValue - 1));
            }
        }

        private class CosAlpha {
            private double cosAlphaValue;

            private CosAlpha(EffectiveCenter effectiveCenter) {
                final double D = effectiveCenter.getCrystalDiameter();
                this.cosAlphaValue = (H + efd) / (Math.sqrt(Math.pow(D, 2) / 4 + Math.pow(H + efd, 2)));
            }
        }
    }

    public class GeometryCorrection {

        @Getter
        private double geomCorrValue;

        public GeometryCorrection(DetectorProps detectorProps) {
            double h = detectorProps.getThickness() / 10; // из мм в см
            this.geomCorrValue = Math.pow((H + (h / 2) + efd), 2)
                    / Math.pow(H + efd, 2);
        }
    }

    public class DetectorSizeCorrection {

        @Getter
        private double detSizeCorrValue;

        public DetectorSizeCorrection(DetectorProps detectorProps) {
            double R = detectorProps.getRadius();
            this.detSizeCorrValue = Math.pow(R, 2)
                / (Math.pow(H + efd, 2) * Math.log(1 + Math.pow(R, 2) / Math.pow(H + efd, 2)));
        }

    }

}
