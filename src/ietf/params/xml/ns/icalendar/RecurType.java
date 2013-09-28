package ietf.params.xml.ns.icalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for RecurType complex type. Recurrence Rule (RFC5545 section
 * 3.3.10)
 * <p/>
 * This value type is used to identify properties that contain a recurrence rule
 * specification.
 * <p/>
 * The FREQ rule part is REQUIRED, but MUST NOT occur more than once.
 * <p/>
 * The UNTIL or COUNT rule parts are OPTIONAL, but they MUST NOT occur in the
 * same 'recur'.
 * <p/>
 * The other rule parts are OPTIONAL, but MUST NOT occur more than once.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <code>
 *   <xs:complexType name="RecurType">
 *   <xs:sequence>
 *     <xs:element name="freq" type="xcal:FreqRecurType"/>
 *     <xs:sequence>
 *       <xs:choice minOccurs="0">
 *         <xs:element ref="xcal:until" />
 *         <xs:element ref="xcal:count" />
 *       </xs:choice>
 *     </xs:sequence>
 *     <xs:element name="interval" type="xs:string" minOccurs="0"/>
 *     <xs:element name="bysecond" type="xs:string"
 *                 minOccurs="0" maxOccurs="unbounded" />
 *     <xs:element name="byminute" type="xs:string"
 *                 minOccurs="0" maxOccurs="unbounded" />
 *     <xs:element name="byhour" type="xs:string"
 *                 minOccurs="0" maxOccurs="unbounded" />
 *     <xs:element name="byday" type="xs:string"
 *                 minOccurs="0" maxOccurs="unbounded" />
 *     <xs:element name="byyearday" type="xs:string"
 *                 minOccurs="0" maxOccurs="unbounded" />
 *     <xs:element name="bymonthday" type="xcal:BymonthdayRecurType"
 *                 minOccurs="0" maxOccurs="unbounded" />
 *     <xs:element name="byweekno" type="xs:string"
 *                 minOccurs="0" maxOccurs="unbounded" />
 *     <xs:element name="bymonth" type="xcal:BymonthRecurType"
 *                 minOccurs="0" maxOccurs="unbounded" />
 *     <xs:element name="bysetpos" type="xs:integer"
 *                 minOccurs="0" maxOccurs="unbounded" />
 *     <xs:element name="wkst" type="xcal:WeekdayRecurType" minOccurs="0" />
 *   </xs:sequence>
 * </xs:complexType>
 * </code>
 * <p/>
 * @see <a href="http://tools.ietf.org/html/rfc5545#section-3.3.10">Recurrence
 * Rule</a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecurType", propOrder = {
  "freq",
  "until",
  "count",
  "interval",
  "bysecond",
  "byminute",
  "byhour",
  "byday",
  "byyearday",
  "bymonthday",
  "byweekno",
  "bymonth",
  "bysetpos",
  "wkst"
})
public class RecurType {

