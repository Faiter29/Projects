package sk.stuba.fei.uim.oop.okno.menu;

import sk.stuba.fei.uim.oop.okno.Okno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Farba extends JComboBox implements ActionListener {

    private int indexFarba;
    private Okno okno;

    public Farba(String komponenty[],Okno okno){
        super(komponenty);
        indexFarba=0;
        this.okno=okno;
        addActionListener(this);
    }

    public int getIndexFarba(){
        return indexFarba;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        indexFarba=this.getSelectedIndex();
        this.okno.remove(okno.getHraciePole());
        this.okno.setHraciePole();
        this.okno.repaint();
    }
}
