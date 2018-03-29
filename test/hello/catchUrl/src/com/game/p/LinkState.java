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
		return "�����ƣ�"+this.name+"������:"+this.link+"���򿪷�ʽ��"+this.tar+";�㼶���ͣ�"+this.level+";���Ը�����"+this.father_link+"��";
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
	//equals hashCode  �ж��ഴ���Ķ����ǲ���һ��   ��������һ������ַ
	//������ͨ��Object���е�hashCode()��equals()��������֤�ظ���
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
