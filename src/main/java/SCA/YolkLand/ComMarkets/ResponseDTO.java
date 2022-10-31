package SCA.YolkLand.ComMarkets;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ResponseDTO {

    @Data
    @AllArgsConstructor
    public static class ComMktResultResponse<T> {
        private String message;
        private int status;
        private T data;
    }

    @Data
    public static class ComDto{
        private int id;
        private int year;
        private int quarter;
        private String cadCode;
        private String cadName;
        private int code;
        private String codeName;
        private String serviceCode;
        private String serviceCodeName;
        private int marketCount;
        private int sMarketCount;
        private int openPercent;
        private int openCount;
        private int closePercent;
        private int closeCount;
        private int franchiseCount;

        public ComDto(ComMarkets comMarkets){
            this.id = comMarkets.getId();
            this.year = comMarkets.getYear();
            this.quarter = comMarkets.getQuarter();
            this.cadCode = comMarkets.getCadCode();
            this.cadName = comMarkets.getCadName();
            this.code = comMarkets.getCode();
            this.codeName = comMarkets.getCodeName();
            this.serviceCode = comMarkets.getServiceCode();
            this.serviceCodeName = comMarkets.getServiceCodeName();
            this.marketCount = comMarkets.getMarketCount();
            this.sMarketCount = comMarkets.getSMarketCount();
            this.openPercent = comMarkets.getOpenPercent();
            this.openCount = comMarkets.getOpenCount();
            this.closePercent = comMarkets.getClosePercent();
            this.closeCount = comMarkets.getCloseCount();
            this.franchiseCount = comMarkets.getFranchiseCount();

        }

    }

    public interface ComMarketsByCodeDto2{
        //Data 조회시 primitive type으로 조회 해야 합니다.
        //int -> Integer, float -> Float ...
        Integer getYear();
        Integer getQuarter();
        Integer getTotalMarketCount();
        Integer getTotalFranchiseCount();
    }

    @Data
    public static class ComMarketsByCodeDto{
        private int year;
        private int quarter;
        private int totalMarketCount;
        private int totalFranchiseCount;

        public ComMarketsByCodeDto(ComMarketsByCodeDto2 comMarketsByCodeDto2){
            this.year = comMarketsByCodeDto2.getYear();
            this.quarter = comMarketsByCodeDto2.getQuarter();
            this.totalMarketCount = comMarketsByCodeDto2.getTotalMarketCount();
            this.totalFranchiseCount = comMarketsByCodeDto2.getTotalFranchiseCount();
        }

    }

}
