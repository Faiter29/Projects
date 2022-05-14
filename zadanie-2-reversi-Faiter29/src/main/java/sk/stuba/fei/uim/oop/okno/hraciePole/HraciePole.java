package sk.stuba.fei.uim.oop.okno.hraciePole;

import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.okno.Okno;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HraciePole extends JPanel {

    private Policko policko;
    private Okno okno;
    private ArrayList<Policko> hracpole;
    private ArrayList<Policko> pocitacpole;

    public HraciePole(int velkost, Okno okno, int farba, Hrac hrac, Hrac pocitac) {
        this.okno = okno;
        hracpole=new ArrayList<>();
        pocitacpole=new ArrayList<>();
        //policka= new ArrayList[velkost][velkost];
        setBackground(new Color(0, 0, 0));
        this.setSize(800, 800);
        setLayout(new GridLayout(velkost, velkost));
        for (int y = 0; y < velkost; y++) {
            for (int x = 0; x < velkost; x++) {
                policko = new Policko(x, y, velkost,/* farba,*/hrac,pocitac,okno);
                add(policko);
                if (x == velkost / 2 - 1 && y == velkost / 2 - 1) {
                    policko.add(new Figurka(policko, velkost, 1));
                    policko.setHrac(1);
                        /*if(okno.getMenu().getFarba().getIndexFarba()==1)*/
                    pocitacpole.add(policko);
                    pocitac.pridatPolickaHraca(policko);
                    //pocitac.pridatPolickaHraca(policko);
                }
                if (x == velkost / 2 && y == velkost / 2) {
                    policko.add(new Figurka(policko, velkost, 1));
                    policko.setHrac(1);
                    /*if(okno.getMenu().getFarba().getIndexFarba()==1) */
                    pocitacpole.add(policko);
                    pocitac.pridatPolickaHraca(policko);
                    /*else pocitac.pridatPolickaHraca(policko);*/
                }
                if (x == velkost / 2 - 1 && y == velkost / 2) {
                    policko.add(new Figurka(policko, velkost, 0));
                    policko.setHrac(0);
                    /*if(okno.getMenu().getFarba().getIndexFarba()==0)*/
                    hracpole.add(policko);
                    hrac.pridatPolickaHraca(policko);
                    //else pocitac.pridatPolickaHraca(policko);
                }
                if (x == velkost / 2 && y == velkost / 2 - 1) {
                    policko.add(new Figurka(policko, velkost, 0));
                    policko.setHrac(0);
                    /*if(okno.getMenu().getFarba().getIndexFarba()==0)*/
                    hracpole.add(policko);
                    hrac.pridatPolickaHraca(policko);
                    //else pocitac.pridatPolickaHraca(policko);
                }
            }
        }
    }

    public void pridavaniePolicokHrac(Policko toto){
        hracpole.add(toto);
    }

    public void pridavaniePolicokPocitac(Policko toto){
        pocitacpole.add(toto);
    }

    public void uberaniePolicokHrac(Policko toto){
        pocitacpole.remove(toto);
    }
    public void uberaniePolicokPocitac(Policko toto){
        pocitacpole.remove(toto);
    }

    public ArrayList<Policko> getHracpole() {
        return hracpole;
    }

    public ArrayList<Policko> getPocitacpole() {
        return pocitacpole;
    }

    //public ArrayList<Policko>[][] getPolicka() {
    //    return policka;
    //}
}