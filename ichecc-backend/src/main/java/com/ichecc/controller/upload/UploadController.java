package com.ichecc.controller.upload;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.ichecc.ao.common.DfsAO;

import ng.bayue.fastdfs.ImageUrlUtil;

@Controller
@RequestMapping(value = {"/uploadImg"})
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Value("#{meta['dfs.uploadTempPath']}")
	private String uploadTempPath;
//	@Value("${item.picture.MaxSize}")
	@Value("#{meta['item.picture.MaxSize']}")
	private int itemPictureMaxSize;
	
	@Value("${dfs.group1.host}")
	private String host;
	
	@Autowired
	private DfsAO dfsAO;
	
	@Autowired
	private ImageUrlUtil imageUrlUtil;
	
	/**
	 * <pre>
	 * 上传商品主图片
	 * </pre>
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = {"/img/item"}, method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String itemImgUpload(HttpServletRequest request){
		String savePath = request.getSession().getServletContext().getRealPath(uploadTempPath);
		if(StringUtils.isEmpty(savePath)){
			logger.info("图片临时上传到本地时获取路径错误!");
			return null;
		}
		
		String dfsPath = null;
//		private String filePathTest = "http://pic.58pic.com/58pic/12/01/93/79w58PICF4p.jpg";
//		String dfsPath = filePathTest;
		String fileName = null;
		JSONObject obj = new JSONObject();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String,MultipartFile> map = multipartRequest.getFileMap();
		for(Map.Entry<String, MultipartFile> entry:map.entrySet()){
			MultipartFile mf = entry.getValue();
			fileName = mf.getOriginalFilename();
			int size = (int) mf.getSize();
			if(size > itemPictureMaxSize){
				obj.put("success", 0);
				obj.put("code", "F_EXCEED_SIZE_LIMIT");
				obj.put("msg", "文件大小超过限制！");
				logger.error("文件大小超过限制！");
				return obj.toJSONString();
			}
			obj.put("fileName", fileName);
			if (fileName.lastIndexOf(".") >= 0){
				fileName = UUID.randomUUID().toString() + "." + 
						fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
			}
			
			File file = new File(savePath, fileName);
			if(!file.exists()){
				Boolean b = file.mkdirs();
				if(!b) {
					logger.error("创建文件失败"+fileName);
				}
			}
			try {
				mf.transferTo(file);
				dfsPath =  dfsAO.uploadFile(file);
			} catch (IllegalStateException | IOException e1) {
				fileName = null;
				logger.info("文件上传时保存出错:{}",e1);
			} finally {
				FileUtils.deleteQuietly(file);
			}
			
		}
		
		if(StringUtils.isBlank(dfsPath)){
			obj.put("type", "error");
			obj.put("errorCode", "uploadError");
			obj.put("success", 0);
			obj.put("code", "SERVER_INNER_ERROR");
			obj.put("msg", "服务器错误,上传失败!");
			logger.error("服务器错误,上传失败!");
		}else{
			obj.put("path", dfsPath);
//			obj.put("path", imageUrlUtil.getFileFullUrl(dfsPath));
			obj.put("key",dfsPath);
			obj.put("type", "success");
			obj.put("success", 1);
		}
		return obj.toJSONString();
		
	}
	
	/**
	 * <pre>
	 * 上传商品详情描述页图片
	 * </pre>
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/uploadItemEditor",method=RequestMethod.POST, produces ="text/html;charset=UTF-8")
	@ResponseBody
	public JSONObject uploadItemEditor(HttpServletRequest request){
		String savePath = request.getSession().getServletContext().getRealPath(uploadTempPath);
		if(StringUtils.isBlank(savePath)){
			logger.error("图片上传路径配置错误");
			return null;
		}
		//dfs返回的路径
		String dfsPath = null;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		//上传文件名称
		String fileName = null;
		for(Map.Entry<String, MultipartFile> entity : fileMap.entrySet()){
			MultipartFile mf = entity.getValue();
			if(mf.getSize() > itemPictureMaxSize ){
				JSONObject json = new JSONObject();
				Long size=itemPictureMaxSize/1024L;
				json.put("message", "上传图片最大:".concat(size.toString().concat("Kb")));
//				return json.toJSONString();
				return json;
			}
			fileName = mf.getOriginalFilename();
			if (fileName.lastIndexOf(".") >= 0){
				fileName = UUID.randomUUID().toString() + "." + 
						fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
			}
			File file = new File(savePath, fileName);
			if(!file.exists()){
				Boolean b = file.mkdirs();
				if(!b) {
					logger.error("创建文件失败"+fileName);
				}
			}
			try{
				mf.transferTo(file);
				dfsPath =  dfsAO.uploadFile(file);
			}catch(IOException e){
				fileName = null;
				logger.error("文件上传时保存出错！");
			}finally{
				FileUtils.deleteQuietly(file);
			}
		}
		JSONObject json = new JSONObject();
		json.put("error", 0);
		json.put("url",imageUrlUtil.getFileFullUrl(dfsPath));
//		json.put("url", "C:\\Users\\Public\\Pictures\\Sample Pictures\\tx4.jpg");
//		json.put("url", "http://pic56.nipic.com/file/20141227/19674963_215052431000_2.jpg");
//		return json.toJSONString();
		return json;
	}

}