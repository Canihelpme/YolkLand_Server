package SCA.YolkLand.Apartments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AptRepository extends JpaRepository<Apartments, Integer> {
    List<Apartments> findAllByCode(int code);
}
