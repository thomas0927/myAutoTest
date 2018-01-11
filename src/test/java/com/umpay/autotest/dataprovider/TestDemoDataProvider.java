/*
 * file name   : TestDemoDataProvider.java 
 * <br>copyright   : Copyright (c) 2018
 * <br>description : TODO<何时使用>[注意][示例]
 * <br>modified    : 
 * @author      <a href="mailto:zhangming@umfintech.com">Thomas Zhang</a>
 * @version     1.0
 * @date        2018年1月11日 下午9:15:25
 */ 

package com.umpay.autotest.dataprovider;

import org.testng.annotations.DataProvider;

/*************************************************************************
 * description : TODO
 * @author      <a href="mailto:zhangming@umfintech.com">Thomas Zhang</a>
 * @date        2018年1月11日 下午9:15:25
 * @version     1.0             
 *************************************************************************/

public class TestDemoDataProvider extends BaseDataProvider {

	/**
	 * description :
	 * <br>数据说明：数据分为三部分，并使用json串封装
	 * <ol>
	 * <li>预期结果
	 * <li>输入数据
	 * <li>请求地址
	 * <li>环境参数
	 * <li>提示说明，用于描述该数据覆盖的测试点，也是报错时方便定位问题的信息
	 * </ol>
	 * <li>
	 * @return
	 * @throws Exception
	 * @author Thomas Zhang
	 * @version 1.0
	 * @date 2015年8月10日下午4:08:41
	 */
	@DataProvider(name = "dataProvider_req")
	public static Object[][] reqData() throws Exception {
		//RS to object
		return new Object[][] {
			new Object[] {new Object[] { "{rule}","{input}","{url}","{environment params}","我的第一个自动化测试Demo" }},
		};
	}
}
