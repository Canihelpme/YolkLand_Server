package SCA.YolkLand.Facilities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "back_fac_v2")
public class Facilities {

    @Id
    private int id;

    @Column(name = "기준_년_코드")
    private int year;

    @Column(name = "기준_분기_코드")
    private int quarter;

    @Column(name = "상권_구분_코드")
    private String cadCode;

    @Column(name = "상권_구분_코드_명")
    private String cadName;

    @Column(name = "상권_코드")
    private int code;

    @Column(name = "상권_코드_명")
    private String codeName;

    @Column(name = "집객시설_수")
    private int facility;

    @Column(name = "관공서_수")
    private int officeCount;

    @Column(name = "은행_수")
    private int bankCount;

    @Column(name = "종합병원_수")
    private int bigHosCount;

    @Column(name = "일반_병원_수")
    private int hosCount;

    @Column(name = "약국_수")
    private int pharmCount;

    @Column(name = "유치원_수")
    private int kinderCount;

    @Column(name = "초등학교_수")
    private int elementaryCount;

    @Column(name = "중학교_수")
    private int middleCount;

    @Column(name = "고등학교_수")
    private int highCount;

    @Column(name = "대학교_수")
    private int univCount;

    @Column(name = "백화점_수")
    private int deptCount;

    @Column(name = "슈퍼마켓_수")
    private int marketCount;

    @Column(name = "극장_수")
    private int theatreCount;

    @Column(name = "숙박_시설_수")
    private int hotelCount;

    @Column(name = "공항_수")
    private int airportCount;

    @Column(name = "철도_역_수")
    private int trainCount;

    @Column(name = "버스_터미널_수")
    private int terminalCount;

    @Column(name = "지하철_역_수")
    private int subwayCount;

    @Column(name = "버스_정거장_수")
    private int busStopCount;

}
