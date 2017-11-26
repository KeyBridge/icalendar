/*
 *  Copyright (C) 2014 Caulfield IP Holdings (Caulfield) and/or its affiliates.
 *  All rights reserved. Use is subject to license terms.
 *
 *  Software Code is protected by Caulfield Copyrights. Caulfield hereby reserves
 *  all rights in and to Caulfield Copyrights and no license is granted under
 *  Caulfield Copyrights in this Software License Agreement. Caulfield generally
 *  licenses Caulfield Copyrights for commercialization pursuant to the terms of
 *  either Caulfield's Standard Software Source Code License Agreement or
 *  Caulfield's Standard Product License Agreement.
 *
 *  A copy of either License Agreement can be obtained on request by email from:
 *  info@caufield.org.
 */
package ch.keybridge.icalendar.jsf.converter;

import ietf.params.xml.ns.icalendar.EWeekdayRecurType;
import ietf.params.xml.ns.icalendar.NthWeekdayRecurType;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * String/Object converter for the indicated class.
 *
 * @author jesse
 * @since v2.3.0 created 11/15/17
 */
@FacesConverter(value = "convertRecurNthWeekday")
public class ConvertRecurNthWeekday implements Converter {

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null || value.isEmpty() || value.length() < 2) {
      return null;
    }
    NthWeekdayRecurType weekdayRecurType = new NthWeekdayRecurType(EWeekdayRecurType.valueOf(value.substring(value.length() - 2)));
    if (value.length() > 2) {
      weekdayRecurType.setInteger(Integer.valueOf(value.substring(0, value.length() - 2)));
    }
    return weekdayRecurType;
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    return value != null ? value.toString() : null;
  }
}
