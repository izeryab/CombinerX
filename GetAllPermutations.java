import java.util.*;   
  
public class GetAllPermutations {  
//  
//    public static void main(String args[]) {  
//        int[] numbers = {1, 2, 3, 4};  
//        List<int[]> combinationx = new ArrayList<>();
//       combinations(2, numbers, combinationx,2);
//        
//        for (int[] combination : combinationx) {
//            System.out.println("x"+Arrays.toString(combination));
//        }
//    }  
   
    public static String GET(int pairOf, int[] numbers,int maxCount) {
    	String s="";
        List<int[]> combinationx = new ArrayList<>();
       combinations(pairOf, numbers, combinationx,maxCount);
        
        for (int[] combination : combinationx) {
            s+=Arrays.toString(combination)+"\n";
        }
        return s;
    }  

    public static List<int[]> combinations(int n, int[] arr, List<int[]> list,int maxcount) {
        // Calculate the number of arrays we should create
        int numArrays = (int)Math.pow(arr.length, n);
        // Create each array
        for(int i = 0; i < numArrays; i++) {
            list.add(new int[n]);
        }
        // Fill up the arrays
        for(int j = 0; j < n; j++) {
            // This is the period with which this position changes, i.e.
            // a period of 5 means the value changes every 5th array
            int period = (int) Math.pow(arr.length, n - j - 1);
            for(int i = 0; i < numArrays; i++) {
                int[] current = list.get(i);
                // Get the correct item and set it
                int index = i / period % arr.length;
                current[j] = arr[index];
            }
        }
        
       return removeDubler(list, maxcount);
    }
    
    public static  List<int[]>  removeDubler( List<int[]> list,int maxcount) {
    	ArrayList<int[]> indextoRemove=new ArrayList<>();
    	for (int[] is : list) {
			if(maxcount(is)>maxcount) {
				indextoRemove.add(is);
			}
		}
    	System.out.println(list.size());
    	for (int[] integer : indextoRemove) {
    		System.out.println(Arrays.toString(integer));
			list.remove(integer);
		
		}
    	System.out.println(list.size());
    	return list;
    }
  
    private static int maxcount(int[] array) {
    	int count=0;
    	int maxcount=0;
    	for (int i = 0; i < array.length; i++) {
    		count=0;
			for (int j = 0; j < array.length; j++) {
				if(array[i]==array[j]) {
					count++;
				}
			}
			if(count>=maxcount) {
				maxcount=count;
			}
		}
    	return maxcount;
    }
} 