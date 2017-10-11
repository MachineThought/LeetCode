package org.leetcode;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    public Integer[] towSumONN(Integer[] num, Integer target) {
        if (num.length < 2) {
            throw new IndexOutOfBoundsException("the array length must more than 2 index");
        }

        Integer[] result = new Integer[2];

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;
    }


    public Integer[] towSumON(Integer[] num, Integer target) {
        Map<Integer, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            Integer anotherIndex = tempMap.get(target - num[i]);

            if (anotherIndex != null) {
                return new Integer[]{anotherIndex, i};
            } else {
                tempMap.put(num[i], i);
            }
        }

        return null;
    }

    private void testGroup(Class<TwoSum> clazz, String methodName) {
        System.out.println("---------" + methodName + " start---------");
        Map<Integer[], Integer> group = new HashMap<>();
        group.put(new Integer[]{2, 7, 11, 15}, 9);
        group.put(new Integer[]{2, 3, 12, 14}, 15);
        group.put(new Integer[]{1, 2, 2, 1}, 4);
        group.put(new Integer[]{1, 2, 2, 1}, 5);

        try {
            TwoSum twoSum = clazz.newInstance();
            Method method = clazz.getDeclaredMethod(methodName, Integer[].class, Integer.class);
            for (Map.Entry<Integer[], Integer> map : group.entrySet()) {
                Integer[] result = (Integer[]) method.invoke(twoSum, map.getKey(), map.getValue());
                System.out.print(Arrays.toString(map.getKey()) + "--");
                System.out.print(map.getValue() + "--");
                System.out.println(Arrays.toString(result));
            }

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("---------" + methodName + " end---------");
    }


    @Test
    public void testTowSumONN() {
        testGroup(TwoSum.class, "towSumONN");
    }

    @Test
    public void testTowSumON() {
        testGroup(TwoSum.class, "towSumON");
    }

    @Test
    public void testTowSum() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }


}
