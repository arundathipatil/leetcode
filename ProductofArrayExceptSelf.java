
/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 
 * @author Arundathi Patil
 *
 */
public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4};
		ProductofArrayExceptSelf.productExceptSelf(arr);
	}
	
	
	public static int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        int[] result = new int[nums.length];
        
        l[0] =1;
        for(int i=1; i< nums.length; i++) {
            l[i]= l[i-1] * nums[i-1];
        }
        
        r[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--) {
            r[i]= r[i+1] *nums[i+1];
        }
        
        for(int i=0;i<nums.length;i++) {
            result[i] = l[i] * r[i];
        }
        
        return result;
    }

}
