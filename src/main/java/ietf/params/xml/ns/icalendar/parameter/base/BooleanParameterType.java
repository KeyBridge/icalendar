package ietf.params.xml.ns.icalendar.parameter.base;

import ietf.params.xml.ns.icalendar.parameter.base.bool.RsvpParamType;
import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for BooleanParameterType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="BooleanParameterType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}boolean"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BooleanParameterType", propOrder = {
  "_boolean"
})
@XmlSeeAlso({
  RsvpParamType.class
})
public class BooleanParameterType extends BaseParameterType {

  @XmlElement(name = "boolean")
  protected boolean _boolean;

  /**
   * Gets the value of the boolean property.
   * <p/>
   */
  public boolean isBoolean() {
    return _boolean;
  }

  /**
   * Sets the value of the boolean property.
   * <p/>
   */
  public void setBoolean(boolean value) {
    this._boolean = value;
  }

  public boolean isSetBoolean() {
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 61 * hash + (this._boolean ? 1 : 0);
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
    final BooleanParameterType other = (BooleanParameterType) obj;
    if (this._boolean != other._boolean) {
      return false;
    }
    return true;
  }
}
