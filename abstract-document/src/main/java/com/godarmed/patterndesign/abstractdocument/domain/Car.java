package com.godarmed.patterndesign.abstractdocument.domain;

import com.godarmed.patterndesign.abstractdocument.AbstractDocument;

import java.util.Map;

/**
 * 汽车实体
 */
public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {

    public Car(Map<String, Object> properties) {
        super(properties);
    }

}
