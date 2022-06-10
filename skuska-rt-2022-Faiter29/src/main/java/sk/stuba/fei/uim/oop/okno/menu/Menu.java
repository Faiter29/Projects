package sk.stuba.fei.uim.oop.okno.menu;

import sk.stuba.fei.uim.oop.okno.Okno;
import sk.stuba.fei.uim.oop.okno.menu.slider.Slider;
import sk.stuba.fei.uim.oop.okno.menu.tlacitko.Tlacitko;
import sk.stuba.fei.uim.oop.okno.menu.vyberMoznosti.VyberMoznosti;
import sk.stuba.fei.uim.oop.okno.menu.vypis.Vypis;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    private final Tlacitko akcia;
    private final Tlacitko farba;
    private final Slider dlzka;
    private final VyberMoznosti uhol;
    private final Vypis info;
    private final Vypis infofarba;
    private final Okno okno;
    private String info1;
    private String info2;

    public Menu(Okno okno){
        setLayout(new GridLayout(2,3));
        this.okno=okno;
        info=new Vypis("");
        infofarba=new Vypis("");
        akcia=new Tlacitko("AKCIA",this,this.okno);
        farba=new Tlacitko("FARBA",this,this.okno);
        dlzka=new Slider(this);
        uhol=new VyberMoznosti(new String[]{"0", "5" ,"10", "45", "90" , "180"},this);
        add(akcia);
        add(farba);
        add(dlzka);
        add(info);
        add(infofarba);
        add(uhol);
    }

    public void setInfo1(String text) {
        this.info1="Velkost kroku: "+text;
    }

    public void setInfo2(String text) {
        this.info2="Uhol: "+text;
    }

    public void setInfo(){
        this.info.setText(info1+" | "+info2);
    }

    public void setInfofarba(Color farba){
        this.infofarba.setForeground(farba);
        this.infofarba.setText("FARBA");
    }

    public Tlacitko getColor() {
        return farba;
    }

    public Slider getDlzka() {
        return dlzka;
    }

    public VyberMoznosti getUhol() {
        return uhol;
    }
}
