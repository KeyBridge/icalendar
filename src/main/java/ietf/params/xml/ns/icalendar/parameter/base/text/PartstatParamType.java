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
 * partstat-event = ("NEEDS-ACTION" ; Event needs action / "ACCEPTED" ; Event
 * accepted / "DECLINED" ; Event declined / "TENTATIVE" ; Event tentatively ;
 * accepted / "DELEGATED" ; Event delegated / x-name ; Experimental status /
 * iana-token) ; Other IANA-registered ; status ; These are the participation
 * statuses for a "VEVENT". ; Default is NEEDS-ACTION.
 * <p>
 * partstat-todo = ("NEEDS-ACTION" ; To-do needs action / "ACCEPTED" ; To-do
 * accepted / "DECLINED" ; To-do declined / "TENTATIVE" ; To-do tentatively ;
 * accepted / "DELEGATED" ; To-do delegated / "COMPLETED" ; To-do completed ;
 * COMPLETED property has ; DATE-TIME completed / "IN-PROCESS" ; To-do in
 * process of ; being completed / x-name ; Experimental status / iana-token) ;
 * Other IANA-registered ; status ; These are the participation statuses for a
 * "VTODO". ; Default is NEEDS-ACTION.
 * <p>
 * partstat-jour = ("NEEDS-ACTION" ; Journal needs action / "ACCEPTED" ; Journal
 * accepted / "DECLINED" ; Journal declined / x-name ; Experimental status /
 * iana-token) ; Other IANA-registered ; status ; These are the participation
 * statuses for a "VJOURNAL". ; Default is NEEDS-ACTION.
 * <p>
 * Java class for PartstatParamType complex type. The following schema fragment
 * specifies the expected content contained within this class.
 * <pre>  &lt;complexType name="PartstatParamType"&gt; &lt;complexContent&gt;
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}TextParameterType"&gt;
 * &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartstatParamType")
public class PartstatParamType extends TextParameterType {
}
