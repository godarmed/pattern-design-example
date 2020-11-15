package com.godarmed.patterndesign.abstractdocument;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 文档接口的抽象实现
 */
public abstract class AbstractDocument implements Document{

    private final Map<String, Object> properties;

    protected AbstractDocument(Map<String, Object> properties){
        Objects.requireNonNull(properties, "properties map is required");
        this.properties = properties;
    }


    @Override
    public Void put(String key, Object value) {
        properties.put(key, value);
        return null;
    }

    @Override
    public Object get(String key) {
        return properties.get(key);
    }

    @Override
    public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
        final List<Map<String, Object>> children = (List<Map<String, Object>>) get(key);
        return children == null
                ? Stream.empty()
                : children.stream().map(constructor);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("[");
        properties.forEach((key, value) -> builder.append("[").append(key).append(" : ").append(value)
                .append("]"));
        builder.append("]");
        return builder.toString();
    }


}
