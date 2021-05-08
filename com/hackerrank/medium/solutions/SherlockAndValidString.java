package com.hackerrank.medium.solutions;

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

/*
Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.

Example

This is a valid string because frequencies are .


This is a valid string because we can remove one  and have  of each character in the remaining string.


This string is not valid as we can only remove  occurrence of . That leaves character frequencies of .

Function Description

Complete the isValid function in the editor below.

isValid has the following parameter(s):

string s: a string
Returns

string: either YES or NO
Input Format

A single string .

Constraints

Each character
Sample Input 0

aabbcd
Sample Output 0

NO
Explanation 0

Given , we would need to remove two characters, both c and d  aabb or a and b  abcd, to make it valid. We are limited to removing only one character, so  is invalid.

Sample Input 1

aabbccddeefghi
Sample Output 1

NO
 */
class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        int[] char_count = new int[26];
        int max_count = Integer.MIN_VALUE;
        for (char ch : s.toCharArray()) {
            int position = (int)ch - (int)'a';
            int count = char_count[position]++;
            if (max_count < count) max_count = count;
        }
        int numOfModificationsAllowed = 1;
        int numOfModifications = 0;
        for (int indx = 0; indx < 26; indx++) {
            if (char_count[indx] != 0 && char_count[indx] != max_count) {
                numOfModifications += Math.abs(char_count[indx] - max_count);
            }
        }
        if (numOfModifications <= numOfModificationsAllowed) return "YES";
        else return "NO";

    }

}

public class SherlockAndValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);
        System.out.println(result);
        bufferedReader.close();
    }
}

