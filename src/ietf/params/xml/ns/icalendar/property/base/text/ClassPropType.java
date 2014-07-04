package ietf.params.xml.ns.icalendar.property.base.text;

import ietf.params.xml.ns.icalendar.property.base.TextPropertyType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * classvalue = "PUBLIC" / "PRIVATE" / "CONFIDENTIAL" / iana-token / x-name
 * ;Default is PUBLIC
 * <p/>
 *
 * Java class for ClassPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="ClassPropType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}TextPropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassPropType")
public class ClassPropType extends TextPropertyType {

  public ClassPropType() {
  }

  public ClassPropType(String text) {
    super(text);
  }

}
