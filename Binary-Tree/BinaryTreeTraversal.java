import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		
//		TreeNode el15 = new TreeNode(15, null, null);
//		TreeNode el17 = new TreeNode(17, null, null);
//		TreeNode el20 = new TreeNode(20, el15, el17);
//		TreeNode el9 = new TreeNode(9, null, null);
//		TreeNode root = new TreeNode(3, el9, el20);
		
		TreeNode el4 = new TreeNode(4, null, null);
		TreeNode el2r = new TreeNode(1, el4, null);
		TreeNode el2l = new TreeNode(1, null, null);
		TreeNode el2 = new TreeNode(2, el2l, el2r);
		TreeNode root = new TreeNode(1, null, el2);
		
//		System.out.println(BinaryTreeTraversal.computingLevelsOfBinaryTree(root, 0, 0));
//		BinaryTreeTraversal.levelOrderUsingQueue(root);
//		List<List<Integer>> ans = new ArrayList<>();
//		BinaryTreeTraversal.levelOrderUsingList(el3, root, 0);
//		BinaryTreeTraversal.bottomUpLevelOrder(ans, root, 0);

//		 List<Double> sum = new ArrayList<>();
//	     List<Integer> count = new ArrayList<>();
//	        
//	     averageAtEachLevel(root, sum, count, 0);
//	        
//	     for(int i=0;i<sum.size()-1;i++){
//	        sum.set(i, sum.get(i)/count.get(i));
//	     }
	     
//	     BinaryTreeTraversal.levelOrderTraversal(root);
//	     
//	     List<Integer> ans1 = new ArrayList<>();
//	     BinaryTreeTraversal.rightSideView(root, 0, ans1);
	     
	     List<Integer> temp = new ArrayList<>();
	     int longestPath = 0;
	     longestPath = BinaryTreeTraversal.largestDistinctPath(root);
	}	

	
	
	
	
	
	// Finding longest distinct path using hasmap
	public static int largestDistinctPath(TreeNode node) 
    { 
        if (node == null) 
            return 0; 
    
        HashMap<Integer, 
            Integer> hash = new HashMap<Integer, 
                                        Integer>(); 
    
        return findDistinctPath1(node, hash); 
    } 
    
    public static int findDistinctPath1(TreeNode T, HashMap<Integer, 
                                                    Integer> temp) {
        if(T == null) {
            return temp.size();
        }
        if(temp.containsKey(T.val)) 
        { 
        	return temp.size();
//            temp.put(T.val, temp.get(T.val) + 1); 
        } 
        else
        { 
            temp.put(T.val, 1); 
        }
        
        int max_path = Math.max(findDistinctPath1(T.left, temp), 
                            findDistinctPath1(T.right, temp));
        
        if(temp.containsKey(T.val)) 
        { 
            temp.put(T.val, temp.get(T.val) - 1); 
        } 
        
        if (temp.get(T.val) == 0) 
        temp.remove(T.val); 
        
  
        return max_path;
    }
	
	/**
	 * Input [3,9,20,null,null,15,17]
	 * Output 2
	 * @param root
	 * @param level
	 * @param curLevel
	 * @return
	 */
	public static int computingLevelsOfBinaryTree(TreeNode root, int level, int curLevel) {
		if(root == null) {
			return -1;
		}		
		if(level > curLevel) {
			curLevel = level;
		}
		int a= computingLevelsOfBinaryTree(root.left, level+1, curLevel);
		curLevel = a > curLevel? a : curLevel; 
		a = computingLevelsOfBinaryTree(root.right, level+1, curLevel);
		curLevel = a > curLevel? a : curLevel;
		return curLevel;
	}

	/**
	 * Input [3,9,20,null,null,15,17]
	 * output [3,9,20,15,17]
	 * @param root
	 */
	public static void levelOrderUsingQueue(TreeNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		while(!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			System.out.print(cur.val + " ");
			if(cur.left!=null) queue.add(cur.left);
			if(cur.right!=null)queue.add(cur.right);
		}
	}	
	
	
	public static void levelOrderTraversal(TreeNode root) {
		int h = getHeightOfTree(root);
		
		for(int i =1 ; i<= h; i++) {
			printNodeAtGivenLevel(root, i);
		}
	}
	
	public static int getHeightOfTree(TreeNode root) {
		if(root == null){
			return 0;
		}
		int lH = getHeightOfTree(root.left);
		int rH = getHeightOfTree(root.right);
		
		if(lH > rH) return lH+1;
		else return rH+1;
	}
	
	public static void printNodeAtGivenLevel(TreeNode cur, int level) {
		if(cur == null) {
			return;
		}
		if(level == 1) {
			System.out.print(cur.val + " ");
		}
		printNodeAtGivenLevel(cur.left, level-1);
		printNodeAtGivenLevel(cur.right, level-1);
	}
	
	public static void rightSideView(TreeNode cur, int level, List<Integer> ans) {
		if(cur == null) {
			return;
		}
		if(ans.size() == level) {
			ans.add(level, -1);
		}		
		ans.set(level, cur.val);
		rightSideView(cur.left, level+1, ans);
		rightSideView(cur.right, level+1, ans);
	}
	
	/**
	 * Input [3,9,20,null,null,15,17]
	 * output [[3],
	 * 		   [9,20],
	 * 		   [15,17]
	 * 		  ]
	 * @param root
	 * @param ans
	 * @param level
	 */
	public static void levelOrderUsingList(TreeNode root, List<List<Integer>> ans, int level) {
		if(root == null) {
			return;
		}
		if(ans.size() == level) {
			ans.add(new ArrayList<>());
		}
		
		 (ans.get(level)).add(root.val);
		 levelOrderUsingList(root.left, ans, level+1);
		 levelOrderUsingList(root.right, ans, level+1);
	}
	
	/**
	 * Input : [3,9,20,null,null,15,7]
	 * output: [
				  [15,7],
				  [9,20],
				  [3]
				]
	 */
	public static void bottomUpLevelOrder(List<List<Integer>> ans,TreeNode curr,int level) {
		 if(curr==null) return;
	        
	        if(ans.size()==level) 
	            ans.add(0,new ArrayList<Integer>());
	        
	        ans.get(ans.size()-level-1).add(curr.val);
	        
	        bottomUpLevelOrder(ans,curr.left,level+1);
	        bottomUpLevelOrder(ans,curr.right,level+1);
	}
	
	public static void averageAtEachLevel(TreeNode cur, List<Double> sum, List<Integer> count, int level) {
		 if(cur == null){
	            return;
	        }
	        if(sum.size() == level) {
	            sum.add(level, 0.0);
	            count.add(level, 0);
	        }
	        sum.set(level,cur.val + sum.get(level));
	        count.set(level, count.get(level)+1);
	        
	        averageAtEachLevel(cur.left, sum, count, level+1);
	        averageAtEachLevel(cur.right, sum, count, level+1);
	}
}

/**
Definition for a binary tree node. */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }