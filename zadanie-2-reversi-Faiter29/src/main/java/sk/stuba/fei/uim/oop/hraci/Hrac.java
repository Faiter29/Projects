package sk.stuba.fei.uim.oop.hraci;

import sk.stuba.fei.uim.oop.behHry.Hra;
import sk.stuba.fei.uim.oop.okno.hraciePole.Policko;

import java.util.ArrayList;

public class Hrac {
    private ArrayList<Policko> polickaHraca;
    private ArrayList<Boolean> tahHraca;
    private int hrac;
    private Hra hra;

    public Hrac(Hra hra){
        this.hra=hra;
        polickaHraca=new ArrayList<>();
        tahHraca=new ArrayList<>();
    }

    public int getHrac() {
        return hrac;
    }

    public void setHrac(int hrac) {
        this.hrac = hrac;
    }

    public void pridatPolickaHraca(Policko policko) {
        polickaHraca.add(policko);
    }

    public ArrayList<Policko> getPolickaHraca() {
        return polickaHraca;
    }

    public void resetPolicok(){
        polickaHraca.clear();
    }
}
