package SCA.YolkLand.Area;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaProvider {

    @Autowired
    AreaRepository areaRepository;

    public List<Areas> getAreasInfo(Integer code, String cadName){
        List<Areas> areas = areaRepository.findAreasByCodeAndCadName(code, cadName);
        return areas;
    }

    public List<Areas> getAllAreasInfo(){
        List<Areas> areas = areaRepository.findAll();
        return areas;
    }
}
