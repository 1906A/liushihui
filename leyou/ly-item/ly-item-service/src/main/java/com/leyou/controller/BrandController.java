package com.leyou.controller;

import com.leyou.common.PageResult;
import com.leyou.pojo.Brand;
import com.leyou.pojo.Category;
import com.leyou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @RequestMapping("page")
    public Object findbyPages(@RequestParam("key") String key,
                              @RequestParam("page") Integer page,
                              @RequestParam("rows") Integer rows,
                              @RequestParam("sortBy") String sortBy,
                              @RequestParam("desc") Boolean desc
    ) {


        System.out.println(key + "-" + page + "-" + rows + "-" + sortBy + "-" + desc);
        PageResult<Brand> list = brandService.findBypages(key, page, rows, sortBy, desc);
        //PageResult<Brand> list=brandService.findByLimit(key,page,rows,sortBy,desc);
        return list;
    }


    @RequestMapping("addOrEditBrand")
    public void addOrEditBrand(Brand brand,
                               @RequestParam("cids") List<Long> cids) {

        if (brand.getId() != null) {
            brandService.updateBrand(brand, cids);
        } else {
            brandService.addOrEditBrand(brand, cids);
        }


    }
    @RequestMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        brandService.deleteById(id);

    }
    @RequestMapping("bid/{id}")
    public List<Category> findbid(@PathVariable("id") Long pid){
        return brandService.findbid(pid);

    }

    @RequestMapping("findBrandById")
    public Brand findBrandById(@RequestParam("id") Long id) {
       return brandService.findBrandById(id);

    }
}