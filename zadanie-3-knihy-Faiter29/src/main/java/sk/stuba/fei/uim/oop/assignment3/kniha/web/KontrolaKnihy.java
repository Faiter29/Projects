package sk.stuba.fei.uim.oop.assignment3.kniha.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.kniha.logika.IKnihaServis;
import sk.stuba.fei.uim.oop.assignment3.kniha.web.telo.DostatKnihu;
import sk.stuba.fei.uim.oop.assignment3.kniha.web.telo.Pocet;
import sk.stuba.fei.uim.oop.assignment3.kniha.web.telo.VytvorenieKnihy;
import sk.stuba.fei.uim.oop.assignment3.vynimky.Prazdny;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class KontrolaKnihy {
    @Autowired
    private IKnihaServis servis;

    @GetMapping()
    public List<DostatKnihu> getVsetkyKnihy(){
        return this.servis.getVsetko().stream().map(DostatKnihu::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<DostatKnihu> pridatKnihu(@RequestBody VytvorenieKnihy poziadavka) throws Prazdny{
        return new ResponseEntity<>(new DostatKnihu(this.servis.vytvorenieKnihy(poziadavka)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public DostatKnihu getKnihyId(@PathVariable Long id) throws Prazdny {
        return new DostatKnihu(this.servis.getKnihuId(id));
    }

    @PutMapping("/{id}")
    public DostatKnihu getKnihyID(@PathVariable Long id,@RequestBody VytvorenieKnihy poziadavka) throws Prazdny{
        return new DostatKnihu(this.servis.zmenKnihu(id,poziadavka));
    }

    @DeleteMapping("/{id}")
    public void vymazKnihuId(@PathVariable Long id) throws Prazdny{
        this.servis.vymazKnihuId(id);
    }

    @GetMapping ({ "/{id}/amount"})
    public Pocet dajMnozstvo(@PathVariable Long id) throws Prazdny{
        return new Pocet(this.servis.getMnozstvoId(id));
    }

    @PostMapping ({ "/{id}/amount"})
    public Pocet zvysMnozstvo(@PathVariable Long id,@RequestBody VytvorenieKnihy poziadavka) throws Prazdny{
        return new Pocet(this.servis.zvysMnozstvoId(id,poziadavka));
    }

    @GetMapping ({ "/{id}/lendCount"})
    public Pocet dajMnozstvoPozicanych(@PathVariable Long id) throws Prazdny{
        return new Pocet(this.servis.getMnozstvoVypozicanych(id));
    }
}
