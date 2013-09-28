package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

/**
 * Java class for DurationPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="DurationPropType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element name="duration"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"/>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DurationPropType", propOrder = {
  "duration"
})
public class DurationPropType extends BasePropertyType {

  @XmlElement(required = true)
  protected Duration duration;

  public DurationPropType() {
  }

  public DurationPropType(Duration duration) {
    this.duration = duration;
  }

  /**
   * Gets the value of the duration property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public Duration getDuration() {
    return duration;
  }

  /**
   * Sets the value of the duration property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setDuration(Duration value) {
    this.duration = value;
  }

  public boolean isSetDuration() {
    return (this.duration != null);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 67 * hash + Objects.hashCode(this.duration);
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
    final DurationPropType other = (DurationPropType) obj;
    if (!Objects.equals(this.duration, other.duration)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "DurationPropType" + " duration [" + duration + ']';
  }
}
