package com.vcollaborate.math;

import com.google.common.math.BigIntegerMath;

public final class CombinatoricUtils {
    public static final long combinations(final int n, final int r) {
        return BigIntegerMath.factorial(n).
                divide(
                  BigIntegerMath.factorial(r).
                    multiply(BigIntegerMath.factorial(n - r))
                ).longValue();
    }
}
