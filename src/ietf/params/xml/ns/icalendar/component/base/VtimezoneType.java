package ietf.params.xml.ns.icalendar.component.base;

import ietf.params.xml.ns.icalendar.component.BaseComponentType;
import ietf.params.xml.ns.icalendar.component.EComponentName;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * Timezones only contain daylight and standard
 * <p/>
 *
 * Java class for VtimezoneType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="VtimezoneType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseComponentType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VtimezoneType")
public class VtimezoneType extends BaseComponentType {

  public VtimezoneType() {
    super(EComponentName.VTIMEZONE);
  }
}
