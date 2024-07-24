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
package org.operaton.spin.plugin.script;

import java.util.Collections;
import java.util.List;

import org.operaton.bpm.engine.impl.core.variable.CoreVariableInstance;
import org.operaton.bpm.engine.impl.core.variable.scope.AbstractVariableScope;
import org.operaton.bpm.engine.impl.core.variable.scope.SimpleVariableInstance;
import org.operaton.bpm.engine.impl.core.variable.scope.VariableInstanceFactory;
import org.operaton.bpm.engine.impl.core.variable.scope.VariableInstanceLifecycleListener;
import org.operaton.bpm.engine.impl.core.variable.scope.VariableStore;
import org.operaton.bpm.engine.impl.core.variable.scope.SimpleVariableInstance.SimpleVariableInstanceFactory;

/**
 * Simple standalone variable scope which can be used in testcases.
 *
 * @author Daniel Meyer
 *
 */
public class TestVariableScope extends AbstractVariableScope {

  protected VariableStore<SimpleVariableInstance> variableStore = new VariableStore<SimpleVariableInstance>();

  protected VariableStore<CoreVariableInstance> getVariableStore() {
    return (VariableStore) variableStore;
  }

  public AbstractVariableScope getParentVariableScope() {
    return null;
  }

  @Override
  protected VariableInstanceFactory<CoreVariableInstance> getVariableInstanceFactory() {
    return (VariableInstanceFactory) SimpleVariableInstanceFactory.INSTANCE;
  }

  @Override
  protected List<VariableInstanceLifecycleListener<CoreVariableInstance>> getVariableInstanceLifecycleListeners() {
    return Collections.emptyList();
  }

}
