package com.vcollaborate.bitwise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public final class BinaryStringUtils {
    public static final char SEPARATOR = '_';
    
    public static final String prettyPrint(final String binaryString) {
        return prettyPrint(binaryString, SEPARATOR);
    }
    
    public static final String prettyPrint(final String binaryString, final char separator) {
        char[] reverseBinary = binaryString.toCharArray();
        ArrayUtils.reverse(reverseBinary);
        
        List<String> quadrupleList = new ArrayList<String>();
        for(int i = 0; i < reverseBinary.length; i = i+4) {
            quadrupleList.add(new String(
                    new char[]{
                            reverseBinary[i+3],
                            reverseBinary[i+2],
                            reverseBinary[i+1],
                            reverseBinary[i]
                    }));
        }
        
        Collections.reverse(quadrupleList);
        return StringUtils.join(quadrupleList, separator);
    }

    public static final String fromPrettyString(final String prettyBinaryString) {
        return fromPrettyString(prettyBinaryString, SEPARATOR);
    }
    
    public static final String fromPrettyString(final String prettyBinaryString, final char separator) {
        return StringUtils.remove(prettyBinaryString, separator);
    }
    
    public static final String zeroPadString(final String binaryString, final int length) {
        return String.format("%" + length + "s", binaryString).replace(' ', '0');
    }
    
}
