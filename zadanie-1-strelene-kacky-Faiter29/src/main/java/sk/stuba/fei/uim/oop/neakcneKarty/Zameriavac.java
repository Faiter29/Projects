package sk.stuba.fei.uim.oop.neakcneKarty;

public class Zameriavac{
    private boolean hodnota;
    private String stav;

    public Zameriavac(){
        hodnota = false;
        stav ="nezamierene";
    }

    public void nezamierene(){
        hodnota = false;
        stav ="nezamierene";
    }

    public void zamierene(){
        hodnota = true;
        stav ="zamierene";
    }

    public void vypisZamierovaca(Zameriavac zameriavac){
        System.out.print(zameriavac.stav);
    }

    public boolean hodnotaZameriavaca(Zameriavac zameriavac){
        return zameriavac.hodnota;
    }
}
