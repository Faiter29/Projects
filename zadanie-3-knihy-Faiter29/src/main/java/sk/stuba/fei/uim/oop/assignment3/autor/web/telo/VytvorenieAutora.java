package sk.stuba.fei.uim.oop.assignment3.autor.web.telo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VytvorenieAutora {
    private Long id;
    private String surname;
    private String name;
    private List<Long> books;
}
