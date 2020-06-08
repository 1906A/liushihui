package com.leyou.controller;

import com.leyou.client.*;
import com.leyou.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsDetailController {

    @Autowired
    SpuClient spuClient;
    @Autowired
    SkuClient skuClient;
    @Autowired
    SpecGroupClient SpecGroupClient;
    @Autowired
    BrandClient brandClient;
    @Autowired
    SpecClient specClient;
    @Autowired
    CategoryClient categoryClient;


    @RequestMapping("hello")
    public String hello(Model model){
        String name="张三";
        model.addAttribute("name",name);
        return "hello";
    }
    @RequestMapping("item/{spuId}.html")
    public String item(@PathVariable("spuId") Long spuId,Model model){
        //spu
        Spu spu = spuClient.findSpuById(spuId);
        model.addAttribute("spu",spu);
        //spuDetail
        SpuDetail spuDetail = spuClient.findSpuDetailBySpuId(spuId);
        model.addAttribute("spuDetail",spuDetail);
        //sku
        List<Sku> skuList = skuClient.findSkuById(spuId);
        model.addAttribute("skuList",skuList);
        //规格参数组
        List<SpecGroup> groups = SpecGroupClient.findGroup(spu.getCid3());
        model.addAttribute("groups",groups);

        //7:查询品牌
        Brand brand = brandClient.findBrandById(spu.getBrandId());
        model.addAttribute("brand",brand);

        //5:三级分类   category   id   name
        List<Category> categoryList = categoryClient.findCategoryByCids(
                Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));
        model.addAttribute("categoryList",categoryList);
        //6:参数中的规格参数
        List<SpecParam> specParamList = specClient.fingParamByCidAndGeneric(spu.getCid3(),false);

        //7: 规格参数的特殊属性
        Map<Long,String> paramMap = new HashMap<>();
        specParamList.forEach(param->{
            paramMap.put(param.getId(),param.getName());
        });
        model.addAttribute("paramMap",paramMap);
        return "item";
    }
}
