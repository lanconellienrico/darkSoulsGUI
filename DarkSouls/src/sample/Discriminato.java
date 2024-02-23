package sample;

import java.util.Random;

public class Discriminato extends Character{

    public Discriminato(String name){
        super(name);
        super.forza = 100;
        super.armatura = 0;
        super.vitaTot = 200;
        super.salute = 200;
        super.magia = 0;
        super.fortuna = new Random().nextInt(50)+1;
        super.anime = 0;
    }

    public String toString(){
        return super.name + " [discriminato] souls: " + anime;
    }

}

