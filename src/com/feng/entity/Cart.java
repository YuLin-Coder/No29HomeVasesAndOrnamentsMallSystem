package com.feng.entity;

/**
 * 定义一个购物车实体类
 */
public class Cart {
    private int cart_id;//购物车id
    private String cart_p_filename;//购物车中的商品图片地址
    private String cart_p_name;//购物车中的商品名称
    private int cart_p_price;//购物车商品价格
    private int cart_nums;//购物车商品数量
    private int cart_p_stock;//购物车商品库存
    private int cart_p_id;//购物车商品id
    private String cart_u_id;//购物车用户id
    private int cart_valid;//购物车状态判断

    public Cart() {
    }

    public Cart(int cart_id, String cart_p_filename, String cart_p_name, int cart_p_price, int cart_nums, int cart_p_stock, int cart_p_id, String cart_u_id, int cart_valid) {
        this.cart_id = cart_id;
        this.cart_p_filename = cart_p_filename;
        this.cart_p_name = cart_p_name;
        this.cart_p_price = cart_p_price;
        this.cart_nums = cart_nums;
        this.cart_p_stock = cart_p_stock;
        this.cart_p_id = cart_p_id;
        this.cart_u_id = cart_u_id;
        this.cart_valid = cart_valid;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public String getCart_p_filename() {
        return cart_p_filename;
    }

    public void setCart_p_filename(String cart_p_filename) {
        this.cart_p_filename = cart_p_filename;
    }

    public String getCart_p_name() {
        return cart_p_name;
    }

    public void setCart_p_name(String cart_p_name) {
        this.cart_p_name = cart_p_name;
    }

    public int getCart_p_price() {
        return cart_p_price;
    }

    public void setCart_p_price(int cart_p_price) {
        this.cart_p_price = cart_p_price;
    }

    public int getCart_nums() {
        return cart_nums;
    }

    public void setCart_nums(int cart_nums) {
        this.cart_nums = cart_nums;
    }

    public int getCart_p_stock() {
        return cart_p_stock;
    }

    public void setCart_p_stock(int cart_p_stock) {
        this.cart_p_stock = cart_p_stock;
    }

    public int getCart_p_id() {
        return cart_p_id;
    }

    public void setCart_p_id(int cart_p_id) {
        this.cart_p_id = cart_p_id;
    }

    public String getCart_u_id() {
        return cart_u_id;
    }

    public void setCart_u_id(String cart_u_id) {
        this.cart_u_id = cart_u_id;
    }

    public int getCart_valid() {
        return cart_valid;
    }

    public void setCart_valid(int cart_valid) {
        this.cart_valid = cart_valid;
    }
}
