package sk.stuba.fei.uim.oop.hraci;

import sk.stuba.fei.uim.oop.akcneKarty.BalicekA;

import java.util.ArrayList;
import java.util.List;

public class Hrac {
    private final List<BalicekA> karty;
    private int zivot;
    private final int index;

    public Hrac(List Karty, int index) {
        this.karty = new ArrayList<>();
        this.karty.addAll(Karty);
        this.zivot = 5;
        this.index = index;
    }

    public BalicekA getKarty(int index) {
        return karty.get(index);
    }

    public void pridajKartu(BalicekA karta) {
        karty.add(karta);
    }

    public void vymazKartu(int index) {
        karty.remove(karty.get(index));
    }

    public void znizenieZivota(){
        this.zivot--;
    }

    public int getZivot() {
        return zivot;
    }

    public int getIndex() {
        return index;
    }

    public void vypisHraca() {
        System.out.println("Na Tahu je hrac "+(this.index+1) + " s ostavajucimi "+this.zivot+ " kackami");
        System.out.println("Na ruke mas tieto karty:");
        for (int i=0;i<3;i++) {
            System.out.print(karty.get(i).getNazovKarty()+", ");
        }
        System.out.println();
    }
}


