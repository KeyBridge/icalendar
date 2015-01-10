package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.ToleranceValueType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for TolerancePropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="TolerancePropType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element name="tolerate"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}ToleranceValueType"/>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TolerancePropType", propOrder = {
  "tolerate"
})
public class TolerancePropType extends BasePropertyType {

  @XmlElement(required = true)
  protected ToleranceValueType tolerate;

  /**
   * Gets the value of the tolerate property.
   * <p/>
   * @return possible object is {@link ToleranceValueType }
   *
   */
  public ToleranceValueType getTolerate() {
    return tolerate;
  }

  /**
   * Sets the value of the tolerate property.
   * <p/>
   * @param value allowed object is {@link ToleranceValueType }
   *
   */
  public void setTolerate(ToleranceValueType value) {
    this.tolerate = value;
  }

  public boolean isSetTolerate() {
    return (this.tolerate != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 67 * hash + Objects.hashCode(this.tolerate);
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
    final TolerancePropType other = (TolerancePropType) obj;
    if (!Objects.equals(this.tolerate, other.tolerate)) {
      return false;
    }
    return true;
  }
}
