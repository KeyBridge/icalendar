package ietf.params.xml.ns.icalendar.component.base;

import ietf.params.xml.ns.icalendar.component.BaseComponentType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
public class VeventType extends BaseComponentType {

  public String toStringFull() {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
    sdf.setCalendar(Calendar.getInstance(TIME_ZONE));

    return "VeventType"
      + " uid " + getUID()
      + "]\n dtstamp [" + (getDTSTAMP() != null ? sdf.format(getDTSTAMP().getTime()) : "")
      + "]\n dtstart [" + (getDTSTART() != null ? sdf.format(getDTSTART().getTime()) : "")
      + "]\n dtend   [" + (getDTEND() != null ? sdf.format(getDTEND().getTime()) : "")
      + "]\n duration [" + getDURATION()
      + "] rrule [" + getRRULE()
      + ']';
  }

  @Override
  public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
    sdf.setCalendar(Calendar.getInstance(TIME_ZONE));

    return "VeventType"
      + " dtstart [" + (getDTSTART() != null ? sdf.format(getDTSTART().getTime()) : "")
      + "] dtend [" + (getDTEND() != null ? sdf.format(getDTEND().getTime()) : "")
      + "] rrule [" + getRRULE()
      + ']';
  }
}
