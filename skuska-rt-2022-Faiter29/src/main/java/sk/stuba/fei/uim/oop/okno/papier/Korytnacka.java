package sk.stuba.fei.uim.oop.okno.papier;

import sk.stuba.fei.uim.oop.okno.Okno;

import javax.swing.*;
import java.awt.*;

public class Korytnacka extends JPanel {

    Okno okno;
    private int zaciatokX;
    private int zaciatokY;
    private int uhol;
    private final int velkostPaneluKorytnacky;
    private final int velkostTelaKorytnacky;
    private final int velkostHlavyKorytnacky;
    private int hlavaX;
    private int hlavaY;

    public Korytnacka(Okno okno){
        this.okno=okno;
        zaciatokX=350;
        zaciatokY=250;
        uhol=90;
        velkostPaneluKorytnacky=82;
        velkostHlavyKorytnacky=18;
        velkostTelaKorytnacky=46;
        setOpaque(false);
        hlavaX=velkostPaneluKorytnacky/2-velkostHlavyKorytnacky/2;
        hlavaY =velkostHlavyKorytnacky-velkostHlavyKorytnacky/2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setSize(new Dimension(velkostPaneluKorytnacky,velkostPaneluKorytnacky));
        kresliKorytnacku(g);
    }

    public void kresliKorytnacku(Graphics g){
        g.setColor(new Color(0,80,0));
        g.fillOval(velkostHlavyKorytnacky,velkostHlavyKorytnacky,velkostTelaKorytnacky,velkostTelaKorytnacky);
        g.setColor(Color.GREEN);
        g.fillOval(hlavaX,hlavaY,velkostHlavyKorytnacky,velkostHlavyKorytnacky);
    }

    public int getZaciatokX() {
        return zaciatokX;
    }

    public int getZaciatokY() {
        return zaciatokY;
    }

    public int getVelkostPaneluKorytnacky() {
        return velkostPaneluKorytnacky;
    }

    public void setHlava(int uhol) {
        setUhol(uhol);
        int pomoc=velkostPaneluKorytnacky/2-velkostHlavyKorytnacky/2;
        hlavaX= (int) (pomoc+Math.cos(Math.toRadians(this.uhol))*velkostTelaKorytnacky/2);
        hlavaY= (int) (pomoc-Math.sin(Math.toRadians(this.uhol))*velkostTelaKorytnacky/2);
    }


    public void setZaciatokX(int zaciatokX) {
        this.zaciatokX = zaciatokX;
    }

    public void setZaciatokY(int zaciatokY) {
        this.zaciatokY = zaciatokY;
    }

    public void setUhol(int uhol) {
        this.uhol = this.uhol+uhol;
        if(this.uhol>=360) this.uhol=this.uhol-360;
    }

    public int getUhol() {
        return uhol;
    }
}
