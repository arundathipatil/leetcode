
/**
 *
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 

Constraints:

-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n
 * 
 * 
 * @author Arundathi Patil
 *
 */
public class MergeSortedArrays {
	
	 public void mergeSolution1(int[] nums1, int m, int[] nums2, int n) {
	         if(nums1.length != 0 && nums2.length !=0) {
	             int j=0;
	             int temp = nums2[j];
	             for(int i =0; i<= m && i < nums1.length; i++) {
	                 if(temp <= nums1[i] && i < m) {
	                     int temp1 = temp;
	                     temp = nums1[i];
	                     nums1[i] = temp1;
	                 }
	                 if(i == m) {
	                     m++;
	                     nums1[i] = temp;
	                     i=0;
	                     if(j < nums2.length-1) {
	                         temp = nums2[++j];
	                     }
	                 }
	             }
	         } 
	 }
	 
	public void mergeSolution2(int[] nums1, int m, int[] nums2, int n) {
	        
	        int first = m-1;
	        int second = n-1;
	        
	        if(nums1.length != 0 && nums2.length !=0) {
	            for(int i= m+n-1; i >=0; i--) {
	                if(second < 0) {
	                    break;
	                }
	                if(first >= 0 && nums1[first] >= nums2[second]) {
	                    nums1[i] = nums1[first];
	                    first--;
	                } else {
	                    nums1[i] = nums2[second];
	                    second--;
	                }
	            }
	        }  
	    }

}
