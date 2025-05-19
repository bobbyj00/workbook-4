package com.pluralsight;

public class SuperApp {

    public static void main(String[] args) {
        SuperVillain superAbraham = new SuperVillain("Abraham", 100, 25);
        SuperHero superAssia = new SuperHero("Assia", 100, 25);



        //ask each SuperPerson how they are doing
        System.out.println(superAbraham.getStatus());
        System.out.println(superAssia.getStatus());

        //take damage
        superAbraham.takeDamage(15);
        superAssia.takeDamage(15);

        //ask each SuperPerson how they are doing
        System.out.println(superAbraham.getStatus());
        System.out.println(superAssia.getStatus());

        //make the super people fight each other
        superAbraham.fight(superAssia);
        superAssia.fight(superAbraham);

        //ask each SuperPerson how they are doing
        System.out.println(superAbraham.getStatus());
        System.out.println(superAssia.getStatus());


    }

}

