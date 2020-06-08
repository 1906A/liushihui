package com.leyou.dao;

import com.leyou.pojo.Brand;
import com.leyou.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BrandMapper extends Mapper<Brand> {

    List<Brand> findBypages(@Param("key") String key, @Param("sortBy") String sortBy,@Param("desc") Boolean desc);

//    List<Brand> findByLimit(@Param("key")String key,
//                            @Param("pages") Integer pages,
//                            @Param("rows") Integer rows,
//                         -   @Param("sortBy") String sortBy,
//                            @Param("desc") Boolean desc);

    Long findByCount(@Param("key") String key, @Param("sortBy") String sortBy,@Param("desc")Boolean desc);

    @Insert("insert into  tb_category_brand values(#{id},#{bid})")
    void addOrEditBrand(Long bid, Long id);

@Delete("delete from tb_category_brand where brand_id=#{id} ")
    void deleteBAC(Long id);
    @Select("select  y.* from tb_category_brand t,tb_category y where t.category_id=y.id and t.brand_id=#{pid}")
    List<Category> findbid(Long pid);
@Select("  SELECT b.* FROM tb_brand b,tb_category_brand c WHERE b.id=c.brand_id AND c.category_id=#{cid} ")
List<Brand> findParamByCid(Long cid);
}
