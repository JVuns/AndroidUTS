package com.example.myapplication;

public class RandomItem {

    //opt
    String name;
    int index;
    public static int count;

    public RandomItem(){
        count++;
        index = count;
        int index = (int)(Math.random()*3);

        switch (index){
            case 1:
                name = "Jason";
                break;
            case 2:
                name = "Jevon";
                break;
            case 3:
                name = "Josua";
                break;
            case 4:
                name = "Jose";
                break;
            default:
                name = "Jaysie";
        }

    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
