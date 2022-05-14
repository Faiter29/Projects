package sk.stuba.fei.uim.oop.okno;

import sk.stuba.fei.uim.oop.behHry.Hra;
import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.okno.hraciePole.HraciePole;
import sk.stuba.fei.uim.oop.okno.menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Okno extends JFrame implements KeyListener {

    private Hra hra;
    private HraciePole hraciePole;
    private Menu menu;
    private Hrac pocitac;
    private Hrac hrac;

    public Menu getMenu() {
        return menu;
    }

    public HraciePole getHraciePole() {
        return hraciePole;
    }

    public Hra getHra() {
        return hra;
    }

    public void setHraciePole() {
        this.remove(this.hraciePole);
        hra.getFigurkyMoznychTahov().clear();
        hraciePole.getHracpole().clear();
        hraciePole.getPocitacpole().clear();
        this.hraciePole = new HraciePole(menu.getVelkost().getIndexVelkost(), this, 0,hrac,pocitac);
        this.add(hraciePole);
        hra.kontrolaTahu(hrac.getPolickaHraca(),pocitac);
        pocitac.resetPolicok();
        hrac.resetPolicok();
        SwingUtilities.updateComponentTreeUI(this);
    }

    public Okno(Hra hra, Hrac pocitac, Hrac hrac) {

        setSize(800, 860);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.hra = hra;
        this.hrac=hrac;
        this.pocitac=pocitac;
        menu = new Menu(this);
        add(menu, BorderLayout.PAGE_START);
        hraciePole = new HraciePole(menu.getVelkost().getIndexVelkost(), this, 0,hrac,pocitac);
        add(hraciePole, BorderLayout.CENTER);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_R) setHraciePole();
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE) System.exit(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
