package com.game.p;

public class PageState implements Comparable<PageState>{
	private LinkState linkstate;
	private String title;
	private String state;

	
	public PageState(LinkState linkstate,String title,String state)
	{
	this.linkstate =linkstate;
	this.title =title;
	this.state =state;
	}
	
	@Override
	public String toString()
	{
		return this.linkstate+"；标题:"+this.title+"；状态："+this.state+"；";
	}
	
	public int compareTo(PageState o) 
	{
		return this.linkstate.compareTo(o.linkstate);
	}
	
	//equals hashCode  判断类创建的对象是不是一样   创建两个一样》地址
	//程序中通过Object类中的hashCode()和equals()方法来验证重复类
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(!(obj instanceof PageState)){
			return false;
		}
		PageState p =(PageState) obj;
		if(this.linkstate.equals(p.linkstate)){
			return true;
		}else{
		return false;
		}
	}

	@Override
	public int hashCode() {
		return this.linkstate.hashCode();
	}

	public LinkState getlinkstate()
	{
		return linkstate;
	}
	public String gettitle()
	{
		return title;
	}
	public String getstate()
	{
		return state;
	}
}
