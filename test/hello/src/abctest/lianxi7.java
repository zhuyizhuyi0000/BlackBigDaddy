package abctest;

public class lianxi7 {
	public static void main(String args[]){
		int[] num={1,2,3,4,5};
		
		
	}
	public int searchInsert(int[] nums, int target) {
		int go=nums.length;
		for(int i=0;i<nums.length;i++){123.207.137.22
			if(target==nums[i]){
				go=i;
				break;
			}else if(target<nums[i]){
				go=i;
				break;
			}
		}
        return go;
    }	
}
