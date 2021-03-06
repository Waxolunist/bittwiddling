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

import com.google.common.math.BigIntegerMath;

public final class CombinatoricUtils {

  private CombinatoricUtils() {
  }

  /**
   * Calculates the possible combinations of chosen types (r) from a list of types (n) or n over r.
   * <p>
   * Mathematical it is following formula: <br>
   * \(\binom{n}{r} = \frac{n!}{r!(n-r)!}\)
   */
  public static final long combinations(final int n, final int r) {
    return BigIntegerMath.factorial(n)
        .divide(BigIntegerMath.factorial(r).multiply(BigIntegerMath.factorial(n - r)))
        .longValue();
  }
}
