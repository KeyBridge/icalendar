package ietf.params.xml.ns.icalendar;

import ietf.params.xml.ns.icalendar.adapter.XmlAdapterXCalDateTime;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for PeriodType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="PeriodType"> &lt;complexContent> &lt;restriction
 * base="{http://www.w3.org/2001/XMLSchema}anyType"> &lt;sequence> &lt;element
 * name="start" type="{urn:ietf:params:xml:ns:icalendar-2.0}DateTimeType"/>
 * &lt;sequence> &lt;choice> &lt;element name="end"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DateTimeType"/> &lt;element
 * name="duration"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"/> &lt;/choice>
 * &lt;/sequence> &lt;/sequence> &lt;/restriction> &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodType", propOrder = {
  "start",
  "end",
  "duration"
})
public class PeriodType {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(type = XMLGregorianCalendar.class, value = XmlAdapterXCalDateTime.class)
  protected XMLGregorianCalendar start;
  @XmlJavaTypeAdapter(type = XMLGregorianCalendar.class, value = XmlAdapterXCalDateTime.class)
  protected XMLGregorianCalendar end;
  protected String duration;

  /**
   * Gets the value of the start property.
   * <p/>
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public XMLGregorianCalendar getStart() {
    return start;
  }

  /**
   * Sets the value of the start property.
   * <p/>
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setStart(XMLGregorianCalendar value) {
    this.start = value;
  }

  public boolean isSetStart() {
    return (this.start != null);
  }

  /**
   * Gets the value of the end property.
   * <p/>
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public XMLGregorianCalendar getEnd() {
    return end;
  }

  /**
   * Sets the value of the end property.
   * <p/>
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setEnd(XMLGregorianCalendar value) {
    this.end = value;
  }

  public boolean isSetEnd() {
    return (this.end != null);
  }

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

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 47 * hash + Objects.hashCode(this.start);
    hash = 47 * hash + Objects.hashCode(this.end);
    hash = 47 * hash + Objects.hashCode(this.duration);
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
    final PeriodType other = (PeriodType) obj;
    if (!Objects.equals(this.start, other.start)) {
      return false;
    }
    if (!Objects.equals(this.end, other.end)) {
      return false;
    }
    if (!Objects.equals(this.duration, other.duration)) {
      return false;
    }
    return true;
  }
}
