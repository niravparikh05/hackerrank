package com.hackerrank.medium.solutions;
/*
A student is taking a cryptography class and has found anagrams to be very useful. Two strings are anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency. For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

The student decides on an encryption scheme that involves two large strings. The encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Determine this number.

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

Example


Delete  from  and  from  so that the remaining strings are  and  which are anagrams. This takes  character deletions.

Function Description

Complete the makeAnagram function in the editor below.

makeAnagram has the following parameter(s):

string a: a string
string b: another string
Returns

int: the minimum total characters that must be deleted
Input Format

The first line contains a single string, .
The second line contains a single string, .

Constraints

The strings  and  consist of lowercase English alphabetic letters, ascii[a-z].
Sample Input

cde
abc
Sample Output

4
Explanation

Delete the following characters from the strings make them anagrams:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
It takes  deletions to make both strings anagrams.
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

class ResultSV {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        int min_deletions = 0;

        int[] source_char_count = new int[26]; //as there are only 26 characters
        int[] target_char_count = new int[26];

        //maintain the count of characters position 0 => a => count, position 1 => b => count
        for (char ch : a.toCharArray()) {
            source_char_count[(int) ch - (int)'a']++;
        }
        //maintain the count of characters position 0 => a => count, position 1 => b => count
        for (char ch : b.toCharArray()) {
            target_char_count[(int) ch - (int)'a']++;
        }
        //difference between these two will give us the min deletions required to make it anagram
        for (int indx = 0; indx < 26; indx++) { // again only 26 characters
            int difference = Math.abs(source_char_count[indx] - target_char_count[indx]);
            min_deletions+=difference;
        }
        return min_deletions;
    }

}

public class MakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = ResultSV.makeAnagram(a, b);
        System.out.println(res);
        bufferedReader.close();
    }
}

