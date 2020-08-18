import java.util.HashMap;
import java.util.Map;

public class CheckIfNAndItsDoubleExist {
	
	public static boolean checkIfExist(int[] arr) {
		if(arr == null) {
            return false;
        }
        
        Map<String, String> arrHash = new HashMap<String, String>();
        
        for(int i=0 ; i<arr.length;i++) {
            Integer num = arr[i];
            String temp = num.toString();
            arrHash.put(temp, temp);
        }
        
        int nums = 0;
        for(int i=0 ; i<arr.length;i++) {
            if(arr[i]%2 == 0 ) {
                if(arr[i] == 0 ) {
                    nums++;
                    if(nums > 1) { 
                        return true;
                    }
                   
                } else {
                    Integer num = arr[i]/2;
                    String temp = num.toString();
                    if(arrHash.containsKey(temp) && arrHash.get(temp).equals(temp)) {
                        return true;
                    } 
                }
            }
        }
        
        return false;
        
    }

}
