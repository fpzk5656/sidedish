package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.response.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum DishType {

    MAIN("메인"),
    SIDE("반찬"),
    SOUP("국물"),
    ;

    private final String name;

    public static DishType fromName(String text) {
        return Arrays.stream(values())
                .filter(dishType -> dishType.name.equals(text))
                .findFirst()
                .orElseThrow(() -> new CustomException(ErrorCode.DISH_TYPE_NOT_ALLOWED));
    }
}