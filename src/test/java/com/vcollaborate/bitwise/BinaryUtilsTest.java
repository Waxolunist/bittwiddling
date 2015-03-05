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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.BitSet;

public class BinaryUtilsTest {

  @Test
  public void testToBitSet() {
    BitSet bs = new BitSet();
    bs.set(0, 4);
    assertEquals(bs, BinaryUtils.toBitSet(4, 15));
    bs.set(5);
    assertEquals(bs, BinaryUtils.toBitSet(4, 47));
  }

  @Test
  public void testFromBitSet() {
    BitSet bs = new BitSet();
    bs.set(0, 4);
    assertEquals(15, BinaryUtils.fromBitSet(bs));
    bs.set(5);
    assertEquals(47, BinaryUtils.fromBitSet(bs));
  }

  @Test
  public void testNextPermutation() {
    assertEquals(0b00010101, BinaryUtils.nextPermutation(0b00010011));
    assertEquals(0b00010110, BinaryUtils.nextPermutation(0b00010101));
    assertEquals(0b00011001, BinaryUtils.nextPermutation(0b00010110));
    assertEquals(0b00011010, BinaryUtils.nextPermutation(0b00011001));
    assertEquals(0b00011100, BinaryUtils.nextPermutation(0b00011010));
    assertEquals(0b00100011, BinaryUtils.nextPermutation(0b00011100));
  }

  @Test
  public void testGetAllPermutations() {
    assertEquals(3, BinaryUtils.getAllPermutations(1, 3).length);
    assertEquals(3, BinaryUtils.getAllPermutations(2, 3).length);
  }

  @Test
  public void testGetHammingDistance() {
    assertEquals(2, BinaryUtils.getHammingDistance(0b1011101, 0b1001001));
  }

  @Test
  public void testAllOnes() {
    assertEquals(7, BinaryUtils.allOnes(3));
  }

  @Test
  public void testIsBitSet() {
    assertEquals(true, BinaryUtils.isBitSet(7, 0));
    assertEquals(true, BinaryUtils.isBitSet(7, 1));
    assertEquals(true, BinaryUtils.isBitSet(7, 2));
    assertEquals(false, BinaryUtils.isBitSet(7, 3));
  }

  @Test
  public void testGetBitsSet() {
    assertArrayEquals(new int[]{0,1,2}, BinaryUtils.getBitsSet(7));
    assertArrayEquals(new int[]{3}, BinaryUtils.getBitsSet(8));
  }

}
