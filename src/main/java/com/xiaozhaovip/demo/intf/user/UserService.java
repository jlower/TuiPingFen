package com.xiaozhaovip.demo.intf.user;

import com.xiaozhaovip.demo.intf.entity.User;

public interface UserService {

    User loadById(int id );

    int insert(User user);

    int update(User user);
}
