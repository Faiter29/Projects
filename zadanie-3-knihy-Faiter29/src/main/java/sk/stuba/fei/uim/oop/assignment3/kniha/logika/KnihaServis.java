package sk.stuba.fei.uim.oop.assignment3.kniha.logika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.autor.logika.AutorServis;
import sk.stuba.fei.uim.oop.assignment3.kniha.data.IRepozitarKnihy;
import sk.stuba.fei.uim.oop.assignment3.kniha.data.Kniha;
import sk.stuba.fei.uim.oop.assignment3.kniha.web.telo.VytvorenieKnihy;
import sk.stuba.fei.uim.oop.assignment3.vynimky.Prazdny;

import java.util.List;

@Service
public class KnihaServis implements IKnihaServis{
    @Autowired
    private IRepozitarKnihy repozitar;
    @Autowired
    private AutorServis autorServis;

    @Autowired
    public KnihaServis(IRepozitarKnihy repozitar) {
        this.repozitar = repozitar;
    }

    @Override
    public List<Kniha> getVsetko() {
        return this.repozitar.findAll();
    }

    @Override
    public Kniha vytvorenieKnihy(VytvorenieKnihy poziadavka) throws Prazdny {
        if(poziadavka.getAuthor()==null) {
            throw new Prazdny();
        }
        if(autorServis.getAutoryId(poziadavka.getAuthor())==null) {
            throw new Prazdny();
        }
        Kniha novaKniha=new Kniha();
        novaKniha.setName(poziadavka.getName());
        novaKniha.setDescription(poziadavka.getDescription());
        novaKniha.setAuthor(poziadavka.getAuthor());
        novaKniha.setAmount(poziadavka.getAmount());
        novaKniha.setPages(poziadavka.getPages());
        novaKniha.setLendCount(poziadavka.getLendCount());
        this.repozitar.save(novaKniha);
        autorServis.pridajKnihu(poziadavka.getAuthor(),novaKniha.getId());
        return novaKniha;
    }

    @Override
    public Kniha getKnihuId(Long id) throws Prazdny{
        if(this.repozitar.findKnihaById(id)==null){
             throw new Prazdny();
        }
        return this.repozitar.findKnihaById(id);
    }

    @Override
    public Kniha zmenKnihu(Long id, VytvorenieKnihy poziadavka) throws Prazdny {
        if(this.repozitar.findKnihaById(id)==null) throw new Prazdny();
        Kniha kniha=this.getKnihuId(id);
        if(poziadavka.getName()!=null){
            kniha.setName(poziadavka.getName());
        }
        if (poziadavka.getDescription()!=null){
            kniha.setDescription(poziadavka.getDescription());
        }
        if(poziadavka.getPages()>0){
            kniha.setPages(poziadavka.getPages());
        }
        if(poziadavka.getAuthor()!=0){
            if(autorServis.getAutoryId(poziadavka.getAuthor())==null) throw new Prazdny();
            autorServis.pridajKnihu(poziadavka.getAuthor(),id);
            autorServis.vymazKnihu(this.repozitar.findKnihaById(id).getAuthor(),id);
            kniha.setAuthor(poziadavka.getAuthor());
        }
        this.repozitar.save(kniha);
        return kniha;
    }

    @Override
    public void vymazKnihuId(Long id) throws Prazdny{
        if(this.repozitar.findKnihaById(id)==null) throw new Prazdny();
        autorServis.vymazKnihu(this.getKnihuId(id).getAuthor(),id);
        this.repozitar.delete(this.getKnihuId(id));
    }

    @Override
    public int getMnozstvoId(Long id) throws Prazdny{
        if(this.repozitar.findKnihaById(id)==null){
            throw new Prazdny();
        }
        return this.repozitar.findKnihaById(id).getAmount();
    }

    @Override
    public int zvysMnozstvoId(Long id, VytvorenieKnihy poziadavka) throws Prazdny {
        if(this.repozitar.findKnihaById(id)==null){
            throw new Prazdny();
        }
        Kniha kniha=this.getKnihuId(id);
        kniha.setAmount(kniha.getAmount()+poziadavka.getAmount());
        return this.repozitar.findKnihaById(id).getAmount();
    }

    @Override
    public int getMnozstvoVypozicanych(Long id) throws Prazdny{
        if(this.repozitar.findKnihaById(id)==null){
            throw new Prazdny();
        }
        return this.repozitar.findKnihaById(id).getLendCount();
    }

    public void pridajMonzstvoVypozicanych(Kniha kniha, int i) {
        kniha.setLendCount(kniha.getLendCount()+i);
    }
}
