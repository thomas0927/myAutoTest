/*
 * file name   : BaseDataProvider.java 
 * <br>copyright   : Copyright (c) 2018
 * <br>description : TODO<何时使用>[注意][示例]
 * <br>modified    : 
 * @author      <a href="mailto:zhangming@umfintech.com">Thomas Zhang</a>
 * @version     1.0
 * @date        2018年1月11日 下午9:13:14
 */ 

package com.umpay.autotest.dataprovider;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

/*************************************************************************
 * description : 基础数据
 * @author      <a href="mailto:zhangming@umfintech.com">Thomas Zhang</a>
 * @date        2018年1月11日 下午9:13:14
 * @version     1.0             
 *************************************************************************/

public class BaseDataProvider {
	protected static AtomicInteger seq = new AtomicInteger();
	protected static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
	
	/**
	 * 测试用例中产生Trace
	 * 
	 * @return
	 */
	protected static  String genTrace() {
		return String.format("%s%04d", sdf.format(System.currentTimeMillis()), seq.incrementAndGet());
	}
	/**
	 * description : 生成测试订单号
	 * @return
	 * @author      Thomas Zhang
	 * @version     1.0
	 * @date        2015年8月21日上午11:56:31
	 */
	protected static String genOrderId() {
		return String.format("JD%s%04d", sdf.format(System.currentTimeMillis()), seq.incrementAndGet());
	}
}
