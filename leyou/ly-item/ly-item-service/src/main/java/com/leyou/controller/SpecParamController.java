package com.leyou.controller;


import com.leyou.pojo.SpecGroup;
import com.leyou.pojo.SpecParam;
import com.leyou.service.SpecGroupService;
import com.leyou.service.SpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("specParam")
public class SpecParamController {

    @Autowired
    SpecParamService specParamService;



    @RequestMapping("params")
    public  List<SpecParam> findParam(@RequestParam("gid") Long gid){
      return   specParamService.findParam(gid);

    }


    @RequestMapping("param")
    public void saveParam(@RequestBody SpecParam specParam) {
        specParamService.saveParam(specParam);

    }
    @RequestMapping("param/{id}")
    public void delParam(@PathVariable("id") Long id) {
        specParamService.delParam(id);

    }
    @RequestMapping("params1")
    public List<SpecParam> findParamByCid(@RequestParam("cid") Long cid) {
        return specParamService.findParamByCid(cid);

    }
    @RequestMapping("params1ByCid")
    public List<SpecParam> findParamByCidAndSearch(@RequestParam("cid") Long cid) {
        return specParamService.findParamByCidAndSearch(cid);

    }

    @RequestMapping("paramByCidAndGeneric")
    public List<SpecParam> fingParamByCidAndGeneric(@RequestParam("cid") Long cid,
                                                    @RequestParam("generic") boolean generic){
        return specParamService.fingParamByCidAndGeneric(cid,generic);
    }

}