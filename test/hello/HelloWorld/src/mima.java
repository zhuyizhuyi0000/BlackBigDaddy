
public class mima {
public static void main(String args[])
{
	int i,min,max,j=0,k=0;
	int a[]={5,6,2,23,43,5,34,55};
	min=max=a[0];
	for(i=0;i<a.length;i++)
	{
		if(a[i]>max)
		{	max=a[i];
		    j=i;}
		if(a[i]<min)
		{  	min=a[i];
			k=i;
			}
	}
	System.out.print("max="+max+",maxth="+(j+1)+",min="+min+",minth="+(k+1));
}
}
