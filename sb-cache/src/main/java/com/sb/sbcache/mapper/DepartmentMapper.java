package com.sb.sbcache.mapper;


import com.sb.sbcache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    Department getDepartmentById(Integer id);
}
