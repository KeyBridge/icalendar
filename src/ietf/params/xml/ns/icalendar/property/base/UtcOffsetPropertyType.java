package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.utcoffset.TzoffsetfromPropType;
import ietf.params.xml.ns.icalendar.property.base.utcoffset.TzoffsettoPropType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for UtcOffsetPropertyType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="UtcOffsetPropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}utc-offset"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UtcOffsetPropertyType", propOrder = {
  "utcOffset"
})
@XmlSeeAlso({
  TzoffsettoPropType.class,
  TzoffsetfromPropType.class
})
public class UtcOffsetPropertyType extends BasePropertyType {

  @XmlElement(name = "utc-offset", required = true)
  protected String utcOffset;

  /**
   * Gets the value of the utcOffset property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getUtcOffset() {
    return utcOffset;
  }

  /**
   * Sets the value of the utcOffset property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setUtcOffset(String value) {
    this.utcOffset = value;
  }

  public boolean isSetUtcOffset() {
    return (this.utcOffset != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 73 * hash + Objects.hashCode(this.utcOffset);
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
    final UtcOffsetPropertyType other = (UtcOffsetPropertyType) obj;
    if (!Objects.equals(this.utcOffset, other.utcOffset)) {
      return false;
    }
    return true;
  }
}
