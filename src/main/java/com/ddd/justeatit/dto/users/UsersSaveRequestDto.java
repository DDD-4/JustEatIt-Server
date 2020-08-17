package com.ddd.justeatit.dto.users;


import com.ddd.justeatit.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public UsersSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Users toEntity(){
        return Users.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
