package SCA.YolkLand.ComMarkets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static SCA.YolkLand.ComMarkets.ResponseDTO.*;

public interface ComRepository extends JpaRepository<ComMarkets, Integer> {

    //각 분기별 전체 점포 개수
    //각 분기 별 점포수 가져옴
    //프랜차이즈와 일반 점포수 비교도 필요함 -> 가능
    @Query("select cm.year as year, cm.quarter as quarter, sum(cm.marketCount) as totalMarketCount, sum(cm.franchiseCount) as totalFranchiseCount from ComMarkets cm "+
            "where cm.code = :code "+
            "GROUP BY cm.year, cm.quarter "+
            "ORDER BY cm.year")
    List<ComMarketsByCodeDto2> getComMarketsByCadCode(@Param("code") Integer code);

    /*상권의 매 분기별 개업 점포수와 폐업 점포수 점포_수 확인 */
    @Query("select cm.codeName, cm.year, cm.quarter, sum(cm.closeCount), sum(cm.openCount), sum(cm.marketCount) " +
            "from ComMarkets cm " +
            "where cm.code = ?1 " +
            "GROUP BY cm.year, cm.quarter " +
            "ORDER BY cm.year")
    List<ComMarkets> getOpenCloseMarketsByCode(int code);

    /*상권내 전체 서비스 업종의 각자 점포수 출력*/
    @Query("select cm.codeName ,cm.serviceCode, cm.serviceCodeName,sum(cm.marketCount) " +
            "from ComMarkets cm " +
            "where cm.code = ?1 and cm.year = 2022 and cm.quarter = 2 " +
            "Group By cm.serviceCode " +
            "Order by cm.serviceCode")
    List<ComMarkets> getSeveralMarketCount(int code);

    //생존율은 비교 불가
    //select 상권_코드_명,서비스_업종_코드, 서비스_업종_코드_명,sum(점포_수) as 업종별_점포_수 from com_mkt where 상권_코드 = 2120160 and 기준_년_코드 = 2022 and 기준_분기_코드 = 2 Group By 서비스_업종_코드 Order by 서비스_업종_코드;

}
