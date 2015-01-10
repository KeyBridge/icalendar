package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.ECalscaleValueType;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for CalscalePropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="CalscalePropType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element name="text"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}ECalscaleValueType"/>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalscalePropType", propOrder = {
  "text"
})
public class CalscalePropType extends BasePropertyType {

  @XmlElement(required = true)
  protected ECalscaleValueType text;

  public CalscalePropType() {
    this.text = ECalscaleValueType.GREGORIAN;
  }

  public CalscalePropType(ECalscaleValueType text) {
    this.text = text;
  }

  /**
   * Gets the value of the text property.
   * <p/>
   * @return possible object is {@link ECalscaleValueType }
   *
   */
  public ECalscaleValueType getText() {
    return text;
  }

  /**
   * Sets the value of the text property.
   * <p/>
   * @param value allowed object is {@link ECalscaleValueType }
   *
   */
  public void setText(ECalscaleValueType value) {
    this.text = value;
  }

  public boolean isSetText() {
    return (this.text != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 71 * hash + (this.text != null ? this.text.hashCode() : 0);
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
    final CalscalePropType other = (CalscalePropType) obj;
    if (this.text != other.text) {
      return false;
    }
    return true;
  }
}
