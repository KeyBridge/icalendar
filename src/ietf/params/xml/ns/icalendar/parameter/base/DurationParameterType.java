package ietf.params.xml.ns.icalendar.parameter.base;

import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;

/**
 * Java class for DurationParameterType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="DurationParameterType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType">
 * &lt;sequence> &lt;element name="duration"
 * type="{http://www.w3.org/2001/XMLSchema}duration"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DurationParameterType", propOrder = {
  "duration"
})
public class DurationParameterType extends BaseParameterType {

  @XmlElement(required = true)
  protected Duration duration;

  /**
   * Gets the value of the duration property.
   * <p/>
   * @return possible object is {@link Duration }
   *
   */
  public Duration getDuration() {
    return duration;
  }

  /**
   * Sets the value of the duration property.
   * <p/>
   * @param value allowed object is {@link Duration }
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
    int hash = 7;
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
    final DurationParameterType other = (DurationParameterType) obj;
    if (!Objects.equals(this.duration, other.duration)) {
      return false;
    }
    return true;
  }
}
