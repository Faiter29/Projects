package sk.stuba.fei.uim.oop.okno.menu;

import sk.stuba.fei.uim.oop.okno.Okno;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private Tlacitko koniec;
    private Tlacitko reset;
    private Velkost velkost;
    private Farba farba;
    private Text textFarba;
    private Text textVelkost;
    private Okno okno;

    public Okno getOkno() {
        return okno;
    }

    public void setOkno(Okno okno) {
        this.okno = okno;
    }

    public Velkost getVelkost() {
        return velkost;
    }

    //public Farba getFarba() {
    //    return farba;
    //}

    public Menu(Okno okno){
        this.okno=okno;
        textFarba=new Text("Tvoja farba je: Biela");
        textVelkost=new Text("Velkost hracieho pola je");
        velkost=new Velkost(new String[]{"6x6","8x8","10x10","12x12"},okno);
        //farba=new Farba(new String[]{"Biela","Cierna"},okno);
        reset=new Tlacitko("RESET",okno);
        koniec=new Tlacitko("KONIEC",okno);

        setBackground(Color.GRAY);

        //this.add(farba);
        this.add(textVelkost);
        this.add(velkost);
        this.add(reset);
        this.add(koniec);
        this.add(textFarba);
    }

}
