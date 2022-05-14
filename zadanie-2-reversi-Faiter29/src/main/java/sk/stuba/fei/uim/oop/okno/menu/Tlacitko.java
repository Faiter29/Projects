package sk.stuba.fei.uim.oop.okno.menu;

import sk.stuba.fei.uim.oop.okno.Okno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tlacitko extends JButton implements ActionListener {

    private Okno okno;

    public Tlacitko(String nazov,Okno okno){
        super(nazov);
        this.okno=okno;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("KONIEC")) System.exit(0);
        else {
            this.okno.setHraciePole();
            this.okno.repaint();
        }
    }
}
