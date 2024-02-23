package sample;

public class Viandante extends Character {

    public Viandante(String name) {
        super(name);
        super.forza = 30;
        super.armatura = 40;
        super.vitaTot = 200;
        super.salute = super.vitaTot;
        super.magia = 10;
        super.fortuna = 15;
        super.anime = 0;
    }

    public String toString() {
        return super.name + " [viandante] souls: " + anime;
    }

}