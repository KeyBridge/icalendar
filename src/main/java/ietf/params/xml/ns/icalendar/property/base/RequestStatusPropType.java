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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for RequestStatusPropType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="RequestStatusPropType"&gt; &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt;
 * &lt;sequence&gt; &lt;element name="code"
 * type="{http://www.w3.org/2001/XMLSchema}string"/&gt; &lt;element
 * name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 * &lt;element name="extdata" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 * &lt;/sequence&gt; &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestStatusPropType", propOrder = {
  "code",
  "description",
  "extdata"
})
public class RequestStatusPropType extends BasePropertyType {

  @XmlElement(required = true)
  protected String code;
  @XmlElement(required = true)
  protected String description;
  @XmlElement(required = true)
  protected String extdata;

  /**
   * Gets the value of the code property.
   *
   * @return possible object is {@link String }
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets the value of the code property.
   *
   * @param value allowed object is {@link String }
   */
  public void setCode(String value) {
    this.code = value;
  }

  public boolean isSetCode() {
    return (this.code != null);
  }

  /**
   * Gets the value of the description property.
   *
   * @return possible object is {@link String }
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the value of the description property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDescription(String value) {
    this.description = value;
  }

  public boolean isSetDescription() {
    return (this.description != null);
  }

  /**
   * Gets the value of the extdata property.
   *
   * @return possible object is {@link String }
   */
  public String getExtdata() {
    return extdata;
  }

  /**
   * Sets the value of the extdata property.
   *
   * @param value allowed object is {@link String }
   */
  public void setExtdata(String value) {
    this.extdata = value;
  }

  public boolean isSetExtdata() {
    return (this.extdata != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 23 * hash + Objects.hashCode(this.code);
    hash = 23 * hash + Objects.hashCode(this.description);
    hash = 23 * hash + Objects.hashCode(this.extdata);
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
    final RequestStatusPropType other = (RequestStatusPropType) obj;
    if (!Objects.equals(this.code, other.code)) {
      return false;
    }
    if (!Objects.equals(this.description, other.description)) {
      return false;
    }
    return Objects.equals(this.extdata, other.extdata);
  }
}