  private static final String FREQ = "FREQ";
  private static final String UNTIL = "UNTIL";
  private static final String COUNT = "COUNT";
  private static final String INTERVAL = "INTERVAL";
  private static final String BYSECOND = "BYSECOND";
  private static final String BYMINUTE = "BYMINUTE";
  private static final String BYHOUR = "BYHOUR";
  private static final String BYDAY = "BYDAY";
  private static final String BYMONTHDAY = "BYMONTHDAY";
  private static final String BYYEARDAY = "BYYEARDAY";
  private static final String BYWEEKNO = "BYWEEKNO";
  private static final String BYMONTH = "BYMONTH";
  private static final String BYSETPOS = "BYSETPOS";
  private static final String WKST = "WKST";
  private static final String UTC_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
  @XmlElement(required = true)
  /**
   * The FREQ rule part is REQUIRED, but MUST NOT occur more than once.
   * <p/>
   * type-freq = element freq { "SECONDLY" | "MINUTELY" | "HOURLY" | "DAILY" |
   * "WEEKLY" | "MONTHLY" | "YEARLY" }
   */
  protected FreqRecurType freq;
  /**
   * The UNTIL or COUNT rule parts are OPTIONAL, but they MUST NOT occur in the
   * same 'recur'.
   * <p/>
   * type-until = element until { type-date | type-date-time }
   */
  protected UntilRecurType until;
  /**
   * The UNTIL or COUNT rule parts are OPTIONAL, but they MUST NOT occur in the
   * same 'recur'.
   * <p/>
   * type-count = element count { xsd:positiveInteger }
   */
  protected Integer count;
  /**
   * element interval { xsd:positiveInteger }
   */
  protected Integer interval;
  /**
   * type-bysecond = element bysecond { xsd:positiveInteger }
   */
  protected List<String> bysecond;
  /**
   * type-byminute = element byminute { xsd:positiveInteger }
   */
  protected List<String> byminute;
  /**
   * type-byhour = element byhour { xsd:positiveInteger }
   */
  protected List<String> byhour;
  /**
   * type-byday = element byday { xsd:integer?, type-weekday }
   */
  protected List<String> byday;
  /**
   * type-byyearday = element byyearday { xsd:integer }
   */
  protected List<Integer> byyearday;
  /**
   * type-bymonthday = element bymonthday { xsd:integer } [-31,31]
   */
  @XmlElement(type = Integer.class)
  protected List<Integer> bymonthday;
  /**
   * type-byweekno = element byweekno { xsd:integer }
   */
  protected List<Integer> byweekno;
  /**
   * type-bymonth = element bymonth { xsd:positiveInteger } [1,12]
   */
  @XmlElement(type = Integer.class)
  protected List<Integer> bymonth;
  /**
   * type-bysetpos = element bysetpos { xsd:integer }
   */
  protected List<Integer> bysetpos;
  /**
   * type-weekday = ( "SU" | "MO" | "TU" | "WE" | "TH" | "FR" | "SA" )
   */
  protected WeekdayRecurType wkst;

  public RecurType() {
  }

  /**
   * Construct a new RecurType instance from an iCalendar-compliant RECUR
   * String.
   * <p/>
   * This method is forked from the iCal4j Recur class.
   * <p/>
   * @param aValue an iCalendar RECUR String representation of a recurrence.
   * @throws Exception if the specified string contains an invalid
   *                   representation of an UNTIL date value or otherwise cannot
   *                   be parsed
   */
  public RecurType(final String aValue) throws Exception {
    DateFormat sdf = new SimpleDateFormat(UTC_PATTERN);

    final StringTokenizer tokenizer = new StringTokenizer(aValue, ";=");
    while (tokenizer.hasMoreTokens()) {
      final String token = tokenizer.nextToken();
      switch (token) {
        case FREQ:
          freq = FreqRecurType.fromValue(nextToken(tokenizer, token));
          break;
        case UNTIL:
          final String untilString = nextToken(tokenizer, token);
          if (untilString != null && untilString.indexOf("T") >= 0) {
            until = new UntilRecurType(sdf.parse(untilString));
          } else {
            until = null;
          }
          break;
        case COUNT:
          count = Integer.parseInt(nextToken(tokenizer, token));
          break;
        case INTERVAL:
          interval = Integer.parseInt(nextToken(tokenizer, token));
          break;
        case BYSECOND:
          bysecond = listParseString(nextToken(tokenizer, token));
          break;
        case BYMINUTE:
          byminute = listParseString(nextToken(tokenizer, token));
          break;
        case BYHOUR:
          byhour = listParseString(nextToken(tokenizer, token));
          break;
        case BYDAY:
          byday = listParseString(nextToken(tokenizer, token));
          break;
        case BYMONTHDAY:
          bymonthday = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYYEARDAY:
          byyearday = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYWEEKNO:
          byweekno = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYMONTH:
          bymonth = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYSETPOS:
          bysetpos = listParseInteger(nextToken(tokenizer, token));
          break;
        case WKST:
          wkst = WeekdayRecurType.valueOf(nextToken(tokenizer, token));
          break;
      }
    }
    /**
     * Validate the Frequency.
     */
    if (freq == null) {
      throw new IllegalArgumentException("A recurrence rule MUST contain a FREQ rule part.");
    }
  }

  /**
   * Internal tokenizer method supporting the String constructor.
   * <p/>
   * @param t         a StringTokenizer instance
   * @param lastToken the last token
   * @return the next token
   */
  private String nextToken(StringTokenizer t, String lastToken) {
    try {
      return t.nextToken();
    } catch (NoSuchElementException e) {
      throw new IllegalArgumentException("Missing expected token, last token: " + lastToken);
    }
  }

