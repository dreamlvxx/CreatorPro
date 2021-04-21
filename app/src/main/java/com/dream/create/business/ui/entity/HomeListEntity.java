package com.dream.create.business.ui.entity;

import java.util.ArrayList;
import java.util.List;

public class HomeListEntity {
    private List<Item> data;

    public HomeListEntity() {
        data = new ArrayList<>();
    }

    public List<Item> getData() {
        return data;
    }

    public void setData(List<Item> data) {
        this.data = data;
    }

    public void addItem(Item msg){
        this.data.add(msg);
    }

    public void addAllItem(List<Item> dataAll){
        this.data.addAll(dataAll);
    }

    public static class Item{
        public String name;

        public Item(String name) {
            this.name = name;
        }
    }

}
