package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for DatetimePropertyType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="DatetimePropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}date-time"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatetimePropertyType", propOrder = {
  "dateTime"
})
public class DatetimePropertyType extends BasePropertyType {

  @XmlElement(name = "date-time", required = true)
  protected XMLGregorianCalendar dateTime;

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
    /**
     * Call normalize to Normalize this instance to UTC.
     * <p/>
     * 2000-03-04T23:00:00+03:00 normalizes to 2000-03-04T20:00:00Z
     * <p/>
     * Implements W3C XML Schema Part 2, Section 3.2.7.3 (A).
     */
    this.dateTime = value.normalize();
  }

  public boolean isSetDateTime() {
    return (this.dateTime != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.dateTime);
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
    final DatetimePropertyType other = (DatetimePropertyType) obj;
    if (!Objects.equals(this.dateTime, other.dateTime)) {
      return false;
    }
    return true;
  }
}
