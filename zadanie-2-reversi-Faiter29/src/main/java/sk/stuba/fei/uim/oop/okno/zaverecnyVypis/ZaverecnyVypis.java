package sk.stuba.fei.uim.oop.okno.zaverecnyVypis;

import javax.swing.*;

public class ZaverecnyVypis extends JFrame {
    public ZaverecnyVypis(int vitaz){
        super("Vitaz");
        if(vitaz==0) JOptionPane.showMessageDialog(this,"Prehral si");
        if(vitaz==2) JOptionPane.showMessageDialog(this,"Vyhral si");
        if(vitaz==1) JOptionPane.showMessageDialog(this,"Remiza");
    }
}
