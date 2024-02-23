package sample;

public class Guerriero extends Character {

        public Guerriero(String name){
            super(name);
            super.forza = 50;
            super.armatura = 50;
            super.vitaTot = 150;
            super.salute = 150;
            super.magia = 0;
            super.fortuna = 5;
            super.anime = 0;
        }

        public String toString(){
            return super.name + " [guerriero] souls: " + anime;
        }


}

