package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;

/**
 * types the content of the xCal attach element
 * <p/>
 * Java class for WsCalendarAttachType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="WsCalendarAttachType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;choice maxOccurs="unbounded" minOccurs="0"> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}artifact"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}artifactBase"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}uri"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}text"/> &lt;/choice>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WsCalendarAttachType", propOrder = {
  "artifactOrArtifactBaseOrUri"
})
public class WsCalendarAttachType extends BasePropertyType {

  @XmlElementRefs({
    @XmlElementRef(name = "artifactBase", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false),
    @XmlElementRef(name = "uri", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false),
    @XmlElementRef(name = "artifact", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false),
    @XmlElementRef(name = "text", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
  })
  protected List<JAXBElement<?>> artifactOrArtifactBaseOrUri;

  /**
   * Gets the value of the artifactOrArtifactBaseOrUri property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the artifactOrArtifactBaseOrUri property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getArtifactOrArtifactBaseOrUri().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list null null null   {@link JAXBElement }{@code <}{@link ArtifactBaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
   * {@link JAXBElement }{@code <}{@link ArtifactType }{@code >}
   * {@link JAXBElement }{@code <}{@link String }{@code >}
   * <p/>
   *
   */
  public List<JAXBElement<?>> getArtifactOrArtifactBaseOrUri() {
    if (artifactOrArtifactBaseOrUri == null) {
      artifactOrArtifactBaseOrUri = new ArrayList<JAXBElement<?>>();
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
    if (!Objects.equals(this.artifactOrArtifactBaseOrUri, other.artifactOrArtifactBaseOrUri)) {
      return false;
    }
    return true;
  }
}
