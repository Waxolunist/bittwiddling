/*
 * Copyright (C) 2012-2015 Christian Sterzl <christian.sterzl@gmail.com>
 *
 * This file is part of Bittwiddling.
 *
 * Bittwiddling is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bittwiddling is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Bittwiddling.  If not, see <http://www.gnu.org/licenses/>.
 */
        
package com.vcollaborate.bitwise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryStringUtilsTest {

  @Test
  public void testPrettyPrintString() {
    assertEquals("1111_1111", BinaryStringUtils.prettyPrint("11111111"));
    assertEquals("0111_1111", BinaryStringUtils.prettyPrint("1111111"));
  }

  @Test
  public void testPrettyPrintStringChar() {
    assertEquals("1111:1111", BinaryStringUtils.prettyPrint("11111111", ':'));
    assertEquals("0111-1111", BinaryStringUtils.prettyPrint("1111111", '-'));
  }

  @Test
  public void testFromPrettyStringString() {
    assertEquals("11111111", BinaryStringUtils.fromPrettyString("1111_1111"));
    assertEquals("1111111", BinaryStringUtils.fromPrettyString("111_1111"));
  }

  @Test
  public void testFromPrettyStringStringChar() {
    assertEquals("11111111", BinaryStringUtils.fromPrettyString("1111:1111", ':'));
    assertEquals("1111111", BinaryStringUtils.fromPrettyString("111-1111", '-'));
  }

  @Test
  public void testZeroPadString() {
    assertEquals("11111111", BinaryStringUtils.zeroPadString("11111111"));
    assertEquals("01111111", BinaryStringUtils.zeroPadString("1111111"));
    assertEquals("000011111111", BinaryStringUtils.zeroPadString("11111111", 12));
    assertEquals("11111111", BinaryStringUtils.zeroPadString("11111111", 8));
    assertEquals("11111111", BinaryStringUtils.zeroPadString("11111111", 4));
  }

}
