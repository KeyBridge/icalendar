#  iCalendar (RFC5545) XML Encoding (xCal)

## About

This is a Java implementation of the XML format for iCalendar (xCal) specification: RFC 6321.

## Alternatives

This project exists to provide a standards-based serializable iCalendar
implementation. While this library implements all basic functionality such as
recurrence, etc. if you need a comprehensive iCalendar management utility
that accommodates all configurations and circumstances then you might consider
the excellent [iCal4j](https://github.com/ical4j/ical4j) project.

## Timezone support

By default all datetime instances are recorded in the **UTC** timezone.
Other timezones are fully supported however. Note that datetime instances are
fixed. When you change a timezone the datetimes are updated but not
shifted. e.g. changing the timezone from EST (GMT-4) to PST (GTM-7) for
a 9:00 AM (EST) datetime will provide a 06:00 AM (PST) datetime.

## Supported specifications

xCalendar and RFC5545 specifications are both available from the IETF RFC Tracker.
These classes were originally compiled using XSDs from the Bedework project. See:

- xCal: The XML format for iCalendar (draft-daboo-et-al-icalendar-in-xml-11)
- iCalendar Internet Calendaring and Scheduling Core Object Specification (RFC5545)

## Supported Specifications

| Name | Specification |
| ---- | ------------- |
| iCalendar | [RFC 2445](http://tools.ietf.org/html/rfc2445) (deprecated) |
| iCalendar | [RFC 5545](http://tools.ietf.org/html/rfc5545) |
| Recuddence | [RFC 7229](http://tools.ietf.org/html/rfc7529) |
| xCal | [RFC 6321](http://tools.ietf.org/html/rfc6321) |
| jCal | [RFC 7265](http://tools.ietf.org/html/rfc7265) |
| Parameter Value Encoding | [RFC 6868](http://tools.ietf.org/html/rfc6868)

## License

  Apache License, Version 2.0

>  Copyright (C) 2013 Caulfield IP Holdings (Caulfield) and/or its affiliates.
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
