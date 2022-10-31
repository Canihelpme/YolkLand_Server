package SCA.YolkLand.Apartments;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ResponseDTOs {

    @Data
    @AllArgsConstructor
    public static class AptResultResponse<T> {
        private String message;
        private int status;
        private T data;
        private T data2;
    }

    @Data
    @AllArgsConstructor
    public static class AptDto {
        private int year;
        private int quarter;
        private String quarterName;
        private String con;
        private int code;
        private String codeName;
        private int aptNumber;
        private int apt66Under;
        private int apt66;
        private int apt99;
        private int apt132;
        private int apt165;
        private int apt0;
        private int apt1;
        private int apt2;
        private int apt3;
        private int apt4;
        private int apt5;
        private int apt6;
        private int aptMean;
        private double aptMeanCp;
        public AptDto(Apartments apt){
            this.year = apt.getYear();
            this.quarter = apt.getQuarter();
            this.quarterName = apt.getCadCode();
            this.con = apt.getCadName();
            this.code = apt.getCode();
            this.codeName = apt.getCodeName();
            this.aptNumber = apt.getAptNumber();
            this.apt66Under = apt.getApt66Under();
            this.apt66 = apt.getApt66();
            this.apt99 = apt.getApt99();
            this.apt132 = apt.getApt132();
            this.apt165 = apt.getApt165();
            this.apt0 = apt.getApt0();
            this.apt1 = apt.getApt1();
            this.apt2 = apt.getApt2();
            this.apt3 = apt.getApt3();
            this.apt4 = apt.getApt4();
            this.apt5 = apt.getApt5();
            this.apt6  = apt.getApt6();
            this.aptMean = apt.getAptMean();
            this.aptMeanCp = apt.getAptMeanCp();
        }
    }

    @Data
    public static class TicDto {
        private int totalAptAmount;
        private int incDec;
        private String mostType;
        private String mostPrice;
        public TicDto(int total, int incDec, String mostType, String mostPrice){
            this.totalAptAmount = total;
            this.incDec = incDec;
            this.mostType = mostType;
            this.mostPrice = mostPrice;
        }
    }

}
