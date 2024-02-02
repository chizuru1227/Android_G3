package com.goprot.ih4c_mobile;

public class RecycleData {
    private int id;
    private  String gakka;
    private  String bunya;


    public RecycleData( int id,String gakka, String bunya) {
        this.gakka = gakka;
        this.bunya = bunya;
        this.id = id;
    }

    @Override
    public String toString() {
        return "RecycleData{" +
                "gakka='" + gakka + '\'' +
                ", bunya='" + bunya + '\'' +
                ", id=" + id +
                '}';
    }

    public String getGakka() {
        return gakka;
    }

    public void setGakka(String gakka) {
        this.gakka = gakka;
    }

    public String getBunya() {
        return bunya;
    }

    public void setBunya(String bunya) {
        this.bunya = bunya;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
