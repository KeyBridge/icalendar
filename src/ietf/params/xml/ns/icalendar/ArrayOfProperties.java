package ietf.params.xml.ns.icalendar;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

/**
 * Java class for ArrayOfProperties complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="ArrayOfProperties"> &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence> &lt;choice maxOccurs="unbounded" minOccurs="0"> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}baseProperty"/> &lt;element
 * name="tzid" type="{urn:ietf:params:xml:ns:icalendar-2.0}TextPropertyType"/>
 * &lt;/choice> &lt;/sequence> &lt;/restriction> &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProperties", propOrder = {
  "basePropertyOrTzid"
})
public class ArrayOfProperties {

  @XmlElementRefs({
    @XmlElementRef(name = "baseProperty", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false),
    @XmlElementRef(name = "tzid", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
  })
  protected List<JAXBElement<? extends BasePropertyType>> basePropertyOrTzid;

  /**
   * Gets the value of the basePropertyOrTzid property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the basePropertyOrTzid property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getBasePropertyOrTzid().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list null null null
   * null null null null null null null null   {@link JAXBElement }{@code <}{@link RecurrenceIdPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link VersionPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link AttendeePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link SummaryPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link RdatePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link LastModifiedPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link TriggerPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link UidPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link XMicrosoftCdoBusystatusPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link ActionPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link ResourcesPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link WsCalendarAttachType }{@code >}
   * {@link JAXBElement }{@code <}{@link XBedeworkExsynchEndtzidPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link PercentCompletePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link TolerancePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link CalscalePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link ExrulePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link RrulePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link RepeatPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link UrlPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link TzoffsettoPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link AttachPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link XBedeworkRegistrationEndPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link TzoffsetfromPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link CompletedPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link OrganizerPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link DtstartPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link LocationPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link DurationPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link TextPropertyType }{@code >}
   * {@link JAXBElement }{@code <}{@link ContactPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link DescriptionPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link TznamePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link CreatedPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link GeoPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link MethodPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link DtendPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link BasePropertyType }{@code >}
   * {@link JAXBElement }{@code <}{@link ExdatePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link CategoriesPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link LinkPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link XBedeworkInstanceOnlyPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link DuePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link PriorityPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link TranspPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link CommentPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link OrganizerPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link DurationPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link ProdidPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link XBedeworkCostPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link StatusPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link XMicrosoftCdoIntendedstatusPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link WsCalendarTypeType }{@code >}
   * {@link JAXBElement }{@code <}{@link XBedeworkMaxTicketsPerUserPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link XBedeworkExsynchLastmodPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link SequencePropType }{@code >}
   * {@link JAXBElement }{@code <}{@link XBedeworkExsynchStarttzidPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link XBedeworkRegistrationStartPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link TzurlPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link ClassPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link DtstampPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link RequestStatusPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link RelatedToPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link XBedeworkMaxTicketsPropType }{@code >}
   * {@link JAXBElement }{@code <}{@link FreebusyPropType }{@code >}
   * <p/>
   *
   */
  public List<JAXBElement<? extends BasePropertyType>> getBasePropertyOrTzid() {
    if (basePropertyOrTzid == null) {
      basePropertyOrTzid = new ArrayList<JAXBElement<? extends BasePropertyType>>();
    }
    return this.basePropertyOrTzid;
  }

  public boolean isSetBasePropertyOrTzid() {
    return ((this.basePropertyOrTzid != null) && (!this.basePropertyOrTzid.isEmpty()));
  }

  public void unsetBasePropertyOrTzid() {
    this.basePropertyOrTzid = null;
  }

  /**
   * Method to add a jaXBElement to the baseProperty list.
   * <p/>
   * Developer note: Use the ObjectFactory to build jaXBElements.
   * <p/>
   * @param jaXBElement
   */
  public void addProperty(JAXBElement<? extends BasePropertyType> jaXBElement) {
    getBasePropertyOrTzid().add(jaXBElement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ArrayOfProperties ");
    if (basePropertyOrTzid != null) {
      for (JAXBElement<? extends BasePropertyType> jaxbElement : basePropertyOrTzid) {
        sb.append("\n")
          .append("  [").append(jaxbElement.getName()).append("]")
          .append(" ")
          .append(jaxbElement.getValue());
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.basePropertyOrTzid);
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
    final ArrayOfProperties other = (ArrayOfProperties) obj;
    if (!Objects.equals(this.basePropertyOrTzid, other.basePropertyOrTzid)) {
      return false;
    }
    return true;
  }
}
