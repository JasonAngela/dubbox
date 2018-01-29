/**
 * Copyright (c) 2005-2012 springside.org.cn
 */
package cn.bjd.platform.elastic.provider.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 关于异常的工具类.
 * @author calvin
 * @version 2013-01-15
 */
public final class Exceptions {

	/**
	 * 工具类应隐藏public构造器
	 */
	private Exceptions(){

	}


	/**
	 * 将CheckedException转换为UncheckedException.
	 * @param e
	 * @return RuntimeException
	 */
	public static RuntimeException unchecked(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}


	/**
	 * 将ErrorStack转化为String.
	 * @param e
	 * @return String
	 */
	public static String getStackTraceAsString(Throwable e) {
		if (e == null){
			return "";
		}
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}


	/**
	 * 判断异常是否由某些底层的异常引起.
	 * @param ex
	 * @param causeExceptionClasses
	 * @return boolean
	 */
	public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
		Throwable cause = ex.getCause();
		while (cause != null) {
			for (Class<? extends Exception> causeClass : causeExceptionClasses) {
				if (causeClass.isInstance(cause)) {
					return true;
				}
			}
			cause = cause.getCause();
		}
		return false;
	}

	/**
	 * 在request中获取异常类
	 * @param request
	 * @return  Throwable
	 */
	public static Throwable getThrowable(HttpServletRequest request){
		Throwable ex = null;
		if (request.getAttribute("exception") != null) {
			ex = (Throwable) request.getAttribute("exception");
		} else if (request.getAttribute("javax.servlet.error.exception") != null) {
			ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
		}
		return ex;
	}
	
}
