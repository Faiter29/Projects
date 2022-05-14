package sk.stuba.fei.uim.oop.assignment3.list.logika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.kniha.logika.KnihaServis;
import sk.stuba.fei.uim.oop.assignment3.list.data.IRepozitarPozicanychKnih;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListPozicanychKnih;
import sk.stuba.fei.uim.oop.assignment3.vynimky.Prazdny;
import sk.stuba.fei.uim.oop.assignment3.vynimky.ZlyVyber;

import java.util.List;

@Service
public class PozicanieListServis implements IPozicanieListServis {

    @Autowired
    private final IRepozitarPozicanychKnih repozitar;

    @Autowired
    private KnihaServis knihaServis;

    @Autowired
    private PozicanieListServis(IRepozitarPozicanychKnih repozitar) {
        this.repozitar=repozitar;
    }

    @Override
    public List<ListPozicanychKnih> getVsetkyListy() {
        return this.repozitar.findAll();
    }

    @Override
    public ListPozicanychKnih getListId(Long id) throws Prazdny {
        if(this.repozitar.findListById(id)==null){
            throw new Prazdny();
        }
        return this.repozitar.findListById(id);
    }

    @Override
    public void vymazListId(Long id) throws Prazdny {
        if(this.repozitar.findListById(id)==null) throw new Prazdny();
        for(int i=0;i<this.repozitar.findListById(id).getLendingList().size();i++) {
            knihaServis.pridajMonzstvoVypozicanych(this.repozitar.findListById(id).getLendingList().get(i),-1);
        }
        this.repozitar.delete(this.getListId(id));
    }

    @Override
    public ListPozicanychKnih vytvorenieListu(){
        ListPozicanychKnih novyList=new ListPozicanychKnih();
        this.repozitar.save(novyList);
        return novyList;
    }

    @Override
    public ListPozicanychKnih pridatKnihuDoListu(Long id, Long idKnihy) throws Prazdny, ZlyVyber {
        if (knihaServis.getKnihuId(idKnihy)==null) throw new Prazdny();
        if (this.repozitar.findListById(id)==null) throw  new Prazdny();
        if (this.repozitar.findListById(id).isLended()) throw new ZlyVyber();
        if (this.repozitar.findListById(id).getLendingList().contains(knihaServis.getKnihuId(idKnihy))) throw  new ZlyVyber();
        ListPozicanychKnih list=this.repozitar.findListById(id);
        list.getLendingList().add(knihaServis.getKnihuId(idKnihy));
        this.repozitar.save(list);
        return list;
    }

    @Override
    public void vypozicatKnihuZListu(Long id) throws Prazdny,ZlyVyber{
        if(this.repozitar.findListById(id)==null) throw new Prazdny();
        if(this.repozitar.findListById(id).isLended())throw new ZlyVyber();
        if(this.repozitar.findListById(id).getLendingList()==null) throw new Prazdny();
        this.repozitar.findListById(id).setLended(true);
        this.repozitar.save(this.repozitar.findListById(id));
        for(int i=0;i<this.repozitar.findListById(id).getLendingList().size();i++) {
            knihaServis.pridajMonzstvoVypozicanych(this.repozitar.findListById(id).getLendingList().get(i),1);
        }

    }

    @Override
    public void odstranKnihuZListu(Long id,Long idKnihy) throws Prazdny{
        if(knihaServis.getKnihuId(idKnihy)==null || this.repozitar.findListById(id)==null) throw new Prazdny();
        ListPozicanychKnih list=this.repozitar.findListById(id);
        list.getLendingList().remove(knihaServis.getKnihuId(idKnihy));
        this.repozitar.save(list);
    }
}
