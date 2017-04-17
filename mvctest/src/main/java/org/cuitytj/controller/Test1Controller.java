package org.cuitytj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/** 
* @author 作者 yetianjiao 
* @version 2017年4月7日 上午11:17:57 
* 最原始的controller写法
*/
public class Test1Controller implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("");
		
		return null;
	}

}
