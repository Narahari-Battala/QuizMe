package com.telusko;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.service.AddService;


@Controller
public class AddController {

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("firstname") int i, HttpServletRequest request,@RequestParam("lastname")int j, HttpServletResponse response){
		
		
/*		int i = Integer.parseInt(request.getParameter("firstname"));
		int j = Integer.parseInt(request.getParameter("lastname"));*/
		
		AddService as = new AddService();
		int k = as.add(i, j);
		//int k = i+j;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",k);
		//return "display.jsp";
		return mv;
	}
	
}
