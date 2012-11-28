package com.vcollaborate.bitwise;

import java.util.BitSet;

import com.vcollaborate.math.CombinatoricUtils;

public final class BinaryUtils {
    // public static final int countOnes(long value) {
    // int c = 0;
    // long b = value;
    // while(b != 0L) {
    // c += (b & 1);
    // b = b >> 1;
    // }
    // return c;
    // }

    // public static final boolean hasNOnes(long value, int ones) {
    // int c = 0;
    // long b = value;
    // while(b != 0L) {
    // c += (b & 1);
    // if(c > ones) {
    // return false;
    // }
    // b = b >> 1;
    // }
    // return c == ones;
    // }

    // public static final int countZeros(long value) {
    // int c = 0;
    // long b = value;
    // while(b != 0L) {
    // c += (~b & 1);
    // b = b >> 1;
    // }
    // return c;
    // }
    //
    // public static final boolean hasNZeros(long value, int zeros) {
    // int c = 0;
    // long b = value;
    // while(b != 0L) {
    // c += (~b & 1);
    // if(c > zeros) {
    // return false;
    // }
    // b = b >> 1;
    // }
    // return c == zeros;
    // }

    public static final BitSet toBitSet(final int size, final long value) {
        BitSet bits = new BitSet(size);
        int c = 0;
        long b = value;
        while (b != 0L) {
            if (b % 2L != 0L) {
                bits.set(c);
            }
            ++c;
            b = b >>> 1;
        }
        return bits;
    }

    public static final long fromBitSet(final BitSet bits) {
        long value = 0L;
        for (int i = 0; i < bits.size(); i++) {
            value += bits.get(i) ? (1L << i) : 0L;
        }
        return value;
    }

    public static final long nextPermutation(long val) {
        long t = val | (val - 1);
        return (t + 1) | (((-t & -~t) - 1) >> (Long.numberOfTrailingZeros(val) + 1));
    }

    public static final long[] getAllPermutations(int bits, int length) {
        long min = allOnes(bits);
        long permutations = CombinatoricUtils.combinations(length, bits);
        long[] retVal = new long[(int) permutations];

        long v = min;
        for (int idx = 0; idx < permutations; idx++) {
            retVal[idx] = v;
            v = nextPermutation(v);
        }
        return retVal;
    }

    public static final int getHammingDistance(final long a, final long b) {
        return Long.bitCount(a ^ b);
    }

    public static final long allOnes(final long bits) {
        return (1 << bits) - 1;
    }

    /**
     * 
     * @param val
     * @param pos 0-based position to test
     * @return
     */
    public static final boolean isBitSet(final long val, final int pos) {
        return (val & (1 << pos)) != 0;
    }

    public static final int[] getBitsSet(final long val) {
        long t = val;
        int[] retVal = new int[Long.bitCount(val)];
        for(int i = 0; i < retVal.length; i++) {
            retVal[i] = Long.numberOfTrailingZeros(t);
            t = t ^ Long.lowestOneBit(t);
        }
        return retVal;
    }
}
