package sample;

import java.util.Random;

public class Boss{

    private int damage;
    private int vitaTot;
    private int salute;
    protected String name;

    public Boss(String name, int damage, int vitaTot){
        this.name = name;
        this.damage = damage;
        this.vitaTot = vitaTot;
        this.salute = vitaTot;
    }

    public int bossAttack(int damage){
        Random r = new Random();
        return r.nextInt(damage) + damage/2;
    }

    public double healthBar(){
        double salPerc = (double)getSalute()/getVitaTot();
        return salPerc;
    }

    public String getName(){ return name; }

    public int getDamage(){ return damage; }

    public int getVitaTot(){ return vitaTot; }

    public int getSalute(){ return salute; }

    public void setDamage(int danno){ damage = danno; }

    public void setVitaTot(int v){ vitaTot = v; }

    public void setSalute(int s){ salute = s; }

    public void infliggiDannoRicevuto(int attaccoRicevuto) {
        int sal = getSalute()-attaccoRicevuto;
        if(sal<0) sal=0;
        setSalute(sal);
    }

    public boolean isDead(){
        if(getSalute()<=0)
            return true;
        else
            return false;
    }

}
