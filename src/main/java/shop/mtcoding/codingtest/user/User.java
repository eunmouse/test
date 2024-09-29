package shop.mtcoding.codingtest.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@Table(name = "user_tb")
@NoArgsConstructor // 빈 생성자 (하이버네이트가 om 할때 필요)
@Entity // DB에서 조회하면 자동 매핑이됨
public class User {
    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

    @Builder
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}