  /**
   * Gets the value of the freq property.
   * <p/>
   * @return possible object is {@link FreqRecurType }
   *
   */
  public FreqRecurType getFreq() {
    return freq;
  }

  /**
   * Sets the value of the freq property.
   * <p/>
   * @param value allowed object is {@link FreqRecurType }
   *
   */
  public void setFreq(FreqRecurType value) {
    this.freq = value;
  }

  public boolean isSetFreq() {
    return (this.freq != null);
  }

  /**
   * Gets the value of the until property.
   * <p/>
   * @return possible object is {@link UntilRecurType }
   *
   */
  public UntilRecurType getUntil() {
    return until;
  }

  /**
   * Sets the value of the until property.
   * <p/>
   * @param value allowed object is {@link UntilRecurType }
   *
   */
  public void setUntil(UntilRecurType value) {
    this.until = value;
  }

  public boolean isSetUntil() {
    return (this.until != null);
  }

  /**
   * Gets the value of the count property.
   * <p/>
   * @return possible object is {@link Integer }
   *
   */
  public Integer getCount() {
    return count;
  }

  /**
   * Sets the value of the count property.
   * <p/>
   * @param value allowed object is {@link Integer }
   *
   */
  public void setCount(Integer value) {
    this.count = value;
  }

  public boolean isSetCount() {
    return (this.count != null);
  }

  /**
   * Gets the value of the interval property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public Integer getInterval() {
    return interval;
  }

  /**
   * Sets the value of the interval property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setInterval(Integer value) {
    this.interval = value;
  }

  public boolean isSetInterval() {
    return (this.interval != null);
  }

  /**
   * Gets the value of the bysecond property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the bysecond property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getBysecond().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list {@link String }
   *
   *
   */
  public List<String> getBysecond() {
    if (bysecond == null) {
      bysecond = new ArrayList<String>();
    }
    return this.bysecond;
  }

  public boolean isSetBysecond() {
    return ((this.bysecond != null) && (!this.bysecond.isEmpty()));
  }

  public void unsetBysecond() {
    this.bysecond = null;
  }

  /**
   * Gets the value of the byminute property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the byminute property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getByminute().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list {@link String }
   *
   *
   */
  public List<String> getByminute() {
    if (byminute == null) {
      byminute = new ArrayList<String>();
    }
    return this.byminute;
  }

  public boolean isSetByminute() {
    return ((this.byminute != null) && (!this.byminute.isEmpty()));
  }

  public void unsetByminute() {
    this.byminute = null;
  }

  /**
   * Gets the value of the byhour property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the byhour property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getByhour().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list {@link String }
   *
   *
   */
  public List<String> getByhour() {
    if (byhour == null) {
      byhour = new ArrayList<String>();
    }
    return this.byhour;
  }

  public boolean isSetByhour() {
    return ((this.byhour != null) && (!this.byhour.isEmpty()));
  }

  public void unsetByhour() {
    this.byhour = null;
  }

  /**
   * Gets the value of the byday property.
   * <p/>
   * Recommend using the methods addByDay and removeByDay to manipulate this
   * list.
   */
  public List<String> getByday() {
    if (byday == null) {
      byday = new ArrayList<String>();
    }
    return this.byday;
  }

  public boolean isSetByday() {
    return ((this.byday != null) && (!this.byday.isEmpty()));
  }

  public void unsetByday() {
    this.byday = null;
  }

  public void addByDay(WeekdayRecurType weekdayRecurType) {
    if (!getByday().contains(weekdayRecurType.name())) {
      getByday().add(weekdayRecurType.name());
    }
  }

  public void removeByDay(WeekdayRecurType weekdayRecurType) {
    getByday().remove(weekdayRecurType.name());
  }

  /**
   * Gets the value of the byyearday property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the byyearday property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getByyearday().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list {@link String }
   *
   *
   */
  public List<Integer> getByyearday() {
    if (byyearday == null) {
      byyearday = new ArrayList<Integer>();
    }
    return this.byyearday;
  }

