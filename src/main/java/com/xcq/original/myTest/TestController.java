package com.xcq.original.myTest;

import com.xcq.original.utils.ReadImgColorUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {

    @PostMapping(value = "/imgToExcel")
    public void imgToExcel(HttpServletResponse response) {
        int x = 0;
        try {
            x = ReadImgColorUtil.getScreenPixel(100, 345);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        System.out.println(x + " - ");
        List<HashMap<Integer,List<Integer>>> list = null;
        try {
            list = ReadImgColorUtil.getImagePixel("D:\\picture\\20180618135740.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HSSFWorkbook wb =  ReadImgColorUtil.exportImg(list);

//        try {
////            response.setCharacterEncoding("utf-8");
////            response.setContentType("application/msdownload");
////            //response.setHeader("Content-Disposition", "attachment;filename=111" + ".xlsx");
////            response.setHeader("Content-Disposition", "attachment;filename=111.xlsx");
////            OutputStream out = new FileOutputStream(file);
////            wb.write(response.getOutputStream());
////            response.getOutputStream().close();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
    String fileName = "111.xlsx";
    response.reset();

    // ContentType 可以不设置
    response.setContentType("application/vnd.ms-excel;charset=UTF-8");
    response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        try {
            wb.write(response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
