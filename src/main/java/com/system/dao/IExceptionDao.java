package com.system.dao;

import com.system.entity.ExceptionEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *  异常记录
 * @author cxh
 * @date 2021/5/7 14:10
 */
@Repository
@Mapper
public interface IExceptionDao {

    @Insert(" insert into exception(id,code,exception,create_date,creator) values " +
            " <foreach collection='list' item='item' separator=',' >" +
            " (#{item.id},#{item.code},#{item.exception},now(),#{item.creator})" +
            " </foreach> ")
    void batchInsert(@Param("list") List<ExceptionEntity> exceptionList);
}
