package com.nnxy.print116.dao;

import com.nnxy.print116.entity.Print;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PrintMapper {
    @Insert("insert into print(number,size, printStyle, printColor, note, gmtCreate, gmtModify) " +
            "values(#{number},#{size},#{printStyle},#{printColor},#{note},#{gmtCreate},#{gmtModify})")
    Integer inset(Print print);
    @Select("SELECT * FROM print WHERE flag=0 ORDER BY gmtModify ASC")
    List<Print> select();
}
