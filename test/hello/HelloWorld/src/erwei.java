
public class erwei {
public static void main(String args[])
{
	int i,j,sum=0;
	int num[][]={
			{2,3,4,5},
			{7,8,9,0}
			};
	for(i=0;i<num.length;i++)
		for(j=0;j<num[i].length;j++)
		{
			System.out.print(num[i][j]+" ");
			sum +=num[i][j];
		}
	System.out.print(sum);
}
}
