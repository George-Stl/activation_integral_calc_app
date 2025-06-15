package com.activation.integral.app.service;

import com.activation.integral.app.database.ElementEntity;
import com.activation.integral.app.database.ElementRepository;
import com.activation.integral.app.elements.Aluminium;
import com.activation.integral.app.elements.Element;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ElementFactory {
    private final ElementRepository repository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ElementFactory(ElementRepository repository) {
        this.repository = repository;
        this.objectMapper = new ObjectMapper();
    }

    public Element createElement(String elementName) {
        ElementEntity elementEntity = repository.findByName(elementName.toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException("Unknown element: " + elementName));

        try {
            Map<Integer, Double> crossSection = objectMapper.readValue(
                    elementEntity.getCrossSection(),
                    new TypeReference<Map<Integer, Double>>() {}
            );

            List<Double> gammaLines = objectMapper.readValue(
                    elementEntity.getGammaLines(),
                    new TypeReference<List<Double>>() {}
            );

            List<Double> massAbsorpCoeff = objectMapper.readValue(
                    elementEntity.getMassAbsorpCoeff(),
                    new TypeReference<List<Double>>() {}
            );

            switch (elementName.toUpperCase()) {
                case "ALUMINIUM":
                    return new Aluminium(crossSection,
                            gammaLines,
                            elementEntity.getHalfLife(),
                            massAbsorpCoeff,
                            elementEntity.getDensity(),
                            elementEntity.getMolarMass(),
                            elementEntity.getIsotopeConcentration(),
                            elementEntity.getNumOfGammaOnOneDecay());
                case "INDIUM":
                    // TODO добавить индий
                case "FLUOROPLAST":
                    // TODO добавить фторопласт
                default:
                    throw new IllegalArgumentException("Unknown element: " + elementName);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
