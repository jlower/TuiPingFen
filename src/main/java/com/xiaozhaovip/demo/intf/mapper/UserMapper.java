package com.xiaozhaovip.demo.intf.mapper;

import com.xiaozhaovip.demo.intf.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from yike_user_new where id = #{id}")
    User loadById(int id);


    @Insert("insert into yike_user_new(id,UserName,Password,AddTime, UpdateTime) " +
            "values(null,#{userName},#{password},now(), now()")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(User user);

}
