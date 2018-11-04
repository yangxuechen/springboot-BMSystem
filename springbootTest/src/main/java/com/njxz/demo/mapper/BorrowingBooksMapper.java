package com.njxz.demo.mapper;

import com.njxz.demo.domain.BorrowingBooks;
import com.njxz.demo.domain.BorrowingBooksExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BorrowingBooksMapper {
    long countByExample(BorrowingBooksExample example);

    int deleteByExample(BorrowingBooksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BorrowingBooks record);

    int insertSelective(BorrowingBooks record);

    List<BorrowingBooks> selectByExample(BorrowingBooksExample example);

    BorrowingBooks selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BorrowingBooks record, @Param("example") BorrowingBooksExample example);

    int updateByExample(@Param("record") BorrowingBooks record, @Param("example") BorrowingBooksExample example);

    int updateByPrimaryKeySelective(BorrowingBooks record);

    int updateByPrimaryKey(BorrowingBooks record);

    //分页查询
    List<BorrowingBooks> selectByPageNumAndPageSize(@Param("currIndex")int currIndex,@Param("pageSize")int pageSize,@Param("userId")int userId);

    //查询该userId用户的总借书记录数目
     int selectAllRecordCount(@Param("userId") int userId);

     //分页查询所有记录
    List<BorrowingBooks> selectAllByPage(@Param("currIndex")int currIndex,@Param("pageSize")int pageSize);

    //查询所有记录总数
    int selectAll();
}