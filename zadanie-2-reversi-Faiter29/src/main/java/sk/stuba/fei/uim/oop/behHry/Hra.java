package sk.stuba.fei.uim.oop.behHry;

import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.okno.Okno;
import sk.stuba.fei.uim.oop.okno.hraciePole.Policko;

import java.util.ArrayList;

public class Hra {

    private ArrayList<ArrayList> mozneTahy;
    private ArrayList<ArrayList> figurkyMoznychTahov;
    private Hrac hrac;
    private Hrac pocitac;
    private Okno okno;

    public Hra(){
        figurkyMoznychTahov=new ArrayList<>();
        mozneTahy=new ArrayList<>();
        deklarovanieHracov();
        okno=new Okno(this,pocitac,hrac);
        hrac.setHrac(0);
        pocitac.setHrac(1);
        /*if(okno.getMenu().getFarba().getIndexFarba()==0){
            hrac.setHrac(0);
            pocitac.setHrac(1);
        }
        else{
            hrac.setHrac(1);
            pocitac.setHrac(0);
        }*/
        kontrolaTahu(hrac.getPolickaHraca(),pocitac);
    }

    private void deklarovanieHracov() {
        hrac = new Hrac(this);
        pocitac=new Hrac(this);
    }

    public void kontrolaTahu(ArrayList<Policko> hracpole,Hrac protihrac){

        for (int i=0;i<hracpole.size();i++) {
                int Xpolicka = hracpole.get(i).getIndexX();
                int Ypolicka = hracpole.get(i).getIndexY();
                kontrolaTahuStrana(Xpolicka, Ypolicka, protihrac, 0, -1);
                kontrolaTahuStrana(Xpolicka, Ypolicka, protihrac, 1, -1);
                kontrolaTahuStrana(Xpolicka, Ypolicka, protihrac, 1, 0);
                kontrolaTahuStrana(Xpolicka, Ypolicka, protihrac, 1, 1);
                kontrolaTahuStrana(Xpolicka, Ypolicka, protihrac, 0, 1);
                kontrolaTahuStrana(Xpolicka, Ypolicka, protihrac, -1, 1);
                kontrolaTahuStrana(Xpolicka, Ypolicka, protihrac, -1, 0);
                kontrolaTahuStrana(Xpolicka, Ypolicka, protihrac, -1, -1);
        }
    }

    private void kontrolaTahuStrana(int polickoX, int polickoY, Hrac protihrac, int x, int y) {
        int posun = 0;
        Policko kontrola;
        ArrayList<Object> indexApocetTahov=new ArrayList<>();
        ArrayList<Policko> figurky=new ArrayList<>();
        while ((polickoX + (posun + 1) * x >= 0) && (polickoX + (posun + 1) * x < okno.getMenu().getVelkost().getIndexVelkost()) && (polickoY + (posun + 1) * y >= 0) && (polickoY + (posun + 1) * y < okno.getMenu().getVelkost().getIndexVelkost())) {
            posun++;
                kontrola = (Policko) okno.getHraciePole().getComponent((polickoX + posun * x) + (polickoY + posun * y) * okno.getMenu().getVelkost().getIndexVelkost());
                if (kontrola.getfigurka() == protihrac.getHrac()) {
                    figurky.add(kontrola);
                    if ((polickoX + (posun + 1) * x >= 0) && (polickoX + (posun + 1) * x < okno.getMenu().getVelkost().getIndexVelkost()) && (polickoY + (posun + 1) * y >= 0) && (polickoY + (posun + 1) * y < okno.getMenu().getVelkost().getIndexVelkost())) {
                        kontrola = (Policko) okno.getHraciePole().getComponent((polickoX + (posun + 1) * x) + (polickoY + (posun + 1) * y) * okno.getMenu().getVelkost().getIndexVelkost());
                        if (!kontrola.isObsadenost()) {
                            indexApocetTahov.add(posun);
                            indexApocetTahov.add(kontrola);
                            figurky.add(kontrola);
                            kontrola.setPocetPreskoku(posun);
                            kontrola.add(new VykresliTah(okno.getMenu().getVelkost().getIndexVelkost()));
                            break;
                        }
                    } else
                        kontrola = (Policko) okno.getHraciePole().getComponent((polickoX + posun * x) + (polickoY + posun * y) * okno.getMenu().getVelkost().getIndexVelkost());
                }
                else {
                    mozneTahy.clear();
                    indexApocetTahov.add(0);
                    indexApocetTahov.add(null);
                    break;
                }

        }
        figurkyMoznychTahov.add(figurky);
        mozneTahy.add(indexApocetTahov);
    }

    public void resetpolicka(){
        for(int i=0;i<okno.getMenu().getVelkost().getIndexVelkost();i++) {
            Policko policko = (Policko) okno.getHraciePole().getComponent(i);
            policko.setPocetPreskoku(0);
        }
            figurkyMoznychTahov.clear();
            mozneTahy.clear();
    }

    public ArrayList<ArrayList> getMozneTahy() {
        return mozneTahy;
    }

    public ArrayList<ArrayList> getFigurkyMoznychTahov() {
        return figurkyMoznychTahov;
    }
}