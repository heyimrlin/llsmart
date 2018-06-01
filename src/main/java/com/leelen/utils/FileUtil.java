/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月24日下午4:35:25
 * @包名:com.leelen.utils
 * @描述:TODO
 */
package com.leelen.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author xiaoxl
 *
 */
public class FileUtil {

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
