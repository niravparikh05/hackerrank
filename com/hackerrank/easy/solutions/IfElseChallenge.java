package com.hackerrank.easy.solutions;

/*
 * Given an integer, , perform the following conditional actions:
If  is odd, print Weird
If  is even and in the inclusive range of  to , print Not Weird
If  is even and in the inclusive range of  to , print Weird
If  is even and greater than , print Not Weird
Complete the stub code provided in your editor to print whether or not  is weird.

Input Format

A single line containing a positive integer, .

Constraints

Output Format

Print Weird if the number is weird; otherwise, print Not Weird.

Sample Input 0

3
Sample Output 0

Weird
Sample Input 1

24
Sample Output 1

Not Weird
 * 
 */
import java.util.Scanner;

public class IfElseChallenge {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (N % 2 > 0) { // this is an odd number
			System.out.println("Weird");
		} else {
			//this is an even number
			if (N > 20 || (N >= 2 && N <= 5)) {
				System.out.println("Not Weird");
			}
			else if (N >= 6 && N <= 20) {
				System.out.println("Weird");	
			}
		}

        scanner.close();
		

	}

}
