package sk.stuba.fei.uim.oop.okno.papier;

import sk.stuba.fei.uim.oop.okno.Okno;

import javax.swing.*;
import java.awt.*;

public class Papier extends JPanel {

    private final Okno okno;
    private final Korytnacka korytnacka;
    private Ciara ciara;

    public Papier(Okno okno) {
        this.okno = okno;
        setSize(400, 400);
        setBackground(Color.white);
        setLayout(null);
        korytnacka=new Korytnacka(this.okno);
        korytnacka.setBounds(korytnacka.getZaciatokX(),korytnacka.getZaciatokY(),korytnacka.getVelkostPaneluKorytnacky(),korytnacka.getVelkostPaneluKorytnacky());
        this.add(korytnacka);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void korytnackaKresli(int dlzka,Color farba){
        ciara=new Ciara(korytnacka,dlzka,farba,0);
        ciara.setBounds(0,0,dlzka,dlzka);
        this.add(ciara);
        korytnacka.setBounds(korytnacka.getZaciatokX(),korytnacka.getZaciatokY(),korytnacka.getVelkostPaneluKorytnacky(),korytnacka.getVelkostPaneluKorytnacky());
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void otocKorytnacku(int uhol){
        korytnacka.setHlava(uhol);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void korytnackaCuva(int dlzka, Color farba) {
        ciara=new Ciara(korytnacka,dlzka,farba,180);
        ciara.setBounds(0,0,dlzka,dlzka);
        this.add(ciara);
        korytnacka.setBounds(korytnacka.getZaciatokX(),korytnacka.getZaciatokY(),korytnacka.getVelkostPaneluKorytnacky(),korytnacka.getVelkostPaneluKorytnacky());
        SwingUtilities.updateComponentTreeUI(this);
    }
}
