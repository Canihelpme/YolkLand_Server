package SCA.YolkLand.Area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static SCA.YolkLand.Area.ResponseDTOs.*;

public interface AreaRepository extends JpaRepository<Areas, Integer> {

    List<Areas> findAreasByCode(int code);

    List<Areas> findAreasByCodeAndCadName(int code, String codeName);

    List<Areas> findAll();

}
