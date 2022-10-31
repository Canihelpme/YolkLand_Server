package SCA.YolkLand.Apartments;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

import static SCA.YolkLand.Apartments.ResponseDTOs.*;

@Service
@RequiredArgsConstructor
public class AptProvider {
    @Autowired
    AptRepository aptRepository;

    /**
     * 상권별 배후지 아파트 전체 정보 전송
     * @param code
     * @return
     */
    public List<Apartments> getApartmentsInfo(Integer code){
        List<Apartments> apts = aptRepository.findAllByCode(code);
        return apts;
    }

    /**
     * //총 가구수 합 및 직전 분기대비 세대수 증감, 가장 많은 타입, 가장 많은 가격대 모두 반환하는 함수
     * @param top(현재 분기 아파트 세대수 총합)
     * @param last(직전 분기 아파트 세대수 총합)
     * @return
     */

    public TicDto totalService(Apartments top, Apartments last) throws NoSuchFieldException, IllegalAccessException {
        //Add all name of fields at top class to total2 array.
        int topRes = CalIncDec(top), lastRes = CalIncDec(last), incDec = 0;
        String mostType = calMostType(top), mostPrice = calMostPrice(top);

        if ((topRes - lastRes) > 0){
            incDec = 1;
        }else if((topRes - lastRes) == 0){
            incDec = 2;
        }else{
            incDec = 3;
        }

        return new TicDto(topRes, incDec, mostType, mostPrice);
    }

    private int CalIncDec(Apartments apt) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> mostAmountTotal = new ArrayList<>();
        int Res = 0, val = 0;
        Field resField;

        for(Field field : apt.getClass().getDeclaredFields()){
            String name = field.getName();
            if (name == "apt0" || name == "apt1" || name == "apt2" || name == "apt3" || name == "apt4" || name == "apt5" || name == "apt6") {
                //Add specific field's value to total array
                resField = apt.getClass().getDeclaredField(name);
                resField.setAccessible(true);
                val = (int)resField.get(apt);
                mostAmountTotal.add(val);
            }
        }
        for(int i : mostAmountTotal){
            Res += i;
        }
        return Res;
    }

    /**
     * 가장 많은 평형 구하는 Method
     * @Param top(현재 분기 아파트 Domain)
     */
    private String calMostType(Apartments top) throws NoSuchFieldException, IllegalAccessException {
        int val = 0;
        String name, maxKey;
        Field resField;
        HashMap<String, Integer> mostTypeTotalMap = new HashMap<>();

        for(Field field : top.getClass().getDeclaredFields()) {
            name = field.getName();
            if (name == "apt66Under" || name == "apt66" || name == "apt99" || name == "apt132" || name == "apt165") {
                resField = top.getClass().getDeclaredField(name);
                resField.setAccessible(true);
                val = (int) resField.get(top);
                mostTypeTotalMap.put(name, val);
            }
        }

        maxKey = mostTypeTotalMap.keySet().stream()
                .max(Comparator.comparing(mostTypeTotalMap::get))
                .orElse(null);
        return maxKey;
    }

    private String calMostPrice(Apartments top) throws NoSuchFieldException, IllegalAccessException {
        int val = 0;
        Field resField;
        String name, maxKey;
        HashMap<String, Integer> mostPriceTotalMap = new HashMap<>();

        for(Field field : top.getClass().getDeclaredFields()){
            name = field.getName();
            if(name == "apt0" || name == "apt1" || name == "apt2" || name == "apt3" || name == "apt4" || name == "apt5" || name == "apt6"){
                resField = top.getClass().getDeclaredField(name);
                resField.setAccessible(true);
                val = (int) resField.get(top);
                mostPriceTotalMap.put(name, val);
            }
        }
        maxKey = mostPriceTotalMap.keySet().stream()
                .max(Comparator.comparing(mostPriceTotalMap::get))
                .orElse(null);
        return maxKey;
    }
}
