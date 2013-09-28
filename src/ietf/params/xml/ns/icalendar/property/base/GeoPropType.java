package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for GeoPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="GeoPropType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"> &lt;sequence>
 * &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}latitude"/>
 * &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}longitude"/>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoPropType", propOrder = {
  "latitude",
  "longitude"
})
public class GeoPropType
  extends BasePropertyType {

  protected float latitude;
  protected float longitude;

  /**
   * Gets the value of the latitude property.
   * <p/>
   */
  public float getLatitude() {
    return latitude;
  }

  /**
   * Sets the value of the latitude property.
   * <p/>
   */
  public void setLatitude(float value) {
    this.latitude = value;
  }

  public boolean isSetLatitude() {
    return true;
  }

  /**
   * Gets the value of the longitude property.
   * <p/>
   */
  public float getLongitude() {
    return longitude;
  }

  /**
   * Sets the value of the longitude property.
   * <p/>
   */
  public void setLongitude(float value) {
    this.longitude = value;
  }

  public boolean isSetLongitude() {
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 19 * hash + Float.floatToIntBits(this.latitude);
    hash = 19 * hash + Float.floatToIntBits(this.longitude);
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
    final GeoPropType other = (GeoPropType) obj;
    if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
      return false;
    }
    if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(other.longitude)) {
      return false;
    }
    return true;
  }
}
