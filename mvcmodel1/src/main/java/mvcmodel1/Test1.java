package mvcmodel1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

/** 
* @author 作者 yetianjiao 
* @version 2017年3月29日 下午3:59:53 
* 类说明 
*/

public class Test1{
	private Log logger=LogFactory.getLog(Test1.class);
	
	public static void main(String[] args) {
		Test1 x=new Test1();
		x.test();
	}
	void test(){
		logger.info("test log success!");
	}
}
