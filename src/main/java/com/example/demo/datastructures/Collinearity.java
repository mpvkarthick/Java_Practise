package com.example.demo.datastructures;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Collinearity {

	public static void main(String[] args) {

		System.out.println(checkStraightLine(new int[][] { { -3,-2 }, { -1, -2 },{ 2,-2 },{-2,-2}, { 0,-2 } }));

	}

	public static boolean checkStraightLine(int[][] coordinates) {

		BigDecimal bd;
		double c2;
		double c1;
		double diff;
		double runningDiff;
		c2 = Math.sqrt(Math.pow(coordinates[1][0], 2) + Math.pow(coordinates[1][1], 2));
		bd = new BigDecimal(Double.toString(c2));
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		c2 = bd.doubleValue();
		c1 = Math.sqrt(Math.pow(coordinates[0][0], 2) + Math.pow(coordinates[0][1], 2));
		bd = new BigDecimal(Double.toString(c1));
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		c1 = bd.doubleValue();
		bd = new BigDecimal(Double.toString(c2-c1));
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		diff = Math.abs(bd.doubleValue());
		for (int i = 0; i < coordinates.length - 1; i++) {

			c2 = Math.sqrt(Math.pow(coordinates[i + 1][0], 2) + Math.pow(coordinates[i + 1][1], 2));
			bd = new BigDecimal(Double.toString(c2));
			bd = bd.setScale(1, RoundingMode.HALF_UP);
			c2 = bd.doubleValue();
			c1 = Math.sqrt(Math.pow(coordinates[i][0], 2) + Math.pow(coordinates[i][1], 2));
			bd = new BigDecimal(Double.toString(c1));
			bd = bd.setScale(1, RoundingMode.HALF_UP);
			c1 = bd.doubleValue();
			bd = new BigDecimal(Double.toString(c2-c1));
			bd = bd.setScale(1, RoundingMode.HALF_UP);
			runningDiff = bd.doubleValue();
			System.out.println("Co-ordinates Difference between c2 = " + c2 + " ,c1 = " + c1 + " is " + (runningDiff));
			//if(Math.abs(runningDiff) != diff) return false;
			
		}
		return true;
	}
}
