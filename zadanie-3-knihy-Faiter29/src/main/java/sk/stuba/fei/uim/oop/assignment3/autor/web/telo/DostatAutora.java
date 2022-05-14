package sk.stuba.fei.uim.oop.assignment3.autor.web.telo;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;

import java.util.List;

@Getter
public class DostatAutora {
    private final Long id;
    private final String name;
    private final String surname;
    private final List<Long> books;

    public DostatAutora(Autor a){
        this.id= a.getId();
        this.name=a.getName();
        this.surname= a.getSurname();
        this.books=a.getBooks();
    }

}
