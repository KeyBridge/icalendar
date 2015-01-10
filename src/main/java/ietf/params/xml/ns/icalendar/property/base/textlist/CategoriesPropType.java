package ietf.params.xml.ns.icalendar.property.base.textlist;

import ietf.params.xml.ns.icalendar.property.base.TextListPropertyType;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for CategoriesPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="CategoriesPropType"> &lt;complexContent>
 * &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}TextListPropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoriesPropType")
public class CategoriesPropType extends TextListPropertyType {

  public CategoriesPropType() {
  }

  public CategoriesPropType(List<String> text) {
    super(text);
  }

}
