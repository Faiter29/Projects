package sk.stuba.fei.uim.oop.okno.menu;

import sk.stuba.fei.uim.oop.okno.Okno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Velkost extends JComboBox implements ActionListener {

    private int velkost;
    private Okno okno;

    public Velkost(String komponenty[],Okno okno){
        super(komponenty);
        this.okno=okno;
        velkost=6;
        addActionListener(this);
    }

    public int getIndexVelkost() {
        return velkost;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.getSelectedIndex() == 0) velkost = 6;
        else if (this.getSelectedIndex() == 1) velkost = 8;
        else if (this.getSelectedIndex() == 2) velkost = 10;
        else velkost = 12;
        this.okno.remove(okno.getHraciePole());
        this.okno.setHraciePole();
        this.okno.repaint();
    }
}
