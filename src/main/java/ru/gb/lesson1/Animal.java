package ru.gb.lesson1;

public class Animal {
    protected String name;
    protected String type;
    protected String color;


    public Animal(String type, String name, String color){
        this.type = type;
        this.name = name;
        this.color = color;
    }

    String getType(){
        return type;
    }

    String getName(){
        return name;
    }

    String getColor(){
        return color;
    }

    String getFullInfo(){
        return this.type + " " + this.name + " " + this.color;
    }

    public void run(int meters, int maxDist){
            if(meters <= maxDist){
                System.out.println(type + " " + name + " run " + meters + " meters.");
            }else
                System.out.println("Maximum distance of " + type + " " + maxDist);
        }

    public void swim(int meters, int maxSwimDist){
        if(meters <= maxSwimDist){
            System.out.println(type + " " + name + " swim " + meters + " meters.");
        }else
            System.out.println("Maximum swim distance of " + type + " " + maxSwimDist);

    }








}
