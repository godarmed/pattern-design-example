package com.godarmed.patterndesign.abstractdocument.domain;

import com.godarmed.patterndesign.abstractdocument.AbstractDocument;

import java.util.Map;

/**
 * 片段实体
 */
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {

    public Part(Map<String, Object> properties) {
        super(properties);
    }

}