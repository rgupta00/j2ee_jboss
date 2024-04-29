package com.interceptorexample;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logger
@Interceptor
public class LoggingInterceptor {
	
	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {
		System.out.println("Before method invocation");
		try{
			return ctx.proceed();
		}
		finally{
			System.out.println("After method......");
		}
	}

}
