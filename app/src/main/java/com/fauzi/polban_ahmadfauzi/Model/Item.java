package com.fauzi.polban_ahmadfauzi.Model;

public class Item {
    int id;
    String nama_item;
    String desc_item;

    public Item(String id,String nama_item,String desc_item){
    this.id = Integer.parseInt(id);
    this.nama_item = nama_item;
    this.desc_item = desc_item;
    }

    public int getId() {
        return id;
    }

    public String getNama_item() {
        return nama_item;
    }

    public String getDesc_item() {
        return desc_item;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setDesc_item(String desc_item) {
        this.desc_item = desc_item;
    }

    public void setNama_item(String nama_item) {
        this.nama_item = nama_item;
    }


}
