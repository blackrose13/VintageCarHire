package com.vintagecarhire;
/////this java class shows the name or the rows found the vintage database in the asset folder ontop of the res folder

public class Item {

    private Integer id;
    private String vintagename;
    private Integer engine;
    private Integer numberOfSeats;
    private boolean convertable;
    private Integer numberOfDoors;
    private Integer yearOfManufacturer;
    private Integer price;
    private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVintagename() {
        return vintagename;
    }

    public void setVintagename(String vintagename) {
        this.vintagename = vintagename;
    }

    public Integer getEngine() {
        return engine;
    }

    public void setEngine(Integer engine) {
        this.engine = engine;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean getConvertable() {
        return convertable;
    }

    public void setConvertable(boolean convertable) {
        this.convertable = convertable;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Integer getYearOfManufacturer() {
        return yearOfManufacturer;
    }

    public void setYearOfManufacturer(Integer yearOfManufacturer) {
        this.yearOfManufacturer = yearOfManufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
