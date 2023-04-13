package com.example.lovelychecker;

import java.util.Map;

public class Product {
    private String id;
    private String title;
    private Double fromPrice;
    private Double toPrice;
    private Map<String, Object> characteristics;

    public Product(String id, String title, Double fromPrice, Double toPrice, Map<String, Object> characteristics) {
        this.id = id;
        this.title = title;
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
        this.characteristics = characteristics;
    }

    public Product(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getFromPrice() {
        return fromPrice;
    }

    public void setFromPrice(Double fromPrice) {
        this.fromPrice = fromPrice;
    }

    public Double getToPrice() {
        return toPrice;
    }

    public void setToPrice(Double toPrice) {
        this.toPrice = toPrice;
    }

    public Map<String, Object> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<String, Object> characteristics) {
        this.characteristics = characteristics;
    }
}
