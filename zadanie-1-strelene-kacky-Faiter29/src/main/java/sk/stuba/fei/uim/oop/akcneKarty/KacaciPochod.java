package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.neakcneKarty.BalicekS;
import sk.stuba.fei.uim.oop.neakcneKarty.Zameriavac;

import java.util.List;

public class KacaciPochod extends BalicekA{

    public KacaciPochod() {
        nazovKarty = "Kacaci Pochod";
    }

    public void pouzitKartu(List<BalicekS> baliceks, Zameriavac[] zameriavace, List<Hrac> hraci){
        BalicekS pomoc=baliceks.get(0);
        for (int i=1;i<baliceks.size();i++){
            baliceks.set(i-1,baliceks.get(i));
        }
        baliceks.set(baliceks.size()-1,pomoc);
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
