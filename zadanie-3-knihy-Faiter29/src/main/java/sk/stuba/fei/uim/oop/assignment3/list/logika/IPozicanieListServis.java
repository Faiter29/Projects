package sk.stuba.fei.uim.oop.assignment3.list.logika;

import sk.stuba.fei.uim.oop.assignment3.list.data.ListPozicanychKnih;
import sk.stuba.fei.uim.oop.assignment3.vynimky.Prazdny;
import sk.stuba.fei.uim.oop.assignment3.vynimky.ZlyVyber;

import java.util.List;

public interface IPozicanieListServis{

    List<ListPozicanychKnih> getVsetkyListy();

    void vymazListId(Long id) throws Prazdny;

    ListPozicanychKnih vytvorenieListu();

    ListPozicanychKnih pridatKnihuDoListu(Long id, Long idKnihy) throws Prazdny, ZlyVyber;

    void vypozicatKnihuZListu(Long id)throws Prazdny,ZlyVyber;

    void odstranKnihuZListu(Long id,Long idKnihy) throws Prazdny;

    ListPozicanychKnih getListId(Long id) throws Prazdny;
}
