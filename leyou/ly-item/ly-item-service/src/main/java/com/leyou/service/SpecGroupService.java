package com.leyou.service;


import com.leyou.dao.SpecGroupMapper;

import com.leyou.dao.SpecParamMapper;
import com.leyou.pojo.SpecGroup;
import com.leyou.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecGroupService {
    @Autowired
    SpecGroupMapper specGroupMapper;
    @Autowired
    SpecParamMapper specParamMapper;



    public void addgroup(SpecGroup specGroup) {
        if (specGroup.getId()==null){
        specGroupMapper.insert(specGroup);
        }else {
            specGroupMapper.updateByPrimaryKey(specGroup);
        }
    }

    public List<SpecGroup> findgroup(Long categoryid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(categoryid);
        //根据分类id查规格参数
        List<SpecGroup> groupList = new ArrayList<>();
        groupList = specGroupMapper.select(specGroup);
        groupList.forEach(group->{
            SpecParam specParam = new SpecParam();
            specParam.setGroupId(group.getId());
           group.setParams( specParamMapper.select(specParam));
        });

        return  groupList ;
    }

    public void deletegroup(Long id) {
        specGroupMapper.deleteByPrimaryKey(id);
    }


}
