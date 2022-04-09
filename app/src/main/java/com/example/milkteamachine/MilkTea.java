package com.example.milkteamachine;

public class MilkTea {
    private String name;
    private String size;
    private String sweetness;

    public MilkTea(String name, String size, String sweetness){
        this.name=name;
        this.size=size;
        this.sweetness=sweetness;
    }

    public String getName(){
        return name;
    }

    public String getSize(){
        return size;
    }

    public String getSweetness(){
        return sweetness;
    }
}
