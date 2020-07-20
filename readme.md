#  iCalendar (RFC5545) 

**About**

This is a Java implementation of the iCalendar specification with support for standards based event transfer and serialization in XML and JSON.

_iCalendar_ is a Java library used to read and write iCalendar data streams as defined in RFCs 5545, 7529, 6321, 7265, etc. The iCalendar standard provides a common data format used to store information about calendar-specific data such as events, appointments, to-do lists, etc. All popular calendaring tools, such as Outlook and Apple's iCal support the iCalendar standard.

**Alternatives**

This library provides a standards-based serializable iCalendar implementation. While this library implements all basic functionality such as recurrence, etc. if you need an iCalendar processing and management utility that accommodates related configurations such as vCard and various obscure corner cases then you might also consider the excellent [iCal4j](https://github.com/ical4j/ical4j) project.

**Timezone support**

By default all datetime values are normalized and conveyed in the **UTC** timezone and internal datetime instances are fixed. To render datetimes in a local timezone we do not recommend shifting the datetime value, but instead recommend using a display converter.

For example: the same datetime value may be displayed using a timezone EST (GMT-4) and timezone PST (GTM-7) display converter as 9:00 AM (EST) and 06:00 AM (PST), respectively, without modifying the underlying datetime value. Common display converters include _FacesConverter_, _java.date.DateTimeFormatter_, etc.

**Supported specifications**

RFC specifications are available from the IETF RFC Tracker. Many aspects of this project including the original _xCAL_ XSD implementation are based on the excellent [Bedework](https://www.apereo.org/projects/bedework) project.

| Name | Specification | Description |
| ---- | ------------- | --- |
| iCalendar | [RFC 5545](http://tools.ietf.org/html/rfc5545) | Internet Calendaring and Scheduling (iCalendar) |
| iCalendar | [RFC 2445](http://tools.ietf.org/html/rfc2445) | (deprecated) |
| Recurrence | [RFC 7529](http://tools.ietf.org/html/rfc7529) | Non-Gregorian Recurrence Rules |
| xCal | [RFC 6321](http://tools.ietf.org/html/rfc6321) | XML Format for iCalendar |
| jCal | [RFC 7265](http://tools.ietf.org/html/rfc7265) | JSON Format for iCalendar |
| Parameter Value Encoding | [RFC 6868](http://tools.ietf.org/html/rfc6868)
| iTIP |  [RFC 5546](http://tools.ietf.org/html/rfc5546) | Transport-Independent Interoperability Protocol |
| SDP  |  [RFC 5547](http://tools.ietf.org/html/rfc5547) | Session Description Protocol |


**License**

Apache License, Version 2.0

>  Copyright (C) Key Bridge and/or its affiliates.
>
>   Licensed under the Apache License, Version 2.0 (the "License");
>   you may not use this file except in compliance with the License.
>   You may obtain a copy of the License at
>
>       http://www.apache.org/licenses/LICENSE-2.0
>
>   Unless required by applicable law or agreed to in writing, software
>   distributed under the License is distributed on an "AS IS" BASIS,
>   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
>   See the License for the specific language governing permissions and
>   limitations under the License.


**Contributing**

We use this library in various web applications and protocols in our various spectrum administration system properties. Your contributions, bug reports and feature requests are welcome!

Contributions may be in the form of feature enhancements, bug fixes, test cases, documentation and forum participation. If you have a question, just ask. If you have an answer, write it down.
