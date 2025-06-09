package com.seolyu.inventoryservice.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 공통
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "10000", "잘못된 요청입니다."),
    INVALID_FORMAT(HttpStatus.BAD_REQUEST, "10001", "잘못된 입력 데이터입니다."),
    URL_NOT_FOUND(HttpStatus.NOT_FOUND, "10002", "URL not found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "10003", "서버에서 처리 중 에러가 발생하였습니다."),
    INVALID_JSON_FORMAT(HttpStatus.BAD_REQUEST, "10004", "JSON 형식이 잘못되었습니다."),
    FILE_UPLOAD_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "10005", "파일 업로드 실패하였습니다."),
    INVALID_AUTHORITY(HttpStatus.FORBIDDEN, "10006", "접근 권한이 없습니다."),
    FILE_DOWNLOAD_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "10007", "File Download Error"),

    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
