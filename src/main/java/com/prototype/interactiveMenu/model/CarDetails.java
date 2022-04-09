package com.prototype.interactiveMenu.model;

public class CarDetails {
    private String model;
    private String color;
    private String plateNumber;

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "CarDetails : " +
                "color='" + color + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
