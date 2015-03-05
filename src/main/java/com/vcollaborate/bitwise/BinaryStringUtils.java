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

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import java.util.List;

public final class BinaryStringUtils {
  public static final char SEPARATOR = '_';

  private BinaryStringUtils() {
  }

  /**
   * Returns {@code binaryString} zero-padded separated by {@value #SEPARATOR} in groups of 4.
   */
  public static final String prettyPrint(final String binaryString) {
    return prettyPrint(binaryString, SEPARATOR);
  }

  /**
   * Returns {@code binaryString} zero-padded separated by {@code seaparator} in groups of 4.
   */
  public static final String prettyPrint(final String binaryString, final char separator) {
    String paddedBinaryString = zeroPadString(binaryString);
    List<String> splitted = Splitter.fixedLength(4).splitToList(paddedBinaryString);
    return Joiner.on(separator).join(splitted);
  }

  /**
   * Reverse operation of {@link #prettyPrint(String)}.
   */
  public static final String fromPrettyString(final String prettyBinaryString) {
    return fromPrettyString(prettyBinaryString, SEPARATOR);
  }

  /**
   * Reverse operation of {@link #prettyPrint(String, char)}.
   */
  public static final String fromPrettyString(final String prettyBinaryString,
      final char separator) {
    List<String> splitted = Splitter.on(separator).splitToList(prettyBinaryString);
    return Joiner.on("").join(splitted);
  }

  /**
   * @see {@link Strings#padStart(String, int, char)}. Char is set to the value {@code 0}.
   */
  public static final String zeroPadString(final String binaryString, final int minLength) {
    return Strings.padStart(binaryString, minLength, '0');
  }

  /**
   * Same as {@link #zeroPadString(String, int)}, but determines {@code minLength} automatically.
   */
  public static final String zeroPadString(final String binaryString) {
    int minLength = (int) Math.ceil(binaryString.length() / 4.) * 4;
    return zeroPadString(binaryString, minLength);
  }

}
