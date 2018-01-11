package com.umpay.autotest;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.umpay.autotest.dataprovider.TestDemoDataProvider;

/**
 * ***********************************************************************
 * description : 我们通过这个抽象类定义基本的测试规则
 * <br>
 * 在这个Demo中，我们针对接口及测试，定义的测试流程分为：
 * <ol>
 * <li>测试数据的准备（我们将通过外部获取测试数据，将测试数据和测试逻辑分开）
 * <li>组装请求报文（我们将用RestFull接口形式发送报文）
 * <li>测试用例执行
 * <li>验证测试结果
 * <li>
 * </ol>
 * @author      <a href="mailto:zhangming@umpay.com">Thomas Zhang</a>
 * @date        2018年1月11日 下午8:55:33
 * @version     1.0             
 ************************************************************************
 */
public abstract class AbstractBaseTest {
	
	/**
	 * 用例请求数据
	 */
	public Object reqParams;
	/**
	 * 请求测试的地址
	 */
	public String _URL = "";//https://trade.zb.com/api/
	/**
	 * <br>description 加载数据：
	 * 初始化基础测试数据，基础数据的原则，每个接口都需要并且这些字段都是可以动态生成的 ，与用例结果无关
	 * <li>包括但不限于：通常为每个用例都一致的信息
	 * @throws Exception
	 * @author      <a href="mailto:zhangming@umfintech.com">Thomas Zhang</a>
	 * @version     1.0
	 * @date        2018年1月11日下午9:02:16
	 */
	@BeforeMethod
	public void setUp() throws Exception {
		reqParams=new HashMap<String, String>();
	}

	/**
	 * <br>description 卸载数据：
	 * 初始化基础测试数据，基础数据的原则，每个接口都需要并且这些字段都是可以动态生成的 ，与用例结果无关
	 * <li>包括但不限于：通常为每个用例都一致的信息
	 * @throws Exception
	 * @author      <a href="mailto:zhangming@umfintech.com">Thomas Zhang</a>
	 * @version     1.0
	 * @date        2018年1月11日下午9:02:25
	 */
	@AfterMethod
	public void tearDown() throws Exception {
		//TODO
	}
	
	/**
	 * description : 组装请求报文（我们将用RestFull接口形式发送报文）
	 * 将从数据库取得的数据封装成请求的报文，放到 {@link #reqParams}中
	 * @param params 从{@link TestDemoDataProvider }获取的测试数据
	 * @throws Exception
	 * @author      <a href="mailto:zhangming@umfintech.com">Thomas Zhang</a>
	 * @version     1.0
	 * @date        2018年1月11日下午9:23:39
	 */
	protected void assembleData(Object[] params) throws Exception{
		_URL=(String) params[2];
		//TODO 添加数据封装
	}

	/**
	 * description:这里我们设置了单个用例的超时时间为2秒，通过外部{@link TestDemoDataProvider }获取测试数据
	 * @param params
	 * <ol>
	 * <li>预期结果
	 * <li>输入数据
	 * <li>请求地址
	 * <li>环境参数
	 * <li>提示说明，用于描述该数据覆盖的测试点，也是报错时方便定位问题的信息
	 * </ol>
	 * @throws Exception
	 * @author      <a href="mailto:zhangming@umfintech.com">Thomas Zhang</a>
	 * @version     1.0
	 * @date        2018年1月11日下午9:05:34
	 */
	@Test(timeOut=2000,dataProvider="dataProvider_req",dataProviderClass=TestDemoDataProvider.class)
	public void testUseCase(Object[] params) throws Exception {
		assembleData(params);
		String result = getJsonPost(reqParams);
		resultAssert(params[0],result);

	}
	
	/**
	 * description : 获取json内容(统一加密)
	 * @param params
	 * @return
	 * @author      <a href="mailto:zhangming@umfintech.com">Thomas Zhang</a>
	 * @version     1.0
	 * @date        2018年1月11日下午9:30:38
	 */
	public abstract String getJsonPost(Object reqParams);

	/**
	 * description : 结果验证
	 * @param object
	 * @param result
	 * @author      <a href="mailto:zhangming@umfintech.com">Thomas Zhang</a>
	 * @version     1.0
	 * @date        2018年1月11日下午9:28:10
	 */
	public abstract void resultAssert(Object object, String result);
}
