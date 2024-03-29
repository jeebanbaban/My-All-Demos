package com.example.myapplication.bluetooth;

public class DeviceItem {


    private String deviceName;
    private String address;
    private boolean connected;

    public DeviceItem(String name, String address, String connected){
        this.deviceName = name;
        this.address = address;

        if (connected == "true") {
            this.connected = true;
        }
        else {
            this.connected = false;
        }
    }

    public String getDeviceName() {
        return deviceName;
    }

    public boolean getConnected() {
        return connected;
    }

    public String getAddress() {
        return address;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }


    @Override
    public String toString() {
        return "DeviceItem{" +
                "deviceName='" + deviceName + '\'' +
                ", address='" + address + '\'' +
                ", connected=" + connected +
                '}';
    }
}
