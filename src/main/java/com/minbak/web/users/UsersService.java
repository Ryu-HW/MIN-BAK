package com.minbak.web.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void createUser(UserDto userDto){

        //중복된 이메일이 있는지 확인
        if(usersMapper.findUserEmailByEmail(userDto.getEmail()) == null){
            //페스워드 암호화
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            //회원데이터 저장
            usersMapper.createUser(userDto);

            //저장된 객체를 참조하여 id값 추출
            Integer user_id = userDto.getUserId();
            //잘 추출되면 1(ROLE_USER) 권한 추가
            if(user_id == null){
                throw new IllegalStateException("회원가입이 제대로 되지 않았습니다.");
            }else {
                usersMapper.createUserRoleByUserIdAndRoleId(user_id,1);
            }
        }else {
//            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
            return;
        }

    }

    public void createHostBy3rdUsers() {
        List<Integer> userIds = usersMapper.findAllUserIds();
        for(int userId : userIds){
            if ((userId % 3) == 1){
                usersMapper.createUserRoleByUserIdAndRoleId(userId,2);
            }
        }
    }
}
