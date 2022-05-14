package sk.stuba.fei.uim.oop.assignment3.kniha.logika;

import sk.stuba.fei.uim.oop.assignment3.kniha.data.Kniha;
import sk.stuba.fei.uim.oop.assignment3.kniha.web.telo.VytvorenieKnihy;
import sk.stuba.fei.uim.oop.assignment3.vynimky.Prazdny;

import java.util.List;

public interface IKnihaServis {
    List<Kniha> getVsetko();

    Kniha vytvorenieKnihy(VytvorenieKnihy poziadavka) throws Prazdny;

    Kniha getKnihuId(Long id) throws Prazdny;

    Kniha zmenKnihu(Long id, VytvorenieKnihy poziadavka) throws Prazdny;

    void vymazKnihuId(Long id) throws Prazdny;

    int getMnozstvoId(Long id) throws Prazdny;

    int zvysMnozstvoId(Long id,VytvorenieKnihy poziadavka) throws Prazdny;

    int getMnozstvoVypozicanych(Long id) throws Prazdny;
}
