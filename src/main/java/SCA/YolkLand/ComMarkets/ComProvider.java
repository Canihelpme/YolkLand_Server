package SCA.YolkLand.ComMarkets;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static SCA.YolkLand.ComMarkets.ResponseDTO.*;

@Service
@RequiredArgsConstructor
public class ComProvider {
    @Autowired
    private ComRepository comRepository;
    public List<ComMarketsByCodeDto2> getComMarketsByCode(Integer code) {
        List<ComMarketsByCodeDto2> comMarkets = comRepository.getComMarketsByCadCode(code);
        System.out.println(comMarkets.getClass().getFields());
        return comMarkets;
    }

    public List<ComMarkets> getOpenCloseMarketsByCode(Integer code){
        List<ComMarkets> comMarkets = comRepository.getOpenCloseMarketsByCode(code);
        return comMarkets;
    }

    public List<ComMarkets> getSeveralMarketCount(Integer code){
        List<ComMarkets> comMarkets = comRepository.getSeveralMarketCount(code);
        return comMarkets;
    }


}
