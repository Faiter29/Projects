package sk.stuba.fei.uim.oop.assignment3.kniha.web.telo;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.kniha.data.Kniha;

@Getter
public class DostatKnihu {
    private final Long id;

    private final String name;
    private final String description;
    private final Long author;
    private final int pages;
    private final int amount;
    private final int lendCount;

    public DostatKnihu(Kniha k){
        this.id= k.getId();
        this.name=k.getName();
        this.description=k.getDescription();
        this.author=k.getAuthor();
        this.pages=k.getPages();
        this.amount=k.getAmount();
        this.lendCount=k.getLendCount();
    }
}
