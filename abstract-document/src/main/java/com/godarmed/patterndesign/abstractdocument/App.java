/*
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.godarmed.patterndesign.abstractdocument;

import com.godarmed.patterndesign.abstractdocument.domain.Car;
import com.godarmed.patterndesign.abstractdocument.domain.enums.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The Abstract Document pattern enables handling additional, non-static properties. This pattern
 * uses concept of traits to enable type safety and separate properties of different classes into
 * set of interfaces.
 *
 * <p>In Abstract Document pattern,({@link AbstractDocument}) fully implements {@link Document})
 * interface. Traits are then defined to enable access to properties in usual, static way.
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static void main(String[] args) {
    LOGGER.info("Constructing parts and car");

    Map<String, Object> wheelProperties = new HashMap<String, Object>(){{
        put(Property.TYPE.toString(), "wheel");
        put(Property.MODEL.toString(), "15C");
        put(Property.PRICE.toString(), 100L);
    }};

    Map<String, Object> doorProperties = new HashMap<String, Object>(){{
        put(Property.TYPE.toString(), "door");
        put(Property.MODEL.toString(), "Lambo");
        put(Property.PRICE.toString(), 300L);
    }};

    Map<String, Object> carProperties = new HashMap<String, Object>(){{
        put(Property.MODEL.toString(), "300SL");
        put(Property.PRICE.toString(), 10000L);
        put(Property.PARTS.toString(), Arrays.asList(wheelProperties, doorProperties));
    }};

    Car car = new Car(carProperties);

    LOGGER.info("Here is our car:");
    LOGGER.info("-> model: {}", car.getModel());
    LOGGER.info("-> price: {}", car.getPrice());
    LOGGER.info("-> parts: ");
    car.getParts().forEach(p -> LOGGER.info("\t{}/{}/{}",
        p.getType().orElse(null),
        p.getModel().orElse(null),
        p.getPrice().orElse(null))
    );
  }
}
