package SCA.YolkLand.Area;

import SCA.YolkLand.Apartments.ResponseDTOs;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static SCA.YolkLand.Area.ResponseDTOs.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/area")
public class AreaController {

    private final AreaProvider areaProvider;

    @Operation(summary = "Get Apartments Information", description = "상권 정보 가져오기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상권 위치,정보 조회 성공", content = @Content(schema = @Schema(implementation = ResponseDTOs.AptResultResponse.class))),
            @ApiResponse(responseCode = "400", description = "상권 조회 실패"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "서버 에러")
    })
    @Parameters({
            @Parameter(name = "cadName", description = "상권구분코드명", example = "골목상권")
    })
    @ResponseBody
    @GetMapping("/{code}")
    public AreaResultResponse getAreasByCode(@PathVariable("code") Integer code, @RequestParam("cadName") String cadName)throws NoSuchFieldException, IllegalAccessException {
        List<Areas> areas = areaProvider.getAreasInfo(code,cadName);
        if (areas.isEmpty())
        {
            return new AreaResultResponse("상권 조회 실패", 400, null);
        } else {
            List<AreaDto> collect  = areas.stream().map(area -> new AreaDto(area)).collect(Collectors.toList());
            return new AreaResultResponse("상권 위치,정보 조회 성공", 200, collect);
        }
    }

    @Operation(summary = "Get Apartments Information", description = "전체 상권 정보 가져오기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "전체 상권 위치,정보 조회 성공", content = @Content(schema = @Schema(implementation = ResponseDTOs.AptResultResponse.class))),
            @ApiResponse(responseCode = "400", description = "전체 상권 조회 실패"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "서버 에러")
    })
    @ResponseBody
    @GetMapping("")
    public AreaResultResponse getAreasByCode()throws NoSuchFieldException, IllegalAccessException {
        List<Areas> areas = areaProvider.getAllAreasInfo();
        if (areas.isEmpty())
        {
            return new AreaResultResponse("전체 상권 조회 실패", 400, null);
        } else {
            List<AreaDto> collect  = areas.stream().map(area -> new AreaDto(area)).collect(Collectors.toList());
            return new AreaResultResponse("전체 상권 위치,정보 조회 성공", 200, collect);
        }
    }


}
