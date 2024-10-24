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
package org.operaton.bpm.engine.impl.cmd;

import org.operaton.bpm.engine.history.UserOperationLogEntry;
import org.operaton.bpm.engine.impl.management.UpdateJobSuspensionStateBuilderImpl;
import org.operaton.bpm.engine.impl.persistence.entity.SuspensionState;
import org.operaton.bpm.engine.impl.runtime.UpdateProcessInstanceSuspensionStateBuilderImpl;

/**
 *
 * @author Daniel Meyer
 */
public class SuspendProcessInstanceCmd extends AbstractSetProcessInstanceStateCmd {

  public SuspendProcessInstanceCmd(UpdateProcessInstanceSuspensionStateBuilderImpl builder) {
    super(builder);
  }

  @Override
  protected SuspensionState getNewSuspensionState() {
    return SuspensionState.SUSPENDED;
  }

  @Override
  protected SuspendJobCmd getNextCommand(UpdateJobSuspensionStateBuilderImpl jobCommandBuilder) {
    return new SuspendJobCmd(jobCommandBuilder);
  }

  @Override
  protected String getLogEntryOperation() {
    return UserOperationLogEntry.OPERATION_TYPE_SUSPEND;
  }

}