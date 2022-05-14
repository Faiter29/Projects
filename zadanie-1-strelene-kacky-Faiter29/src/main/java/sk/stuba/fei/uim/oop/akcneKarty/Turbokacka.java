package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.neakcneKarty.BalicekS;
import sk.stuba.fei.uim.oop.neakcneKarty.Zameriavac;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.List;

public class Turbokacka extends BalicekA{

    public Turbokacka(){
        nazovKarty="Turbokacka";
    }

    @Override
    public void pouzitKartu(List<BalicekS> baliceks, Zameriavac[] zameriavace, List<Hrac> hraci){
        int index= ZKlavesnice.readInt("Zadaj index kacky, ktoru chces posunut (1-6).")-1;
        while(index<0 || index>5){
            index=ZKlavesnice.readInt("Zly index rybnika, skus to znova");
        }
        while(true) {
            if(baliceks.get(index).getIndex()!=0) {
                BalicekS pomoc = baliceks.get(index);
                for (int i = index - 1; i >= 0; i--) {
                    baliceks.set(i + 1, baliceks.get(i));
                }
                baliceks.set(0, pomoc);
                break;
            }
            else index=ZKlavesnice.readInt("Zadaj index, s kackou!")-1;
        }
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
