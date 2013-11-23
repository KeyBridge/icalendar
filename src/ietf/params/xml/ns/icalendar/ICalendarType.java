package ietf.params.xml.ns.icalendar;

import ietf.params.xml.ns.icalendar.component.base.VcalendarType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for IcalendarType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="IcalendarType"> &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}vcalendar" maxOccurs="unbounded"/>
 * &lt;/sequence> &lt;/restriction> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IcalendarType", propOrder = {
  "vcalendar"
})
public class ICalendarType {

  @XmlElement(required = true)
  protected List<VcalendarType> vcalendar;

  /**
   * Gets the value of the vcalendar property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the vcalendar property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getVcalendar().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list
     * {@link VcalendarType }
   *
   *
   */
  public List<VcalendarType> getVcalendar() {
    if (vcalendar == null) {
      vcalendar = new ArrayList<>();
    }
    return this.vcalendar;
  }

  public boolean isSetVcalendar() {
    return ((this.vcalendar != null) && (!this.vcalendar.isEmpty()));
  }

  public void unsetVcalendar() {
    this.vcalendar = null;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.vcalendar);
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
    final ICalendarType other = (ICalendarType) obj;
    if (!Objects.equals(this.vcalendar, other.vcalendar)) {
      return false;
    }
    return true;
  }
}
