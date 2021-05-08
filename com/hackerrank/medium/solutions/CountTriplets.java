package com.hackerrank.medium.solutions;
/*
You are given an array and you need to find number of tripets of indices  such that the elements at those indices are in geometric progression for a given common ratio  and .

Example


There are  and  at indices  and . Return .

Function Description

Complete the countTriplets function in the editor below.

countTriplets has the following parameter(s):

int arr[n]: an array of integers
int r: the common ratio
Returns

int: the number of triplets
Input Format

The first line contains two space-separated integers  and , the size of  and the common ratio.
The next line contains  space-seperated integers .

Constraints

Sample Input 0

4 2
1 2 2 4
Sample Output 0

2
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Integer> leftMap = new HashMap<>();
        final Map<Long, Integer> rightMap = new HashMap<>();
        arr.stream().forEach(val -> {
            rightMap.put(val, rightMap.getOrDefault(val, 0) + 1);
        });
        long count = 0;
        for (int indx = 0; indx < arr.size(); indx++) {
            long midVal = arr.get(indx);
            long c1 = 0, c2 = 0;

            rightMap.put(midVal, rightMap.getOrDefault(midVal, 0) - 1);

            if (leftMap.containsKey(midVal / r) && midVal % r == 0) {
                c1 = leftMap.get(midVal / r);
            }

            if (rightMap.containsKey(midVal * r)) {
                c2 = rightMap.get(midVal * r);
            }

            count += c1 * c2;

            leftMap.put(midVal, leftMap.getOrDefault(midVal, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);
        System.out.println(ans);
        bufferedReader.close();
    }
}

