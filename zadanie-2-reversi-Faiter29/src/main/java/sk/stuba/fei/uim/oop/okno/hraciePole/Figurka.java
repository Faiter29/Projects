package sk.stuba.fei.uim.oop.okno.hraciePole;

import javax.swing.*;
import java.awt.*;

public class Figurka extends JPanel {

    //Policko policko;
    private int farba;
    private int velkost;

    public Figurka(Policko policko, int velkost, int farba) {
        this.farba=farba;
        this.velkost=velkost;
        //this.policko=policko;
        this.setOpaque(false);
        policko.setObsadenost(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.setSize(800/velkost-70/velkost,800/velkost-70/velkost);
        kresleniefigurka(g);
    }
    private void kresleniefigurka(Graphics g) {
        if (farba==0) g.setColor(Color.WHITE);
        else g.setColor(Color.BLACK);
        g.fillOval((70/velkost)/2+5,(70/velkost)/2+5,800/velkost-(70/velkost)*2-10,800/velkost-(70/velkost)*2-10);
    }
}
