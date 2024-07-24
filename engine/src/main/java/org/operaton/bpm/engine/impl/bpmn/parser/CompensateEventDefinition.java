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
package org.operaton.bpm.engine.impl.bpmn.parser;

import java.io.Serializable;

/**
 * @author Daniel Meyer
 */
public class CompensateEventDefinition implements Serializable {

  private static final long serialVersionUID = 1L;
  
  protected String activityRef;
  protected boolean waitForCompletion;

  public String getActivityRef() {
    return activityRef;
  }

  public void setActivityRef(String activityRef) {
    this.activityRef = activityRef;
  }

  public boolean isWaitForCompletion() {
    return waitForCompletion;
  }

  public void setWaitForCompletion(boolean waitForCompletion) {
    this.waitForCompletion = waitForCompletion;
  }

}
