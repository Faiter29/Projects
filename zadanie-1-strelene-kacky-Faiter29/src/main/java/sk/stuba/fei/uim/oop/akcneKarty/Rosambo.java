package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.neakcneKarty.BalicekS;
import sk.stuba.fei.uim.oop.neakcneKarty.Zameriavac;

import java.util.Collections;
import java.util.List;

public class Rosambo extends BalicekA{

    public Rosambo(){
        nazovKarty="Rosambo";
    }

    @Override
    public void pouzitKartu(List<BalicekS> baliceks, Zameriavac[] zameriavace, List<Hrac> hraci){
        Collections.shuffle(baliceks.subList(0,6));
    }

    public boolean skuskaKarty(Zameriavac[] zameriavace){
        pravdivostPouzitia=true;
        return pravdivostPouzitia;
    }

    @Override
    public String getNazovKarty() {
        return nazovKarty;
    }
}
