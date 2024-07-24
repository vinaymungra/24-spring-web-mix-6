package com.service;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileUploadService {
	public void uploadProductImage(MultipartFile masterImage,String path)
	{
//		System.out.println(masterImage.getOriginalFilename());
		
		try {
				byte b[]= masterImage.getBytes();
				File file =new  File(path,masterImage.getOriginalFilename());
				FileUtils.writeByteArrayToFile(file, b);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
