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
package org.operaton.bpm.model.bpmn.impl.instance;

import org.operaton.bpm.model.bpmn.BpmnModelInstance;
import org.operaton.bpm.model.bpmn.builder.StartEventBuilder;
import org.operaton.bpm.model.bpmn.instance.CatchEvent;
import org.operaton.bpm.model.bpmn.instance.StartEvent;
import org.operaton.bpm.model.xml.ModelBuilder;
import org.operaton.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.operaton.bpm.model.xml.type.ModelElementTypeBuilder;
import org.operaton.bpm.model.xml.type.attribute.Attribute;

import static org.operaton.bpm.model.bpmn.impl.BpmnModelConstants.*;

/**
 * The BPMN startEvent element
 *
 * @author Sebastian Menski
 */
public class StartEventImpl extends CatchEventImpl implements StartEvent {

  protected static Attribute<Boolean> isInterruptingAttribute;

  /** operaton extensions */

  protected static Attribute<Boolean> operatonAsyncAttribute;
  protected static Attribute<String> operatonFormHandlerClassAttribute;
  protected static Attribute<String> operatonFormKeyAttribute;
  protected static Attribute<String> operatonFormRefAttribute;
  protected static Attribute<String> operatonFormRefBindingAttribute;
  protected static Attribute<String> operatonFormRefVersionAttribute;
  protected static Attribute<String> operatonInitiatorAttribute;

  public static void registerType(ModelBuilder modelBuilder) {

    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(StartEvent.class, BPMN_ELEMENT_START_EVENT)
      .namespaceUri(BPMN20_NS)
      .extendsType(CatchEvent.class)
      .instanceProvider(new ModelElementTypeBuilder.ModelTypeInstanceProvider<StartEvent>() {
        public StartEvent newInstance(ModelTypeInstanceContext instanceContext) {
          return new StartEventImpl(instanceContext);
        }
      });

    isInterruptingAttribute = typeBuilder.booleanAttribute(BPMN_ATTRIBUTE_IS_INTERRUPTING)
      .defaultValue(true)
      .build();

    /** operaton extensions */

    operatonAsyncAttribute = typeBuilder.booleanAttribute(CAMUNDA_ATTRIBUTE_ASYNC)
      .namespace(OPERATON_NS)
      .defaultValue(false)
      .build();

    operatonFormHandlerClassAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_FORM_HANDLER_CLASS)
      .namespace(OPERATON_NS)
      .build();

    operatonFormKeyAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_FORM_KEY)
      .namespace(OPERATON_NS)
      .build();

    operatonFormRefAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_FORM_REF)
        .namespace(OPERATON_NS)
        .build();

    operatonFormRefBindingAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_FORM_REF_BINDING)
        .namespace(OPERATON_NS)
        .build();

    operatonFormRefVersionAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_FORM_REF_VERSION)
        .namespace(OPERATON_NS)
        .build();

    operatonInitiatorAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_INITIATOR)
      .namespace(OPERATON_NS)
      .build();

    typeBuilder.build();
  }

  public StartEventImpl(ModelTypeInstanceContext context) {
    super(context);
  }

  @Override
  public StartEventBuilder builder() {
    return new StartEventBuilder((BpmnModelInstance) modelInstance, this);
  }

  public boolean isInterrupting() {
    return isInterruptingAttribute.getValue(this);
  }

  public void setInterrupting(boolean isInterrupting) {
    isInterruptingAttribute.setValue(this, isInterrupting);
  }

  /** operaton extensions */

  /**
   * @deprecated use isOperatonAsyncBefore() instead.
   */
  @Deprecated
  public boolean isOperatonAsync() {
    return operatonAsyncAttribute.getValue(this);
  }

  /**
   * @deprecated use setOperatonAsyncBefore(isOperatonAsyncBefore) instead.
   */
  @Deprecated
  public void setOperatonAsync(boolean isOperatonAsync) {
    operatonAsyncAttribute.setValue(this, isOperatonAsync);
  }

  public String getOperatonFormHandlerClass() {
    return operatonFormHandlerClassAttribute.getValue(this);
  }

  public void setOperatonFormHandlerClass(String operatonFormHandlerClass) {
    operatonFormHandlerClassAttribute.setValue(this, operatonFormHandlerClass);
  }

  public String getOperatonFormKey() {
    return operatonFormKeyAttribute.getValue(this);
  }

  public void setOperatonFormKey(String operatonFormKey) {
    operatonFormKeyAttribute.setValue(this, operatonFormKey);
  }


  public String getOperatonFormRef() {
    return operatonFormRefAttribute.getValue(this);
  }

  public void setOperatonFormRef(String operatonFormRef) {
    operatonFormRefAttribute.setValue(this, operatonFormRef);
  }

  public String getOperatonFormRefBinding() {
    return operatonFormRefBindingAttribute.getValue(this);
  }

  public void setOperatonFormRefBinding(String operatonFormRefBinding) {
    operatonFormRefBindingAttribute.setValue(this, operatonFormRefBinding);
  }

  public String getOperatonFormRefVersion() {
    return operatonFormRefVersionAttribute.getValue(this);
  }

  public void setOperatonFormRefVersion(String operatonFormRefVersion) {
    operatonFormRefVersionAttribute.setValue(this, operatonFormRefVersion);
  }

  public String getOperatonInitiator() {
    return operatonInitiatorAttribute.getValue(this);
  }

  public void setOperatonInitiator(String operatonInitiator) {
    operatonInitiatorAttribute.setValue(this, operatonInitiator);
  }
}