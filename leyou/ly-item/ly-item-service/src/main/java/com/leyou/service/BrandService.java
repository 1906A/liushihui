package com.leyou.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.PageResult;
import com.leyou.dao.BrandMapper;
import com.leyou.dao.CategoryMapper;
import com.leyou.pojo.Brand;
import com.leyou.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandMapper brandMapper;

    public PageResult<Brand> findBypages(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        PageHelper.startPage(page,rows);//页码page，每页条数rows

       List<Brand> list= brandMapper.findBypages(key,sortBy,desc);//查询条件key，根据什么排序sotrBy，升降desc
        PageInfo<Brand> pageInfo = new PageInfo<Brand>(list);
        return new PageResult<Brand>(pageInfo.getTotal(),pageInfo.getList());

    }


    public void addOrEditBrand(Brand brand, List<Long> cids) {
        brandMapper.insert(brand);

    cids.forEach(id->{
        brandMapper.addOrEditBrand(brand.getId(),id);
    });
    }

    public void deleteById(Long pid) {
        Brand brand = new Brand();
        brand.setId(pid);
        brandMapper.delete(brand);
        brandMapper.deleteBAC(pid);

    }

    public List<Category> findbid(Long pid) {
        return brandMapper.findbid(pid);
    }


    public void updateBrand(Brand brand, List<Long> cids) {
        brandMapper.updateByPrimaryKey(brand);
        brandMapper.deleteBAC(brand.getId());
        cids.forEach(id->{
            brandMapper.addOrEditBrand(brand.getId(),id);
        });
    }

    public List<Brand> findParamByCid(Long cid) {
       return brandMapper.findParamByCid(cid);
    }

    public Brand findBrandById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
