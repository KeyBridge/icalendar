package ietf.params.xml.ns.icalendar;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * A tolerance value is a set of durations which indicate the allowed tolerance
 * for the indicated value, e.g. startafter=PT5M indicates that 5 minutes late
 * is acceptable.
 * <p/>
 *
 * Java class for ToleranceValueType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="ToleranceValueType"> &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence> &lt;element name="startbefore"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"
 * minOccurs="0"/> &lt;element name="startafter"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"
 * minOccurs="0"/> &lt;element name="endbefore"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"
 * minOccurs="0"/> &lt;element name="endafter"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"
 * minOccurs="0"/> &lt;element name="durationlong"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"
 * minOccurs="0"/> &lt;element name="durationshort"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"
 * minOccurs="0"/> &lt;element name="precision"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"
 * minOccurs="0"/> &lt;/sequence> &lt;/restriction> &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ToleranceValueType", propOrder = {
  "startbefore",
  "startafter",
  "endbefore",
  "endafter",
  "durationlong",
  "durationshort",
  "precision"
})
public class ToleranceValueType {

  protected String startbefore;
  protected String startafter;
  protected String endbefore;
  protected String endafter;
  protected String durationlong;
  protected String durationshort;
  protected String precision;

  /**
   * Gets the value of the startbefore property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getStartbefore() {
    return startbefore;
  }

  /**
   * Sets the value of the startbefore property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setStartbefore(String value) {
    this.startbefore = value;
  }

  public boolean isSetStartbefore() {
    return (this.startbefore != null);
  }

  /**
   * Gets the value of the startafter property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getStartafter() {
    return startafter;
  }

  /**
   * Sets the value of the startafter property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setStartafter(String value) {
    this.startafter = value;
  }

  public boolean isSetStartafter() {
    return (this.startafter != null);
  }

  /**
   * Gets the value of the endbefore property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getEndbefore() {
    return endbefore;
  }

  /**
   * Sets the value of the endbefore property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setEndbefore(String value) {
    this.endbefore = value;
  }

  public boolean isSetEndbefore() {
    return (this.endbefore != null);
  }

  /**
   * Gets the value of the endafter property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getEndafter() {
    return endafter;
  }

  /**
   * Sets the value of the endafter property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setEndafter(String value) {
    this.endafter = value;
  }

  public boolean isSetEndafter() {
    return (this.endafter != null);
  }

  /**
   * Gets the value of the durationlong property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getDurationlong() {
    return durationlong;
  }

  /**
   * Sets the value of the durationlong property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setDurationlong(String value) {
    this.durationlong = value;
  }

  public boolean isSetDurationlong() {
    return (this.durationlong != null);
  }

  /**
   * Gets the value of the durationshort property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getDurationshort() {
    return durationshort;
  }

  /**
   * Sets the value of the durationshort property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setDurationshort(String value) {
    this.durationshort = value;
  }

  public boolean isSetDurationshort() {
    return (this.durationshort != null);
  }

  /**
   * Gets the value of the precision property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getPrecision() {
    return precision;
  }

  /**
   * Sets the value of the precision property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setPrecision(String value) {
    this.precision = value;
  }

  public boolean isSetPrecision() {
    return (this.precision != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.startbefore);
    hash = 97 * hash + Objects.hashCode(this.startafter);
    hash = 97 * hash + Objects.hashCode(this.endbefore);
    hash = 97 * hash + Objects.hashCode(this.endafter);
    hash = 97 * hash + Objects.hashCode(this.durationlong);
    hash = 97 * hash + Objects.hashCode(this.durationshort);
    hash = 97 * hash + Objects.hashCode(this.precision);
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
    final ToleranceValueType other = (ToleranceValueType) obj;
    if (!Objects.equals(this.startbefore, other.startbefore)) {
      return false;
    }
    if (!Objects.equals(this.startafter, other.startafter)) {
      return false;
    }
    if (!Objects.equals(this.endbefore, other.endbefore)) {
      return false;
    }
    if (!Objects.equals(this.endafter, other.endafter)) {
      return false;
    }
    if (!Objects.equals(this.durationlong, other.durationlong)) {
      return false;
    }
    if (!Objects.equals(this.durationshort, other.durationshort)) {
      return false;
    }
    if (!Objects.equals(this.precision, other.precision)) {
      return false;
    }
    return true;
  }
}
