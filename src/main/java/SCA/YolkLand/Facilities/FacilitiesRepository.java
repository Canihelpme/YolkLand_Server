package SCA.YolkLand.Facilities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilitiesRepository extends JpaRepository<Facilities, Integer> {

    Facilities findFacilitiesByCode(int code);

}
