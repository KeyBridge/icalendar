#  iCalendar (RFC5545) XML Encoding (xCal)

## About

This is a Java implementation of the XML format for iCalendar (xCal) specification: RFC 6321.

We use this library in various web applications and protocols in our various
spectrum administration system properties. Your bug reports and feature requests
are welcome!

## Alternatives

This library provides a standards-based serializable iCalendar
implementation. While this library implements all basic functionality such as
recurrence, etc. if you need an iCalendar processing and management utility
that accommodates related configurations such as vCard and various corner cases
then you might also consider the excellent [iCal4j](https://github.com/ical4j/ical4j) project.

## Timezone support

By default all datetime values are normalized and conveyed in the **UTC** timezone
and internal datetime instances are fixed. To render datetimes in a local timezone
we do not recommend shifting the datetime value, but instead recommend using a display
converter.
For example: the same datetime value may be displayed using a timezone EST (GMT-4) and timezone PST (GTM-7)
display converter as 9:00 AM (EST) and 06:00 AM (PST), respectively, without modifying the underlying datetime value.
Common display converters include _FacesConverter_, _SimpleDateFormat_, etc.

## Supported specifications

RFC specifications are available from the IETF RFC Tracker. Many aspects of this project
including the original XSD are based on the excellent [Bedework](https://www.apereo.org/projects/bedework) project.

| Name | Specification |
| ---- | ------------- |
| iCalendar | [RFC 2445](http://tools.ietf.org/html/rfc2445) (deprecated) |
| iCalendar | [RFC 5545](http://tools.ietf.org/html/rfc5545) |
| Recurrence | [RFC 7529](http://tools.ietf.org/html/rfc7529) |
| xCal | [RFC 6321](http://tools.ietf.org/html/rfc6321) |
| jCal | [RFC 7265](http://tools.ietf.org/html/rfc7265) |
| Parameter Value Encoding | [RFC 6868](http://tools.ietf.org/html/rfc6868)

## License

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

__END
