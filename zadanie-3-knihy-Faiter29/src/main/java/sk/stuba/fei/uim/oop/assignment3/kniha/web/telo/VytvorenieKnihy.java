package sk.stuba.fei.uim.oop.assignment3.kniha.web.telo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VytvorenieKnihy {
    private Long id;
    private String name;
    private String description;
    private Long author;
    private int pages;
    private int amount;
    private int lendCount;
}
