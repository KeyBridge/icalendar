package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for TriggerPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="TriggerPropType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;choice> &lt;element name="duration"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}date-time"/> &lt;/choice>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TriggerPropType", propOrder = {
  "duration",
  "dateTime"
})
public class TriggerPropType extends BasePropertyType {

  protected String duration;
  @XmlElement(name = "date-time")
  protected XMLGregorianCalendar dateTime;

  /**
   * Gets the value of the duration property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Sets the value of the duration property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setDuration(String value) {
    this.duration = value;
  }

  public boolean isSetDuration() {
    return (this.duration != null);
  }

  /**
   * Gets the value of the dateTime property.
   * <p/>
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public XMLGregorianCalendar getDateTime() {
    return dateTime;
  }

  /**
   * Sets the value of the dateTime property.
   * <p/>
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setDateTime(XMLGregorianCalendar value) {
    this.dateTime = value;
  }

  public boolean isSetDateTime() {
    return (this.dateTime != null);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 17 * hash + Objects.hashCode(this.duration);
    hash = 17 * hash + Objects.hashCode(this.dateTime);
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
    final TriggerPropType other = (TriggerPropType) obj;
    if (!Objects.equals(this.duration, other.duration)) {
      return false;
    }
    if (!Objects.equals(this.dateTime, other.dateTime)) {
      return false;
    }
    return true;
  }
}
