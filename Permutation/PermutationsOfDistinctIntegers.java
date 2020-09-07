import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 
 *  Input: [1,2,3]
	Output:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
 * @author Arundathi Patil
 *
 */
public class PermutationsOfDistinctIntegers {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null) {
            return ans;
        }        
        permutate(nums, ans, 0, nums.length-1);
        return ans;
    }
    
    public void permutate(int[] nums, List<List<Integer>> ans, int l, int r) {
        if(l == r) {
            addToList(nums, ans);
        }
        for(int i=l;i<=r;i++) {
            swap(nums, l, i);
            permutate(nums, ans, l+1, r);
            swap(nums, l, i);
        }
    }
    
    public void swap(int[] nums, int l, int i) {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;      
    }
    
    public void addToList(int[] nums, List<List<Integer>> ans) {
        List<Integer> a = new ArrayList<>();        
        for(int num: nums) {
            a.add(num);
        }        
        ans.add(a);
    }
}
