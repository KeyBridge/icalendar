package ietf.params.xml.ns.icalendar.parameter.base.text;

import ietf.params.xml.ns.icalendar.parameter.base.TextParameterType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * scheduleagentparam = "SCHEDULE-AGENT" "=" ("SERVER" ; The server handles
 * scheduling / "CLIENT" ; The client handles scheduling / "NONE" ; No automatic
 * scheduling / x-name ; Experimental type / iana-token) ; Other IANA registered
 * type ; ; Default is SERVER
 * <p/>
 *
 * Java class for ScheduleAgentParamType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="ScheduleAgentParamType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}TextParameterType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScheduleAgentParamType")
public class ScheduleAgentParamType extends TextParameterType {
}
