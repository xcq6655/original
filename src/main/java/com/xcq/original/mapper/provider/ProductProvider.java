package com.xcq.original.mapper.provider;

public class ProductProvider {

    public String queryProductInfo(){
        StringBuilder sb = new StringBuilder("SELECT * FROM `t_product` t");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
