package com.leyou.service;


import com.leyou.dao.SpecGroupMapper;
import com.leyou.dao.SpecParamMapper;
import com.leyou.pojo.SpecGroup;
import com.leyou.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecParamService {

    @Autowired
    SpecParamMapper specParamMapper;


    public List<SpecParam> findParam(Long gid) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        return specParamMapper.select(specParam);
    }

    public void saveParam(SpecParam specParam) {
        if (specParam.getId()!=null){
            specParamMapper.updateByPrimaryKey(specParam);
        }else {
            specParamMapper.insert(specParam);
        }
    }

    public void delParam(Long id) {

        specParamMapper.deleteByPrimaryKey(id);
    }


    public List<SpecParam> findParamByCid(Long cid) {
        return specParamMapper.findParamByCid(cid);
    }

    public List<SpecParam> findParamByCidAndSearch(Long cid) {
        SpecParam specParam = new SpecParam();
        specParam.setCid(cid);
        specParam.setSearching(true);
        return specParamMapper.select(specParam);
    }

    public List<SpecParam> fingParamByCidAndGeneric(Long cid, boolean generic) {
        SpecParam specParam = new SpecParam();
        specParam.setCid(cid);
        specParam.setGeneric(generic);
        return specParamMapper.select(specParam);
    }
}
