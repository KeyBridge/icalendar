package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for LinkPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="LinkPropType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"> &lt;choice>
 * &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}uri"/> &lt;element
 * name="uid" type="{http://www.w3.org/2001/XMLSchema}string"/> &lt;element
 * name="reference" type="{http://www.w3.org/2001/XMLSchema}string"/>
 * &lt;/choice> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkPropType", propOrder = {
  "uri",
  "uid",
  "reference"
})
public class LinkPropType extends BasePropertyType {

  protected String uri;
  protected String uid;
  protected String reference;

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
   * Gets the value of the uid property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getUid() {
    return uid;
  }

  /**
   * Sets the value of the uid property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setUid(String value) {
    this.uid = value;
  }

  public boolean isSetUid() {
    return (this.uid != null);
  }

  /**
   * Gets the value of the reference property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getReference() {
    return reference;
  }

  /**
   * Sets the value of the reference property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setReference(String value) {
    this.reference = value;
  }

  public boolean isSetReference() {
    return (this.reference != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 71 * hash + Objects.hashCode(this.uri);
    hash = 71 * hash + Objects.hashCode(this.uid);
    hash = 71 * hash + Objects.hashCode(this.reference);
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
    final LinkPropType other = (LinkPropType) obj;
    if (!Objects.equals(this.uri, other.uri)) {
      return false;
    }
    if (!Objects.equals(this.uid, other.uid)) {
      return false;
    }
    if (!Objects.equals(this.reference, other.reference)) {
      return false;
    }
    return true;
  }
}
