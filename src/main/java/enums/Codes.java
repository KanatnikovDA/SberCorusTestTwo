package enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Список с кодами ответа
 */
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public enum Codes {
    HTTP_101(101, "invalid_access_key"),
    HTTP_103(103, "invalid_api_function"),
    HTTP_601(601,"missing_query"),
    HTTP_615(615,"request_failed");

    private final int value;
    private final String type;
}
