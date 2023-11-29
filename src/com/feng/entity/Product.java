package com.feng.entity;
/*
定义商品实体类
 */
public class Product {
    private  int PRODUCT_ID;//商品id
    private String PRODUCT_NAME;//商品名称
    private String PRODUCT_DESCRIPTION;//商品描述
    private  int PRODUCT_PRICE;//商品价格
    private  int PRODUCT_STOCK;//商品库存
    private String PRODUCT_FILENAME;//商品图片地址

    public Product() {
    }

    public Product(int PRODUCT_ID, String PRODUCT_NAME, String PRODUCT_DESCRIPTION, int PRODUCT_PRICE, int PRODUCT_STOCK, String PRODUCT_FILENAME) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
        this.PRODUCT_PRICE = PRODUCT_PRICE;
        this.PRODUCT_STOCK = PRODUCT_STOCK;
        this.PRODUCT_FILENAME = PRODUCT_FILENAME;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }

    public void setPRODUCT_DESCRIPTION(String PRODUCT_DESCRIPTION) {
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
    }

    public int getPRODUCT_PRICE() {
        return PRODUCT_PRICE;
    }

    public void setPRODUCT_PRICE(int PRODUCT_PRICE) {
        this.PRODUCT_PRICE = PRODUCT_PRICE;
    }

    public int getPRODUCT_STOCK() {
        return PRODUCT_STOCK;
    }

    public void setPRODUCT_STOCK(int PRODUCT_STOCK) {
        this.PRODUCT_STOCK = PRODUCT_STOCK;
    }

    public String getPRODUCT_FILENAME() {
        return PRODUCT_FILENAME;
    }

    public void setPRODUCT_FILENAME(String PRODUCT_FILENAME) {
        this.PRODUCT_FILENAME = PRODUCT_FILENAME;
    }
}
