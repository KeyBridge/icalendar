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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

/**
 * types the content of the xCal attach element
 * <p>
 * Java class for WsCalendarAttachType complex type. The following schema
 * fragment specifies the expected content contained within this class.
 * <pre> &lt;complexType name="WsCalendarAttachType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;choice maxOccurs="unbounded" minOccurs="0"> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}artifact"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}artifactBase"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}uri"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}text"/> &lt;/choice>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WsCalendarAttachType", propOrder = {
  "artifactOrArtifactBaseOrUri"
})
public class WsCalendarAttachType extends BasePropertyType {

  @XmlElementRefs({
    @XmlElementRef(name = "artifactBase", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
    ,  @XmlElementRef(name = "uri", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
    ,  @XmlElementRef(name = "artifact", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
    ,  @XmlElementRef(name = "text", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
  })
  protected List<JAXBElement<?>> artifactOrArtifactBaseOrUri;

  /**
   * Gets the value of the artifactOrArtifactBaseOrUri property.
   *
   * @return the value of the artifactOrArtifactBaseOrUri
   */
  public List<JAXBElement<?>> getArtifactOrArtifactBaseOrUri() {
    if (artifactOrArtifactBaseOrUri == null) {
      artifactOrArtifactBaseOrUri = new ArrayList<>();
    }
    return this.artifactOrArtifactBaseOrUri;
  }

  public boolean isSetArtifactOrArtifactBaseOrUri() {
    return ((this.artifactOrArtifactBaseOrUri != null) && (!this.artifactOrArtifactBaseOrUri.isEmpty()));
  }

  public void unsetArtifactOrArtifactBaseOrUri() {
    this.artifactOrArtifactBaseOrUri = null;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 19 * hash + Objects.hashCode(this.artifactOrArtifactBaseOrUri);
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
    final WsCalendarAttachType other = (WsCalendarAttachType) obj;
    return Objects.equals(this.artifactOrArtifactBaseOrUri, other.artifactOrArtifactBaseOrUri);
  }
}
