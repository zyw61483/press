package org.evr.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class FileUtil {
	
	private static final String imgType =".jpg.jpeg.png.gif";
	private static final String videoType =".mp4";
	private static final String audioType =".mp3";
	private static final int BUFFER_SIZE = 16 * 1024;
	public static final SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat yms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static  final DecimalFormat df2  = new DecimalFormat("###.00");
	private static int width; 
	private static int height;
	
	public static Map<String,Object> saveFile(File file,String fileName,String filedName,String validateType){
		//校验文件
		Map<String, Object> temp = null;
		if(validateType.equals("video")){
			temp = isValidateVideo(file,fileName);
		}else if(validateType.equals("audio")){
			temp = isValidateAudio(file,fileName);
		}
		//创建文件名并初始文件夹
//		String tempFileName = createFileName(filedName);
		String tempFileName = fileName;
		if ((Boolean) temp.get("flag")) {
			Map<String,Object> map = new HashMap<String, Object>();
			InputStream in;
			OutputStream out;
			try {
				in = new BufferedInputStream(new FileInputStream(file));
				out = new BufferedOutputStream(new FileOutputStream(new File(ServletActionContext.getServletContext().getRealPath("/admin/ifiles/"+filedName) + "/" + tempFileName)));
				byte [] buffer = new byte [BUFFER_SIZE];
				int len;
				while ((len = in.read(buffer)) != -1 )  {
					//System.out.println(len);
	                out.write(buffer,0,len);
	            }
				out.flush();
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
				map.put("flag", false);
				map.put("errorMsg", e.getMessage());
				return map;
			}
			map.put("fileName", tempFileName);
			map.put("flag", true);
			return map;
		}else{
			return temp;
		}
	}
	
	public static Map<String,Object> saveImg(File img,String fileName,String filedName){
		//校验是否是图片，图片是否为空
		Map<String, Object> temp = isValidateImg(img,fileName);
		//创建文件名并初始文件夹
		createFileName(filedName);
		String tempImgName = fileName;
		if ((Boolean) temp.get("flag") && img !=null) {
			Map<String,Object> map = new HashMap<String, Object>();
			InputStream in;
			FileOutputStream out;
			try {
				in = new BufferedInputStream(new FileInputStream(img), BUFFER_SIZE);
				out = new FileOutputStream(new File(ServletActionContext.getServletContext().getRealPath("/admin/ifiles/"+filedName) + "/" + tempImgName));
				if(temp.get("type").toString().indexOf("png") >= 0 || temp.get("type").toString().indexOf("PNG") >= 0){
					byte [] buffer = new byte [BUFFER_SIZE];
					while (in.read(buffer) > 0 )  {
		                out.write(buffer);
		            }
					in.close();
				}
				else
				{
					Image image = ImageIO.read(in);
					initImgSize(image);
					BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
					tag.getGraphics().drawImage(image.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null); 
					JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
					encoder.encode(tag);
				}
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
				map.put("flag", false);
				map.put("errorMsg", e.getMessage());
				return map;
			}
			map.put("imgName", tempImgName);
			map.put("flag", true);
			return map;
		}else{
			return temp;
		}
	}

	private static String createFileName(String filedName) {
		File file =new File(ServletActionContext.getServletContext().getRealPath("/admin/ifiles/"+filedName));    
		//如果文件夹不存在则创建    
		if  (!file.exists()  && !file .isDirectory()){       
		    file .mkdir();    
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return format.format(new Date());
	}

	private static Map<String,Object> isValidateImg(File img,String fileName) {
		Map<String,Object> map = new HashMap<String, Object>();
		Boolean flag = true;
		String type = null;
		if(img==null){
			//flag = false;
			map.put("errorMsg", "图片不存在！");
		}else{
			type = fileName.substring(fileName.indexOf("."));
			if(imgType.indexOf(type)==-1){
				flag = false;
				map.put("errorMsg", "图片格式："+imgType);
			}
		}
		map.put("flag", flag);
		map.put("type", type);
		return map;
	}
	
	private static Map<String,Object> isValidateVideo(File video,String fileName) {
		Map<String,Object> map = new HashMap<String, Object>();
		Boolean flag = true;
		String type = null;
		if(video==null){
			flag = false;
			map.put("errorMsg", "视频不存在！");
		}else{
			type = fileName.substring(fileName.indexOf("."));
			if(videoType.indexOf(type)==-1){
				flag = false;
				map.put("errorMsg", "视频格式："+videoType);
			}
		}
		map.put("flag", flag);
		map.put("type", type);
		return map;
	}
	private static Map<String,Object> isValidateAudio(File video,String fileName) {
		Map<String,Object> map = new HashMap<String, Object>();
		Boolean flag = true;
		String type = null;
		if(video==null){
			flag = false;
			map.put("errorMsg", "音频不存在！");
		}else{
			type = fileName.substring(fileName.indexOf("."));
			if(audioType.indexOf(type)==-1){
				flag = false;
				map.put("errorMsg", "频格式："+audioType);
			}
		}
		map.put("flag", flag);
		map.put("type", type);
		return map;
	}
	
	private static void initImgSize(Image img){
		width = img.getWidth(null);
		height = img.getHeight(null);
		if(width/4 > height/3)
		{
			if(width > 1000)
			{
				height  = height*1000/width;
				width = 1000;
			}
		}else{
			if(height > 750)
			{
				width  = width*750/height;
				height = 750;
			}
		}
	}

	public static void delFile(String file) {
		if(file!=null){
			File temp =new File(ServletActionContext.getServletContext().getRealPath(file)); 
			if(temp.exists()){
				temp.delete();
			}
		}
	}
}
