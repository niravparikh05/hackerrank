package com.hackerrank.easy.solutions;

import java.util.Scanner;

/*
 * 
 * "In computing, End Of File (commonly abbreviated EOF) is a condition in a computer operating system where no more data can be read from a data source." � (Wikipedia: End-of-file)

The challenge here is to read  lines of input until you reach EOF, then number and print all  lines of content.

Hint: Java's Scanner.hasNext() method is helpful for this problem.

Input Format

Read some unknown  lines of input from stdin(System.in) until you reach EOF; each line of input contains a non-empty String.

Output Format

For each line, print the line number, followed by a single space, and then the line content received as input.

Sample Input

Hello world
I am a file
Read me until end-of-file.
Sample Output

1 Hello world
2 I am a file
3 Read me until end-of-file.
 * 
 */

public class EOFClass1 {
	
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		try {
			int indx = 1;
			while (sc.hasNext()) {
				System.out.println(indx + " " + sc.nextLine());
				indx++;
			}
		} finally {
			sc.close();
		}

	}

}
