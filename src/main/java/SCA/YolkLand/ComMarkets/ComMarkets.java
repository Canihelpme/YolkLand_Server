package SCA.YolkLand.ComMarkets;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "com_mkt")
public class ComMarkets {

    @Id
    @Column(name = "id")
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

    @Column(name = "서비스_업종_코드")
    private String serviceCode;

    @Column(name = "서비스_업종_코드_명")
    private String serviceCodeName;

    @Column(name = "점포_수")
    private int marketCount;

    @Column(name = "유사_업종_점포_수")
    private int sMarketCount;

    @Column(name = "개업_율")
    private int openPercent;

    @Column(name = "개업_점포_수")
    private int openCount;

    @Column(name = "폐업_률")
    private int closePercent;

    @Column(name = "폐업_점포_수")
    private int closeCount;

    @Column(name = "프랜차이즈_점포_수")
    private int franchiseCount;

}
