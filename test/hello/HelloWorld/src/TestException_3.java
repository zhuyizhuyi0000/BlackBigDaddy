
public class TestException_3 {
	public static void main(String args[])
	{
		try
		{
			int arr[]=new int[7];
			arr[18]=8;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("���鳬���󶨷�Χ��");
			System.out.println("�쳣��"+e);
		}
		finally
		{
			System.out.println("����!");
		}
		System.out.println("main()����������");
	}
}
