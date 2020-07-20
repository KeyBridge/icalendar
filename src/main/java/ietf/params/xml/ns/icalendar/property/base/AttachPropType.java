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
package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for AttachPropType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="AttachPropType"&gt; &lt;complexContent&gt; &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt; &lt;choice&gt;
 * &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}uri"/&gt; &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}binary"/&gt; &lt;/choice&gt;
 * &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachPropType", propOrder = {
  "uri",
  "binary"
})
public class AttachPropType extends BasePropertyType {

  protected String uri;
  protected String binary;

  /**
   * Gets the value of the uri property.
   *
   * @return possible object is {@link String }
   */
  public String getUri() {
    return uri;
  }

  /**
   * Sets the value of the uri property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUri(String value) {
    this.uri = value;
  }

  public boolean isSetUri() {
    return (this.uri != null);
  }

  /**
   * Gets the value of the binary property.
   *
   * @return possible object is {@link String }
   */
  public String getBinary() {
    return binary;
  }

  /**
   * Sets the value of the binary property.
   *
   * @param value allowed object is {@link String }
   */
  public void setBinary(String value) {
    this.binary = value;
  }

  public boolean isSetBinary() {
    return (this.binary != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 19 * hash + Objects.hashCode(this.uri);
    hash = 19 * hash + Objects.hashCode(this.binary);
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
    final AttachPropType other = (AttachPropType) obj;
    if (!Objects.equals(this.uri, other.uri)) {
      return false;
    }
    return Objects.equals(this.binary, other.binary);
  }
}
