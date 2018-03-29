package abctest;

import java.io.File;

public class zidonghuaceshijilei {
	public static void main(String args[]){
		File direcory = new File("");
		String path="";
		try{
			path=direcory.getAbsolutePath();//返回此抽象路径名的绝对路径名字符串
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(path);//jieguo/Users/yizhu/Downloads/wahaha/hello
	}
	//加载所有jars  rootpath+bin+lib下   
}
