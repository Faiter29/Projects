package sk.stuba.fei.uim.oop.behHry;

import sk.stuba.fei.uim.oop.okno.hraciePole.Policko;

import javax.swing.*;
import java.awt.*;

public class VykresliTah extends JPanel {

    private int dlzka;
    private Policko policko;

    public VykresliTah(int dlzka) {
        //this.farba=farba;
        this.dlzka=dlzka;
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.fillOval((70/dlzka)*2+700/(dlzka*10),(70/dlzka)*2+700/(dlzka*10),800/dlzka-(70/dlzka)*5-10,800/dlzka-(70/dlzka)*5-10);
    }
}
