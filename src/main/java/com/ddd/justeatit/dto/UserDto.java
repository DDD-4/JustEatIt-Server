package com.ddd.justeatit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {
    private String userId;
    private String userName;
    private String userNickName;
    private String userEmail;
    private Integer userBanDay;
    private List<String> userFriend = new ArrayList<>();
    private UserPreferInfoDto userPreferInfo = new UserPreferInfoDto();
    private UserVisitInfoDto userVisitInfo = new UserVisitInfoDto();
}
