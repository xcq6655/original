package com.xcq.original.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadImgColorUtil {

    @Autowired
    private static HttpServletResponse response;
    /**
     * 读取一张图片的RGB值
     *
     * @throws Exception
     */
    public static List<HashMap<Integer,List<Integer>>> getImagePixel(String image) throws Exception {
        int[] rgb = new int[3];
        File file = new File(image);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        //System.out.println("width=" + width + ",height=" + height + ".");
       // System.out.println("minx=" + minx + ",miniy=" + miny + ".");
        //List<ImgColorRGb> colorRGbList = new ArrayList<ImgColorRGb>();
        List<HashMap<Integer,List<Integer>>> list = new ArrayList<>();
        for (int i = miny; i < height; i++) {
            HashMap<Integer,List<Integer>> map = new HashMap<>();
            for (int j = minx; j < width; j++) {
                List<Integer> listRgb = new ArrayList<Integer>();
                int pixel = bi.getRGB(j, i); // 下面三行代码将一个数字转换为RGB数字
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")");
                listRgb.add(rgb[0]);
                listRgb.add(rgb[1]);
                listRgb.add(rgb[2]);
                map.put(j,listRgb);
            }
            System.out.println(map.toString());
            list.add(map);
            System.out.println("width: "+width +"    height:"+height +"     minx:"+minx+"     miny:"+miny);
            System.out.println("单元格行数："+i+"---- list长度 :"+list.size());
        }
            return list;
    }

    /**
     * 返回屏幕色彩值
     *
     * @param x
     * @param y
     * @return
     * @throws AWTException
     */
    public static int getScreenPixel(int x, int y) throws AWTException { // 函数返回值为颜色的RGB值。
        Robot rb = new Robot(); // java.awt.image包中的类，可以用来抓取屏幕，即截屏。
        Toolkit tk = Toolkit.getDefaultToolkit(); // 获取缺省工具包
        Dimension di = tk.getScreenSize(); // 屏幕尺寸规格
        System.out.println(di.width);
        System.out.println(di.height);
        Rectangle rec = new Rectangle(0, 0, di.width, di.height);
        BufferedImage bi = rb.createScreenCapture(rec);
        int pixelColor = bi.getRGB(x, y);

        return 16777216 + pixelColor; // pixelColor的值为负，经过实践得出：加上颜色最大值就是实际颜色值。
    }

    public static HSSFWorkbook exportImg(List<HashMap<Integer,List<Integer>>> list){
        //1.创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个sheet
        HSSFSheet sheet = workbook.createSheet("111");
        // =====================> 创建行 <===================== //
        for(int i=0;i<1;i++){
            HSSFRow row = sheet.createRow(i);
            for(int y=0;y<108;y++){
                System.out.println("第"+i+"行,第"+y+"个单元格，颜色为："+list.get(i).get(y).get(0)+" "+list.get(i).get(y).get(1)+" "+list.get(i).get(y).get(2));
                HSSFCell cell = row.createCell(y);
                HSSFCellStyle styleCell = workbook.createCellStyle();
                styleCell.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
                //styleCell.setFillBackgroundColor(new HSSFColor(new Color(list.get(i).get(y).get(0), list.get(i).get(y).get(1), list.get(i).get(y).get(2))));
                cell.setCellStyle(styleCell);
            }
        }
        return workbook;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        int x = 0;
        ReadImgColorUtil rc = new ReadImgColorUtil();
        x = rc.getScreenPixel(100, 345);
        System.out.println(x + " - ");
        List<HashMap<Integer,List<Integer>>> list = rc.getImagePixel("D:\\图片\\微信图片_郭淑红.jpg");
        HSSFWorkbook wb =  rc.exportImg(list);
        response.setContentType("application/vnd.ms-excel");
        //查询excle名称
        String title =  "郭姐照片" + ".xls";
        String fileName = new String(title.getBytes("UTF-8"), "ISO8859-1");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        OutputStream ouputStream = null;
        try {
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
