package ietf.params.xml.ns.icalendar.parameter.base;

import ietf.params.xml.ns.icalendar.ERangeValueType;
import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for RangeParamType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="RangeParamType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType"> &lt;sequence>
 * &lt;element name="text"
 type="{urn:ietf:params:xml:ns:icalendar-2.0}ERangeValueType"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RangeParamType", propOrder = {
  "text"
})
public class RangeParamType extends BaseParameterType {

  @XmlElement(required = true)
  protected ERangeValueType text;

  /**
   * Gets the value of the text property.
   * <p/>
   * @return possible object is {@link ERangeValueType }
   *
   */
  public ERangeValueType getText() {
    return text;
  }

  /**
   * Sets the value of the text property.
   * <p/>
   * @param value allowed object is {@link ERangeValueType }
   *
   */
  public void setText(ERangeValueType value) {
    this.text = value;
  }

  public boolean isSetText() {
    return (this.text != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + (this.text != null ? this.text.hashCode() : 0);
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
    final RangeParamType other = (RangeParamType) obj;
    if (this.text != other.text) {
      return false;
    }
    return true;
  }
}
