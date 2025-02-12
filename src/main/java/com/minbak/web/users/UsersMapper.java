package com.minbak.web.users;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {

    // 회원가입
    public void createUser(UserDto userDto);

    // 역할 목록 조회 (예시: 제한된 수의 역할)
    public List<RoleDto> findRoles(int limit);

    // 사용자 역할 삽입 (userId와 roleId로 연결)
    public void createUserRoleByUserIdAndRoleId(int userId, int roleId);

    // 이메일로 사용자 조회 (이메일 중복 체크용)
    public String findUserEmailByEmail(String email);

    // 이메일로 사용자 전체 조회
    public UserDto findUserByEmail(String email);

    // 사용자 ID로 역할 조회
    public List<RoleDto> findRolesByUserId(Integer userId);

    public List<Integer> findAllUserIds();
}
