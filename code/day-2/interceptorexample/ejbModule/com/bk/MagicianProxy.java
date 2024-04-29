package com.bk;

public class MagicianProxy extends Magician{
	
	private Audiance audiance=new Audiance();
	
	public void doMagic() {
		audiance.clapping();
		System.out.println("doing magic");
	}
}
