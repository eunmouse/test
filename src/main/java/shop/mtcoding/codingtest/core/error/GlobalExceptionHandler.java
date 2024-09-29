package shop.mtcoding.codingtest.core.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.mtcoding.codingtest.core.error.ex.*;
import shop.mtcoding.codingtest.core.util.Resp;
import shop.mtcoding.codingtest.core.util.Script;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 유효성 검사 실패 (잘못된 클라이언트의 요청)
    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> ex400(Exception e) {
        return new ResponseEntity<>(Resp.fail(400, e.getMessage()), HttpStatus.BAD_REQUEST);
                                        // 이건 프론트엔드 개발자가 볼 수 있게 // 이 상태코드는 브라우저에 요청하는 것.
    }

    // 인증 실패 (클라이언트가 인증없이 요청했거나, 인증에 실패했거나)
    @ExceptionHandler(Exception401.class)
    public ResponseEntity<?> ex401(Exception e) {
        return new ResponseEntity<>(Resp.fail(401, e.getMessage()), HttpStatus.UNAUTHORIZED); // 인증 안됨
    }

    // 서버에서 리소스(자원) 찾을 수 없을 때
    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> ex404(Exception e) {
        return new ResponseEntity<>(Resp.fail(404, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    // 권한 실패 (인증은 되어 있으나, 권한이 없음)
    @ExceptionHandler(Exception403.class)
    public ResponseEntity<?> ex403(Exception e) {
        return new ResponseEntity<>(Resp.fail(403, e.getMessage()), HttpStatus.FORBIDDEN); // 권한 없음
    }

    // 서버에서 심각한 오류가 발생했을 때 (알고 있을 떄)
    @ExceptionHandler(Exception500.class)
    public ResponseEntity<?> ex500(Exception e) {
        return new ResponseEntity<>(Resp.fail(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 서버에서 심각한 오류가 발생했을 때 (모를 때)
    @ExceptionHandler(Exception.class)
    public String ex(Exception e) {
        return Script.back(e.getMessage());
    }
}
