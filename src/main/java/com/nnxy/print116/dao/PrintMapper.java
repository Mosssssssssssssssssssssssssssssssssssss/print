package com.nnxy.print116.dao;

import com.nnxy.print116.entity.Print;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PrintMapper {
    @Insert("insert into print(number,size, printStyle, printColor, note, gmtCreate, gmtModify) " +
            "values(#{number},#{size},#{printStyle},#{printColor},#{note},#{gmtCreate},#{gmtModify})")
    Integer inset(Print print);

}