  public boolean isSetByyearday() {
    return ((this.byyearday != null) && (!this.byyearday.isEmpty()));
  }

  public void unsetByyearday() {
    this.byyearday = null;
  }

  /**
   * Gets the value of the bymonthday property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the bymonthday property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getBymonthday().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list {@link Integer }
   *
   *
   */
  public List<Integer> getBymonthday() {
    if (bymonthday == null) {
      bymonthday = new ArrayList<Integer>();
    }
    return this.bymonthday;
  }

  public boolean isSetBymonthday() {
    return ((this.bymonthday != null) && (!this.bymonthday.isEmpty()));
  }

  public void unsetBymonthday() {
    this.bymonthday = null;
  }

  /**
   * Gets the value of the byweekno property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the byweekno property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getByweekno().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list {@link String }
   *
   *
   */
  public List<Integer> getByweekno() {
    if (byweekno == null) {
      byweekno = new ArrayList<Integer>();
    }
    return this.byweekno;
  }

  public boolean isSetByweekno() {
    return ((this.byweekno != null) && (!this.byweekno.isEmpty()));
  }

  public void unsetByweekno() {
    this.byweekno = null;
  }

  /**
   * Gets the value of the bymonth property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the bymonth property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getBymonth().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list {@link Integer }
   *
   *
   */
  public List<Integer> getBymonth() {
    if (bymonth == null) {
      bymonth = new ArrayList<Integer>();
    }
    return this.bymonth;
  }

  public boolean isSetBymonth() {
    return ((this.bymonth != null) && (!this.bymonth.isEmpty()));
  }

  public void unsetBymonth() {
    this.bymonth = null;
  }

  /**
   * Gets the value of the bysetpos property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the bysetpos property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getBysetpos().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list {@link Integer }
   *
   *
   */
  public List<Integer> getBysetpos() {
    if (bysetpos == null) {
      bysetpos = new ArrayList<Integer>();
    }
    return this.bysetpos;
  }

  public boolean isSetBysetpos() {
    return ((this.bysetpos != null) && (!this.bysetpos.isEmpty()));
  }

  public void unsetBysetpos() {
    this.bysetpos = null;
  }

  /**
   * Gets the value of the wkst property.
   * <p/>
   * @return possible object is {@link WeekdayRecurType }
   *
   */
  public WeekdayRecurType getWkst() {
    return wkst;
  }

  /**
   * Sets the value of the wkst property.
   * <p/>
   * @param value allowed object is {@link WeekdayRecurType }
   *
   */
  public void setWkst(WeekdayRecurType value) {
    this.wkst = value;
  }

