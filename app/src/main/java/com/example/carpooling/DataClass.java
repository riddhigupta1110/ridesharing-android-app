package com.example.carpooling;

public class DataClass {

    private String dataName;
    private String dataSrc;
    private String dataDest;
    private String dataTime;
    private String dataNoPass;
    private String dataFarePerP;
    private String dataGender;
    private String dataImage;


    public DataClass(String dataName, String dataSrc, String dataDest, String dataTime, String dataGender, String dataNoPass, String dataFarePerP, String dataImage) {
        this.dataName = dataName;
        this.dataSrc = dataSrc;
        this.dataDest = dataDest;
        this.dataTime = dataTime;
        this.dataGender = dataGender;
        this.dataNoPass = dataNoPass;
        this.dataFarePerP = dataFarePerP;
        this.dataImage = dataImage;
    }

    public String getDataName() {
        return dataName;
    }
    public String getDataSrc() {
        return dataSrc;
    }
    public String getDataDest() {
        return dataDest;
    }
    public String getDataTime() {
        return dataTime;
    }
    public String getGender() {
        return dataGender;
    }
    public String getDataNoPass() { return dataNoPass; }
    public String getDataFarePerP() {
        return dataFarePerP;
    }
    public String getDataImage() {
        return dataImage;
    }
    public DataClass(){

    }
}
