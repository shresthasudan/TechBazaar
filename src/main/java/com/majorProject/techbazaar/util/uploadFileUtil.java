package com.majorProject.techbazaar.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class uploadFileUtil {
	
	private static final String ABS_PATH="D:\\Boardway\\java2\\TechBazaarV1\\src\\main\\webapp\\resources\\images\\";
	//private static String REAL_PATH="";

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// TODO Auto-generated method stub
		//REAL_PATH=request.getSession().getServletContext().getRealPath("assets/images/");
		if(!new File(ABS_PATH).exists()){
			new File(ABS_PATH).mkdirs();
		}
//		if(!new File(REAL_PATH).exists()){
//			new File(REAL_PATH).mkdirs();
//		}
		try {
			//file.transferTo(new File(REAL_PATH+code+".jpg"));
			file.transferTo(new File(ABS_PATH+code+".jpg"));
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
