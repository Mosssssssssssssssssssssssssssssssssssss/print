package com.nnxy.print116.dao;

import com.nnxy.print116.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginAndRegisterMapper {
    @Insert("insert into user(number,name,phone,password) values(#{number},#{name},#{phone},#{password})")
    Integer insert(User user);
    @Select("select count(1) from user where number=#{registerNum}")
    Integer exist(@Param("registerNum") String registerNum);
}
