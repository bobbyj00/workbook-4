package com.pluralsight;

import java.util.Random;

//create a class using the extends keyword to basically copy all the functionality from the parent class to the hold class
public class SuperHero extends SuperPerson {

    //constructor that calls the parent class constructor
    public SuperHero(String name, int health, int powerLevel) {
        super(name, health);

        //in the parent we default power level (XP) to 0
        //for our superhero we want to have them pass in power level
        //but just use that as xp
        this.experiencePoints = powerLevel;

        //let the world know the hero now exists
        System.out.println((this.name + " , the savior, has arrived with a power level of " + powerLevel));
    }


    @Override
    public void fight(SuperPerson opponent) {
        //make the hero do a random amount of damage to the opponent
        int baseDamage = new Random().nextInt(21);
        //the damage should be a random number plus the experiencePoints(powerLevel)
        int damage = baseDamage + this.experiencePoints;
        //if the base damage (without the xp) don't do any damage and just say you missed
        if (baseDamage == 0) {
            System.out.println(this.name + "swings and misses!");
        } else {
            System.out.println(this.name + "lands a heroic punch on " + opponent.name + " for " + damage + " damage!");
            opponent.takeDamage(damage);
        }
        //otherwise deal the damage and say something about you kicking butt against your opponent

    }

}
