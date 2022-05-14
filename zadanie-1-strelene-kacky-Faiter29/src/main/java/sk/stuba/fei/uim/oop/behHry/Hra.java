package sk.stuba.fei.uim.oop.behHry;
import sk.stuba.fei.uim.oop.akcneKarty.*;
import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.neakcneKarty.BalicekS;
import sk.stuba.fei.uim.oop.neakcneKarty.Kacky;
import sk.stuba.fei.uim.oop.neakcneKarty.Voda;
import sk.stuba.fei.uim.oop.neakcneKarty.Zameriavac;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hra {
    int pocetHracov;
    Zameriavac[] zameriavace;
    List<Hrac> hraci;
    boolean[] kontrola;
    int kontrolapocet;
    int pocetHracovVHre;
    int vyberkartu;
    List<BalicekS> baliceks;
    List<BalicekA> baliceka;

    public Hra() {
        pocetHracov= ZKlavesnice.readInt("Zadaj pocet hracov (2-6)");
        while(pocetHracov>6 || pocetHracov<2){
            pocetHracov=ZKlavesnice.readInt("Skus napisat cislo od 2 po 6");
        }
        kontrola=new boolean[3];
        kontrolapocet=0;
        hraci=new ArrayList<>();
        zameriavace=new Zameriavac[6];
        pocetHracovVHre=pocetHracov;
        baliceks=new ArrayList<>();
        baliceka=new ArrayList<>();

        alokovaniezameriavacov();
        generovanieBalicekS();
        generovanieBalicekA();
        generovanieHracov();
        vypisRybnika();

        while(pocetHracovVHre!=1){
            for (Hrac hraci:hraci){
                if (hraci!=null) {
                    vypisHraca(hraci);
                    kontrolapocet = 0;
                    for (int i = 0; i < 3; i++) {
                        kontrola[i] = hraci.getKarty(i).skuskaKarty(zameriavace);
                        if (kontrola[i]) kontrolapocet++;
                    }
                    vyberkartu = ZKlavesnice.readInt("Ktoru kartu chces zahrat (1-3)?") - 1;
                    while (vyberkartu > 2 || vyberkartu < 0) {
                        vyberkartu = ZKlavesnice.readInt("Chces vyhodit kartu 1, 2 alebo 3?") - 1;
                    }
                    while (true) {
                        if (kontrola[vyberkartu]) break;
                        if (kontrolapocet == 0) break;
                        vyberkartu = ZKlavesnice.readInt("Vyhod kartu ktora sa da pouzit!") - 1;
                    }
                    if (kontrolapocet != 0) {
                        zahrajKartu(vyberkartu, hraci);
                    }
                    vyhodKartu(vyberkartu, hraci);
                    potiahniKartu(hraci);
                    kontrolaHracov();
                    vypisRybnika();
                    if (pocetHracovVHre == 1) break;
                }
            }
        }
        koniecHry();
    }

    private void koniecHry() {
        for(Hrac hraci:hraci){
            if(hraci!=null) {
                System.out.println("Vyhral hrac " + (hraci.getIndex() + 1));
            }
        }
    }

    public void kontrolaHracov() {
        int index = -1;
        for (Hrac hraci:hraci) {
            if (hraci != null) {
                if (hraci.getZivot() == 0) {
                    index = hraci.getIndex();
                    dajKartyDoBalicka(hraci);
                    pocetHracovVHre--;
                    break;
                }
            }
        }
        if(index!=-1) {
            hraci.set(index,null);
        }
    }

    private void vyhodKartu(int vyhodkartu, Hrac hraci) {
        baliceka.add(hraci.getKarty(vyhodkartu));
        hraci.vymazKartu(vyhodkartu);
    }

    private void potiahniKartu(Hrac hraci) {
        hraci.pridajKartu(baliceka.get(0));
        baliceka.remove(baliceka.get(0));
    }

    private void dajKartyDoBalicka(Hrac hrac) {
        for(int i=0;i<3;i++){
            baliceka.add(hrac.getKarty(i));
        }
    }

    private void zahrajKartu(int vyberkartu, Hrac hrac) {
        hrac.getKarty(vyberkartu).pouzitKartu(baliceks,zameriavace,hraci);
    }

    public void vypisRybnika(){
        System.out.println("-----------------------------------");
        for (int i=0;i<6;i++){
            System.out.print(i+1+". - ");
            zameriavace[i].vypisZamierovaca(zameriavace[i]);
            System.out.print(" - "+baliceks.get(i).getKarta());
            if(baliceks.get(i).getIndex()!=0) System.out.println(" hraca "+baliceks.get(i).getIndex());
            else System.out.println();
        }
        System.out.println("-----------------------------------");
    }

    public void vypisHraca(Hrac hraci){
        hraci.vypisHraca();
        System.out.println("-----------------------------------");
    }

    private void generovanieHracov() {
        for(int i=0;i<pocetHracov;i++){
            hraci.add(new Hrac(baliceka.subList(0,3),i));
            for(int j=0;j<3;j++) {
                baliceka.remove(baliceka.get(0));
            }
        }
    }

    private void generovanieBalicekA() {
        for (int i=0;i<10;i++){
            baliceka.add(new Zamierit());
        }
        for (int i=0;i<12;i++){
            baliceka.add(new Vystrelit());
        }
        for (int i=0;i<2;i++){
            baliceka.add(new DivokyBill());
        }
        for (int i=0;i<6;i++){
            baliceka.add(new KacaciPochod());
        }
        for (int i=0;i<1;i++){
            baliceka.add(new Turbokacka());
        }
        for (int i=0;i<2;i++){
            baliceka.add(new Rosambo());
        }
        for(int i=0;i<1;i++){
            baliceka.add(new KacaciTanec());
        }
        Collections.shuffle(baliceka);
    }

    public void generovanieBalicekS(){
        for (int i=0;i<5;i++){
            baliceks.add(new Voda());
        }
        for(int i=0;i<pocetHracov;i++){
            for (int j=0;j<5;j++) {
                baliceks.add(new Kacky(i+1));
            }
        }
        Collections.shuffle(baliceks);
    }

    private void alokovaniezameriavacov() {
        for (int i=0;i<6;i++){
            zameriavace[i]=new Zameriavac();
        }
    }
}