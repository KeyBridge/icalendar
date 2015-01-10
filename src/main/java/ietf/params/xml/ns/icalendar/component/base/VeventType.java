package ietf.params.xml.ns.icalendar.component.base;

import ietf.params.xml.ns.icalendar.component.BaseComponentType;
import ietf.params.xml.ns.icalendar.component.EComponentName;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for VeventType complex type.
 * <p/>
 * RFC5545 says:
 * <p/>
 * Either 'dtend' or 'duration' may appear in a 'eventprop', but 'dtend' and
 * 'duration' MUST NOT occur in the same 'eventprop'
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VeventType")
@XmlRootElement
public class VeventType extends BaseComponentType {

  public VeventType() {
    super(EComponentName.VEVENT);
  }

  /**
   * Print the VeventType start and end string on a single line..
   * <p>
   * @return From [UTC_PATTERN] to [UTC_PATTERN]
   */
  @Override
  public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat(UTC_PATTERN, Locale.ENGLISH);
    sdf.setTimeZone(TIME_ZONE);
    StringBuilder b = new StringBuilder();
    b.append("From ").append(getDTSTART() != null ? sdf.format(getDTSTART().getTime()) : "");
    b.append("to ").append(getDTEND() != null ? sdf.format(getDTEND().getTime()) : "");
    return b.toString();
  }

  /**
   * Print the VEvent to a simple string format.
   * <p>
   * @return
   */
  public String toStringMultiline() {
//    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
    SimpleDateFormat sdf = new SimpleDateFormat(UTC_PATTERN, Locale.ENGLISH);
    sdf.setTimeZone(TIME_ZONE);
    StringBuilder b = new StringBuilder();
    b.append(BEGIN).append(':').append(getName());
    b.append(LINE_SEPARATOR);
    b.append("DTSTAMP:").append(getDTSTAMP() != null ? sdf.format(getDTSTAMP().getTime()) : "");
    b.append(LINE_SEPARATOR);
    b.append("DTSTART:").append(getDTSTART() != null ? sdf.format(getDTSTART().getTime()) : "");
    b.append(LINE_SEPARATOR);
    b.append("DTEND:").append(getDTEND() != null ? sdf.format(getDTEND().getTime()) : "");
    b.append(LINE_SEPARATOR);
    b.append(END).append(':').append(getName());
    b.append(LINE_SEPARATOR);
    return b.toString();
  }

  public String toStringFull() {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
    sdf.setTimeZone(TIME_ZONE);

    return "VeventType"
      + " uid " + getUID()
      + "]\n dtstamp [" + (getDTSTAMP() != null ? sdf.format(getDTSTAMP().getTime()) : "")
      + "]\n dtstart [" + (getDTSTART() != null ? sdf.format(getDTSTART().getTime()) : "")
      + "]\n dtend   [" + (getDTEND() != null ? sdf.format(getDTEND().getTime()) : "")
      + "]\n duration [" + getDURATION()
      + "] rrule [" + getRRULE()
      + ']';
  }

  public String toStringBrief() {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
    sdf.setTimeZone(TIME_ZONE);

    return "VeventType"
      + " dtstart [" + (getDTSTART() != null ? sdf.format(getDTSTART().getTime()) : "")
      + "] dtend [" + (getDTEND() != null ? sdf.format(getDTEND().getTime()) : "")
      + "] rrule [" + getRRULE()
      + ']';
  }
}
