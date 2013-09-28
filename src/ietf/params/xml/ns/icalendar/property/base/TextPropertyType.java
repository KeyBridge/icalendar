package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.text.ClassPropType;
import ietf.params.xml.ns.icalendar.property.base.text.DescriptionPropType;
import ietf.params.xml.ns.icalendar.property.base.text.TzidPropType;
import ietf.params.xml.ns.icalendar.property.base.text.StatusPropType;
import ietf.params.xml.ns.icalendar.property.base.text.UidPropType;
import ietf.params.xml.ns.icalendar.property.base.text.TranspPropType;
import ietf.params.xml.ns.icalendar.property.base.text.LocationPropType;
import ietf.params.xml.ns.icalendar.property.base.text.XBedeworkExsynchLastmodPropType;
import ietf.params.xml.ns.icalendar.property.base.text.SummaryPropType;
import ietf.params.xml.ns.icalendar.property.base.text.ProdidPropType;
import ietf.params.xml.ns.icalendar.property.base.text.MethodPropType;
import ietf.params.xml.ns.icalendar.property.base.text.BusytypePropType;
import ietf.params.xml.ns.icalendar.property.base.text.ContactPropType;
import ietf.params.xml.ns.icalendar.property.base.text.XBedeworkCostPropType;
import ietf.params.xml.ns.icalendar.property.base.text.XBedeworkInstanceOnlyPropType;
import ietf.params.xml.ns.icalendar.property.base.text.TznamePropType;
import ietf.params.xml.ns.icalendar.property.base.text.XBedeworkExsynchEndtzidPropType;
import ietf.params.xml.ns.icalendar.property.base.text.XBedeworkExsynchStarttzidPropType;
import ietf.params.xml.ns.icalendar.property.base.text.VersionPropType;
import ietf.params.xml.ns.icalendar.property.base.text.XMicrosoftCdoBusystatusPropType;
import ietf.params.xml.ns.icalendar.property.base.text.XMicrosoftCdoIntendedstatusPropType;
import ietf.params.xml.ns.icalendar.property.base.text.CommentPropType;
import ietf.params.xml.ns.icalendar.property.base.text.ActionPropType;
import ietf.params.xml.ns.icalendar.property.base.text.WsCalendarTypeType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for TextPropertyType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="TextPropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}text"/>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextPropertyType", propOrder = {
  "text"
})
@XmlSeeAlso({
  ActionPropType.class,
  BusytypePropType.class,
  ClassPropType.class,
  CommentPropType.class,
  ContactPropType.class,
  DescriptionPropType.class,
  LocationPropType.class,
  MethodPropType.class,
  ProdidPropType.class,
  StatusPropType.class,
  SummaryPropType.class,
  TranspPropType.class,
  TzidPropType.class,
  TznamePropType.class,
  UidPropType.class,
  VersionPropType.class,
  WsCalendarTypeType.class,
  XBedeworkCostPropType.class,
  XBedeworkExsynchEndtzidPropType.class,
  XBedeworkExsynchLastmodPropType.class,
  XBedeworkExsynchStarttzidPropType.class,
  XBedeworkInstanceOnlyPropType.class,
  XMicrosoftCdoBusystatusPropType.class,
  XMicrosoftCdoIntendedstatusPropType.class
})
public class TextPropertyType extends BasePropertyType {

  @XmlElement(required = true)
  protected String text;

  public TextPropertyType() {
  }

  public TextPropertyType(String text) {
    this.text = text;
  }

  /**
   * Gets the value of the text property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the value of the text property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setText(String value) {
    this.text = value;
  }

  public boolean isSetText() {
    return (this.text != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 17 * hash + Objects.hashCode(this.text);
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
    final TextPropertyType other = (TextPropertyType) obj;
    if (!Objects.equals(this.text, other.text)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "TextPropertyType{" + "text=" + text + '}';
  }
}
