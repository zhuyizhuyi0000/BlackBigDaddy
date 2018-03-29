package abctest;

public class stdent {
	private String name;
	private int age;
	private int score;
	
	public void setName(String name){
		this.name=name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public void setScore(int score){
		this.score=score;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public int getScore(){
		return score;
	}
	public String say(){
		return getName()+getAge()+getScore();
	}
}
