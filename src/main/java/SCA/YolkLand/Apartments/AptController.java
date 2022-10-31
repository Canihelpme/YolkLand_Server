package SCA.YolkLand.Apartments;

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

import static SCA.YolkLand.Apartments.Apartments.*;
import static SCA.YolkLand.Apartments.ResponseDTOs.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AptController {

    private final AptProvider aptProvider;

    //http://localhost:8080/swagger-ui/index.html link to Swagger
    @Operation(summary = "Get Apartments Information", description = "상권 배후지의 아파트 정보 가져오기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상권 배후지 아파트 조회 성공", content = @Content(schema = @Schema(implementation = AptResultResponse.class))),
            @ApiResponse(responseCode = "400", description = "상권 배후지 아파트 조회 실패"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "서버 에러")
    })
    @Parameters({
            @Parameter(name = "code", description = "상권구분코드", example = "2110824"),
    })
    @ResponseBody
    @GetMapping("/apt")
    public AptResultResponse getApartmentsByCode(@RequestParam("code") Integer code) throws NoSuchFieldException, IllegalAccessException {
        List<Apartments> apts = aptProvider.getApartmentsInfo(code);
        if (apts.isEmpty())
        {
            return new AptResultResponse("상권 배후지 아파트 조회 실패", 400, null, null);
        } else {
            List<AptDto> collect = apts.stream().map(apt -> new AptDto(apt)).collect(Collectors.toList());
            Apartments top = apts.get(0);
            Apartments last = apts.get(1);
            TicDto ticDto = aptProvider.totalService(top,last);
            return new AptResultResponse("상권 배후지 아파트 조회 성공", 200, collect,ticDto);
        }
    }




}
