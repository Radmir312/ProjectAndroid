package com.example.myapplication.Objects;

public class BasketItem {
    private Product product;
    private int quantity;
    public BasketItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotalPrice(){
        return product.getPrice() * quantity;
    }
}
