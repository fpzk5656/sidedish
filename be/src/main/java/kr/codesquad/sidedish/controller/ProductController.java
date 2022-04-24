package kr.codesquad.sidedish.controller;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.sidedish.service.ProductDTO;
import kr.codesquad.sidedish.response.CommonCode;
import kr.codesquad.sidedish.response.CommonResponse;
import kr.codesquad.sidedish.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api/v1/products")
public class ProductController {

	private final ProductService productService;

	/**
	 * 상품 카테고리별 목록 불러오기
	 */
	@ResponseBody
	@GetMapping("/{dishType}/{sideDishType}")
	public ResponseEntity<CommonResponse<List<ResponseSimpleProductInfo>>> loadListByType(
		@PathVariable String dishType,
		@PathVariable String sideDishType) {
		List<ProductDTO> productDTOs = productService.loadListByType(dishType, sideDishType);

		List<ResponseSimpleProductInfo> simpleDTOs = productDTOs.stream()
			.map(p -> ResponseSimpleProductInfo.from(p))
			.collect(Collectors.toList());

		return new CommonResponse(CommonCode.SUCCESS, simpleDTOs).toResponseEntity();
	}


	/**
	 * 상품 세부 정보 불러오기
	 */
	@ResponseBody
	@GetMapping("/{id}/detail")
	public ResponseEntity<CommonResponse<ResponseDetailProductInfo>> loadDetail(@PathVariable Integer id) {
		return new CommonResponse(CommonCode.SUCCESS,
			ResponseDetailProductInfo.from(productService.findById(id))).toResponseEntity();
	}

	/**
	 * 주문 넣기
	 */
	@PostMapping("/orders")
	public ResponseEntity<CommonResponse> order(@RequestBody RequestProduct requestProduct) {
		productService.order(requestProduct);

		return new CommonResponse(CommonCode.SUCCESS).toResponseEntity();
	}
}
