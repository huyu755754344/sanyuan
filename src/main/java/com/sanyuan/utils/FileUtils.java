package com.sanyuan.utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	public final static String URL = "//三元.hunlian.art";
	public final static String DIR = "/usr/local/docker/sanyuan/webapp";
	
	/**
	 * 删除图片
	 * @param fileName
	 * @return
	 */
	public static boolean deleteFile(String fileName) {
        File file = new File(getFileName(fileName));
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                //System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                //System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            //System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
	
	public static String getFileName(String url) {
		String[] str = url.split(URL);
		if(str.length>1) {
			return DIR+str[1];
		}
		return DIR+url;
	}
	
	/**
	 * 本地上传图片
	 * @param file
	 * @param url
	 * @return
	 */
	public static String addFile(MultipartFile file,String url) {
		try {
			//处理上传文件
			String oldFileName = file.getOriginalFilename();  
			//文件后缀  
			String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));  
			//文件重命名  
			//时间(毫秒数)+随机数+_blog+suffix  
			//1970-1-1~今天   System.currentTimeMillis();  
			String newFileName = System.currentTimeMillis()+new Random().nextInt(1000000)+suffix;  
			//上传文件 java.io.File
			//url提交路径(服务器)  
			File targetFile = new File(DIR+url,newFileName); 
			file.transferTo(targetFile);
			return newFileName;
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	/*public static void main(String[] args) {
		System.out.println(getFileName("/towardstheisland"));
		System.out.println(getFileName("//www.towardstheisland.com/towardstheisland"));
		
	}
	*/
}
