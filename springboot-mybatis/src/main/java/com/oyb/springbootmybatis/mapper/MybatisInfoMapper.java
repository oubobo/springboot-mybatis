package com.oyb.springbootmybatis.mapper;

import com.oyb.springbootmybatis.vo.MybatisInfoVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MybatisInfoMapper {

 /*   @Select("SELECT * from  test.t_mybatis_info")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "age",column = "age"),
            @Result(property = "cupSize",column = "cup_size")
    })
    List<MybatisInfoVO> getAll();

    @Select("SELECT * from  test.t_mybatis_info where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "age",column = "age"),
            @Result(property = "cupSize",column = "cup_size")
    })
    MybatisInfoVO getOne(Long id);

    @Insert("insert into test.t_mybatis_info(age,cup_size)  values(#{age},#{cupSize})")
    void insert(MybatisInfoVO vo);

    @Update("update test.t_mybatis_info set cup_size=#{cupSize} where id=#{id}")
    void update(MybatisInfoVO vo);

    @Delete("delete from test.t_mybatis_info where id=#{id}")
    void delete(Long id);*/


    List<MybatisInfoVO> getAll();

    MybatisInfoVO getOne(Long id);

    void insert(MybatisInfoVO vo);

    void delete(Long id);

    void update(MybatisInfoVO vo);



}
