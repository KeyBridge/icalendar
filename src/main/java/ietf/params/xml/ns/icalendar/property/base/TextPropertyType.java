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
import ietf.params.xml.ns.icalendar.property.base.text.*;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for TextPropertyType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="TextPropertyType"&gt; &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt;
 * &lt;sequence&gt; &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}text"/&gt;
 * &lt;/sequence&gt; &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextPropertyType", propOrder = {
  "text"
})
@XmlSeeAlso({
  ActionPropType.class,
  BusytypePropType.class,
  ClassPropType.class,
  CommentPropType.class,
  ContactPropType.class,
  DescriptionPropType.class,
  LocationPropType.class,
  MethodPropType.class,
  ProdidPropType.class,
  StatusPropType.class,
  SummaryPropType.class,
  TranspPropType.class,
  TzidPropType.class,
  TznamePropType.class,
  UidPropType.class,
  VersionPropType.class,
  WsCalendarTypeType.class,
  XBedeworkCostPropType.class,
  XBedeworkExsynchEndtzidPropType.class,
  XBedeworkExsynchLastmodPropType.class,
  XBedeworkExsynchStarttzidPropType.class,
  XBedeworkInstanceOnlyPropType.class,
  XMicrosoftCdoBusystatusPropType.class,
  XMicrosoftCdoIntendedstatusPropType.class
})
public class TextPropertyType extends BasePropertyType {

  @XmlElement(required = true)
  protected String text;

  public TextPropertyType() {
  }

  public TextPropertyType(String text) {
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
    hash = 17 * hash + Objects.hashCode(this.text);
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
    final TextPropertyType other = (TextPropertyType) obj;
    return Objects.equals(this.text, other.text);
  }

  @Override
  public String toString() {
    return "TextPropertyType{" + "text=" + text + '}';
  }
}
