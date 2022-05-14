package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.neakcneKarty.BalicekS;
import sk.stuba.fei.uim.oop.neakcneKarty.Zameriavac;

import java.util.Collections;
import java.util.List;

public class KacaciTanec extends BalicekA{

    public KacaciTanec() {
        nazovKarty = "Kacaci Tanec";
    }

    @Override
    public void pouzitKartu(List<BalicekS> baliceks, Zameriavac[] zameriavace, List<Hrac> hraci) {
        Collections.shuffle(baliceks);
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