  public boolean isSetWkst() {
    return (this.wkst != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 31 * hash + (this.freq != null ? this.freq.hashCode() : 0);
    hash = 31 * hash + Objects.hashCode(this.until);
    hash = 31 * hash + Objects.hashCode(this.count);
    hash = 31 * hash + Objects.hashCode(this.interval);
    hash = 31 * hash + Objects.hashCode(this.bysecond);
    hash = 31 * hash + Objects.hashCode(this.byminute);
    hash = 31 * hash + Objects.hashCode(this.byhour);
    hash = 31 * hash + Objects.hashCode(this.byday);
    hash = 31 * hash + Objects.hashCode(this.byyearday);
    hash = 31 * hash + Objects.hashCode(this.bymonthday);
    hash = 31 * hash + Objects.hashCode(this.byweekno);
    hash = 31 * hash + Objects.hashCode(this.bymonth);
    hash = 31 * hash + Objects.hashCode(this.bysetpos);
    hash = 31 * hash + (this.wkst != null ? this.wkst.hashCode() : 0);
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
    final RecurType other = (RecurType) obj;
    if (this.hashCode() != obj.hashCode()) {
      return false;
    }
    return true;
  }

  /**
   * Print all of this RecurType configuration fields.
   * <p/>
   * @return
   */
  public String toStringFull() {
    return "RecurType"
      + " freq [" + freq
      + "] until [" + until
      + "] count [" + count
      + "] interval [" + interval
      + "] bysecond [" + bysecond
      + "] byminute [" + byminute
      + "] byhour [" + byhour
      + "] byday [" + byday
      + "] byyearday [" + byyearday
      + "] bymonthday [" + bymonthday
      + "] byweekno [" + byweekno
      + "] bymonth [" + bymonth
      + "] bysetpos [" + bysetpos
      + "] wkst [" + wkst
      + ']';
  }

  /**
   * Print this RecurType object instance as a properly formatted RECUR string.
   * <p/>
   * This method is forked from the iCal4j Recur class.
   * <p/>
   * @return an iCalendar-compliant RECUR string.
   */
  @Override
  public final String toString() {
    final StringBuffer b = new StringBuffer();
    b.append(FREQ);
    b.append('=');
    b.append(freq);
    if (wkst != null) {
      b.append(';');
      b.append(WKST);
      b.append('=');
      b.append(wkst);
    }
    if (until != null) {
      b.append(';');
      b.append(UNTIL);
      b.append('=');
      b.append(until);
    }
    if (count != null && count >= 1) {
      b.append(';');
      b.append(COUNT);
      b.append('=');
      b.append(count);
    }
    if (interval != null && interval >= 1) {
      b.append(';');
      b.append(INTERVAL);
      b.append('=');
      b.append(interval);
    }
    if (isSetBymonth()) {
      b.append(';');
      b.append(BYMONTH);
      b.append('=');
      b.append(listFormat(bymonth));
    }
    if (isSetByweekno()) {
      b.append(';');
      b.append(BYWEEKNO);
      b.append('=');
      b.append(listFormat(byweekno));
    }
    if (isSetByyearday()) {
      b.append(';');
      b.append(BYYEARDAY);
      b.append('=');
      b.append(listFormat(byyearday));
    }
    if (isSetBymonthday()) {
      b.append(';');
      b.append(BYMONTHDAY);
      b.append('=');
      b.append(listFormat(bymonthday));
    }
    if (isSetByday()) {
      b.append(';');
      b.append(BYDAY);
      b.append('=');
      b.append(listFormat(byday));
    }
    if (isSetByhour()) {
      b.append(';');
      b.append(BYHOUR);
      b.append('=');
      b.append(listFormat(byhour));
    }
    if (isSetByminute()) {
      b.append(';');
      b.append(BYMINUTE);
      b.append('=');
      b.append(listFormat(byminute));
    }
    if (isSetBysecond()) {
      b.append(';');
      b.append(BYSECOND);
      b.append('=');
      b.append(listFormat(bysecond));
    }
    if (isSetBysetpos()) {
      b.append(';');
      b.append(BYSETPOS);
      b.append('=');
      b.append(listFormat(bysetpos));
    }
    return b.toString();
  }

  //<editor-fold defaultstate="collapsed" desc="List Tokenizer Support Methods">
  /**
   * Format a list of objects (expect Integer and String) into a concatenated
   * comma-delimited String. {@inheritDoc}
   */
  private String listFormat(List<?> aList) {
    final StringBuffer b = new StringBuffer();
    for (final Iterator i = aList.iterator(); i.hasNext();) {
      b.append(i.next());
      if (i.hasNext()) {
        b.append(',');
      }
    }
    return b.toString();
  }

  /**
   * Parse a comma-delimited String into a list of Integers.
   * <p/>
   * @param aString              a string representation of a number list
   * @param minValue             the minimum allowable value
   * @param maxValue             the maximum allowable value
   * @param allowsNegativeValues indicates whether negative values are allowed
   */
  private List<Integer> listParseInteger(String aString) {
    List<Integer> list = new ArrayList<Integer>();
    final StringTokenizer t = new StringTokenizer(aString, ",");
    while (t.hasMoreTokens()) {
      list.add(Integer.valueOf(t.nextToken()));
    }
    return list;
  }

  /**
   * Parse a comma-delimited String into a list of Strings.
   * <p/>
   * @param aString              a string representation of a number list
   * @param minValue             the minimum allowable value
   * @param maxValue             the maximum allowable value
   * @param allowsNegativeValues indicates whether negative values are allowed
   */
  private List<String> listParseString(String aString) {
    List<String> list = new ArrayList<String>();
    final StringTokenizer t = new StringTokenizer(aString, ",");
    while (t.hasMoreTokens()) {
      list.add(t.nextToken());
    }
    return list;
  }//</editor-fold>
}
