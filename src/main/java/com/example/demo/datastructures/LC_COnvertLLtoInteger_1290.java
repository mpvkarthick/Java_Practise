/**
 * @author Karthik Mannepalli
 * Problem Statement : 
 * Level : 
 */
package com.example.demo.datastructures;

/**
 * @author cpsdadmin
 *
 */
public class LC_COnvertLLtoInteger_1290 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ans = 3 ;
		ans |= 0;
		System.out.println(ans);
		System.out.println(0 << 0);

	}

	public int getDecimalValue(ListNode head) {

		return getDecimalValue(head, 0);
	}
	
	public int getDecimalValue(ListNode head, int sum) {
		
		sum+=head.val;
		
		if(head.next == null) {
			return sum;
		}
		
		return getDecimalValue(head.next, sum <<1);
	}
}
