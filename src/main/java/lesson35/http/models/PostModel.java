package lesson35.http.models;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Builder
public class PostModel {
    private String title;
    private String body;
    private int userId;
    private int id;
}


