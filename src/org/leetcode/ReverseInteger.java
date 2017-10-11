package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author yangxing
 * @date 2017/9/27 16:01
 */
public class ReverseInteger {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x = x / 10;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
                return 0;
        }
        return (int) sum;
    }


    @Test
    public void testReverse() throws InterruptedException {
        System.out.println(reverse(153236469));
    }
}
