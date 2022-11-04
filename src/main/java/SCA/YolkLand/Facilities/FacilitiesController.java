package SCA.YolkLand.Facilities;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static SCA.YolkLand.Facilities.ResponseDTO.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fac")
public class FacilitiesController {
    private final FacilitiesProvider facilitiesProvider;

    @GetMapping("/{code}")
    public FacRes getFacilitiesByCode(@PathVariable("code") Integer code) {
        Facilities fac = facilitiesProvider.getFacilitiesInfo(code);
        int hospitalCount = fac.getHosCount()+fac.getBigHosCount();
        int schoolCount = fac.getKinderCount()+fac.getElementaryCount()+fac.getMiddleCount()+fac.getHighCount()+fac.getUnivCount();
        int transportCount = fac.getAirportCount()+fac.getTrainCount()+ fac.getTerminalCount() + fac.getSubwayCount()+fac.getBusStopCount();
        FacResultResponse res = new FacResultResponse(fac, hospitalCount, schoolCount, transportCount);

        return new FacRes(200,"시설 조회 성공", res);
    }
}
