package com.majorProject.techbazaar.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	
	public static String Today(){
		
		Date date = new Date();
		SimpleDateFormat formatDate=new SimpleDateFormat("yyyy/MM/dd");
		String formateddate=formatDate.format(date).toString();
		System.out.println(formateddate);
		return formateddate;
	}

}
