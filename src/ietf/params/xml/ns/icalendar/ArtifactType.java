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
 * wsCalendar.
 * <p/>
 *
 * Java class for ArtifactType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="ArtifactType"> &lt;complexContent> &lt;restriction
 * base="{http://www.w3.org/2001/XMLSchema}anyType"> &lt;anyAttribute
 * processContents='lax' namespace='##other'/> &lt;/restriction>
 * &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArtifactType")
public class ArtifactType {

  @XmlAnyAttribute
  private Map<QName, String> otherAttributes = new HashMap<QName, String>();

  /**
   * Gets a map that contains attributes that aren't bound to any typed property
   * on this class.
   * <p/>
   * the map is keyed by the name of the attribute and the value is the string
   * value of the attribute.
   * <p/>
   * the map returned by this method is live, and you can add new attribute by
   * updating the map directly. Because of this design, there's no setter.
   * <p/>
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
