package sample;

public class Chierico extends Character {

    public Chierico(String name){
        super(name);
        super.forza = 40;
        super.armatura = 30;
        super.vitaTot = 250;
        super.salute = 250;
        super.magia = 30;
        super.fortuna = 10;
        super.anime = 0;
    }

    public String toString(){
        return super.name + " [chierico] souls: " + anime;
    }


}

