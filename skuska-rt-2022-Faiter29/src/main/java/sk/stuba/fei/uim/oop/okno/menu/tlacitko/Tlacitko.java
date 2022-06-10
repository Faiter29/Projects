package sk.stuba.fei.uim.oop.okno.menu.tlacitko;

import sk.stuba.fei.uim.oop.okno.Okno;
import sk.stuba.fei.uim.oop.okno.menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tlacitko extends JButton implements ActionListener {

    private final Menu menu;
    private final Okno okno;
    private Color farba;
    private int farbicka;

    public Tlacitko(String nazov, Menu menu, Okno okno){

        super(nazov);
        this.menu=menu;
        this.okno=okno;
        farbicka=1;
        farba=Color.black;
        setFocusable(false);
        menu.setInfofarba(farba);
        addActionListener(this);
    }

    public Color getFarba() {
        return farba;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("AKCIA")){
            okno.otocitKorytnacku(menu.getUhol().getCislo());
            okno.kresliCiaru(menu.getDlzka().getCislo(),menu.getColor().getFarba());
        }
        else if(e.getActionCommand().equals("FARBA")){
            farbicka++;
            if(farbicka>3) farbicka=1;
            if (farbicka==1) farba=Color.black;
            if (farbicka==2) farba=Color.blue;
            if (farbicka==3) farba=Color.MAGENTA;
            //Color help=farba;
            //farba = JColorChooser.showDialog(this, "Paleta", farba);
            //if(farba==null) farba=help;
            menu.setInfofarba(farba);
        }
    }
}
