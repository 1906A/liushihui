package com.leyou.controller;

import com.leyou.common.PageResult;
import com.leyou.pojo.Sku;
import com.leyou.pojo.SpuDetail;
import com.leyou.service.SkuService;
import com.leyou.service.SpuService;
import com.leyou.vo.SpuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sku")
public class SkuController {

    @Autowired
    SkuService skuService;

    @RequestMapping("list")
    public List<Sku> findSkuById(@RequestParam("id") Long id){
        System.out.println(id+"-------------");
      return   skuService.findSkuById(id);
    }




}