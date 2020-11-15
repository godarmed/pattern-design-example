package com.godarmed.patterndesign.abstractdocument;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 文档接口
 */
public interface Document {

    /**
     * 设置与键相关的值
     *
     * @param key   element key
     * @param value element value
     * @return Void
     */
    Void put(String key, Object value);

    /**
     * 根据键对应的值
     *
     * @param key element key
     * @return value or null
     */
    Object get(String key);

    /**
     * 获取子文档的流
     *
     * @param key         element key
     * @param constructor constructor of child class
     * @return child documents
     */
    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);

}
