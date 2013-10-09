package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.RecurType;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.recur.ExrulePropType;
import ietf.params.xml.ns.icalendar.property.base.recur.RrulePropType;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for RecurPropertyType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="RecurPropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element name="recur"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}RecurType"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecurPropertyType", propOrder = {
  "recur"
})
@XmlSeeAlso({
  ExrulePropType.class,
  RrulePropType.class
})
public class RecurPropertyType extends BasePropertyType {

  @XmlElement(required = true)
  protected RecurType recur;

  public RecurPropertyType() {
  }

  public RecurPropertyType(RecurType recur) {
    this.recur = recur;
  }

  /**
   * Gets the value of the recur property.
   * <p/>
   * @return possible object is {@link RecurType }
   *
   */
  public RecurType getRecur() {
    return recur;
  }

  /**
   * Sets the value of the recur property.
   * <p/>
   * @param value allowed object is {@link RecurType }
   *
   */
  public void setRecur(RecurType value) {
    this.recur = value;
  }

  public boolean isSetRecur() {
    return (this.recur != null);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 83 * hash + Objects.hashCode(this.recur);
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
    final RecurPropertyType other = (RecurPropertyType) obj;
    if (!Objects.equals(this.recur, other.recur)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return recur != null ? recur.toString() : null;
  }
}
