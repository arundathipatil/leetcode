import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *  Input: [1,1,2]
	Output:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]
 * 
 * @author Arundathi Patil
 *
 */
public class UniquePermutationWithDuplicates {
	public List<List<Integer>> permuteUnique(int[] nums) {
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
        Set<Integer> set = new HashSet<>();
        for(int i=l;i<=r;i++) {
           if(!set.add(nums[i]))continue;
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
