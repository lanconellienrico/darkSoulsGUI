package sample;

import java.util.Random;

public class Character {

    protected int forza;
    protected int armatura;
    protected int vitaTot;
    protected int salute;
    protected int magia;
    protected int fortuna;
    protected int anime;
    protected String name;

    public Character(String name){
        forza = 0;
        armatura = 0;
        vitaTot = 0;
        salute = 0;
        magia = 0;
        fortuna = 0;
        anime = 0;
        this.name = name;
    }

    public int getForza() {
        return forza;
    }

    public int getArmatura() {
        return armatura;
    }

    public int getVitaTot() {
        return vitaTot;
    }

    public int getSalute() {
        return salute;
    }

    public int getMagia() {
        return magia;
    }

    public int getFortuna() {
        return fortuna;
    }

    public int getPunteggio() {
        return anime;
    }

    public String getName() { return name; }

    public void setForza(int forza) {
        this.forza = forza;
    }

    public void setArmatura(int armatura) {
        this.armatura = armatura;
    }

    public void setVita(int vitaTot) {
        this.vitaTot = vitaTot;
    }

    public void setSalute(int salute) {
        this.salute = salute;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public void setFortuna(int fortuna) {
        this.fortuna = fortuna;
    }

    public void setPunteggio(int punteggio) {
        this.anime = punteggio;
    }

    public void setName(String name) { this.name = name; }

    public int dannoRicevuto(int attaccoRicevuto){
        int danno = attaccoRicevuto - getArmatura();
        if (danno < 0) danno = 0;
        return danno;
    }

    public void infliggiDannoRicevuto(int attaccoRicevuto) {
        int sal = getSalute()-attaccoRicevuto;
        if(sal<0) sal=0;
        setSalute(sal);
    }

    public boolean buonFine(){
       Random r = new Random();
       int f = r.nextInt(getFortuna());
       if(f<1)
           return false;
       else
           return true;
    }

    public int attaccoInflitto(){
        Random r = new Random();
        int f = r.nextInt(getFortuna())+1;
        if(f>getFortuna()/3*2)
            return getForza()*2;
        else
            return getForza();
    }

    public double healthBar(){
        double salPerc = (double)getSalute()/getVitaTot();
        return salPerc;
    }

    public boolean isDead(){
        if(getSalute()<=0)
            return true;
        else
            return false;
    }

    public String toString(){
        return "souls: " + anime;
    }


}
