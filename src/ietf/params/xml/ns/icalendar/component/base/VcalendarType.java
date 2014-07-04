package ietf.params.xml.ns.icalendar.component.base;

import ietf.params.xml.ns.icalendar.component.BaseComponentType;
import ietf.params.xml.ns.icalendar.component.EComponentName;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * This type is the basis for all components and provides a base class for
 * applications.
 * <p/>
 *
 * Java class for VcalendarType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="VcalendarType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseComponentType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VcalendarType")
public class VcalendarType extends BaseComponentType {

  public VcalendarType() {
    super(EComponentName.VCALENDAR);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final String toString() {
    final StringBuilder b = new StringBuilder();
    b.append(BEGIN).append(':').append(getName());
    b.append(LINE_SEPARATOR);
    b.append(getProperties());
    b.append(getComponents());
    b.append(END).append(':').append(getName());
    b.append(LINE_SEPARATOR);
    return b.toString();
  }

}
