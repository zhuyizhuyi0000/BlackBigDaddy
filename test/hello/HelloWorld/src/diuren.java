
public class diuren {
	public static void main(String args[])
	{
		int sum=1000;
		int sh=5;
		int a[]=new int[sum];
		int o=0;
		int d=0;
		boolean c=true;
		for(int i=0;i<=sum-1;i++)
			a[i]=1;
		while(c)
		{
			for(int i=0;i<=sum-1;i++)
				{
				o=o+a[i];
				if(o==sh)
					{
					a[i]=0;
//					System.out.print(i+1+",");
					d++;
					if(sh-1==sum-d)
					{
						c=false;
						break;
					}
					o=0;
					}
				}
		}
		for(int i=0;i<=sum-1;i++)
			if(a[i]==1)
			System.out.println(i+1);
	}
}
