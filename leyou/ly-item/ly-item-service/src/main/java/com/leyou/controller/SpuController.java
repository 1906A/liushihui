package com.leyou.controller;

import com.leyou.common.PageResult;
import com.leyou.pojo.Brand;
import com.leyou.pojo.Category;
import com.leyou.pojo.Spu;
import com.leyou.pojo.SpuDetail;
import com.leyou.service.BrandService;
import com.leyou.service.SpuService;
import com.leyou.vo.SpuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spu")
public class SpuController {

    @Autowired
    SpuService spuService;

    @RequestMapping("page")
    public PageResult<SpuVo> findbyPages(@RequestParam("key") String key,
                                         @RequestParam("page") Integer page,
                                         @RequestParam("rows") Integer rows,
                                         @RequestParam(required = false,value = "saleable") Integer saleable
    ) { System.out.println(key + "-" + page + "-" + rows +  "-" + saleable);
        //PageResult<Brand> list=brandService.findByLimit(key,page,rows,sortBy,desc);
        return  spuService.findByPages(key, page, rows, saleable);

    }


    @RequestMapping("goods")
    public void saveSpuDetail(@RequestBody SpuVo spuVo){
        if(spuVo.getId()!=null){
        spuService.updateSpuDetail(spuVo);
        }
        else{
            spuService.saveSpuDetail(spuVo);
        }



}
    @RequestMapping("detail/{spuId}")
    public SpuDetail findSpuDetailBySpuId(@PathVariable("spuId") Long spuId){
       return spuService.findSpuDetailBySpuId(spuId);
    }

    @RequestMapping("deleteGoods/{spuId}")
    public void deleteGoods(@PathVariable("spuId") Long spuId){
         spuService.deleteGoods(spuId);
    }

    @RequestMapping("findSpuById")
    public Spu findSpuById(@RequestParam("spuId") Long spuId){
        return spuService.findSpuById(spuId);
    }


}