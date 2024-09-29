package shop.mtcoding.codingtest.core.error.ex;

// 클라이언트가 요청한 리소스를 찾을 수 없을 때
public class Exception404 extends RuntimeException {

    public Exception404(String message) {
        super(message);
    }
}
