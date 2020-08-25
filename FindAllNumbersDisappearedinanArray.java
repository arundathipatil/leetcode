/*
 	Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
	
	Find all the elements of [1, n] inclusive that do not appear in this array.
	
	Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
	
	Example:
	
	Input:
	[4,3,2,7,8,2,3,1]
	
	Output:
	[5,6] 
 *  @author Arundathi Patil
 */


import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

	public static void main(String[] args) {
		int[] nums = new int[]{4,3,2,7,8,2,3,1};
		
		FindAllNumbersDisappearedinanArray.findDisappearedNumbers(nums);
	}

	 public static List<Integer> findDisappearedNumbers(int[] nums) {
	        List<Integer> missing = new ArrayList<Integer>();
	        
	        int i=0;
	        while(i<nums.length) {            
	            if(nums[i] == i+1 || nums[i] == 0) {
	                i++;
	            } else {
	                if(nums[nums[i]-1] == nums[i]) {
	                    nums[i] = 0;
	                    i++;
	                } else {
	                    int temp = nums[i];
	                    nums[i] = nums[nums[i]-1];
	                    nums[temp-1] = temp;
	                }
	            }
	        }
	        
	        for(int j=0; j<nums.length;j++) {
	            if(nums[j] == 0) {
	                missing.add(j+1);
	            }
	        }
	        
	        return missing;
	    }
}
