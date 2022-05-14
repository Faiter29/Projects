package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.neakcneKarty.BalicekS;
import sk.stuba.fei.uim.oop.neakcneKarty.Zameriavac;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.List;

public class DivokyBill extends BalicekA{

    public DivokyBill() {
        nazovKarty = "Divoky Bill";
    }

    @Override
    public void pouzitKartu(List<BalicekS> baliceks, Zameriavac[] zameriavace, List<Hrac> hraci){
        int index= ZKlavesnice.readInt("Zadaj index kacky, ktoru chces zastrelit (1-6).")-1;
        while(index<0 || index>5){
            index=ZKlavesnice.readInt("Zly index rybnika, skus to znova")-1;
        }
        if(baliceks.get(index).getKarta().contains("VODA")) zameriavace[index].nezamierene();
        else{
            hraci.get(baliceks.get(index).getIndex()-1).znizenieZivota();
            baliceks.remove(baliceks.get(index));
            zameriavace[index].nezamierene();
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
