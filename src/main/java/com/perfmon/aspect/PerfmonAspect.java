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
import com.perfmon.util.PerfmonConstants;

@Aspect
public class PerfmonAspect {
	private static Logger logger = LoggerFactory.getLogger(PerfmonAspect.class);
	
	@Around(" @annotation(perfmon)")
	public Object recordperf(ProceedingJoinPoint pjp, Perfmon perfmon) throws Throwable{
		StopWatch clock = new StopWatch();		
		MethodSignature methodSign = (MethodSignature) pjp.getSignature();
		
		String targetMethodName = StringUtils.equals(perfmon.markerName(), PerfmonConstants.defaultString) 
				? methodSign.getMethod().getName() : perfmon.markerName();
		try{
			clock.start();
			logger.info("logger called for method: {} and meta-data: {}", targetMethodName, perfmon.metaData());
			Object o = pjp.proceed();
			return o;
		} finally{
			clock.stop();
			logger.info("{} took a total of {} miliseconds",targetMethodName, clock.getTotalTimeMillis());
		}
	}
}
