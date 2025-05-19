package com.pluralsight;

import java.util.Random;

public class SuperVillain extends SuperPerson {

    public SuperVillain(String name, int health, int powerLevel) {
        super(name, health);

        this.experiencePoints = powerLevel;

        System.out.println((this.name + ", the God Of Destruction has arrived with a power level of " + powerLevel));

    }

        @Override
        public void fight(SuperPerson opponent) {
            //make the hero do a random amount of damage to the opponent
            int baseDamage = new Random().nextInt(31);
            //the damage should be a random number plus the experiencePoints(powerLevel)
            int damage = baseDamage + this.experiencePoints;
            //if the base damage (without the xp) don't do any damage and just say you missed
            if (baseDamage == 0) {
                System.out.println(this.name + "swings and misses!");
            } else {
                System.out.println(this.name + " hits " + opponent.name + " with destruction blast for " + damage + " damage!");
                opponent.takeDamage(damage);
            }


    }
}