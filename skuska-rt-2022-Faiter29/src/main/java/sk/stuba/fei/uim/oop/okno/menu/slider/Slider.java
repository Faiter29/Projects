package sk.stuba.fei.uim.oop.okno.menu.slider;

import sk.stuba.fei.uim.oop.okno.menu.Menu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JSlider implements ChangeListener {

    private final Menu menu;
    private int cislo;

    public Slider(Menu menu){
        this.menu=menu;
        setMinimum(0);
        setMaximum(100);
        setValue(10);
        cislo=10;
        setFocusable(false);
        setMinorTickSpacing(10);
        setMajorTickSpacing(10);
        setSnapToTicks(true);
        setPaintTicks(true);
        setPaintLabels(true);
        menu.setInfo1(String.valueOf(this.getValue()));
        menu.setInfo();
        addChangeListener(this);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        menu.setInfo1(String.valueOf(this.getValue()));
        cislo=this.getValue();
        menu.setInfo();
    }

    public int getCislo() {
        return cislo;
    }
}
