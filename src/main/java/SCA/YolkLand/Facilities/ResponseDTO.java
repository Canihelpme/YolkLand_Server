package SCA.YolkLand.Facilities;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ResponseDTO {

    @Data
    @AllArgsConstructor
    public static class FacRes<T>{
        private int status;
        private String message;
        private T data;
    }

    @Data
    @AllArgsConstructor
    public static class FacResultResponse{
        private int officeCount;
        private int bankCount;
        private int hospitalCount;
        private int schoolCount;
        private int facility;
        private int deptCount;
        private int theatreCount;
        private int hotelCount;
        private int transportCount;

        public FacResultResponse(Facilities fac, int hospitalCount, int schoolCount, int transportCount){
            this.officeCount = fac.getOfficeCount();
            this.bankCount = fac.getBankCount();
            this.hospitalCount = hospitalCount;
            this.schoolCount = schoolCount;
            this.facility = fac.getFacility();
            this.deptCount = fac.getDeptCount();
            this.theatreCount = fac.getTheatreCount();
            this.hotelCount = fac.getHotelCount();
            this.transportCount = transportCount;
        }
    }
}
