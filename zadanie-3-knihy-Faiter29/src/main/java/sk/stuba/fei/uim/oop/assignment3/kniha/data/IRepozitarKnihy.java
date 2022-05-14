package sk.stuba.fei.uim.oop.assignment3.kniha.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepozitarKnihy extends JpaRepository<Kniha, Long> {
    Kniha findKnihaById(Long id);
}
