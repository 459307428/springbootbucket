package com.liuawei.spirng.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("fileupload")
public class FileUploadController {

	@PostMapping("/image")
	public String uploadImage(@RequestParam MultipartFile file) throws IOException{
		String contentType = file.getContentType();
		if (contentType.equals(MediaType.IMAGE_JPEG_VALUE)
				||contentType.equals(MediaType.IMAGE_PNG_VALUE)) {
			InputStream is= file.getInputStream();
			byte[] data = new byte[2048];
			FileOutputStream fis = new FileOutputStream(
					new File("D:\\liuawei\\springbootbucket\\resources\\upload"+file.getName()));
			if((is.read(data)!=-1)){
				fis.write(data);
			}
			fis.flush();
			fis.close();
			is.close();
		}else {
			return "error";
		}
		return "success";
	}
	
}
