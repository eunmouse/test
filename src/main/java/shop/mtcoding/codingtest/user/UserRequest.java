package shop.mtcoding.codingtest.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

public class UserRequest {

    @Data
    public static class saveDTO {

        private int id;

        private String name;

        public User toEntity() {
            return User.builder().id(id).name(name).build();
        }
    }
}
