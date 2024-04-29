package com.demo;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
@Other
public  class MyAlgoImplemantionTwo implements MyAlgo{

	@Override
	public String calculation() {
		return "MyAlgoImplemantionTwo";
	}

}
