/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.operaton.bpm.dmn.engine.test.junit5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.operaton.bpm.dmn.engine.DmnEngine;
import org.operaton.bpm.dmn.engine.DmnEngineConfiguration;
import org.operaton.bpm.dmn.engine.impl.DefaultDmnEngineConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

class RegisterDmnEngineExtensionTest {
  private DmnEngineConfiguration customConfiguration = new DefaultDmnEngineConfiguration();

  @RegisterExtension
  private DmnEngineExtension dmnEngineExtension = DmnEngineExtension.forConfiguration(customConfiguration);

  static DmnEngine dmnEngineStaticField;
  private DmnEngine dmnEngineInstanceField;

  @Test
  void shouldThrowExceptionForNullConfiguration() {
    assertThatThrownBy(() -> DmnEngineExtension.forConfiguration(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessage("configuration must not be null");
  }

  @Test
  void shouldInjectEngineWithCustomConfigurationIntoStaticField() {
    assertThat(dmnEngineStaticField.getConfiguration())
        .isEqualTo(customConfiguration);
  }

  @Test
  void shouldInjectEngineWithCustomConfigurationIntoInstanceField() {
    assertThat(dmnEngineInstanceField.getConfiguration())
        .isEqualTo(customConfiguration);
  }

  @Test
  void shouldInjectEngineWithCustomConfigurationParamVersion(DmnEngine dmnEngineParam) {
    assertThat(dmnEngineParam.getConfiguration())
        .isEqualTo(customConfiguration);
  }
}