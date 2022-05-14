package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.hraci.Hrac;
import sk.stuba.fei.uim.oop.neakcneKarty.BalicekS;
import sk.stuba.fei.uim.oop.neakcneKarty.Zameriavac;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.List;

public class Vystrelit extends BalicekA {

    public Vystrelit() {
        nazovKarty = "Vystrelit";
    }

    @Override
    public void pouzitKartu(List<BalicekS> baliceks, Zameriavac[] zameriavace, List<Hrac> hraci){
        int index= ZKlavesnice.readInt("Zadaj index miesta, kde chces strielat (1-6).")-1;
        while(index<0 || index>5){
            index=ZKlavesnice.readInt("Zly index rybnika, skus to znova");
        }
        while(true) {
            if (zameriavace[index].hodnotaZameriavaca(zameriavace[index])) {
                zameriavace[index].nezamierene();
                if(baliceks.get(index).getKarta().contains("Kacka")) {
                    hraci.get(baliceks.get(index).getIndex()-1).znizenieZivota();
                    baliceks.remove(baliceks.get(index));
                }
                break;
            }
            else index=ZKlavesnice.readInt("Zadaj index, kde je namierene!")-1;
        }
    }

    public boolean skuskaKarty(Zameriavac[] zameriavace){
        int pocet=0;
        for (int i=0;i<6;i++){
            if((zameriavace[i].hodnotaZameriavaca(zameriavace[i]))) pocet++;
        }
        if (pocet==0) pravdivostPouzitia=false;
        else pravdivostPouzitia=true;
        return pravdivostPouzitia;
    }

    @Override
    public String getNazovKarty() {
        return nazovKarty;
    }
}
