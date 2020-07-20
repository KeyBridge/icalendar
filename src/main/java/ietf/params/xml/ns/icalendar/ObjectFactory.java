/*
 * Copyright 2016 Key Bridge LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ietf.params.xml.ns.icalendar;

import ietf.params.xml.ns.icalendar.component.BaseComponentType;
import ietf.params.xml.ns.icalendar.component.base.*;
import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import ietf.params.xml.ns.icalendar.parameter.base.*;
import ietf.params.xml.ns.icalendar.parameter.base.bool.RsvpParamType;
import ietf.params.xml.ns.icalendar.parameter.base.caladdress.SentByParamType;
import ietf.params.xml.ns.icalendar.parameter.base.caladdresslist.DelegatedFromParamType;
import ietf.params.xml.ns.icalendar.parameter.base.caladdresslist.DelegatedToParamType;
import ietf.params.xml.ns.icalendar.parameter.base.caladdresslist.MemberParamType;
import ietf.params.xml.ns.icalendar.parameter.base.text.*;
import ietf.params.xml.ns.icalendar.parameter.base.uri.AltrepParamType;
import ietf.params.xml.ns.icalendar.parameter.base.uri.DirParamType;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.*;
import ietf.params.xml.ns.icalendar.property.base.caladdress.AttendeePropType;
import ietf.params.xml.ns.icalendar.property.base.caladdress.OrganizerPropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.*;
import ietf.params.xml.ns.icalendar.property.base.integer.*;
import ietf.params.xml.ns.icalendar.property.base.recur.ExrulePropType;
import ietf.params.xml.ns.icalendar.property.base.recur.RrulePropType;
import ietf.params.xml.ns.icalendar.property.base.text.*;
import ietf.params.xml.ns.icalendar.property.base.textlist.CategoriesPropType;
import ietf.params.xml.ns.icalendar.property.base.textlist.ResourcesPropType;
import ietf.params.xml.ns.icalendar.property.base.uri.TzurlPropType;
import ietf.params.xml.ns.icalendar.property.base.uri.UrlPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.CompletedPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.CreatedPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.DtstampPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.LastModifiedPropType;
import ietf.params.xml.ns.icalendar.property.base.utcoffset.TzoffsetfromPropType;
import ietf.params.xml.ns.icalendar.property.base.utcoffset.TzoffsettoPropType;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.URL;
import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the ietf.params.xml.ns.icalendar_2 package. An
 * ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

  private final static QName _RecurrenceId_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "recurrence-id");
  private final static QName _Priority_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "priority");
  private final static QName _Description_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "description");
  private final static QName _Resources_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "resources");
  private final static QName _Cn_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "cn");
  private final static QName _XMicrosoftCdoBusystatus_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-microsoft-cdo-busystatus");
  private final static QName _CalAddress_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "cal-address");
  private final static QName _Geo_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "geo");
  private final static QName _Vtimezone_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vtimezone");
  private final static QName _DateTime_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "date-time");
  private final static QName _Vcalendar_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vcalendar");
  private final static QName _Categories_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "categories");
  private final static QName _XBedeworkRegistrationStart_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-registration-start");
  private final static QName _Cutype_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "cutype");
  private final static QName _XBedeworkMaxTicketsPerUser_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-max-tickets-per-user");
  private final static QName _XBedeworkUid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-uid");
  private final static QName _XWsCalendarAttach_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-wsCalendar-attach");
  private final static QName _Role_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "role");
  private final static QName _Created_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "created");
  private final static QName _XWscalendarType_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-wscalendar-type");
  private final static QName _Time_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "time");
  private final static QName _Float_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "float");
  private final static QName _Until_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "until");
  private final static QName _Attendee_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "attendee");
  private final static QName _Components_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "components");
  private final static QName _RequestStatus_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "request-status");
  private final static QName _Rel_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "rel");
  private final static QName _XBedeworkExsynchOrganizer_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-exsynch-organizer");
  private final static QName _Sequence_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "sequence");
  private final static QName _Integer_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "integer");
  private final static QName _Member_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "member");
  private final static QName _Action_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "action");
  private final static QName _Tzoffsetto_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tzoffsetto");
  private final static QName _Dtstart_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "dtstart");
  private final static QName _Fmttype_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "fmttype");
  private final static QName _XBedeworkCost_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-cost");
  private final static QName _Related_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "related");
  private final static QName _Location_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "location");
  private final static QName _Count_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "count");
  private final static QName _XMicrosoftCdoIntendedstatus_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-microsoft-cdo-intendedstatus");
  private final static QName _XBedeworkInstanceOnly_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-instance-only");
  private final static QName _Dtend_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "dtend");
  private final static QName _Icalendar_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "icalendar");
  private final static QName _ArtifactBase_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "artifactBase");
  private final static QName _Rsvp_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "rsvp");
  private final static QName _Duration_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "duration");
  private final static QName _Standard_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "standard");
  private final static QName _Tolerance_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tolerance");
  private final static QName _Comment_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "comment");
  private final static QName _Gap_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "gap");
  private final static QName _Partstat_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "partstat");
  private final static QName _XBedeworkMaxTickets_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-max-tickets");
  private final static QName _XBedeworkRegistrationEnd_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-registration-end");
  private final static QName _Completed_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "completed");
  private final static QName _Encoding_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "encoding");
  private final static QName _Valarm_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "valarm");
  private final static QName _Calscale_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "calscale");
  private final static QName _Interval_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "interval");
  private final static QName _Vtodo_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vtodo");
  private final static QName _Binary_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "binary");
  private final static QName _Tzid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tzid");
  private final static QName _Dtstamp_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "dtstamp");
  private final static QName _Method_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "method");
  private final static QName _Vavailability_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vavailability");
  private final static QName _Freebusy_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "freebusy");
  private final static QName _Parameters_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "parameters");
  private final static QName _XBedeworkExsynchEndtzid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-exsynch-endtzid");
  private final static QName _XBedeworkExsynchStarttzid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-exsynch-starttzid");
  private final static QName _Due_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "due");
  private final static QName _Uri_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "uri");
  private final static QName _Period_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "period");
  private final static QName _Url_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "url");
  private final static QName _Text_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "text");
  private final static QName _RelatedTo_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "related-to");
  private final static QName _Repeat_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "repeat");
  private final static QName _Daylight_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "daylight");
  private final static QName _BaseComponent_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "baseComponent");
  private final static QName _Boolean_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "boolean");
  private final static QName _Rdate_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "rdate");
  private final static QName _Summary_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "summary");
  private final static QName _UtcOffset_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "utc-offset");
  private final static QName _Latitude_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "latitude");
  private final static QName _ScheduleAgent_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "schedule-agent");
  private final static QName _DelegatedFrom_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "delegated-from");
  private final static QName _Vfreebusy_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vfreebusy");
  private final static QName _Available_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "available");
  private final static QName _Organizer_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "organizer");
  private final static QName _ScheduleForceSend_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "schedule-force-send");
  private final static QName _Date_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "date");
  private final static QName _Tzname_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tzname");
  private final static QName _BaseParameter_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "baseParameter");
  private final static QName _Exdate_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "exdate");
  private final static QName _Artifact_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "artifact");
  private final static QName _Longitude_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "longitude");
  private final static QName _Granularity_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "granularity");
  private final static QName _UtcDateTime_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "utc-date-time");
  private final static QName _Prodid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "prodid");
  private final static QName _BaseProperty_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "baseProperty");
  private final static QName _Rrule_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "rrule");
  private final static QName _Uid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "uid");
  private final static QName _Transp_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "transp");
  private final static QName _Altrep_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "altrep");
  private final static QName _Class_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "class");
  private final static QName _Properties_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "properties");
  private final static QName _Status_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "status");
  private final static QName _Dir_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "dir");
  private final static QName _ScheduleStatus_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "schedule-status");
  private final static QName _Tzoffsetfrom_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tzoffsetfrom");
  private final static QName _Vevent_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vevent");
  private final static QName _DelegatedTo_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "delegated-to");
  private final static QName _XBedeworkExsynchLastmod_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-exsynch-lastmod");
  private final static QName _Language_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "language");
  private final static QName _Reltype_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "reltype");
  private final static QName _SentBy_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "sent-by");
  private final static QName _PercentComplete_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "percent-complete");
  private final static QName _Exrule_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "exrule");
  private final static QName _Gluon_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "gluon");
  private final static QName _Contact_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "contact");
  private final static QName _Fbtype_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "fbtype");
  private final static QName _Version_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "version");
  private final static QName _Range_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "range");
  private final static QName _Link_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "link");
  private final static QName _Attach_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "attach");
  private final static QName _Vjournal_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vjournal");
  private final static QName _LastModified_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "last-modified");
  private final static QName _Trigger_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "trigger");
  private final static QName _Tzurl_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tzurl");

  public ObjectFactory() {
  }

  public SummaryPropType createSummaryPropType() {
    return new SummaryPropType();
  }

  public XBedeworkExsynchLastmodPropType createXBedeworkExsynchLastmodPropType() {
    return new XBedeworkExsynchLastmodPropType();
  }

  public DelegatedToParamType createDelegatedToParamType() {
    return new DelegatedToParamType();
  }

  public AttendeePropType createAttendeePropType() {
    return new AttendeePropType();
  }

  public VeventType createVeventType() {
    return new VeventType();
  }

  public UntilRecurType createUntilRecurType() {
    return UntilRecurType.getInstance();
  }

  public RdatePropType createRdatePropType() {
    return new RdatePropType();
  }

  public WsCalendarTypeType createWsCalendarTypeType() {
    return new WsCalendarTypeType();
  }

  public CreatedPropType createCreatedPropType() {
    return new CreatedPropType();
  }

  public TolerancePropType createTolerancePropType() {
    return new TolerancePropType();
  }

  public RoleParamType createRoleParamType() {
    return new RoleParamType();
  }

  public XBedeworkUidParamType createXBedeworkUidParamType() {
    return new XBedeworkUidParamType();
  }

  public WsCalendarAttachType createWsCalendarAttachType() {
    return new WsCalendarAttachType();
  }

  public PercentCompletePropType createPercentCompletePropType() {
    return new PercentCompletePropType();
  }

  public RequestStatusPropType createRequestStatusPropType() {
    return new RequestStatusPropType();
  }

  public XBedeworkRegistrationEndPropType createXBedeworkRegistrationEndPropType() {
    return new XBedeworkRegistrationEndPropType();
  }

  public OrganizerPropType createOrganizerPropType() {
    return new OrganizerPropType();
  }

  public AvailableType createAvailableType() {
    return new AvailableType();
  }

  public VfreebusyType createVfreebusyType() {
    return new VfreebusyType();
  }

  public XBedeworkMaxTicketsPropType createXBedeworkMaxTicketsPropType() {
    return new XBedeworkMaxTicketsPropType();
  }

  public DelegatedFromParamType createDelegatedFromParamType() {
    return new DelegatedFromParamType();
  }

  public ScheduleAgentParamType createScheduleAgentParamType() {
    return new ScheduleAgentParamType();
  }

  public SentByParamType createSentByParamType() {
    return new SentByParamType();
  }

  public PartstatParamType createPartstatParamType() {
    return new PartstatParamType();
  }

  public ReltypeParamType createReltypeParamType() {
    return new ReltypeParamType();
  }

  public ArrayOfComponents createArrayOfComponents() {
    return new ArrayOfComponents();
  }

  public LanguageParamType createLanguageParamType() {
    return new LanguageParamType();
  }

  public CommentPropType createCommentPropType() {
    return new CommentPropType();
  }

  public DurationParameterType createDurationParameterType() {
    return new DurationParameterType();
  }

  public VtodoType createVtodoType() {
    return new VtodoType();
  }

  public WsCalendarIntervalType createWsCalendarIntervalType() {
    return new WsCalendarIntervalType();
  }

  public RangeParamType createRangeParamType() {
    return new RangeParamType();
  }

  public LinkPropType createLinkPropType() {
    return new LinkPropType();
  }

  public FbtypeParamType createFbtypeParamType() {
    return new FbtypeParamType();
  }

  public CalscalePropType createCalscalePropType() {
    return new CalscalePropType();
  }

  public ContactPropType createContactPropType() {
    return new ContactPropType();
  }

  public TznamePropType createTznamePropType() {
    return new TznamePropType();
  }

  public VersionPropType createVersionPropType() {
    return new VersionPropType();
  }

  public ValarmType createValarmType() {
    return new ValarmType();
  }

  public ScheduleForceSendParamType createScheduleForceSendParamType() {
    return new ScheduleForceSendParamType();
  }

  public ExrulePropType createExrulePropType() {
    return new ExrulePropType();
  }

  public WsCalendarGluonType createWsCalendarGluonType() {
    return new WsCalendarGluonType();
  }

  public EncodingParamType createEncodingParamType() {
    return new EncodingParamType();
  }

  public CompletedPropType createCompletedPropType() {
    return new CompletedPropType();
  }

  public MemberParamType createMemberParamType() {
    return new MemberParamType();
  }

  public TzurlPropType createTzurlPropType() {
    return new TzurlPropType();
  }

  public TriggerPropType createTriggerPropType() {
    return new TriggerPropType();
  }

  public VavailabilityType createVavailabilityType() {
    return new VavailabilityType();
  }

  public LastModifiedPropType createLastModifiedPropType() {
    return new LastModifiedPropType();
  }

  public VjournalType createVjournalType() {
    return new VjournalType();
  }

  public ArtifactType createArtifactType() {
    return new ArtifactType();
  }

  public AttachPropType createAttachPropType() {
    return new AttachPropType();
  }

  public SequencePropType createSequencePropType() {
    return new SequencePropType();
  }

  public MethodPropType createMethodPropType() {
    return new MethodPropType();
  }

  public TextParameterType createTextParameterType() {
    return new TextParameterType();
  }

  public ExdatePropType createExdatePropType() {
    return new ExdatePropType();
  }

  public DtstampPropType createDtstampPropType() {
    return new DtstampPropType();
  }

  public TzidParamType createTzidParamType() {
    return new TzidParamType();
  }

  public UidPropType createUidPropType() {
    return new UidPropType();
  }

  public ResourcesPropType createResourcesPropType() {
    return new ResourcesPropType();
  }

  public LocationPropType createLocationPropType() {
    return new LocationPropType();
  }

  public RrulePropType createRrulePropType() {
    return new RrulePropType();
  }

  public XMicrosoftCdoIntendedstatusPropType createXMicrosoftCdoIntendedstatusPropType() {
    return new XMicrosoftCdoIntendedstatusPropType();
  }

  public ProdidPropType createProdidPropType() {
    return new ProdidPropType();
  }

  public FmttypeParamType createFmttypeParamType() {
    return new FmttypeParamType();
  }

  public RelatedParamType createRelatedParamType() {
    return new RelatedParamType();
  }

  public XBedeworkCostPropType createXBedeworkCostPropType() {
    return new XBedeworkCostPropType();
  }

  public DtstartPropType createDtstartPropType() {
    return new DtstartPropType();
  }

  public XBedeworkExsynchStarttzidPropType createXBedeworkExsynchStarttzidPropType() {
    return new XBedeworkExsynchStarttzidPropType();
  }

  public XBedeworkExsynchEndtzidPropType createXBedeworkExsynchEndtzidPropType() {
    return new XBedeworkExsynchEndtzidPropType();
  }

  public DescriptionPropType createDescriptionPropType() {
    return new DescriptionPropType();
  }

  public PriorityPropType createPriorityPropType(int priority) {
    return new PriorityPropType(priority);
  }

  public DurationPropType createDurationPropType() {
    return new DurationPropType();
  }

  public FreebusyPropType createFreebusyPropType() {
    return new FreebusyPropType();
  }

  public RecurrenceIdPropType createRecurrenceIdPropType() {
    return new RecurrenceIdPropType();
  }

  public ActionPropType createActionPropType() {
    return new ActionPropType();
  }

  public TzoffsettoPropType createTzoffsettoPropType() {
    return new TzoffsettoPropType();
  }

  public ArrayOfParameters createArrayOfParameters() {
    return new ArrayOfParameters();
  }

  public GeoPropType createGeoPropType() {
    return new GeoPropType();
  }

  public DtendPropType createDtendPropType() {
    return new DtendPropType();
  }

  public StatusPropType createStatusPropType() {
    return new StatusPropType();
  }

  public ClassPropType createClassPropType() {
    return new ClassPropType();
  }

  public ArrayOfProperties createArrayOfProperties() {
    return new ArrayOfProperties();
  }

  public PeriodType createPeriodType() {
    return new PeriodType();
  }

  public AltrepParamType createAltrepParamType() {
    return new AltrepParamType();
  }

  public UrlPropType createUrlPropType() {
    return new UrlPropType();
  }

  public XBedeworkInstanceOnlyPropType createXBedeworkInstanceOnlyPropType() {
    return new XBedeworkInstanceOnlyPropType();
  }

  public XMicrosoftCdoBusystatusPropType createXMicrosoftCdoBusystatusPropType() {
    return new XMicrosoftCdoBusystatusPropType();
  }

  public CnParamType createCnParamType() {
    return new CnParamType();
  }

  public DuePropType createDuePropType() {
    return new DuePropType();
  }

  public TranspPropType createTranspPropType() {
    return new TranspPropType();
  }

  public VtimezoneType createVtimezoneType() {
    return new VtimezoneType();
  }

  public RepeatPropType createRepeatPropType() {
    return new RepeatPropType();
  }

  public RelatedToPropType createRelatedToPropType() {
    return new RelatedToPropType();
  }

  public ICalendarType createIcalendarType() {
    return new ICalendarType();
  }

  public DirParamType createDirParamType() {
    return new DirParamType();
  }

  public StandardType createStandardType() {
    return new StandardType();
  }

  public TzoffsetfromPropType createTzoffsetfromPropType() {
    return new TzoffsetfromPropType();
  }

  public XBedeworkMaxTicketsPerUserPropType createXBedeworkMaxTicketsPerUserPropType() {
    return new XBedeworkMaxTicketsPerUserPropType();
  }

  public ScheduleStatusParamType createScheduleStatusParamType() {
    return new ScheduleStatusParamType();
  }

  public CutypeParamType createCutypeParamType() {
    return new CutypeParamType();
  }

  public XBedeworkRegistrationStartPropType createXBedeworkRegistrationStartPropType() {
    return new XBedeworkRegistrationStartPropType();
  }

  public RsvpParamType createRsvpParamType() {
    return new RsvpParamType();
  }

  public VcalendarType createVcalendarType() {
    return new VcalendarType();
  }

  public CategoriesPropType createCategoriesPropType() {
    return new CategoriesPropType();
  }

  public DaylightType createDaylightType() {
    return new DaylightType();
  }

  public DateDatetimePropertyType createDateDatetimePropertyType() {
    return new DateDatetimePropertyType();
  }

  public DatetimePropertyType createDatetimePropertyType() {
    return new DatetimePropertyType();
  }

  public CalAddressPropertyType createCalAddressPropertyType() {
    return new CalAddressPropertyType();
  }

  public UtcDatetimePropertyType createUtcDatetimePropertyType() {
    return new UtcDatetimePropertyType();
  }

  public CalAddressParamType createCalAddressParamType() {
    return new CalAddressParamType();
  }

  public UtcOffsetPropertyType createUtcOffsetPropertyType() {
    return new UtcOffsetPropertyType();
  }

  public CalAddressListParamType createCalAddressListParamType() {
    return new CalAddressListParamType();
  }

  public TextListPropertyType createTextListPropertyType() {
    return new TextListPropertyType();
  }

  public BooleanParameterType createBooleanParameterType() {
    return new BooleanParameterType();
  }

  public TextPropertyType createTextPropertyType() {
    return new TextPropertyType();
  }

  public RecurPropertyType createRecurPropertyType() {
    return new RecurPropertyType();
  }

  public IntegerPropertyType createIntegerPropertyType() {
    return new IntegerPropertyType();
  }

  public BusytypePropType createBusytypePropType() {
    return new BusytypePropType();
  }

  public UriPropertyType createUriPropertyType() {
    return new UriPropertyType();
  }

  public RecurType createRecurType() {
    return new RecurType();
  }

  public TzidPropType createTzidPropType() {
    return new TzidPropType();
  }

  public ToleranceValueType createToleranceValueType() {
    return new ToleranceValueType();
  }

  public UriParameterType createUriParameterType() {
    return new UriParameterType();
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "recurrence-id", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<RecurrenceIdPropType> createRecurrenceId(RecurrenceIdPropType value) {
    return new JAXBElement<>(_RecurrenceId_QNAME, RecurrenceIdPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "priority", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<PriorityPropType> createPriority(PriorityPropType value) {
    return new JAXBElement<>(_Priority_QNAME, PriorityPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "description", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<DescriptionPropType> createDescription(DescriptionPropType value) {
    return new JAXBElement<>(_Description_QNAME, DescriptionPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "resources", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<ResourcesPropType> createResources(ResourcesPropType value) {
    return new JAXBElement<>(_Resources_QNAME, ResourcesPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "cn", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<CnParamType> createCn(CnParamType value) {
    return new JAXBElement<>(_Cn_QNAME, CnParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-microsoft-cdo-busystatus", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XMicrosoftCdoBusystatusPropType> createXMicrosoftCdoBusystatus(XMicrosoftCdoBusystatusPropType value) {
    return new JAXBElement<>(_XMicrosoftCdoBusystatus_QNAME, XMicrosoftCdoBusystatusPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "cal-address")
  public JAXBElement<String> createCalAddress(String value) {
    return new JAXBElement<>(_CalAddress_QNAME, String.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "geo", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<GeoPropType> createGeo(GeoPropType value) {
    return new JAXBElement<>(_Geo_QNAME, GeoPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vtimezone", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<VtimezoneType> createVtimezone(VtimezoneType value) {
    return new JAXBElement<>(_Vtimezone_QNAME, VtimezoneType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "date-time")
  public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
    return new JAXBElement<>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vcalendar")
  public JAXBElement<VcalendarType> createVcalendar(VcalendarType value) {
    return new JAXBElement<>(_Vcalendar_QNAME, VcalendarType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "categories", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<CategoriesPropType> createCategories(CategoriesPropType value) {
    return new JAXBElement<>(_Categories_QNAME, CategoriesPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-registration-start", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XBedeworkRegistrationStartPropType> createXBedeworkRegistrationStart(XBedeworkRegistrationStartPropType value) {
    return new JAXBElement<>(_XBedeworkRegistrationStart_QNAME, XBedeworkRegistrationStartPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "cutype", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<CutypeParamType> createCutype(CutypeParamType value) {
    return new JAXBElement<>(_Cutype_QNAME, CutypeParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-max-tickets-per-user", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XBedeworkMaxTicketsPerUserPropType> createXBedeworkMaxTicketsPerUser(XBedeworkMaxTicketsPerUserPropType value) {
    return new JAXBElement<>(_XBedeworkMaxTicketsPerUser_QNAME, XBedeworkMaxTicketsPerUserPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-uid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<XBedeworkUidParamType> createXBedeworkUid(XBedeworkUidParamType value) {
    return new JAXBElement<>(_XBedeworkUid_QNAME, XBedeworkUidParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-wsCalendar-attach", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<WsCalendarAttachType> createXWsCalendarAttach(WsCalendarAttachType value) {
    return new JAXBElement<>(_XWsCalendarAttach_QNAME, WsCalendarAttachType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "role", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<RoleParamType> createRole(RoleParamType value) {
    return new JAXBElement<>(_Role_QNAME, RoleParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "created", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<CreatedPropType> createCreated(CreatedPropType value) {
    return new JAXBElement<>(_Created_QNAME, CreatedPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-wscalendar-type", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<WsCalendarTypeType> createXWscalendarType(WsCalendarTypeType value) {
    return new JAXBElement<>(_XWscalendarType_QNAME, WsCalendarTypeType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "time")
  public JAXBElement<String> createTime(String value) {
    return new JAXBElement<>(_Time_QNAME, String.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "float")
  public JAXBElement<Float> createFloat(Float value) {
    return new JAXBElement<>(_Float_QNAME, Float.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "until")
  public JAXBElement<UntilRecurType> createUntil(UntilRecurType value) {
    return new JAXBElement<>(_Until_QNAME, UntilRecurType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "attendee", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<AttendeePropType> createAttendee(AttendeePropType value) {
    return new JAXBElement<>(_Attendee_QNAME, AttendeePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "components")
  public JAXBElement<ArrayOfComponents> createComponents(ArrayOfComponents value) {
    return new JAXBElement<>(_Components_QNAME, ArrayOfComponents.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "request-status", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<RequestStatusPropType> createRequestStatus(RequestStatusPropType value) {
    return new JAXBElement<>(_RequestStatus_QNAME, RequestStatusPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "rel", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<TextParameterType> createRel(TextParameterType value) {
    return new JAXBElement<>(_Rel_QNAME, TextParameterType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-exsynch-organizer", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<OrganizerPropType> createXBedeworkExsynchOrganizer(OrganizerPropType value) {
    return new JAXBElement<>(_XBedeworkExsynchOrganizer_QNAME, OrganizerPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "sequence", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<SequencePropType> createSequence(SequencePropType value) {
    return new JAXBElement<>(_Sequence_QNAME, SequencePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "integer")
  public JAXBElement<BigInteger> createInteger(BigInteger value) {
    return new JAXBElement<>(_Integer_QNAME, BigInteger.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "member", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<MemberParamType> createMember(MemberParamType value) {
    return new JAXBElement<>(_Member_QNAME, MemberParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "action", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<ActionPropType> createAction(ActionPropType value) {
    return new JAXBElement<>(_Action_QNAME, ActionPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzoffsetto", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<TzoffsettoPropType> createTzoffsetto(TzoffsettoPropType value) {
    return new JAXBElement<>(_Tzoffsetto_QNAME, TzoffsettoPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "dtstart", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<DtstartPropType> createDtstart(DtstartPropType value) {
    return new JAXBElement<>(_Dtstart_QNAME, DtstartPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "fmttype", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<FmttypeParamType> createFmttype(FmttypeParamType value) {
    return new JAXBElement<>(_Fmttype_QNAME, FmttypeParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-cost", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XBedeworkCostPropType> createXBedeworkCost(XBedeworkCostPropType value) {
    return new JAXBElement<>(_XBedeworkCost_QNAME, XBedeworkCostPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "related", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<RelatedParamType> createRelated(RelatedParamType value) {
    return new JAXBElement<>(_Related_QNAME, RelatedParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "location", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<LocationPropType> createLocation(LocationPropType value) {
    return new JAXBElement<>(_Location_QNAME, LocationPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "count")
  public JAXBElement<BigInteger> createCount(BigInteger value) {
    return new JAXBElement<>(_Count_QNAME, BigInteger.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-microsoft-cdo-intendedstatus", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XMicrosoftCdoIntendedstatusPropType> createXMicrosoftCdoIntendedstatus(XMicrosoftCdoIntendedstatusPropType value) {
    return new JAXBElement<>(_XMicrosoftCdoIntendedstatus_QNAME, XMicrosoftCdoIntendedstatusPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-instance-only", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XBedeworkInstanceOnlyPropType> createXBedeworkInstanceOnly(XBedeworkInstanceOnlyPropType value) {
    return new JAXBElement<>(_XBedeworkInstanceOnly_QNAME, XBedeworkInstanceOnlyPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "dtend", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<DtendPropType> createDtend(DtendPropType value) {
    return new JAXBElement<>(_Dtend_QNAME, DtendPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "icalendar")
  public JAXBElement<ICalendarType> createIcalendar(ICalendarType value) {
    return new JAXBElement<>(_Icalendar_QNAME, ICalendarType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "artifactBase")
  public JAXBElement<ArtifactBaseType> createArtifactBase(ArtifactBaseType value) {
    return new JAXBElement<>(_ArtifactBase_QNAME, ArtifactBaseType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "rsvp", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<RsvpParamType> createRsvp(RsvpParamType value) {
    return new JAXBElement<>(_Rsvp_QNAME, RsvpParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "duration", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<DurationPropType> createDuration(DurationPropType value) {
    return new JAXBElement<>(_Duration_QNAME, DurationPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "standard", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<StandardType> createStandard(StandardType value) {
    return new JAXBElement<>(_Standard_QNAME, StandardType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tolerance", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<TolerancePropType> createTolerance(TolerancePropType value) {
    return new JAXBElement<>(_Tolerance_QNAME, TolerancePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "comment", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<CommentPropType> createComment(CommentPropType value) {
    return new JAXBElement<>(_Comment_QNAME, CommentPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "gap", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<DurationParameterType> createGap(DurationParameterType value) {
    return new JAXBElement<>(_Gap_QNAME, DurationParameterType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "partstat", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<PartstatParamType> createPartstat(PartstatParamType value) {
    return new JAXBElement<>(_Partstat_QNAME, PartstatParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-max-tickets", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XBedeworkMaxTicketsPropType> createXBedeworkMaxTickets(XBedeworkMaxTicketsPropType value) {
    return new JAXBElement<>(_XBedeworkMaxTickets_QNAME, XBedeworkMaxTicketsPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-registration-end", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XBedeworkRegistrationEndPropType> createXBedeworkRegistrationEnd(XBedeworkRegistrationEndPropType value) {
    return new JAXBElement<>(_XBedeworkRegistrationEnd_QNAME, XBedeworkRegistrationEndPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "completed", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<CompletedPropType> createCompleted(CompletedPropType value) {
    return new JAXBElement<>(_Completed_QNAME, CompletedPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "encoding", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<EncodingParamType> createEncoding(EncodingParamType value) {
    return new JAXBElement<>(_Encoding_QNAME, EncodingParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "valarm", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<ValarmType> createValarm(ValarmType value) {
    return new JAXBElement<>(_Valarm_QNAME, ValarmType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "calscale", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<CalscalePropType> createCalscale(CalscalePropType value) {
    return new JAXBElement<>(_Calscale_QNAME, CalscalePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "interval", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<WsCalendarIntervalType> createInterval(WsCalendarIntervalType value) {
    return new JAXBElement<>(_Interval_QNAME, WsCalendarIntervalType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vtodo", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<VtodoType> createVtodo(VtodoType value) {
    return new JAXBElement<>(_Vtodo_QNAME, VtodoType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "binary")
  public JAXBElement<String> createBinary(String value) {
    return new JAXBElement<>(_Binary_QNAME, String.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<TzidParamType> createTzid(TzidParamType value) {
    return new JAXBElement<>(_Tzid_QNAME, TzidParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "dtstamp", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<DtstampPropType> createDtstamp(DtstampPropType value) {
    return new JAXBElement<>(_Dtstamp_QNAME, DtstampPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "method", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<MethodPropType> createMethod(MethodPropType value) {
    return new JAXBElement<>(_Method_QNAME, MethodPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vavailability", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<VavailabilityType> createVavailability(VavailabilityType value) {
    return new JAXBElement<>(_Vavailability_QNAME, VavailabilityType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "freebusy", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<FreebusyPropType> createFreebusy(FreebusyPropType value) {
    return new JAXBElement<>(_Freebusy_QNAME, FreebusyPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "parameters")
  public JAXBElement<ArrayOfParameters> createParameters(ArrayOfParameters value) {
    return new JAXBElement<>(_Parameters_QNAME, ArrayOfParameters.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-exsynch-endtzid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XBedeworkExsynchEndtzidPropType> createXBedeworkExsynchEndtzid(XBedeworkExsynchEndtzidPropType value) {
    return new JAXBElement<>(_XBedeworkExsynchEndtzid_QNAME, XBedeworkExsynchEndtzidPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-exsynch-starttzid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XBedeworkExsynchStarttzidPropType> createXBedeworkExsynchStarttzid(XBedeworkExsynchStarttzidPropType value) {
    return new JAXBElement<>(_XBedeworkExsynchStarttzid_QNAME, XBedeworkExsynchStarttzidPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "due", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<DuePropType> createDue(DuePropType value) {
    return new JAXBElement<>(_Due_QNAME, DuePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "uri")
  public JAXBElement<String> createUri(String value) {
    return new JAXBElement<>(_Uri_QNAME, String.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "period")
  public JAXBElement<PeriodType> createPeriod(PeriodType value) {
    return new JAXBElement<>(_Period_QNAME, PeriodType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "url", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<UrlPropType> createUrl(UrlPropType value) {
    return new JAXBElement<>(_Url_QNAME, UrlPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "text")
  public JAXBElement<String> createText(String value) {
    return new JAXBElement<>(_Text_QNAME, String.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "related-to", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<RelatedToPropType> createRelatedTo(RelatedToPropType value) {
    return new JAXBElement<>(_RelatedTo_QNAME, RelatedToPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "repeat", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<RepeatPropType> createRepeat(RepeatPropType value) {
    return new JAXBElement<>(_Repeat_QNAME, RepeatPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "daylight", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<DaylightType> createDaylight(DaylightType value) {
    return new JAXBElement<>(_Daylight_QNAME, DaylightType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "baseComponent")
  public JAXBElement<BaseComponentType> createBaseComponent(BaseComponentType value) {
    return new JAXBElement<>(_BaseComponent_QNAME, BaseComponentType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "boolean")
  public JAXBElement<Boolean> createBoolean(Boolean value) {
    return new JAXBElement<>(_Boolean_QNAME, Boolean.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "rdate", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<RdatePropType> createRdate(RdatePropType value) {
    return new JAXBElement<>(_Rdate_QNAME, RdatePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "summary", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<SummaryPropType> createSummary(SummaryPropType value) {
    return new JAXBElement<>(_Summary_QNAME, SummaryPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "utc-offset")
  public JAXBElement<String> createUtcOffset(String value) {
    return new JAXBElement<>(_UtcOffset_QNAME, String.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "latitude")
  public JAXBElement<Float> createLatitude(Float value) {
    return new JAXBElement<>(_Latitude_QNAME, Float.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "schedule-agent", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<ScheduleAgentParamType> createScheduleAgent(ScheduleAgentParamType value) {
    return new JAXBElement<>(_ScheduleAgent_QNAME, ScheduleAgentParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "delegated-from", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<DelegatedFromParamType> createDelegatedFrom(DelegatedFromParamType value) {
    return new JAXBElement<>(_DelegatedFrom_QNAME, DelegatedFromParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vfreebusy", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<VfreebusyType> createVfreebusy(VfreebusyType value) {
    return new JAXBElement<>(_Vfreebusy_QNAME, VfreebusyType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "available", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<AvailableType> createAvailable(AvailableType value) {
    return new JAXBElement<>(_Available_QNAME, AvailableType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "organizer", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<OrganizerPropType> createOrganizer(OrganizerPropType value) {
    return new JAXBElement<>(_Organizer_QNAME, OrganizerPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "schedule-force-send", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<ScheduleForceSendParamType> createScheduleForceSend(ScheduleForceSendParamType value) {
    return new JAXBElement<>(_ScheduleForceSend_QNAME, ScheduleForceSendParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "date")
  public JAXBElement<XMLGregorianCalendar> createDate(XMLGregorianCalendar value) {
    return new JAXBElement<>(_Date_QNAME, XMLGregorianCalendar.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzname", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<TznamePropType> createTzname(TznamePropType value) {
    return new JAXBElement<>(_Tzname_QNAME, TznamePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "baseParameter")
  public JAXBElement<BaseParameterType> createBaseParameter(BaseParameterType value) {
    return new JAXBElement<>(_BaseParameter_QNAME, BaseParameterType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "exdate", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<ExdatePropType> createExdate(ExdatePropType value) {
    return new JAXBElement<>(_Exdate_QNAME, ExdatePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "artifact")
  public JAXBElement<ArtifactType> createArtifact(ArtifactType value) {
    return new JAXBElement<>(_Artifact_QNAME, ArtifactType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "longitude")
  public JAXBElement<Float> createLongitude(Float value) {
    return new JAXBElement<>(_Longitude_QNAME, Float.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "granularity", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<DurationPropType> createGranularity(DurationPropType value) {
    return new JAXBElement<>(_Granularity_QNAME, DurationPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "utc-date-time")
  public JAXBElement<XMLGregorianCalendar> createUtcDateTime(XMLGregorianCalendar value) {
    return new JAXBElement<>(_UtcDateTime_QNAME, XMLGregorianCalendar.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "prodid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<ProdidPropType> createProdid(ProdidPropType value) {
    return new JAXBElement<>(_Prodid_QNAME, ProdidPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "baseProperty")
  public JAXBElement<BasePropertyType> createBaseProperty(BasePropertyType value) {
    return new JAXBElement<>(_BaseProperty_QNAME, BasePropertyType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "rrule", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<RrulePropType> createRrule(RrulePropType value) {
    return new JAXBElement<>(_Rrule_QNAME, RrulePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "uid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<UidPropType> createUid(UidPropType value) {
    return new JAXBElement<>(_Uid_QNAME, UidPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "transp", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<TranspPropType> createTransp(TranspPropType value) {
    return new JAXBElement<>(_Transp_QNAME, TranspPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "altrep", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<AltrepParamType> createAltrep(AltrepParamType value) {
    return new JAXBElement<>(_Altrep_QNAME, AltrepParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "class", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<ClassPropType> createClass(ClassPropType value) {
    return new JAXBElement<>(_Class_QNAME, ClassPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "properties")
  public JAXBElement<ArrayOfProperties> createProperties(ArrayOfProperties value) {
    return new JAXBElement<>(_Properties_QNAME, ArrayOfProperties.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "status", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<StatusPropType> createStatus(StatusPropType value) {
    return new JAXBElement<>(_Status_QNAME, StatusPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "dir", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<DirParamType> createDir(DirParamType value) {
    return new JAXBElement<>(_Dir_QNAME, DirParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "schedule-status", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<ScheduleStatusParamType> createScheduleStatus(ScheduleStatusParamType value) {
    return new JAXBElement<>(_ScheduleStatus_QNAME, ScheduleStatusParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzoffsetfrom", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<TzoffsetfromPropType> createTzoffsetfrom(TzoffsetfromPropType value) {
    return new JAXBElement<>(_Tzoffsetfrom_QNAME, TzoffsetfromPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vevent", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<VeventType> createVevent(VeventType value) {
    return new JAXBElement<>(_Vevent_QNAME, VeventType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "delegated-to", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<DelegatedToParamType> createDelegatedTo(DelegatedToParamType value) {
    return new JAXBElement<>(_DelegatedTo_QNAME, DelegatedToParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-exsynch-lastmod", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<XBedeworkExsynchLastmodPropType> createXBedeworkExsynchLastmod(XBedeworkExsynchLastmodPropType value) {
    return new JAXBElement<>(_XBedeworkExsynchLastmod_QNAME, XBedeworkExsynchLastmodPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "language", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<LanguageParamType> createLanguage(LanguageParamType value) {
    return new JAXBElement<>(_Language_QNAME, LanguageParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "reltype", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<ReltypeParamType> createReltype(ReltypeParamType value) {
    return new JAXBElement<>(_Reltype_QNAME, ReltypeParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "sent-by", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<SentByParamType> createSentBy(SentByParamType value) {
    return new JAXBElement<>(_SentBy_QNAME, SentByParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "percent-complete", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<PercentCompletePropType> createPercentComplete(PercentCompletePropType value) {
    return new JAXBElement<>(_PercentComplete_QNAME, PercentCompletePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "exrule", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<ExrulePropType> createExrule(ExrulePropType value) {
    return new JAXBElement<>(_Exrule_QNAME, ExrulePropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "gluon", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<WsCalendarGluonType> createGluon(WsCalendarGluonType value) {
    return new JAXBElement<>(_Gluon_QNAME, WsCalendarGluonType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "contact", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<ContactPropType> createContact(ContactPropType value) {
    return new JAXBElement<>(_Contact_QNAME, ContactPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "fbtype", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<FbtypeParamType> createFbtype(FbtypeParamType value) {
    return new JAXBElement<>(_Fbtype_QNAME, FbtypeParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "version", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<VersionPropType> createVersion(VersionPropType value) {
    return new JAXBElement<>(_Version_QNAME, VersionPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "range", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
  public JAXBElement<RangeParamType> createRange(RangeParamType value) {
    return new JAXBElement<>(_Range_QNAME, RangeParamType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "link", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<LinkPropType> createLink(LinkPropType value) {
    return new JAXBElement<>(_Link_QNAME, LinkPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "attach", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<AttachPropType> createAttach(AttachPropType value) {
    return new JAXBElement<>(_Attach_QNAME, AttachPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vjournal", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
  public JAXBElement<VjournalType> createVjournal(VjournalType value) {
    return new JAXBElement<>(_Vjournal_QNAME, VjournalType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "last-modified", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<LastModifiedPropType> createLastModified(LastModifiedPropType value) {
    return new JAXBElement<>(_LastModified_QNAME, LastModifiedPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "trigger", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<TriggerPropType> createTrigger(TriggerPropType value) {
    return new JAXBElement<>(_Trigger_QNAME, TriggerPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzurl", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
  public JAXBElement<TzurlPropType> createTzurl(TzurlPropType value) {
    return new JAXBElement<>(_Tzurl_QNAME, TzurlPropType.class, null, value);
  }

  @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzid", scope = ArrayOfProperties.class)
  public JAXBElement<TextPropertyType> createArrayOfPropertiesTzid(TextPropertyType value) {
    return new JAXBElement<>(_Tzid_QNAME, TextPropertyType.class, ArrayOfProperties.class, value);
  }

  public static <T> String marshal(T clazz) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(clazz.getClass());
    Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    StringWriter stringWriter = new StringWriter();
    marshaller.marshal(clazz, stringWriter);
    return stringWriter.toString();
  }

  public static <T> T unmarshal(URL url, Class<T> clazz) throws JAXBException {
    Unmarshaller unmarshaller = JAXBContext.newInstance(clazz).createUnmarshaller();
    return clazz.cast(unmarshaller.unmarshal(url));
  }

  public static <T> T unmarshal(String xml, Class<T> clazz) throws JAXBException {
    Unmarshaller unmarshaller = JAXBContext.newInstance(clazz).createUnmarshaller();
    return clazz.cast(unmarshaller.unmarshal(new ByteArrayInputStream(xml.getBytes())));
  }
}
