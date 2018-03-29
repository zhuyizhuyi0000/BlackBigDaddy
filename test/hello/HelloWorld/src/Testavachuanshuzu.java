
public class Testavachuanshuzu {
	public static void main(String args[])
	{
		int score[]={23,2,34,53,3,22,1};
		large(score);
	}
	public static void large(int arr[])
	{
		int temp=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(temp<arr[i])
				temp =arr[i];
		}
		System.out.print(temp);
	}
}
