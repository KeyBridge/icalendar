/*
 * Copyright 2016 Key Bridge LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ietf.params.xml.ns.icalendar.parameter.base;

import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import ietf.params.xml.ns.icalendar.parameter.base.text.*;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for TextParameterType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>  &lt;complexType name="TextParameterType"&gt; &lt;complexContent&gt;
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType"&gt;
 * &lt;sequence&gt; &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}text"/&gt;
 * &lt;/sequence&gt; &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextParameterType", propOrder = {
  "text"
})
@XmlSeeAlso({
  CnParamType.class,
  CutypeParamType.class,
  EncodingParamType.class,
  FbtypeParamType.class,
  FmttypeParamType.class,
  LanguageParamType.class,
  PartstatParamType.class,
  RelatedParamType.class,
  ReltypeParamType.class,
  RoleParamType.class,
  ScheduleAgentParamType.class,
  ScheduleForceSendParamType.class,
  ScheduleStatusParamType.class,
  TzidParamType.class,
  XBedeworkUidParamType.class
})
public class TextParameterType extends BaseParameterType {

  @XmlElement(required = true)
  protected String text;

  public TextParameterType() {
  }

  public TextParameterType(String text) {
    this.text = text;
  }

  /**
   * Gets the value of the text property.
   *
   * @return possible object is {@link String }
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the value of the text property.
   *
   * @param value allowed object is {@link String }
   */
  public void setText(String value) {
    this.text = value;
  }

  public boolean isSetText() {
    return (this.text != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(this.text);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final TextParameterType other = (TextParameterType) obj;
    return Objects.equals(this.text, other.text);
  }
}
