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
package org.operaton.bpm.engine.test.bpmn.sendtask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.operaton.bpm.engine.runtime.ProcessInstance;
import org.operaton.bpm.engine.test.Deployment;
import org.operaton.bpm.engine.test.util.PluggableProcessEngineTest;
import org.junit.Test;


/**
 * @author Kristin Polenz
 */
public class SendTaskTest extends PluggableProcessEngineTest {

  @Deployment
  @Test
  public void testJavaDelegate() {
    DummySendTask.wasExecuted = false;
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("sendTaskJavaDelegate");

    testRule.assertProcessEnded(processInstance.getId());
    assertTrue(DummySendTask.wasExecuted);
  }

  @Deployment
  @Test
  public void testActivityName() {
    DummyActivityBehavior.wasExecuted = false;

    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process");

    runtimeService.signal(processInstance.getId());

    testRule.assertProcessEnded(processInstance.getId());

    assertTrue(DummyActivityBehavior.wasExecuted);

    assertNotNull(DummyActivityBehavior.currentActivityName);
    assertEquals("Task", DummyActivityBehavior.currentActivityName);

    assertNotNull(DummyActivityBehavior.currentActivityId);
    assertEquals("task", DummyActivityBehavior.currentActivityId);
  }

}
