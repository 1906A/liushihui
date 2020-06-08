package com.leyou.client;


import com.leyou.pojo.Sku;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("sku")
public interface SkuClient1 {
    @RequestMapping("list")
    public List<Sku> findSkuById(@RequestParam("id") Long id);
}
