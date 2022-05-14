package sk.stuba.fei.uim.oop.assignment3.list.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListPozicanychKnih;
import sk.stuba.fei.uim.oop.assignment3.list.logika.IPozicanieListServis;
import sk.stuba.fei.uim.oop.assignment3.list.web.telo.DostatList;
import sk.stuba.fei.uim.oop.assignment3.list.web.telo.IDknihy;
import sk.stuba.fei.uim.oop.assignment3.vynimky.Prazdny;
import sk.stuba.fei.uim.oop.assignment3.vynimky.ZlyVyber;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class KontrolaListuPozicania {
    @Autowired
    private IPozicanieListServis servis;

    @GetMapping()
    public List<ListPozicanychKnih> getVsetkyListy(){
        return this.servis.getVsetkyListy().stream().map(ListPozicanychKnih::new).collect(Collectors.toList());
    }
    @PostMapping()
    public ResponseEntity<DostatList> vytvoritList(){
        return new ResponseEntity<>(new DostatList(this.servis.vytvorenieListu()), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public DostatList getVsetkyListy(@PathVariable Long id) throws Prazdny{
        return new DostatList(this.servis.getListId(id));
    }
    @DeleteMapping("/{id}")
    public void vymazatList(@PathVariable Long id) throws Prazdny{
        this.servis.vymazListId(id);
    }
    @PostMapping("/{id}/add")
    public DostatList pridatKnihuDoListu(@PathVariable Long id, @RequestBody IDknihy idKnihy) throws Prazdny, ZlyVyber {
        return new DostatList(this.servis.pridatKnihuDoListu(id,idKnihy.getId()));
    }
    @DeleteMapping("/{id}/remove")
    public void vymazatKnihuZListu(@PathVariable Long id, @RequestBody IDknihy idKnihy) throws Prazdny{
        this.servis.odstranKnihuZListu(id,idKnihy.getId());

    }
    @GetMapping("/{id}/lend")
    public void vypozicatKnihuZPozickovehoListu(@PathVariable Long id) throws Prazdny,ZlyVyber{
        this.servis.vypozicatKnihuZListu(id);
    }
}