/*
 * Created on Feb 8, 2011
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2011 the original author or authors.
 */
package org.assert4j.core.assertions.internal.bigdecimals;

import static org.assert4j.core.assertions.test.TestData.someInfo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.assert4j.core.assertions.core.AssertionInfo;
import org.assert4j.core.assertions.internal.BigDecimals;
import org.assert4j.core.assertions.internal.BigDecimalsBaseTest;
import org.junit.Test;


/**
 * Tests for <code>{@link BigDecimals#assertIsZero(AssertionInfo, BigDecimal)}</code>.
 * 
 * @author Yvonne Wang
 * @author Joel Costigliola
 */
public class BigDecimals_assertIsZero_Test extends BigDecimalsBaseTest {

  @Test
  public void should_succeed_since_actual_is_zero() {
    bigDecimals.assertIsZero(someInfo(), BigDecimal.ZERO);
  }

  @Test
  public void should_fail_since_actual_is_not_zero() {
    try {
      bigDecimals.assertIsZero(someInfo(), BigDecimal.ONE);
    } catch (AssertionError e) {
      assertEquals(e.getMessage(), "expected:<[0]> but was:<[1]>");
    }
  }

  @Test
  public void should_succeed_since_actual_is_zero_whatever_custom_comparison_strategy_is() {
    bigDecimalsWithComparatorComparisonStrategy.assertIsZero(someInfo(), BigDecimal.ZERO);
  }

  @Test
  public void should_fail_since_actual_is_not_zero_whatever_custom_comparison_strategy_is() {
    try {
      bigDecimalsWithComparatorComparisonStrategy.assertIsZero(someInfo(), BigDecimal.ONE);
    } catch (AssertionError e) {
      assertEquals(e.getMessage(), "expected:<[0]> but was:<[1]>");
    }
  }

}