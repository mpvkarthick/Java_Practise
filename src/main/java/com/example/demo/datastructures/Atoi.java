package com.example.demo.datastructures;

import java.math.BigInteger;

public class Atoi {

	public static void main(String[] args) {
//		System.out.println((int) '0'); // 48
//		System.out.println((int) '9'); // 57
//		System.out.println((int) '-'); // 45
//		System.out.println((int) '+'); // 43
//		System.out.println((int) 'A'); // 65
//		System.out.println((int) 'Z'); // 90
//		System.out.println((int) 'a'); // 97
//		System.out.println((int) 'z'); // 122

		System.out.println(myAtoi("91283472332"));

	}

	public static int myAtoi(String str) {

		BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));

		BigInteger min = new BigInteger(String.valueOf(Integer.MIN_VALUE));

		int iascii = 0;
		boolean numberStarted = false;
		boolean symbolStarted = false;
		StringBuilder builder = new StringBuilder("");
		String newStr = str.trim();
		int n = newStr.length();
		int i = 0;
		while (i < n) {
			iascii = (int) newStr.charAt(i);
			if (numberStarted && !(iascii >= 48 && iascii <= 57)) {
				break;
			}
			if (numberStarted && (iascii >= 48 && iascii <= 57)) {
				builder.append(newStr.charAt(i));
			}
			if(!numberStarted) {
				//condition 1 - see if incoming is symbol and symbol flag is false. if
				// so allow
				if((iascii == 43 || iascii == 45) && !symbolStarted) {
					builder.append(newStr.charAt(i));
					symbolStarted = true;
					i++;
					continue;
				}
				
				
				//condition 2 - see if incoming is symbol and symbol flag is true. if
				// so break;
				if((iascii == 43 || iascii == 45) && symbolStarted) {
					break;
				}
				
				//condition3 - see if incoming is not a symbol and not a number then 
				// break;
				if (!(iascii == 43 || iascii == 45 || (iascii >= 48 && iascii <= 57))) {
					break;
				}
				
				//condition4 - if incoming is number add
				if (iascii >= 48 && iascii <= 57) {
					builder.append(newStr.charAt(i));
					numberStarted = true;
				}
			}
			
			i++;
		}

		if (builder.toString().equalsIgnoreCase("") || builder.toString().equalsIgnoreCase("+")
				|| builder.toString().equalsIgnoreCase("-")) {
			return 0;
		} else if (new BigInteger(builder.toString()).compareTo(max) > 0) {
			return Integer.MAX_VALUE;
		} else if (min.compareTo(new BigInteger(builder.toString())) > 0) {
			return Integer.MIN_VALUE;
		} else {
			return Integer.parseInt(builder.toString());

		}
	}
}
