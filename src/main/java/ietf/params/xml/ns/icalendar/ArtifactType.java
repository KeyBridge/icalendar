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
package ietf.params.xml.ns.icalendar;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

/**
 *
 * The artifact is here to handle elements that are not proper extensions of
 * wsCalendar. Java class for ArtifactType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="ArtifactType"> &lt;complexContent&gt; &lt;restriction
 * base="{http://www.w3.org/2001/XMLSchema}anyType"&gt; &lt;anyAttribute
 * processContents='lax' namespace='##other'/&gt; &lt;/restriction&gt;
 * &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArtifactType")
public class ArtifactType {

  @XmlAnyAttribute
  private Map<QName, String> otherAttributes = new HashMap<>();

  /**
   * Gets a map that contains attributes that aren't bound to any typed property
   * on this class.
   * <p>
   * the map is keyed by the name of the attribute and the value is the string
   * value of the attribute.
   * <p>
   * the map returned by this method is live, and you can add new attribute by
   * updating the map directly. Because of this design, there's no setter.
   *
   *
   * @return always non-null
   */
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 79 * hash + Objects.hashCode(this.otherAttributes);
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
    final ArtifactType other = (ArtifactType) obj;
    if (!Objects.equals(this.otherAttributes, other.otherAttributes)) {
      return false;
    }
    return true;
  }
}
