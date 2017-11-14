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

import ietf.params.xml.ns.icalendar.EFreqRecurType;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * String/Object converter for the indicated class.
 *
 * @author Jesse Caulfield 07/07/14
 */
@FacesConverter(value = "convertRecurFreq")
public class ConvertRecurFreq implements Converter {

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    try {
      return EFreqRecurType.valueOf(value);
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    if (value instanceof EFreqRecurType) {
      return ((Enum<EFreqRecurType>) value).name();
    }
    return value != null ? value.toString() : null;
  }

}
