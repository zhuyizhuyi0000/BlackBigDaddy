
public class Testjavafenerwei {
	public static void main(String args[])
	{
		int A[][]={{3,23,34,54,4},{2,323,3,1,3}};
		int B[][]=new int[2][5];
		B = add(A);
		for(int i=0;i<B.length;i++)
			{
			for(int j=0;j<B[i].length;j++)
				System.out.print(B[i][j]+" ");
		System.out.println();
		}
	}
	public static int[][] add(int s[][])
	{
		for(int i=0;i<s.length;i++)
			for(int j=0;j<s[i].length;j++)
				s[i][j]+=1;
		return s;
	}
}
