/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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

package org.camunda.bpm.model.bpmn.builder;

import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.CallActivity;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaIn;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaOut;

/**
 * @author Sebastian Menski
 */
public class AbstractCallActivityBuilder<B extends AbstractCallActivityBuilder<B>> extends AbstractActivityBuilder<B, CallActivity> {

  protected AbstractCallActivityBuilder(BpmnModelInstance modelInstance, CallActivity element, Class<?> selfType) {
    super(modelInstance, element, selfType);
  }

  /**
   * Sets the called element
   *
   * @param calledElement  the process to call
   * @return the builder object
   */
  public B calledElement(String calledElement) {
    element.setCalledElement(calledElement);
    return myself;
  }

  /** camunda extensions */

  /**
   * @deprecated use camundaAsyncBefore() instead.
   *
   * Sets the camunda async attribute to true.
   *
   * @return the builder object
   */
  @Deprecated
  public B camundaAsync() {
    element.setCamundaAsyncBefore(true);
    return myself;
  }

  /**
   * @deprecated use camundaAsyncBefore(isCamundaAsyncBefore) instead
   *
   * Sets the camunda async attribute.
   *
   * @param isCamundaAsync  the async state of the task
   * @return the builder object
   */
  @Deprecated
  public B camundaAsync(boolean isCamundaAsync) {
    element.setCamundaAsyncBefore(isCamundaAsync);
    return myself;
  }

  /**
   * Sets the camunda calledElementBinding attribute
   *
   * @param camundaCalledElementBinding  the element binding to use
   * @return the builder object
   */
  public B camundaCalledElementBinding(String camundaCalledElementBinding) {
    element.setCamundaCalledElementBinding(camundaCalledElementBinding);
    return myself;
  }

  /**
   * Sets the camunda calledElementVersion attribute
   *
   * @param camundaCalledElementVersion  the element version to use
   * @return the builder object
   */
  public B camundaCalledElementVersion(String camundaCalledElementVersion) {
    element.setCamundaCalledElementVersion(camundaCalledElementVersion);
    return myself;
  }

  /**
   * Sets the camunda caseRef attribute
   *
   * @param caseRef the case to call
   * @return the builder object
   */
  public B camundaCaseRef(String caseRef) {
    element.setCamundaCaseRef(caseRef);
    return myself;
  }

  /**
   * Sets the camunda caseBinding attribute
   *
   * @param camundaCaseBinding  the case binding to use
   * @return the builder object
   */
  public B camundaCaseBinding(String camundaCaseBinding) {
    element.setCamundaCaseBinding(camundaCaseBinding);
    return myself;
  }

  /**
   * Sets the camunda caseVersion attribute
   *
   * @param camundaCaseVersion  the case version to use
   * @return the builder object
   */
  public B camundaCaseVersion(String camundaCaseVersion) {
    element.setCamundaCaseVersion(camundaCaseVersion);
    return myself;
  }

  /**
   * Sets a "camunda in" parameter to pass a variable from the super process instance to the sub process instance
   *
   * @param source the name of variable in the super process instance
   * @param target the name of the variable in the sub process instance
   * @return
   */
  public B camundaIn(String source, String target) {
    CamundaIn param = modelInstance.newInstance(CamundaIn.class);
    param.setCamundaSource(source);
    param.setCamundaTarget(target);
    addExtensionElement(param);
    return myself;
  }

  /**
   * Sets a "camunda out" parameter to pass a variable from a sub process instance to the super process instance
   *
   * @param source the name of variable in the sub process instance
   * @param target the name of the variable in the super process instance
   * @return
   */
  public B camundaOut(String source, String target) {
    CamundaOut param = modelInstance.newInstance(CamundaOut.class);
    param.setCamundaSource(source);
    param.setCamundaTarget(target);
    addExtensionElement(param);
    return myself;
  }

}
