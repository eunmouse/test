package shop.mtcoding.codingtest.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.codingtest.core.util.Resp;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    // user 등록 API 구현
    //`/users` API를 호출하면, `{"id": 1}`을 응답한다.
    @PostMapping("/users")
    public ResponseEntity<?> save(@Valid UserRequest.saveDTO saveDTO, Error errors) {
        UserResponse.DTO userDTO = userService.유저등록(saveDTO);
        return ResponseEntity.ok(Resp.ok(userDTO));
    }

    // user 조회 API 구현
    // `/users/{id}` API를 호출하면, `{"id": ?, "name": "?"}`을 응답한다.
    @GetMapping("/user/{id}")
    public ResponseEntity<?> findById(@RequestParam("id") Integer id) {
        User user = userService.유저한명조회(id);
        return ResponseEntity.ok(Resp.ok(Resp.ok(user)));
    }

    // user 수정 API 구현
    // `/users/{id}` API를 호출하면, `{"id": ?, "name": "?"}`을 응답한다.
    @PostMapping("/user/{id}")
    public ResponseEntity<?> update(Integer id, @Valid User user, Errors errors) {
        User userPS = userService.유저수정(id, user);
        return ResponseEntity.ok(Resp.ok(userPS));
    }

}
