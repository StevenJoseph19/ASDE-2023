package com.mycompany.tollrateui;

public class TollRate {

    private Integer stationId;
    private Float currentRate;
    private String timestamp;

    public TollRate() {
    }

    public TollRate(Integer stationId, Float currentRate, String timestamp) {
        this.stationId = stationId;
        this.currentRate = currentRate;
        this.timestamp = timestamp;
    }

    public Integer getStationId() {
        return stationId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Float getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(Float currentRate) {
        this.currentRate = currentRate;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

}
