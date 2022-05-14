package sk.stuba.fei.uim.oop.assignment3.list.data;

import lombok.Data;
import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.kniha.data.Kniha;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
public class ListPozicanychKnih {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Kniha> lendingList;
    private boolean lended;

    public ListPozicanychKnih(){
        lendingList=new ArrayList<>();
    }
    public ListPozicanychKnih(ListPozicanychKnih listPozicanychKnih) {
        this.id=listPozicanychKnih.getId();
        this.lendingList=listPozicanychKnih.getLendingList();
        this.lended =listPozicanychKnih.isLended();
    }
}
