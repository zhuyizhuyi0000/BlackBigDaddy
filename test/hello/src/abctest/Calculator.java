package abctest;

public class Calculator {
	private static int result;  //静态变量，用于存储运行结果
	public void add(int n){
		result = result + n;
	}
	public void substract(int n){
		result =result -1;   //bug：应该是-n
	}
	public void multiply(int n){
		//方法没写
	}
	public void divide(int n){
		result =result/n;
	}
	public void square(int n){
		result = n*n;
	}
	public void squareRoot(int n){
		for(;;);//死循环
	}
	public void clear(){
		result=0; //结果清0
	}
	public int getResult(){
		return result;
	}
}
