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

import org.operaton.bpm.model.bpmn.builder.AbstractTaskBuilder;
import org.operaton.bpm.model.bpmn.instance.Activity;
import org.operaton.bpm.model.bpmn.instance.Task;
import org.operaton.bpm.model.bpmn.instance.bpmndi.BpmnShape;
import org.operaton.bpm.model.xml.ModelBuilder;
import org.operaton.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.operaton.bpm.model.xml.impl.util.ModelTypeException;
import org.operaton.bpm.model.xml.type.ModelElementTypeBuilder;
import org.operaton.bpm.model.xml.type.attribute.Attribute;

import static org.operaton.bpm.model.bpmn.impl.BpmnModelConstants.*;
import static org.operaton.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN task element
 *
 * @author Sebastian Menski
 */
public class TaskImpl extends ActivityImpl implements Task {

  /** operaton extensions */

  protected static Attribute<Boolean> operatonAsyncAttribute;


  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(Task.class, BPMN_ELEMENT_TASK)
      .namespaceUri(BPMN20_NS)
      .extendsType(Activity.class)
      .instanceProvider(new ModelTypeInstanceProvider<Task>() {
        public Task newInstance(ModelTypeInstanceContext instanceContext) {
          return new TaskImpl(instanceContext);
        }
      });

    /** operaton extensions */

    operatonAsyncAttribute = typeBuilder.booleanAttribute(CAMUNDA_ATTRIBUTE_ASYNC)
      .namespace(OPERATON_NS)
      .defaultValue(false)
      .build();

    typeBuilder.build();
  }

  public TaskImpl(ModelTypeInstanceContext context) {
    super(context);
  }

  @SuppressWarnings("rawtypes")
  public AbstractTaskBuilder builder() {
    throw new ModelTypeException("No builder implemented.");
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


  public BpmnShape getDiagramElement() {
    return (BpmnShape) super.getDiagramElement();
  }

}