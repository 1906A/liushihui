package com.leyou.client;

import com.leyou.pojo.SpecGroup;
import com.leyou.pojo.SpecParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("specParam")
public interface SpecClient1 {
    @RequestMapping("params1ByCid")
    public List<SpecParam> findParamByCidAndSearch(@RequestParam("cid") Long cid) ;
    @RequestMapping("paramByCidAndGeneric")
    public List<SpecParam> fingParamByCidAndGeneric(@RequestParam("cid") Long cid,
                                                    @RequestParam("generic") boolean generic);


}
