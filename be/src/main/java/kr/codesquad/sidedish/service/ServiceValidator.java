package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.response.ErrorCode;

public class ServiceValidator {

	public static void checkDishTypeIsSide(Dish dish) {
		if (Dish.SIDE != dish) {
			throw new CustomException(ErrorCode.SIDE_DISH_ONLY_ALLOWED);
		}
	}

	public static void checkRemainingProductQuantity(Integer currentQuantity,
		Integer requestQuantity) {
		if (currentQuantity < requestQuantity) {
			throw new CustomException(ErrorCode.PRODUCT_QUANTITY_insufficient);
		}
	}
}