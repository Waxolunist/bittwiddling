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

import com.vcollaborate.math.CombinatoricUtils;

import java.util.BitSet;

public final class BinaryUtils {

  private BinaryUtils() {
  }

  /**
   * Converts {@code value} into a {@link BitSet} of size {@code size}.
   */
  public static final BitSet toBitSet(final int size, final long value) {
    BitSet bits = new BitSet(size);
    int idx = 0;
    long tmp = value;
    while (tmp != 0L) {
      if (tmp % 2L != 0L) {
        bits.set(idx);
      }
      ++idx;
      tmp = tmp >>> 1;
    }
    return bits;
  }

  /**
   * Converts the {@link BitSet} {@code bits} into a long value.
   * <p>
   * This is the reverse operation from {@link #toBitSet(int, long)}.
   */
  public static final long fromBitSet(final BitSet bits) {
    long value = 0L;
    for (int i = 0; i < bits.size(); i++) {
      value += bits.get(i) ? (1L << i) : 0L;
    }
    return value;
  }

  /**
   * Compute the lexicographically next bit permutation.
   * 
   * Suppose we have a pattern of N bits set to 1 in an integer and we want the next permutation of
   * N 1 bits in a lexicographical sense. For example, if N is 3 and the bit pattern is 00010011,
   * the next patterns would be 00010101, 00010110, 00011001,00011010, 00011100, 00100011, and so
   * forth.
   */
  public static final long nextPermutation(long val) {
    long tmp = val | (val - 1);
    return (tmp + 1) | (((-tmp & -~tmp) - 1) >> (Long.numberOfTrailingZeros(val) + 1));
  }

  /**
   * Returns an array containing all permutations of a defined bitset with {@code bits} set and 
   * maximum length of {@code length}.
   */
  public static final long[] getAllPermutations(int bits, int length) {
    long min = allOnes(bits);
    long permutations = CombinatoricUtils.combinations(length, bits);
    long[] retVal = new long[(int) permutations];

    long val = min;
    for (int idx = 0; idx < permutations; idx++) {
      retVal[idx] = val;
      val = nextPermutation(val);
    }
    return retVal;
  }

  /**
   * Calculates the hamming distance between the two given values.
   */
  public static final int getHammingDistance(final long val1, final long val2) {
    return Long.bitCount(val1 ^ val2);
  }

  /**
   * Returns a value with all bits set to 1 of length {@code length}. 
   */
  public static final long allOnes(final long length) {
    return (1 << length) - 1;
  }

  /**
   * Determines if the bit at position {@code pos} in the value {@code val} is set.
   */
  public static final boolean isBitSet(final long val, final int pos) {
    return (val & (1 << pos)) != 0;
  }

  /**
   * Returns the number of bits set.
   */
  public static final int[] getBitsSet(final long val) {
    long tmp = val;
    int[] retVal = new int[Long.bitCount(val)];
    for (int i = 0; i < retVal.length; i++) {
      retVal[i] = Long.numberOfTrailingZeros(tmp);
      tmp = tmp ^ Long.lowestOneBit(tmp);
    }
    return retVal;
  }
}
