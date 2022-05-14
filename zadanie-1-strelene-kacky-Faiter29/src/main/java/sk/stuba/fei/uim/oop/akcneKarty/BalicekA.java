package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.neakcneKarty.BalicekS;
import sk.stuba.fei.uim.oop.neakcneKarty.Zameriavac;

import java.util.List;

public abstract class BalicekA {
    protected String nazovKarty;
    protected boolean pravdivostPouzitia;

    public String getNazovKarty() {
        return nazovKarty;
    }

    public boolean skuskaKarty(Zameriavac[] zameriavace){
        return pravdivostPouzitia;
    }

    public abstract void pouzitKartu(List<BalicekS> baliceks, Zameriavac[] zameriavace, List<Hrac> hraci);

}
