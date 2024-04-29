package com.demo;

import javax.enterprise.inject.Default;

@Default
public  class MyAlgoImplemantionOne implements MyAlgo{
	@Override
	public String calculation() {
		return "MyAlgoImplemantionOne";
	}

}
