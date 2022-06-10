package sk.stuba.fei.uim.oop.okno.menu.vyberMoznosti;

import sk.stuba.fei.uim.oop.okno.menu.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class VyberMoznosti extends JComboBox implements ActionListener {

    private final Menu menu;
    private int cislo;

    public VyberMoznosti(String[] strings,Menu menu){
        super(strings);
        this.menu=menu;
        this.setSelectedIndex(3);
        this.menu.setInfo2(Objects.requireNonNull(this.getSelectedItem()).toString());
        cislo=45;
        setFocusable(false);
        menu.setInfo();
        addActionListener(this);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        this.menu.setInfo2(Objects.requireNonNull(this.getSelectedItem()).toString());
        cislo= Integer.parseInt(this.getSelectedItem().toString());
        menu.setInfo();
    }

    public int getCislo() {
        return cislo;
    }
}

