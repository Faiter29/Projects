package sk.stuba.fei.uim.oop.assignment3.autor.logika;

import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;
import sk.stuba.fei.uim.oop.assignment3.autor.web.telo.VytvorenieAutora;
import sk.stuba.fei.uim.oop.assignment3.vynimky.Prazdny;

import java.util.List;

public interface IAutorServis {

    List<Autor> getVsetko();
    Autor vytvorit(VytvorenieAutora poziadavka);
    Autor getAutoryId(Long id) throws Prazdny;
    Autor zmenAutorId(Long id,VytvorenieAutora zmenAutor) throws Prazdny;
    void vymazAutoraId(Long id) throws Prazdny;
    void pridajKnihu(Long idAutor,Long idKnihy);
    void vymazKnihu(Long idAutor,Long idKnihy);
}
