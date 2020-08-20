
package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement : https://leetcode.com/problems/pascals-triangle-ii/
 * @Level : Easy
 */
public class LC_PascalsTriangleII_119 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getRow(4).toString());

	}

	public static List<Integer> getRow(int rowIndex) {

		List<Integer> pascalRow = new ArrayList<Integer>();
		pascalRow.add(1);

		if (rowIndex == 0) {
			return pascalRow;
		}  else {
			pascalRow.add(1);
			for (int index = 2; index <= rowIndex; index++) {
				for (int i = 0; i < index; i += 2) {
					pascalRow.add(i + 1, pascalRow.get(i) + pascalRow.get(i + 1));
					if (!(i == 0 || i == index)) {
						pascalRow.remove(i);
						i--;
					}
				}
			}

		}

		return pascalRow;
	}

}
