package sk.stuba.fei.uim.oop.okno.papier;

import javax.swing.*;
import java.awt.*;

public class Ciara extends JPanel {
    private final int zaciatokX;
    private final int zaciatokY;
    private final double koniecX;
    private final double koniecY;
    private final int dlzka;
    private final int otoc;
    private final Korytnacka korytnacka;
    private final Color farba;

    public Ciara(Korytnacka korytnacka,int dlzka,Color farba,int otoc){
        this.farba=farba;
        this.korytnacka=korytnacka;
        this.dlzka=dlzka;
        this.zaciatokX=korytnacka.getZaciatokX()+korytnacka.getVelkostPaneluKorytnacky()/2;
        this.zaciatokY=korytnacka.getZaciatokY()+korytnacka.getVelkostPaneluKorytnacky()/2;
        this.otoc=otoc;
        koniecX=koniecXciary();
        koniecY=koniecYciary();
        korytnacka.setZaciatokX((int)koniecX-korytnacka.getVelkostPaneluKorytnacky()/2);
        korytnacka.setZaciatokY((int)koniecY-korytnacka.getVelkostPaneluKorytnacky()/2);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        setSize(800,800);
        kresliCiaru(g);
    }

    public void kresliCiaru(Graphics g) {
        g.setColor(farba);
        g.drawLine(zaciatokX,zaciatokY,(int)koniecX,(int)koniecY);
    }

    private double koniecXciary() {
        return zaciatokX+Math.cos(Math.toRadians(korytnacka.getUhol()+otoc))*dlzka;
    }

    private double koniecYciary() {
        return zaciatokY-Math.sin(Math.toRadians(korytnacka.getUhol()+otoc))*dlzka;
    }
}
