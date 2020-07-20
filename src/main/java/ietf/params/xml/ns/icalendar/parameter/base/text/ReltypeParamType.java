/*
 * Copyright 2016 Key Bridge LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ietf.params.xml.ns.icalendar.parameter.base.text;

import ietf.params.xml.ns.icalendar.parameter.base.TextParameterType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * reltypeparam = "RELTYPE" "=" ("PARENT" ; Parent relationship - Default /
 * "CHILD" ; Child relationship / "SIBLING" ; Sibling relationship / iana-token
 * ; Some other IANA-registered ; iCalendar relationship type / x-name) ; A
 * non-standard, experimental ; relationship type Ws-Calendar adds the values /
 * "FINISHTOSTART" / "FINISHTOFINISH" / "STARTTOFINISH" / "STARTTOSTART"
 * <p>
 * ; Default is PARENT
 * <p>
 * Java class for ReltypeParamType complex type. The following schema fragment
 * specifies the expected content contained within this class.
 * <pre> &lt;complexType name="ReltypeParamType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}TextParameterType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReltypeParamType")
public class ReltypeParamType extends TextParameterType {
}
