/**
  * ITNES Project
  * Copyright 2019 itnes.co.kr
  */
package com.mc.miraclecat.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public class FileUtil {
	
	/**
	 * <pre>
	 * 설명 : 첨부파일 등록
	 * 	입력받은 map에 첨부된 파일 리스트를 넣어서 return
	 * return 값 {fileName:저장된 파일이름, oriFileName:원본 파일이름, fileExt:확장자, fileSize:파일 사이즈}
	 * </pre>
	 * @Method Name : mapAddFileList
	 * @param map
	 * @param request
	 * @param multiRequest
	 * @throws Exception
	 */ 	
	public static void mapAddFileList(HashMap<String, Object> map, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
		
		// 프로퍼티로 파일 물리적 경로 추출
		final String ROOT_PATH = PropertiesUtil.getProperty("filePath");
		final String FULL_PATH = ROOT_PATH+(String)map.get("upFolder");
		
		String newFileName = null ,ext = "";
		
        int thumbnail_width = 1000; //썸네일 가로사이즈
        int thumbnail_height =1333; //썸네일 세로사이즈
		
    	//multiple 파일 업로드
		List<MultipartFile> files = multiRequest.getFiles("upFile");
		List<Object> fileList = new ArrayList<Object>();
		HashMap<String, Object> fileMap = new HashMap<String, Object>();
		
		if (null != files && files.size() > 0) {
			
			long curr = System.currentTimeMillis();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
			String datetime = dateFormat.format(new Date(curr));
			int i = 0;
			for (MultipartFile multipartFile : files) {
				
				String fileName = multipartFile.getOriginalFilename();
				String rFileName = "";
				byte[] fileSize = multipartFile.getBytes();
				int byteToInt = fileSize.length;
				
				if(!"".equals(fileName)) {
			        int index = fileName.lastIndexOf(".");
			        if (index != -1) {
			            ext  = fileName.substring(index + 1);
			            newFileName = datetime+"_"+(i+1)+"_"+fileName;
			        }

			        fileMap = new HashMap<String, Object>();
			        
					File file = new File(FULL_PATH+newFileName);
					file = rename(file);
					rFileName = file.getName();
					multipartFile.transferTo(file);
					
					fileMap.put("fileName", rFileName);
					fileMap.put("oriFileName", fileName);
					fileMap.put("fileExt",ext);
					fileMap.put("fileSize",byteToInt);
					
					// map list 담기
					fileList.add(fileMap);
					
		            if("jpg".equals(ext) || "bmp".equals(ext) || "png".equals(ext)) {
		               JpegReader jpegReader = new JpegReader();  //cmyk 형식 read
	                   BufferedImage buffer_original_image = jpegReader.readImage(file); //ImageIO.read(origin_file_name);
	                   BufferedImage buffer_thumbnail_image = new BufferedImage(thumbnail_width, thumbnail_height, BufferedImage.TYPE_3BYTE_BGR);
	                   Graphics2D graphic = buffer_thumbnail_image.createGraphics();
	                   graphic.drawImage(buffer_original_image, 0, 0, thumbnail_width, thumbnail_height, null);
	                   ImageIO.write(buffer_thumbnail_image, "jpg", file);
		            }
				}
				
				 i++;
			}
			
			
			// list map 담기
			map.put("fileList", fileList);
		}
		
	}
	
	public static String fileUpload(HttpServletRequest request, MultipartHttpServletRequest multiRequest, HashMap<String,Object> map) throws Exception{
		
		final String ROOT_PATH = PropertiesUtil.getProperty("filePath");
		final String FULL_PATH = ROOT_PATH+(String)map.get("upFolder");
		
		String newFileName = null ,ext = "";
		
        int thumbnail_width = 1000; //썸네일 가로사이즈
        int thumbnail_height =1333; //썸네일 세로사이즈
		
    	//multiple 파일 업로드
		List<MultipartFile> files = multiRequest.getFiles("upFile");
		List<String> fileNames = new ArrayList<String>();
		List<String> strList = new ArrayList<String>();
		
		if (null != files && files.size() > 0) {
			long curr = System.currentTimeMillis();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
			String datetime = dateFormat.format(new Date(curr));
			int i = 0;
			for (MultipartFile multipartFile : files) {
				String fileName = multipartFile.getOriginalFilename();
				String rFileName = "";
				if(!"".equals(fileName)) {
			        int index = fileName.lastIndexOf(".");
			        if (index != -1) {
			            ext  = fileName.substring(index + 1);
			            newFileName = datetime+"_"+(i+1)+"_"+fileName;
			        }

					File file = new File(FULL_PATH+newFileName);
					file = rename(file);
					rFileName = file.getName();
					strList.add(rFileName);
					multipartFile.transferTo(file);
					fileNames.add(rFileName);
					
		            if("jpg".equals(ext) || "bmp".equals(ext) || "png".equals(ext)) {
		               JpegReader jpegReader = new JpegReader();  //cmyk 형식 read
	                   BufferedImage buffer_original_image = jpegReader.readImage(file); //ImageIO.read(origin_file_name);
	                   BufferedImage buffer_thumbnail_image = new BufferedImage(thumbnail_width, thumbnail_height, BufferedImage.TYPE_3BYTE_BGR);
	                   Graphics2D graphic = buffer_thumbnail_image.createGraphics();
	                   graphic.drawImage(buffer_original_image, 0, 0, thumbnail_width, thumbnail_height, null);
	                   ImageIO.write(buffer_thumbnail_image, "jpg", file);
		            }
		            
		            i++;
				}
			}
		}
		String fileList = StringUtils.join(strList, ",");
		
		return fileList;
	}
	
	/* 파일명 중복체크 중복파일명뒤에 숫자를 붙여준다 */
	  public static File rename(File f) {             //File f는 원본 파일
		    if (createNewFile(f)) return f;        //생성된 f가 중복되지 않으면 리턴
		     
		    String name = f.getName();
		    String body = null;
		    String ext = null;
		 
		    int dot = name.lastIndexOf(".");
		    if (dot != -1) {                              //확장자가 없을때
		      body = name.substring(0, dot);
		      ext = name.substring(dot);
		    } else {                                     //확장자가 있을때
		      body = name;
		      ext = "";
		    }
		 
		    int count = 0;
		    //중복된 파일이 있을때
		    //파일이름뒤에 a숫자.확장자 이렇게 들어가게 되는데 숫자는 9999까지 된다.
		    while (!createNewFile(f) && count < 9999) { 
		      count++;
		      String newName = body +"_"+ count + ext;
		      f = new File(f.getParent(), newName);
		    }
		    return f;
		  }
		 
	  private static boolean createNewFile(File f) {
	    try {
	      return f.createNewFile();                        //존재하는 파일이 아니면
	    }catch (IOException ignored) {
	      return false;
	    }
	  }
	  
		 /**
	     * 압축
	     * @param sourceFile
	     * @param sourcePath
	     * @param zos
	     * @throws Exception
	     */
	    private static void zipEntry(File sourceFile, String sourcePath, ZipOutputStream zos) throws Exception {
	    	String file ="",
	    			ext = "";
	        // sourceFile 이 디렉토리인 경우 하위 파일 리스트 가져와 재귀호출
	        if (sourceFile.isDirectory()) {

	            if (sourceFile.getName().equalsIgnoreCase(".metadata")) { // .metadata 디렉토리 return
	                return;
	            }
	            File[] fileArray = sourceFile.listFiles(); // sourceFile 의 하위 파일 리스트
	            for (int i = 0; i < fileArray.length; i++) {
	                file = fileArray[i].getName();
	                int index = file.indexOf(".");
	                if (index != -1) {
	                    ext  = file.substring(index + 1);
	                }
	                
	                if(!"zip".equals(ext)) {
	                	zipEntry(fileArray[i], sourcePath, zos); // 재귀 호출
	                }
	            }
	        } else { // sourcehFile 이 디렉토리가 아닌 경우

	            BufferedInputStream bis = null;
	            try {
	                String sFilePath = sourceFile.getPath();
	                System.out.println("zipEntry: sFilePath : "+sFilePath);
	                String zipEntryName = sFilePath.substring(sourcePath.length() - 1, sFilePath.length());
	                System.out.println("zipEntry: zipEntryName : "+zipEntryName);

	                bis = new BufferedInputStream(new FileInputStream(sourceFile));
	                ZipEntry zentry = new ZipEntry(zipEntryName);

	                zentry.setTime(sourceFile.lastModified());
	                zos.putNextEntry(zentry);

	                byte[] buffer = new byte[8];
	                int cnt = 0;
	                while ((cnt = bis.read(buffer, 0, 8)) != -1) {
	                    zos.write(buffer, 0, cnt);
	                }
	                zos.closeEntry();
	            } finally {
	                if (bis != null) {
	                    bis.close();
	                }
	            }
	        }
	    }

	    /**
	     * 지정된 폴더를 Zip 파일로 압축한다.
	     * @param sourcePath - 압축 대상 디렉토리
	     * @param output - 저장 zip 파일 이름
	     * @throws Exception
	     */
	    public static void makeZip(String sourcePath, String output) throws Exception {

	        // 압축 대상(sourcePath)이 디렉토리나 파일이 아니면 리턴한다.
	        File sourceFile = new File(sourcePath);
	        
	        System.out.println("makeZip: sourcePath : "+sourcePath);
	        System.out.println("makeZip: output : "+output);
	        
	        if (!sourceFile.isFile() && !sourceFile.isDirectory()) {
	        	System.out.println("makeZip: 압축 대상의 파일을 찾을 수가 없습니다.");
	            throw new Exception("makeZip: 압축 대상의 파일을 찾을 수가 없습니다.");
	        }

	        //output = output+".zip"; // 일부러 확장자 넣어줌
	        // output 의 확장자가 zip이 아니면 리턴한다.
	        //if (!(StringUtils.substringAfterLast(output, ".")).equalsIgnoreCase("zip")) {
	        //    throw new Exception("압축 후 저장 파일명의 확장자를 확인하세요");
	        //}

	        FileOutputStream fos = null;
	        BufferedOutputStream bos = null;
	        ZipOutputStream zos = null;

	        try {
	            fos = new FileOutputStream(sourcePath+output); // FileOutputStream
	            bos = new BufferedOutputStream(fos); // BufferedStream
	            zos = new ZipOutputStream(bos); // ZipOutputStream
	            zos.setLevel(4); // 압축 레벨 - 최대 압축률은 9, 디폴트 8
	            zipEntry(sourceFile, sourcePath, zos); // Zip 파일 생성
	            zos.finish(); // ZipOutputStream finish
	            
	        } catch (Exception e) {
	        	System.out.println("Exception="+e);
	        } finally {
	            if (zos != null) {
	                zos.close();
	            }
	            if (bos != null) {
	                bos.close();
	            }
	            if (fos != null) {
	                fos.close();
	            }
	        }
	    }
	    
	    /**
	     * 첨부파일을 다운로드 한다.
	     * @param sourcePath - 파일 path
	     * @param fileNm - 파일이름
	     * @throws Exception
	     */
	    public static int download(String sourcePath, String fileNm, HttpServletResponse response) throws Exception {
	    	
	    	int ret = 1;
	   		String downloadPath = sourcePath + fileNm;
	   		File downloadFile = new File(downloadPath);		
	   		
	   	    byte fileByte[] = FileUtils.readFileToByteArray(downloadFile);
	   	     
	   	    response.setContentType("application/octet-stream");
	   	    response.setContentLength(fileByte.length);
	   	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileNm, "UTF-8")+"\";");
	   	    response.setHeader("Content-Transfer-Encoding", "binary");
	   	    response.getOutputStream().write(fileByte);
	   	    response.getOutputStream().flush();
	   	    response.getOutputStream().close();
	   	    
	   	 return ret;
	    }
	    
	    /**
	     * 첨부파일 용량계산
	     * @param size - filesize
	     * @throws Exception
	     */
	    public static String getFileSize(String size)
	    {
	        String gubn[] = {"Byte", "KB", "MB" } ;
	        String returnSize = new String ();
	        int gubnKey = 0;
	        double changeSize = 0;
	        long fileSize = 0;
	        try{
	          fileSize =  Long.parseLong(size);
	          for( int x=0 ; (fileSize / (double)1024 ) >0 ; x++, fileSize/= (double) 1024 ){
	            gubnKey = x;
	            changeSize = fileSize;
	          }
	          returnSize = changeSize + gubn[gubnKey];
	        }catch ( Exception ex){ returnSize = "0.0 Byte"; }

	        return returnSize;
	    }

}
