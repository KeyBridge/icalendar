package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for AttachPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="AttachPropType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"> &lt;choice>
 * &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}uri"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}binary"/> &lt;/choice>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachPropType", propOrder = {
  "uri",
  "binary"
})
public class AttachPropType extends BasePropertyType {

  protected String uri;
  protected String binary;

  /**
   * Gets the value of the uri property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getUri() {
    return uri;
  }

  /**
   * Sets the value of the uri property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setUri(String value) {
    this.uri = value;
  }

  public boolean isSetUri() {
    return (this.uri != null);
  }

  /**
   * Gets the value of the binary property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getBinary() {
    return binary;
  }

  /**
   * Sets the value of the binary property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setBinary(String value) {
    this.binary = value;
  }

  public boolean isSetBinary() {
    return (this.binary != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 19 * hash + Objects.hashCode(this.uri);
    hash = 19 * hash + Objects.hashCode(this.binary);
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
    final AttachPropType other = (AttachPropType) obj;
    if (!Objects.equals(this.uri, other.uri)) {
      return false;
    }
    if (!Objects.equals(this.binary, other.binary)) {
      return false;
    }
    return true;
  }
}
