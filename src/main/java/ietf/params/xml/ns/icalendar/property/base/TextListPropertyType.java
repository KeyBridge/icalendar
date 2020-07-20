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
import ietf.params.xml.ns.icalendar.property.base.textlist.CategoriesPropType;
import ietf.params.xml.ns.icalendar.property.base.textlist.ResourcesPropType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for TextListPropertyType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="TextListPropertyType"&gt; &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt;
 * &lt;sequence&gt; &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}text"
 * maxOccurs="unbounded"/&gt; &lt;/sequence&gt; &lt;/extension&gt; &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextListPropertyType", propOrder = {
  "text"
})
@XmlSeeAlso({
  ResourcesPropType.class,
  CategoriesPropType.class
})
public class TextListPropertyType extends BasePropertyType {

  @XmlElement(required = true)
  protected List<String> text;

  public TextListPropertyType() {
  }

  public TextListPropertyType(List<String> text) {
    this.text = text;
  }

  /**
   * Gets the value of the text property.
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
   * for the text property.
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getText().add(newItem);
   * </pre>
   *
   * @return a non-null ArrayList
   */
  public List<String> getText() {
    if (text == null) {
      text = new ArrayList<>();
    }
    return this.text;
  }

  public boolean isSetText() {
    return ((this.text != null) && (!this.text.isEmpty()));
  }

  public void unsetText() {
    this.text = null;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 11 * hash + Objects.hashCode(this.text);
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
    final TextListPropertyType other = (TextListPropertyType) obj;
    return Objects.equals(this.text, other.text);
  }
}
