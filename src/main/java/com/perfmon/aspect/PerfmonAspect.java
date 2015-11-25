package com.perfmon.aspect;


import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import com.perfmon.annotation.Perfmon;

@Aspect
public class PerfmonAspect {
	private static Logger logger = LoggerFactory.getLogger(PerfmonAspect.class);
	@Around(" @annotation(perfmon)")
	public Object recordperf(ProceedingJoinPoint pjp, Perfmon perfmon) throws Throwable{
		StopWatch clock = new StopWatch();
		MethodSignature methodSign = (MethodSignature) pjp.getSignature();
		String targetMethodName = StringUtils.isNotEmpty(perfmon.methodMarkerName()) ? perfmon.methodMarkerName() : methodSign.getMethod().getName();
		try{
			clock.start();
			logger.info("logger called for method: {}", targetMethodName);
			Object o = pjp.proceed();
			System.out.println("joint point finished");
			return o;
		} finally{
			clock.stop();
			logger.info("{} took a total of {} miliseconds",targetMethodName, clock.getTotalTimeMillis());
		}
	}
}
