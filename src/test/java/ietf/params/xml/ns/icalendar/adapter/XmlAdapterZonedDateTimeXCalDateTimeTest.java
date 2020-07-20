/*
 * Copyright 2020 IETF. All rights reserved. Use is subject to license
 * terms.
 *
 * This software code is protected by Copyrights and remains the property of
 * IETF and its suppliers, if any. IETF reserves all rights in and to
 * Copyrights and no license is granted under Copyrights in this Software
 * License Agreement.
 *
 * IETF generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request by sending an email to info@keybridgewireless.com.
 *
 * All information contained herein is the property of IETF and its
 * suppliers, if any. The intellectual and technical concepts contained herein
 * are proprietary.
 */
package ietf.params.xml.ns.icalendar.adapter;

import java.time.ZonedDateTime;
import org.junit.*;

/**
 *
 * @author Key Bridge
 */
public class XmlAdapterZonedDateTimeXCalDateTimeTest {

  public XmlAdapterZonedDateTimeXCalDateTimeTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void marshalZonedDateTime() {
    XmlAdapterZonedDateTimeXCalDateTime adapter = new XmlAdapterZonedDateTimeXCalDateTime();

    String[] times = new String[]{"20170925T000000Z",
                                  "20140725T000000Z",
                                  "20140730T000000Z"};

    for (String time : times) {
      ZonedDateTime ztime = adapter.unmarshal(time);
      String textTime = adapter.marshal(ztime);
      ZonedDateTime reztime = adapter.unmarshal(textTime);
      System.out.println(time + " ->  " + ztime + " -> " + textTime + " -> " + reztime);

      Assert.assertEquals(ztime, reztime);
    }
  }

}
