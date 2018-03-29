
public class duowei {
public static void main(String args[])
{
	int i,j,k;
	int a[][][]={{{5,1},{2,6}}};
	for(i=0;i<a.length;i++)
		for(j=0;j<a[i].length;j++)
			for(k=0;k<a[i][j].length;k++)
			{
				System.out.print(a[i][j][k]+" ");
			}
}

}
	