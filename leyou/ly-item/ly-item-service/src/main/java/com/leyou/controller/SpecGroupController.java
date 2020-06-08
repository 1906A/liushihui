package com.leyou.controller;


import com.leyou.pojo.SpecGroup;
import com.leyou.pojo.SpecParam;
import com.leyou.service.SpecGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecGroupController {

    @Autowired
    SpecGroupService specGroupService;

    @RequestMapping("group")
    public void addGroup(@RequestBody SpecGroup specGroup) {
        specGroupService.addgroup(specGroup);

    }

    @RequestMapping("groups/{cid}")
    public List<SpecGroup> findGroup(@PathVariable("cid") Long categoryid) {
       return specGroupService.findgroup(categoryid);

    }


    @RequestMapping("group/{id}")
    public void deleteGroup(@PathVariable("id") Long id) {
         specGroupService.deletegroup(id);

    }


}