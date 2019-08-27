package com.sb.sbcache.mapper;


import com.sb.sbcache.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmployeeById(Integer id);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},dId=#{dId} WHERE id=#{id}")
    void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    void deleteEmp(Integer id);

    @Select("SELECT * FROM employee WHERE last_name=#{lastName}")
    Employee getEmpByLastName(String lastName);

}
