package shop.mtcoding.codingtest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.codingtest.core.error.ex.Exception400;
import shop.mtcoding.codingtest.core.error.ex.Exception401;
import shop.mtcoding.codingtest.core.error.ex.Exception404;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void 유저등록(User user) {
        // 1. 유저 존재 유무 확인
        // 유저가 존재하면 유효성 검사 실패 Exception 400
        User userPS = userRepository.findById(user.getId());
        if (userPS != null) {
            throw new Exception400("이미 존재하는 유저입니다.");
        }
        // 2. 유저 등록
        userRepository.save(user);
    }

    public User 유저한명조회(int id) {
        // 유저가 없으면 인증 관련 Exception 401
        try {
            User userPS = userRepository.findById(id);
            return userPS;
        } catch(Exception e) {
            throw new Exception401("인증되지 않았습니다.");
        }
    }

    @Transactional
    public User 유저수정(int id, User user) {
        // 1. 유저 조회
        try {
            User userPS = userRepository.findById(id);
            if (userPS != null) {
                userPS.setName(user.getName());
            } // flush 자동 호출됨, 더티체킹
            return userPS;
        } catch (Exception e) {
            throw new Exception404("존재하지 않는 유저입니다.");
        }
    }
}
