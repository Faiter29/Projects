package sk.stuba.fei.uim.oop.assignment3.autor.logika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;
import sk.stuba.fei.uim.oop.assignment3.autor.data.IRepozitarAutora;
import sk.stuba.fei.uim.oop.assignment3.autor.web.telo.VytvorenieAutora;
import sk.stuba.fei.uim.oop.assignment3.kniha.logika.KnihaServis;
import sk.stuba.fei.uim.oop.assignment3.vynimky.Prazdny;

import java.util.List;

@Service
public class AutorServis implements IAutorServis {

    @Autowired
    private IRepozitarAutora repozitar;

    @Autowired
    public AutorServis(IRepozitarAutora repozitar) {
        this.repozitar = repozitar;
    }
    @Autowired
    private KnihaServis knihaServis;

    @Override
    public List<Autor> getVsetko(){
        return this.repozitar.findAll();
    }

    @Override
    public Autor vytvorit(VytvorenieAutora poziadavka){
        Autor novyAutor=new Autor();
        novyAutor.setName(poziadavka.getName());
        novyAutor.setSurname(poziadavka.getSurname());
        return this.repozitar.save(novyAutor);
    }

    @Override
    public Autor getAutoryId(Long id) throws Prazdny {
        if(this.repozitar.findAutoryById(id)==null){
            throw new Prazdny();
        }
        return this.repozitar.findAutoryById(id);
    }

    @Override
    public Autor zmenAutorId(Long id,VytvorenieAutora poziadavka) throws Prazdny {
        Autor autor=this.getAutoryId(id);
        if(poziadavka.getName()!=null){
            autor.setName(poziadavka.getName());
        }
        if(poziadavka.getSurname()!=null){
            autor.setSurname(poziadavka.getSurname());
        }
        this.repozitar.save(autor);
        return autor;
    }

    @Override
    public void vymazAutoraId(Long id) throws Prazdny{
        if(this.repozitar.findAutoryById(id)==null) throw new Prazdny();
        int pomoc=this.repozitar.findAutoryById(id).getBooks().size()-1;
        for(int i = pomoc; i>=0; i--){
            knihaServis.vymazKnihuId(this.repozitar.findAutoryById(id).getBooks().get(i));
        }
        this.repozitar.delete(this.getAutoryId(id));
    }

    @Override
    public void pridajKnihu(Long idAutor, Long idKnihy){
        Autor autor=repozitar.findAutoryById(idAutor);
        autor.getBooks().add(idKnihy);
        this.repozitar.save(autor);
    }

    @Override
    public void vymazKnihu(Long idAutor,Long idKnihy){
        Autor autor=repozitar.findAutoryById(idAutor);
        autor.getBooks().remove(idKnihy);
        this.repozitar.save(autor);
    }

}
