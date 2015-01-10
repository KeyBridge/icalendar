package ietf.params.xml.ns.icalendar.property.base.recur;

import ietf.params.xml.ns.icalendar.RecurType;
import ietf.params.xml.ns.icalendar.property.base.RecurPropertyType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for RrulePropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="RrulePropType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}RecurPropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RrulePropType")
public class RrulePropType extends RecurPropertyType {

  public RrulePropType() {
  }

  public RrulePropType(RecurType recur) {
    super(recur);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
