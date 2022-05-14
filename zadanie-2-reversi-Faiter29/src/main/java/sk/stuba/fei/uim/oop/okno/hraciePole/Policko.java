package sk.stuba.fei.uim.oop.okno.hraciePole;

import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.okno.Okno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Policko extends JPanel implements MouseListener {

    //ArrayList<Policko> hracpole;
    //ArrayList<Policko> pocitacpole;
    private final Hrac pocitac;
    private final Hrac hrac;
    private final Okno okno;
    private int pocetPreskoku;
    private final int indexX;
    private final int indexY;
    private final int velkost;
    private int figurka;
    private boolean obsadenost;
    //private int farba;

    public Policko(int x, int y, int velkost,/* int farba, */Hrac hrac,Hrac pocitac,Okno okno){
        this.okno=okno;
        this.hrac=hrac;
        this.pocitac=pocitac;
        this.figurka=-1;
        //hracpole=new ArrayList<>();
        //pocitacpole=new ArrayList<>();
        pocetPreskoku=0;
        obsadenost=false;
        //this.farba=farba;
        this.indexX=x;
        this.indexY=y;
        this.velkost=velkost;
        setLayout(new BorderLayout());
        this.addMouseListener(this);
    }

    public void setPocetPreskoku(int pocetPreskoku) {
        this.pocetPreskoku = pocetPreskoku;
    }

    public boolean isObsadenost() {
        return obsadenost;
    }

    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public void setObsadenost(boolean obsadenost) {
        this.obsadenost = obsadenost;
    }

    public int getfigurka() {
        return figurka;
    }

    public void setHrac(int figurka) {
        this.figurka = figurka;
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.setSize(800/velkost-4,800/velkost-4);
        kresleniePolicko(g,800/velkost-4);
    }

    private void kresleniePolicko(Graphics g,int dlzka) {
        g.setColor(new Color(0, 120, 0));
        if (indexX%2==0 && indexY%2==1) g.setColor(new Color(0,80,0));
        if (indexX%2==1 && indexY%2==0) g.setColor(new Color(0,80,0));
        g.fillRect(0, 0, dlzka, dlzka);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ArrayList<ArrayList> listPolicko=okno.getHra().getFigurkyMoznychTahov();
        ArrayList<ArrayList> figurkypocet=okno.getHra().getMozneTahy();
        Policko policko;
        int pocet;
        if (this.obsadenost==false && this.pocetPreskoku!=0) {
            for (int i = 0; i < listPolicko.size(); i++) {
                if (listPolicko.get(i).size() > 0) {
                    if (listPolicko.get(i).get(listPolicko.get(i).size() - 1).equals(this)) {
                        for (int j = 0; j < listPolicko.get(i).size(); j++) {
                            policko = (Policko) listPolicko.get(i).get(j);
                            policko.removeAll();
                            policko.figurka = 0;
                            policko.add(new Figurka(this, velkost, 0));
                            policko.obsadenost = true;
                            pocet = okno.getHraciePole().getHracpole().size();
                            for (int k = 0; k < pocet; k++) {
                                if (okno.getHraciePole().getHracpole().get(k) != policko) {
                                    okno.getHraciePole().pridavaniePolicokHrac(policko);
                                    break;
                                }
                            }
                            pocet = okno.getHraciePole().getPocitacpole().size();
                            for (int k = 0; k < pocet; k++) {
                                if (okno.getHraciePole().getPocitacpole().get(k) == policko) {
                                    okno.getHraciePole().uberaniePolicokPocitac(policko);
                                    break;
                                }
                            }
                        }
                    }
                    policko = (Policko) (listPolicko.get(i).get(listPolicko.get(i).size() - 1));
                    if (policko != this) policko.removeAll();
                }
            }
        }
        okno.getHra().resetpolicka();
        okno.getHra().kontrolaTahu(okno.getHraciePole().getPocitacpole(), hrac);
        SwingUtilities.updateComponentTreeUI(this);

        int najlepsi = 0;
        int indexnajlepsi = 0;
        for (int i = 0; i < figurkypocet.size(); i++) {
            if (figurkypocet.get(i) != null) {
                najlepsi = (int) figurkypocet.get(i).get(0);
                indexnajlepsi = i;
                break;
            }
        }

        for (int i = 0; i < figurkypocet.size(); i++)
            if (figurkypocet.get(i) != null) {
                if (najlepsi < (int) (figurkypocet.get(i).get(0))) {
                    najlepsi = (int) (figurkypocet.get(i).get(0));
                    indexnajlepsi = i;
                }
        }

        if (najlepsi == 0) {
            for (int i = 0; i < listPolicko.size(); i++) {
                if (listPolicko.get(i).size() > 0) {
                    if (listPolicko.get(i).get(listPolicko.get(i).size() - 1).equals(figurkypocet.get(indexnajlepsi).get(1))) {
                        for (int j = 0; j < listPolicko.get(i).size(); j++) {
                            policko = (Policko) listPolicko.get(i).get(j);
                            policko.removeAll();
                            policko.figurka = 1;
                            policko.add(new Figurka(this, velkost, 1));
                            policko.obsadenost = true;
                            pocet = okno.getHraciePole().getPocitacpole().size();
                            for (int k = 0; k < pocet; k++) {
                                if (okno.getHraciePole().getPocitacpole().get(k) != policko) {
                                    okno.getHraciePole().pridavaniePolicokPocitac(policko);
                                    break;
                                }
                            }
                            pocet = okno.getHraciePole().getHracpole().size();
                            for (int k = 0; k < pocet; k++) {
                                if (okno.getHraciePole().getHracpole().get(k) == policko) {
                                    okno.getHraciePole().uberaniePolicokHrac(policko);
                                    break;
                                }
                            }
                        }
                    }
                    policko = (Policko) (listPolicko.get(i).get(listPolicko.get(i).size() - 1));
                    if (policko != this) policko.removeAll();
                }
            }
        }

        okno.getHra().resetpolicka();
        okno.getHra().kontrolaTahu(okno.getHraciePole().getHracpole(),pocitac);
        SwingUtilities.updateComponentTreeUI(this);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
