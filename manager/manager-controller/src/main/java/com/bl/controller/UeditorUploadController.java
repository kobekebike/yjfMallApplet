package com.bl.controller;

import com.alibaba.fastjson.JSONObject;
import com.bl.constants.Constant;
import com.bl.utils.FileUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 图片上传
 */
@Controller
@RequestMapping("/ueditorUploadController")
public class UeditorUploadController {

    private static final Logger log = LoggerFactory.getLogger(UeditorUploadController.class);

    @RequestMapping("uploadUEditorImage.do")
    public void uploadUEditorImage(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value = "upfile", required = false) MultipartFile[] files){
        try{
            if (files != null && files.length > 0) {
                String yjfHome = System.getProperty("yjf_home");
                if(StringUtils.isBlank(yjfHome)){
                    yjfHome = Constant.YJF_HOME;
                }
                List<String> list = new ArrayList<String>();
                JSONObject json=new JSONObject();
                PrintWriter out = response.getWriter();
                for (int i = 0; i < files.length; i++) {
                    MultipartFile file = files[i];
                    // 判断文件是否为空
                    if (!file.isEmpty()) {
                        try {
                            if(FileUtil.isImageByNameSuffix(file)){
                                json.put("state", "上传的不是图片");
                                out.print(json.toString());
                                return;
                            }

                            String random = String.valueOf((int)((Math.random() * 9 + 1) * 100000));
                            String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + random;
                            //根据当前年月生成图片存放路径
                            String filePathExample = "/ueditor/" + new SimpleDateFormat("yyyy/MM").format(new Date()) + "/";
                            String filePath = filePathExample + fileName + "." + file.getOriginalFilename().split("\\.")[1];
                            File saveDir = new File(yjfHome + filePath);
                            if (!saveDir.getParentFile().exists()){
                                saveDir.getParentFile().mkdirs();
                            }
                            // 转存文件
                            file.transferTo(saveDir);

                            if(FileUtil.isImageByType(saveDir)){
                                json.put("state", "上传的不是图片");
                                out.print(json.toString());
                                return;
                            }

                            request.setCharacterEncoding("utf-8");
                            response.setCharacterEncoding("utf-8");
                            try {
                                //返回UEditor的json格式的字符串
                                json.put("state", "SUCCESS");
                                json.put("title", file.getName());
                                json.put("url", filePath);
                                json.put("original", file.getName());
                                out.print(json.toString());
                            } catch (Exception e) {
                                log.error(e.getMessage(), e);
                                json.put("state", "上传图片出错");
                                out.print(json.toString());
                            }
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                            try{
                                if(list != null && list.size() > 0){
                                    for(int j = 0; j < list.size(); j++){
                                        FileUtil.deleteFile(yjfHome + list.get(j));
                                    }
                                }
                            }catch(Exception ex){
                                log.error(ex.getMessage(), ex);
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        }catch(Exception e){
            log.error(e.getMessage(), e);
        }
    }
}
