package com.bl.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileUtil {

    /**
     * 删除单个文件
     *
     * @param filePath 被删除文件的路径+文件名
     */
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }

    /**
     * 读取下载的文件
     *      判断是否是图片
     *      不是则
     *          删除文件
     * @param file
     * @return
     */
    public static boolean isImageByType(File file) {
        boolean flag = false;
        try {
            BufferedImage image = ImageIO.read(file);
            if (image == null) {
                // 不合法，将磁盘上的文件删除
                file.delete();
                flag = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 判断文件的后缀名
     * @param file
     * @return
     */
    public static boolean isImageByNameSuffix(MultipartFile file) {
        //获取图片名
        String oldFileName = file.getOriginalFilename();

        //截取图片后缀
        String suff = oldFileName.substring(oldFileName.lastIndexOf("."));

        //判断是否是图片
        if (!(suff.matches(".(jpg||gif||png||jpeg)"))) {   //不是个图片
            return true;
        }else{
            return false;
        }
    }
}
