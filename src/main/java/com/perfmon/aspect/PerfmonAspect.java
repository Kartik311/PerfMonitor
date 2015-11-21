package com.perfmon.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.perfmon.annotation.Perfmon;

@Aspect
public class PerfmonAspect {
	
	@Around(" @annotation(perfmon)")
	public Object recordperf(ProceedingJoinPoint pjp, Perfmon perfmon) throws Throwable{
		System.out.println("Annotation called");
		Object o = pjp.proceed();
		System.out.println("joint point finished");
		return o;
	}
}
