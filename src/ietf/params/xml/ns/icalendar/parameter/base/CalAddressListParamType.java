package ietf.params.xml.ns.icalendar.parameter.base;

import ietf.params.xml.ns.icalendar.parameter.base.caladdresslist.DelegatedFromParamType;
import ietf.params.xml.ns.icalendar.parameter.base.caladdresslist.DelegatedToParamType;
import ietf.params.xml.ns.icalendar.parameter.base.caladdresslist.MemberParamType;
import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for CalAddressListParamType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="CalAddressListParamType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}cal-address"
 * maxOccurs="unbounded"/> &lt;/sequence> &lt;/extension> &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalAddressListParamType", propOrder = {
  "calAddress"
})
@XmlSeeAlso({
  DelegatedToParamType.class,
  DelegatedFromParamType.class,
  MemberParamType.class
})
public class CalAddressListParamType
  extends BaseParameterType {

  @XmlElement(name = "cal-address", required = true)
  protected List<String> calAddress;

  /**
   * Gets the value of the calAddress property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the calAddress property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getCalAddress().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list {@link String }
   *
   *
   */
  public List<String> getCalAddress() {
    if (calAddress == null) {
      calAddress = new ArrayList<String>();
    }
    return this.calAddress;
  }

  public boolean isSetCalAddress() {
    return ((this.calAddress != null) && (!this.calAddress.isEmpty()));
  }

  public void unsetCalAddress() {
    this.calAddress = null;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 61 * hash + Objects.hashCode(this.calAddress);
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
    final CalAddressListParamType other = (CalAddressListParamType) obj;
    if (!Objects.equals(this.calAddress, other.calAddress)) {
      return false;
    }
    return true;
  }
}
