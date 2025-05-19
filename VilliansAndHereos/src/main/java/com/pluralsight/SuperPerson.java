package com.pluralsight;

import java.util.Random;

public class SuperPerson {

    //protected properties so they can possibly be access by out children, grand children, etc...
    //these properties stay in the family
    protected String name;
    protected int health;
    protected int experiencePoints;

    public SuperPerson(String name, int health) {
        //take in the values for name and health
        this.name = name;
        this.health = health;

        //default the experience points to 0
        this.experiencePoints = 0;
    }
    //method to return if our SuperPerson is alive
    public boolean isAlive() {

        //if the health is greater than zero, return true, otherwise return false
       return this.health > 0;

    }
    //method that allows us to fight another SuperPerson
    public void fight(SuperPerson opponent){
        //generate a random amount of damage
        //this line returns a number between 0 and 20
        int damageAmount = new Random().nextInt(21);
        //print out who we are fighting
        System.out.println(this.name + " is fighting " + opponent.name);
        opponent.takeDamage(damageAmount + this.experiencePoints);
    }

    //this method allows a SuperPerson to take damage
    public void takeDamage(int damageAmount){
        //subtract the damage amount from the health
        //but we don't want to set health below 0
        this.health -= damageAmount;

        //health not allowed to go below zero
        if(this.health < 0){
            this.health = 0;
        }

    }

    //a way to ask the SuperPerson how they are doing
    public String getStatus(){

        //build and return a string that tells us how the SuperPerson is doing
        return this.name + " has " + this.health + "% of health left!";
    }

}