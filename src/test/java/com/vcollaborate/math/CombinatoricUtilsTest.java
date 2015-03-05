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
        
package com.vcollaborate.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CombinatoricUtilsTest {

  @Test
  public void testCombinations() {
    assertEquals(10, CombinatoricUtils.combinations(5, 3));
    assertEquals(120, CombinatoricUtils.combinations(10, 3));
    assertEquals(10, CombinatoricUtils.combinations(10, 1));
  }

}
