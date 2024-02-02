package com.goprot.ih4c_mobile;


public class RecycleHistory {
    private int id;
    private String seikai;
    private String hazure;
    private int rankImgDrawable;

    public RecycleHistory(int id,String seikai,String hazure,int rankImgDrawable){
        this.id =id;
        this.seikai =seikai;
        this.hazure =hazure;
        this.rankImgDrawable =rankImgDrawable;

    }


    @Override
    public String toString() {
        return "RecycleHistory{" +
                "id=" + id +
                ", seikai='" + seikai + '\'' +
                ", hazure='" + hazure + '\'' +
                ", rankImgDrawable=" + rankImgDrawable +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeikai() {
        return seikai;
    }

    public void setSeikai(String seikai) {
        this.seikai = seikai;
    }

    public String getHazure() {
        return hazure;
    }

    public void setHazure(String hazure) {
        this.hazure = hazure;
    }

    public int getRankImgDrawable() {
        return rankImgDrawable;
    }

    public void setRankImgDrawable(int rankImgDrawable) {
        this.rankImgDrawable = rankImgDrawable;
    }



}