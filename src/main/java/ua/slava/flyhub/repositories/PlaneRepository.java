package ua.slava.flyhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.slava.flyhub.domen.models.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
    Plane findByName(String name);

}
