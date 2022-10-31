package SCA.YolkLand.Apartments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "back_apt")
public class Apartments {

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

    @Column(name = "아파트_단지_수")
    private int aptNumber;

    @Column(name = "아파트_면적_66_제곱미터_미만_세대_수")
    private int apt66Under;

    @Column(name = "아파트_면적_66_제곱미터_세대_수")
    private int apt66;

    @Column(name = "아파트_면적_99_제곱미터_세대_수")
    private int apt99;

    @Column(name = "아파트_면적_132_제곱미터_세대_수")
    private int apt132;

    @Column(name = "아파트_면적_165_제곱미터_세대_수")
    private int apt165;

    @Column(name = "아파트_가격_1_억_미만_세대_수")
    private int apt0;

    @Column(name = "아파트_가격_1_억_세대_수")
    private int apt1;

    @Column(name = "아파트_가격_2_억_세대_수")
    private int apt2;

    @Column(name = "아파트_가격_3_억_세대_수")
    private int apt3;

    @Column(name = "아파트_가격_4_억_세대_수")
    private int apt4;

    @Column(name = "아파트_가격_5_억_세대_수")
    private int apt5;

    @Column(name = "아파트_가격_6_억_이상_세대_수")
    private int apt6;

    @Column(name = "아파트_평균_면적")
    private int aptMean;

    @Column(name = "아파트_평균_시가")
    private double aptMeanCp;

}
