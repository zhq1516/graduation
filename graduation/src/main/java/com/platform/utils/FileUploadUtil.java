package com.platform.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * @description:文件上传工具类
 * @author: Air
 * @date: 2019-03-03 16:56
 */
public class FileUploadUtil {

    /**
     *
     * @param request
     * @param storePath 文件存储相对路径 ,例如："/upload","/image","/local/file"
     * @return
     */
    public static String tranferFile(HttpServletRequest request, String storePath){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //先判断request中是否包涵multipart类型的数据，
        if(multipartResolver.isMultipart(request)){
            //再将request中的数据转化成multipart类型的数据
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                MultipartFile file = multiRequest.getFile((String)iter.next());
                if(file != null){
                    String originalFileName = file.getOriginalFilename();
                    String path =request.getSession().getServletContext().getRealPath(storePath);
                    // 得到存储到本地的文件名
                    String localFileName= UUID.randomUUID().toString()+getFileSuffix(originalFileName);
                    // 新建本地文件
                    File localFile = new File(path,localFileName);
                    // 创建目录
                    File fileDir=new File(path);
                    if (!fileDir.isDirectory()) {
                        // 如果目录不存在，则创建目录
                        fileDir.mkdirs();
                    }
                    String src=storePath+"/"+localFileName;
                    //写文件到本地
                    try {
                        file.transferTo(localFile);
                        return src;
                    } catch (IllegalStateException | IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /**
     *
     * @param files
     * @param storePath
     * @return
     */
    public static String uploadFile(List<MultipartFile> files,String storePath){
        StringBuilder result = new StringBuilder();
        if(files != null && files.size() > 0){
            for(MultipartFile file : files){
                if(file != null){
                    String originalFileName = file.getOriginalFilename();
                    String path = "C:\\Users\\Air\\MY_WORK_SPACE\\staticResource\\" + storePath;
                    // 得到存储到本地的文件名
                    String localFileName= UUIDUtil.getUUID2() + getFileSuffix(originalFileName);
                    result.append(storePath + "/" + localFileName + ",");
                    // 新建本地文件
                    File localFile = new File(path,localFileName);
                    // 创建目录
                    File fileDir = new File(path);
                    if (!fileDir.isDirectory()) {
                        // 如果目录不存在，则创建目录
                        fileDir.mkdirs();
                    }
                    //写文件到本地
                    try {
                        file.transferTo(localFile);
                    } catch (IllegalStateException | IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            result.deleteCharAt(result.length()-1);
        }
        return result.toString();
    }

    /**
     * 获取文件后缀
     * @param originalFileName
     * @return
     */
    private static String getFileSuffix(String originalFileName){
        int dot = originalFileName.lastIndexOf('.');
        if((dot > -1)&&(dot < originalFileName.length())){
            return originalFileName.substring(dot);
        }
        return originalFileName;
    }
}
