/**
 * 
 */
package com.perfmon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.perfmon.util.PerfmonConstants;

/**
 * @author Kartikeya
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Perfmon {
	String markerName() default PerfmonConstants.defaultString;
	String metaData() default PerfmonConstants.defaultMetaData;
}
