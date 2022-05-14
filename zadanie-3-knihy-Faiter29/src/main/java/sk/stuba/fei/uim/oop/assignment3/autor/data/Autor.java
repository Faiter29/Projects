package sk.stuba.fei.uim.oop.assignment3.autor.data;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Autor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ElementCollection
    private List<Long> books;

    public Autor(){
        books=new ArrayList<>();
    }
}
