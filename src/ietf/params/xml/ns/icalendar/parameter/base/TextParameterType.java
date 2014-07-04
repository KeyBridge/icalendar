package ietf.params.xml.ns.icalendar.parameter.base;

import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import ietf.params.xml.ns.icalendar.parameter.base.text.*;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for TextParameterType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="TextParameterType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType">
 * &lt;sequence> &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}text"/>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextParameterType", propOrder = {
  "text"
})
@XmlSeeAlso({
  CnParamType.class,
  CutypeParamType.class,
  EncodingParamType.class,
  FbtypeParamType.class,
  FmttypeParamType.class,
  LanguageParamType.class,
  PartstatParamType.class,
  RelatedParamType.class,
  ReltypeParamType.class,
  RoleParamType.class,
  ScheduleAgentParamType.class,
  ScheduleForceSendParamType.class,
  ScheduleStatusParamType.class,
  TzidParamType.class,
  XBedeworkUidParamType.class
})
public class TextParameterType extends BaseParameterType {

  @XmlElement(required = true)
  protected String text;

  public TextParameterType() {
  }

  public TextParameterType(String text) {
    this.text = text;
  }

  /**
   * Gets the value of the text property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the value of the text property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setText(String value) {
    this.text = value;
  }

  public boolean isSetText() {
    return (this.text != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(this.text);
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
    final TextParameterType other = (TextParameterType) obj;
    if (!Objects.equals(this.text, other.text)) {
      return false;
    }
    return true;
  }
}
