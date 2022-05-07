package com.fc.dao;

import com.fc.entity.Types;
import com.fc.entity.TypesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypesMapper {
    long countByExample(TypesExample example);

    int deleteByExample(TypesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Types record);

    int insertSelective(Types record);

    List<Types> selectByExample(TypesExample example);

    Types selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Types record, @Param("example") TypesExample example);

    int updateByExample(@Param("record") Types record, @Param("example") TypesExample example);

    int updateByPrimaryKeySelective(Types record);

    int updateByPrimaryKey(Types record);
}