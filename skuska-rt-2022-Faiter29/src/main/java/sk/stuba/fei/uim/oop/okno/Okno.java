package sk.stuba.fei.uim.oop.okno;

import sk.stuba.fei.uim.oop.okno.menu.Menu;
import sk.stuba.fei.uim.oop.okno.papier.Papier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Okno extends JFrame implements KeyListener {

    private final Menu menu;
    private final Papier papier;

    public Okno(){
        setSize(800,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        menu=new Menu(this);
        papier=new Papier(this);
        this.add(menu,BorderLayout.SOUTH);
        this.add(papier,BorderLayout.CENTER);
        setVisible(true);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int uhol=menu.getUhol().getCislo();
        if(e.getKeyCode()==KeyEvent.VK_UP){
            kresliCiaru(menu.getDlzka().getCislo(),menu.getColor().getFarba());
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            cuvat(menu.getDlzka().getCislo(),menu.getColor().getFarba());
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            otocitKorytnacku(uhol);
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            uhol=360-uhol;
            otocitKorytnacku(uhol);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void kresliCiaru(int dlzka,Color farba){
        papier.korytnackaKresli(dlzka,farba);
    }

    public void otocitKorytnacku(int uhol){
        papier.otocKorytnacku(uhol);
    }

    public void cuvat(int dlzka, Color farba){
        papier.korytnackaCuva(dlzka,farba);
    }

}
