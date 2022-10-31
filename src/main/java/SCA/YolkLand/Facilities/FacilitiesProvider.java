package SCA.YolkLand.Facilities;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilitiesProvider {

    @Autowired
    FacilitiesRepository facilitiesRepository;

    public Facilities getFacilitiesInfo(int code){
        Facilities facilities = facilitiesRepository.findFacilitiesByCode(code);
        return facilities;
    }





}
