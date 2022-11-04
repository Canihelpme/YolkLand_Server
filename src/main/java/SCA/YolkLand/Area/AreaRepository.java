package SCA.YolkLand.Area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static SCA.YolkLand.Area.ResponseDTOs.*;

public interface AreaRepository extends JpaRepository<Areas, Integer> {

    List<Areas> findAreasByCode(@Param("code") Integer code);

}
