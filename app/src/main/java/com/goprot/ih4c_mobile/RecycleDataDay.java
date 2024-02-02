package com.goprot.ih4c_mobile;

public class RecycleDataDay {
    private int id;
    private  String day;
    private  String total;


    public RecycleDataDay(int id, String day, String total) {
        this.day = day;
        this.total = total;
        this.id = id;
    }

    @Override
    public String toString() {
        return "RecycleData{" +
                "day='" + day + '\'' +
                ", total='" + total + '\'' +
                ", id=" + id +
                '}';
    }

    public String getday() {
        return day;
    }

    public void setday(String day) {
        this.day = day;
    }

    public String gettotal() {
        return total;
    }

    public void settotal(String total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
