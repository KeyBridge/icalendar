package ietf.params.xml.ns.icalendar.parameter;

import ietf.params.xml.ns.icalendar.parameter.base.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for BaseParameterType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="BaseParameterType"> &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;/restriction> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseParameterType")
@XmlSeeAlso({
  BooleanParameterType.class,
  CalAddressListParamType.class,
  CalAddressParamType.class,
  DurationParameterType.class,
  RangeParamType.class,
  TextParameterType.class,
  UriParameterType.class
})
public abstract class BaseParameterType {
}
