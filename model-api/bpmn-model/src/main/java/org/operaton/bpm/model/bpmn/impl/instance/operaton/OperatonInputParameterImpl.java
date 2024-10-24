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
package org.operaton.bpm.model.bpmn.impl.instance.operaton;

import static org.operaton.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_NAME;
import static org.operaton.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_INPUT_PARAMETER;
import static org.operaton.bpm.model.bpmn.impl.BpmnModelConstants.OPERATON_NS;

import org.operaton.bpm.model.bpmn.instance.operaton.OperatonInputParameter;
import org.operaton.bpm.model.xml.ModelBuilder;
import org.operaton.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.operaton.bpm.model.xml.type.ModelElementTypeBuilder;
import org.operaton.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.operaton.bpm.model.xml.type.attribute.Attribute;

/**
 * The BPMN inputParameter operaton extension element
 *
 * @author Sebastian Menski
 */
public class OperatonInputParameterImpl extends OperatonGenericValueElementImpl implements OperatonInputParameter {

  protected static Attribute<String> operatonNameAttribute;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(OperatonInputParameter.class, CAMUNDA_ELEMENT_INPUT_PARAMETER)
      .namespaceUri(OPERATON_NS)
      .instanceProvider(new ModelTypeInstanceProvider<OperatonInputParameter>() {
        public OperatonInputParameter newInstance(ModelTypeInstanceContext instanceContext) {
          return new OperatonInputParameterImpl(instanceContext);
        }
      });

    operatonNameAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_NAME)
      .namespace(OPERATON_NS)
      .required()
      .build();

    typeBuilder.build();
  }

  public OperatonInputParameterImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getOperatonName() {
    return operatonNameAttribute.getValue(this);
  }

  public void setOperatonName(String operatonName) {
    operatonNameAttribute.setValue(this, operatonName);
  }

}