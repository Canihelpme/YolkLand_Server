package SCA.YolkLand.Area;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DecimalFormat;

@Entity
@Getter
@Setter
@Table(name = "com_area")
public class Areas {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "상권_구분_코드")
    private String cadCode;

    @Column(name = "상권_구분_코드_명")
    private String cadName;

    @Column(name = "상권_코드")
    private int code;

    @Column(name = "상권_코드_명")
    private String codeName;

    @Column(name = "경도")
    private double longitude;

    @Column(name = "위도")
    private double latitude;

}
