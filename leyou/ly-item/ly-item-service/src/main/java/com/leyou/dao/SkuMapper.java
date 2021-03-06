package com.leyou.dao;


import com.leyou.pojo.Sku;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@org.apache.ibatis.annotations.Mapper
public interface SkuMapper extends Mapper<Sku> {

@Select("SELECT s.*,k.stock FROM  tb_sku s, tb_stock k WHERE k.sku_id=s.id and  s.spu_id=#{id} and enable=1 ")
    List<Sku> findSkuById(Long id);
}
