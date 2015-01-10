package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.CompletedPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.CreatedPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.DtstampPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.LastModifiedPropType;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for UtcDatetimePropertyType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="UtcDatetimePropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}utc-date-time"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UtcDatetimePropertyType", propOrder = {
  "utcDateTime"
})
@XmlSeeAlso({
  CompletedPropType.class,
  CreatedPropType.class,
  DtstampPropType.class,
  LastModifiedPropType.class
})
public class UtcDatetimePropertyType extends BasePropertyType {

  @XmlElement(name = "utc-date-time", required = true)
//  @XmlJavaTypeAdapter(type = XMLGregorianCalendar.class, value = XmlAdapterXCalDateTime.class)
  protected XMLGregorianCalendar utcDateTime;

  public UtcDatetimePropertyType() {
  }

  public UtcDatetimePropertyType(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    this.utcDateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize();
  }

  /**
   * Gets the value of the utcDateTime property.
   * <p/>
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public XMLGregorianCalendar getUtcDateTime() {
    return utcDateTime;
  }

  /**
   * Sets the value of the utcDateTime property.
   * <p/>
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setUtcDateTime(XMLGregorianCalendar value) {
    this.utcDateTime = value;
  }

  public void setUtcDateTime(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    this.utcDateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize();
  }

  public boolean isSetUtcDateTime() {
    return (this.utcDateTime != null);
  }

  public Calendar getCalendar() {
    if (utcDateTime != null) {
      return utcDateTime.toGregorianCalendar(TIME_ZONE, Locale.ENGLISH, null);
    }
    return null;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + Objects.hashCode(this.utcDateTime);
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
    final UtcDatetimePropertyType other = (UtcDatetimePropertyType) obj;
    if (!Objects.equals(this.utcDateTime, other.utcDateTime)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "UtcDatetimePropertyType" + " utcDateTime [" + utcDateTime + ']';
  }
}
