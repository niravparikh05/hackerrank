package com.hackerrank.medium.solutions;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
A group of friends want to buy a bouquet of flowers. The florist wants to maximize his number of new customers and the money he makes. To do this, he decides he'll multiply the price of each flower by the number of that customer's previously purchased flowers plus . The first flower will be original price, , the next will be  and so on.

Given the size of the group of friends, the number of flowers they want to purchase and the original prices of the flowers, determine the minimum cost to purchase all of the flowers. The number of flowers they want equals the length of the  array.

Example


The length of , so they want to buy  flowers total. Each will buy one of the flowers priced  at the original price. Having each purchased  flower, the first flower in the list, , will now cost . The total cost is .

Function Description

Complete the getMinimumCost function in the editor below.

getMinimumCost has the following parameter(s):

int c[n]: the original price of each flower
int k: the number of friends
Returns
- int: the minimum cost to purchase all flowers

Input Format

The first line contains two space-separated integers  and , the number of flowers and the number of friends.
The second line contains  space-separated positive integers , the original price of each flower.

Constraints

Sample Input 0

3 3
2 5 6
Sample Output 0

13
Explanation 0

There are  flowers with costs  and  people in the group. If each person buys one flower,
the total cost of prices paid is  dollars. Thus, we print  as our answer.
 */

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] flowers) {
        //sort all flower prices in ascending order
        Arrays.sort(flowers);
        int i = flowers.length-1;
        int bought = 0;
        int total=0;
        //start backwards from the most expensive flower, stop when there is no more flowers left
        while(i>=0){
            //Calculate total
            //increment bought by 1 when everyone in the group has bought equal number of flowers
            for(int j=0;j<k && i>=0;j++){
                total+=(1+bought)*flowers[i];
                i--;
            }
            bought++;
        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);
        System.out.println(minimumCost);

        scanner.close();
    }
}