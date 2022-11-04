package SCA.YolkLand.Area;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ResponseDTOs {

    @Data
    @AllArgsConstructor
    public static class AreaResultResponse<T> {
        private String message;
        private int status;
        private T data;
    }

    @Data
    @AllArgsConstructor
    public static class AreaDto {
        private int id;
        private String cadCode;
        private String cadName;
        private int code;
        private String codeName;
        private double longitude;
        private double latitude;

        public AreaDto(Areas areas) {
            this.id = areas.getId();
            this.cadCode = areas.getCadCode();
            this.cadName = areas.getCadName();
            this.code = areas.getCode();
            this.codeName = areas.getCodeName();
            this.longitude = areas.getLongitude();
            this.latitude = areas.getLatitude();
        }
    }


}
