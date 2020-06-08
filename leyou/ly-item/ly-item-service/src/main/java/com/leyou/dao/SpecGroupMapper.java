package com.leyou.dao;

import com.leyou.pojo.Category;
import com.leyou.pojo.SpecGroup;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SpecGroupMapper extends Mapper<SpecGroup> {


}
