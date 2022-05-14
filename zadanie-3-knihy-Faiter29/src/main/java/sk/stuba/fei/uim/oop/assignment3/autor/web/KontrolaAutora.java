package sk.stuba.fei.uim.oop.assignment3.autor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.autor.logika.IAutorServis;
import sk.stuba.fei.uim.oop.assignment3.autor.web.telo.DostatAutora;
import sk.stuba.fei.uim.oop.assignment3.autor.web.telo.VytvorenieAutora;
import sk.stuba.fei.uim.oop.assignment3.vynimky.Prazdny;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class KontrolaAutora {

    @Autowired
    private IAutorServis servis;

    @GetMapping()
    public List<DostatAutora> getVsetkychAutorov(){
        return this.servis.getVsetko().stream().map(DostatAutora::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<DostatAutora> pridatAutora(@RequestBody VytvorenieAutora poziadavka){
        return new ResponseEntity<>(new DostatAutora(this.servis.vytvorit(poziadavka)), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public DostatAutora getAutoryId(@PathVariable Long id) throws Prazdny {
        return new DostatAutora(this.servis.getAutoryId(id));
    }
    @PutMapping("/{id}")
    public DostatAutora getAutoryID(@PathVariable Long id,@RequestBody VytvorenieAutora poziadavka) throws Prazdny{
        return new DostatAutora(this.servis.zmenAutorId(id,poziadavka));
    }
    @DeleteMapping("/{id}")
    public void vymazAutoraId(@PathVariable Long id) throws Prazdny{
        this.servis.vymazAutoraId(id);
    }
}
