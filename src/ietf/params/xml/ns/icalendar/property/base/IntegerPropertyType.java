package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.integer.*;
import java.math.BigInteger;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for IntegerPropertyType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="IntegerPropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}integer"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegerPropertyType", propOrder = {
  "integer"
})
@XmlSeeAlso({
  PercentCompletePropType.class,
  PriorityPropType.class,
  RepeatPropType.class,
  SequencePropType.class,
  XBedeworkMaxTicketsPerUserPropType.class,
  XBedeworkMaxTicketsPropType.class
})
public class IntegerPropertyType extends BasePropertyType {

  @XmlElement(required = true)
  protected Integer integer;

  /**
   * Gets the value of the integer property.
   * <p/>
   * @return possible object is {@link BigInteger }
   *
   */
  public Integer getInteger() {
    return integer;
  }

  /**
   * Sets the value of the integer property.
   * <p/>
   * @param value allowed object is {@link BigInteger }
   *
   */
  public void setInteger(Integer value) {
    this.integer = value;
  }

  public boolean isSetInteger() {
    return (this.integer != null);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 17 * hash + Objects.hashCode(this.integer);
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
    final IntegerPropertyType other = (IntegerPropertyType) obj;
    if (!Objects.equals(this.integer, other.integer)) {
      return false;
    }
    return true;
  }
}
