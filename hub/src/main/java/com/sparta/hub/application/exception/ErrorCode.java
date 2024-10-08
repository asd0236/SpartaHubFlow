package com.sparta.hub.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Common Errors
    MISSING_INPUT_VALUE(HttpStatus.BAD_REQUEST, "COMMON_0001", "인자가 부족합니다."),
    NULL_OR_EMPTY_VALUE(HttpStatus.BAD_REQUEST, "COMMON_0002", "값이 null이거나 비어있습니다."),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "COMMON_0003", "잘못된 입력 값입니다."),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "COMMON_0004", "잘못된 타입입니다."),
    INVALID_JSON(HttpStatus.BAD_REQUEST, "COMMON_0005", "JSON 파싱 오류입니다."),
    NOT_EXIST_API(HttpStatus.BAD_REQUEST, "COMMON_0006", "요청 주소가 올바르지 않습니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "COMMON_0007", "사용할 수 없는 메서드입니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON_0008", "요청한 리소스를 찾을 수 없습니다."),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON_0009", "요청한 엔티티를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_0010", "서버 에러입니다."),

    // Authentication & Authorization Errors
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "AUTH_0001", "인증에 실패하였습니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "AUTH_0002", "권한이 없습니다."),

    // Cache Errors
    CACHE_NOT_AVAILABLE(HttpStatus.INTERNAL_SERVER_ERROR, "CACHE_0001", "캐시 시스템에 접근할 수 없습니다."),

    // Hub Module Specific Errors
    HUB_NOT_FOUND(HttpStatus.NOT_FOUND, "HUB_0001", "허브를 찾을 수 없습니다."),
    HUB_ALREADY_EXISTS(HttpStatus.CONFLICT, "HUB_0002", "이미 존재하는 허브입니다."),
    HUB_LOCATION_INVALID(HttpStatus.BAD_REQUEST, "HUB_0003", "허브의 위치가 잘못되었습니다."),
    HUB_DELETED(HttpStatus.CONFLICT, "HUB_0004", "해당 허브는 삭제되었습니다."),

    HUB_ROUTE_NOT_FOUND(HttpStatus.NOT_FOUND, "HUB_ROUTE_0001", "허브 경로를 찾을 수 없습니다."),
    HUB_ROUTE_ALREADY_EXISTS(HttpStatus.CONFLICT, "HUB_ROUTE_0002", "이미 존재하는 허브 경로입니다."),
    HUB_ROUTE_DELETED(HttpStatus.CONFLICT, "HUB_ROUTE_0003", "해당 허브 경로는 삭제되었습니다."),

    // Direction Errors
    DIRECTION_INVALID_ORIGIN(HttpStatus.BAD_REQUEST, "DIR_0001", "출발지 정보가 올바르지 않습니다."),
    DIRECTION_INVALID_DESTINATION(HttpStatus.BAD_REQUEST, "DIR_0002", "목적지 정보가 올바르지 않습니다."),
    DIRECTION_NOT_FOUND(HttpStatus.NOT_FOUND, "DIR_0003", "경로를 찾을 수 없습니다."),
    DIRECTION_API_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DIR_0004", "경로 탐색 API 오류가 발생했습니다."),
    DIRECTION_INVALID_MODE(HttpStatus.BAD_REQUEST, "DIR_0005", "잘못된 이동 수단이 지정되었습니다."),
    DIRECTION_REQUEST_INTERRUPTED(HttpStatus.INTERNAL_SERVER_ERROR, "DIR_0006", "경로 탐색 요청이 중단되었습니다."),
    DIRECTION_IO_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DIR_0007", "경로 탐색 중 I/O 오류가 발생했습니다."),
    DIRECTION_UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DIR_0008", "경로 탐색 중 예기치 않은 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
