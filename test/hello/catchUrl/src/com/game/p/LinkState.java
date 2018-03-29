package com.game.p;

public class LinkState implements Comparable<LinkState>{
	private String link;
	private String name;
	private String tar;
	private String father_link;
	private int level;
	
	public LinkState(String link,String name,String tar,String father_link,int level)
	{
	this.link =link;
	this.name =name;
	this.tar =tar;
	this.level=level;
	this.father_link=father_link;
	}
	
	@Override
	public String toString()
	{
		return "《名称："+this.name+"；链接:"+this.link+"；打开方式："+this.tar+";层级类型："+this.level+";来自父链："+this.father_link+"》";
	}
	
	public int compareTo(LinkState o) {
		if(this.level >o.level){
			return 1;
		}else if (this.level<o.level){
			return -1;
		}else{
		return this.link.compareTo(o.link);
		}
	}
	//equals hashCode  判断类创建的对象是不是一样   创建两个一样》地址
	//程序中通过Object类中的hashCode()和equals()方法来验证重复类
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(!(obj instanceof LinkState)){
			return false;
		}
		LinkState p =(LinkState) obj;
		if(this.link.equals(p.link)){
			return true;
		}else{
		return false;
		}
	}

	@Override
	public int hashCode() {
		return this.link.hashCode();
	}

	public String getlink()
	{
		return link;
	}
	public String getname()
	{
		return name;
	}
	public String gettar()
	{
		return tar;
	}
	public int getlevel()
	{
		return level;
	}
	public String father_link()
	{
		return father_link;
	}
}
