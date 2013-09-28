package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.textlist.CategoriesPropType;
import ietf.params.xml.ns.icalendar.property.base.textlist.ResourcesPropType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for TextListPropertyType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="TextListPropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}text"
 * maxOccurs="unbounded"/> &lt;/sequence> &lt;/extension> &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextListPropertyType", propOrder = {
  "text"
})
@XmlSeeAlso({
  ResourcesPropType.class,
  CategoriesPropType.class
})
public class TextListPropertyType extends BasePropertyType {

  @XmlElement(required = true)
  protected List<String> text;

  /**
   * Gets the value of the text property.
   * <p/>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a
   * <CODE>set</CODE> method for the text property.
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getText().add(newItem);
   * </pre>
   * <p/>
   *
   * Objects of the following type(s) are allowed in the list {@link String }
   *
   *
   */
  public List<String> getText() {
    if (text == null) {
      text = new ArrayList<String>();
    }
    return this.text;
  }

  public boolean isSetText() {
    return ((this.text != null) && (!this.text.isEmpty()));
  }

  public void unsetText() {
    this.text = null;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 11 * hash + Objects.hashCode(this.text);
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
    final TextListPropertyType other = (TextListPropertyType) obj;
    if (!Objects.equals(this.text, other.text)) {
      return false;
    }
    return true;
  }
}
