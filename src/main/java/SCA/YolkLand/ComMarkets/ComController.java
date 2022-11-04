package SCA.YolkLand.ComMarkets;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import SCA.YolkLand.ComMarkets.ResponseDTO.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/com")
public class ComController {

    private final ComProvider comProvider;

    @Operation(summary = "Get Commercial Area's Information", description = "상권 정보 가져오기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상권 정보 조회 성공", content = @Content(schema = @Schema(implementation = ResponseDTO.ComMktResultResponse.class))),
            @ApiResponse(responseCode = "400", description = "상권 정보 조회 실패"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "서버 에러")
    })
    @Parameters({
            @Parameter(name = "code", description = "상권 구분코드", example = "2110824"),
    })
    @ResponseBody
    @GetMapping("/{code}")
    public ComMktResultResponse getComMarketsByCode(@PathVariable("code") Integer code) throws NoSuchFieldException, IllegalAccessException {
        List<ComMarketsByCodeDto2> comMarkets = comProvider.getComMarketsByCode(code);
        List<ComMarketsByCodeDto> collect = comMarkets.stream().map(c -> new ComMarketsByCodeDto(c)).collect(Collectors.toList());
        return new ComMktResultResponse("조회 성공", 200, collect);
        }
}


