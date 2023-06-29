package com.hunbk.repository;

import com.hunbk.domain.Todo;
import com.hunbk.dto.request.TodoRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("select * from todo")
    List<Todo> findAll();

    @Insert(value = "insert into todo(content) values (#{content})")
    void create(TodoRequest todoRequest);

    @Delete("delete from todo where id = #{id}")
    void delete(Long id);

    @Update("update todo set is_check = #{isCheck} where id = #{id}")
    void todoCheck(@Param("id") Long id, @Param("isCheck") Boolean isCheck);

}
