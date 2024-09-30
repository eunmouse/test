package shop.mtcoding.codingtest.user;

import lombok.Data;

public class UserResponse {

    @Data // getter, setter, toString
    public static class DTO {
        private Integer id;

        public DTO(User user) {
            this.id = user.getId();
        }
    }
}
