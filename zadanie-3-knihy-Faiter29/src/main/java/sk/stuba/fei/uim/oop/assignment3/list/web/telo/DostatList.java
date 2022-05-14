package sk.stuba.fei.uim.oop.assignment3.list.web.telo;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.kniha.data.Kniha;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListPozicanychKnih;

import java.util.List;

@Getter
public class DostatList {
    private final Long id;
    private final List<Kniha> lendingList;
    private final boolean lended;

    public DostatList(ListPozicanychKnih p){
        this.id= p.getId();
        this.lendingList=p.getLendingList();
        this.lended=p.isLended();
    }

}
