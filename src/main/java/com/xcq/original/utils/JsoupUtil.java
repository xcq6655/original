package com.xcq.original.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class JsoupUtil {

    //资源所在的网页地址
    //private static String resourceURL = "http://www.csdn.net/";
    //private static String resourceURL = "http://www.fengniao.com/";
    private static String resourceURL = "https://www.taobao.com/";


    //资源下载之后，保存在本地的文件路径
    private static String downloadFilePath = "D://downloadImage//";

    /**
     *
     * 根据图片的外网地址下载图片到本地硬盘的filePath
     * @param filePath 本地保存图片的文件路径
     * @param imgUrl 图片的外网地址
     * @throws UnsupportedEncodingException
     *
     */
    public static void downImages(String filePath,String imgUrl) throws UnsupportedEncodingException {

        //图片url中的前面部分：例如"http://images.csdn.net/"
        String beforeUrl = imgUrl.substring(0,imgUrl.lastIndexOf("/")+1);
        //图片url中的后面部分：例如“20150529/PP6A7429_副本1.jpg”
        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/")+1);
        //编码之后的fileName，空格会变成字符"+"
        String newFileName = URLEncoder.encode(fileName, "UTF-8");
        //把编码之后的fileName中的字符"+"，替换为UTF-8中的空格表示："%20"
        newFileName = newFileName.replaceAll("\\+", "\\%20");
        //编码之后的url
        imgUrl = beforeUrl + newFileName;

        try {
            //创建文件目录
            File files = new File(filePath);
            if (!files.exists()) {
                files.mkdirs();
            }
            //获取下载地址
            URL url = new URL(imgUrl);
            //链接网络地址
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //获取链接的输出流
            InputStream is = connection.getInputStream();
            //创建文件，fileName为编码之前的文件名
            File file = new File(filePath + fileName);
            //根据输入流写入文件
            FileOutputStream out = new FileOutputStream(file);
            int i = 0;
            while((i = is.read()) != -1){
                out.write(i);
            }
            out.close();
            is.close();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("图片写入磁盘发生异常，相关图片： "+imgUrl);
        }
    }

    public static void main(String[] args) {

        //从一个网站获取和解析一个HTML文档，jsoup的API中有此方法的说明
        Document document = null;
        try {
            document = Jsoup.connect(resourceURL).get();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("解析HTML文档发生异常，异常信息 ： "+e.getMessage());
        }
        //System.out.println(document);
        //获取所有的img标签
        Elements elements = document.getElementsByTag("img");
        List<String> imgList = new ArrayList<>();
        for(Element element : elements){
            //获取每个img标签的src属性的内容，即图片地址，加"abs:"表示绝对路径
            String imgSrc = element.attr("abs:src");
            //如果该地址不是以jpg，png结尾的，默认不是图片
            if(StringUtils.endsWithIgnoreCase(imgSrc,".jpg") || StringUtils.endsWithIgnoreCase(imgSrc,".png")){
                imgList.add(imgSrc);
                //下载图片文件到电脑的本地硬盘上
                System.out.println("正在下载图片：-----------" + imgSrc);
                try {
                    downImages(downloadFilePath, imgSrc);
                } catch (UnsupportedEncodingException e) {
                    //e.printStackTrace();
                    System.out.println("下载图片发生异常，相关图片：-----------" + imgSrc);
                }
                System.out.println("图片下载完毕：-----------" + imgSrc);
                System.out.println("-------------------------------------------------------------------------------------------------------------");
            }
        }
        System.out.println("共下载了 " + imgList.size() +" 个文件(不去重)");
    }

}
