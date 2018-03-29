
public class maopao {
public static void main(String args[])
{
	int x,y,i;
	int a[]={12,2,343,45,3,2,24,545,6,54,34,45,5,66,21};
	
	for(y=a.length-1;y>0;y--)
	{
	for(x=0;x<a.length-1;x++)
	{
		if(a[x]>a[x+1])
		{
			a[x]=a[x]+a[x+1];
		    a[x+1]=a[x]-a[x+1];
		    a[x]=a[x]-a[x+1];
		}
		
	}
	}
	for(i=0;i<a.length;i++)
	System.out.println(a[i]);
}
}
