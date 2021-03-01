package com.majorProject.techbazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.majorProject.techbazaar.daos.ProductDaosImpl;
import com.majorProject.techbazaar.daos.ReportDaosImpl;

@Controller
public class ReportController {
	
	@RequestMapping(value="/report",method=RequestMethod.GET)
	public String report(ModelMap modelMap)
	{
		ReportDaosImpl pr = new ReportDaosImpl();
		modelMap.put("listProducts", pr.findAll());
		return "report";
		
	}

}
