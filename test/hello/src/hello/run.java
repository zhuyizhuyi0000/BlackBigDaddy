package hello;

public class run {
	public static void main(String args[]){
		Runtime run = Runtime.getRuntime();
		try{
			run.exec("");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
