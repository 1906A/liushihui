package com.leyou.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.PageResult;
import com.leyou.dao.*;

import com.leyou.pojo.Sku;
import com.leyou.pojo.Spu;
import com.leyou.pojo.SpuDetail;
import com.leyou.pojo.Stock;
import com.leyou.vo.SpuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SpuService {
    @Autowired
    SpuMapper spuMapper;
    @Autowired
    SpuDetailMapper spuDetailMapper;
    @Autowired
    SkuMapper skuMapper;
    @Autowired
    StockMapper stockMapper;



    public PageResult<SpuVo> findByPages(String key, Integer page, Integer rows, Integer saleable) {
        PageHelper.startPage(page,rows);//页码page，每页条数rows

        List<SpuVo> list= spuMapper.findByPages(key,saleable);//查询条件key，根据什么排序sotrBy，升降desc
        PageInfo<SpuVo> pageInfo = new PageInfo<SpuVo>(list);
        return new PageResult<SpuVo>(pageInfo.getTotal(),pageInfo.getList());


    }

    public void saveSpuDetail(SpuVo spuVo) {
        Date nowtime = new Date();

        Spu spu = new Spu();
        spu.setBrandId(spuVo.getBrandId());
        spu.setCid1(spuVo.getCid1());
        spu.setCid2(spuVo.getCid2());
        spu.setCid3(spuVo.getCid3());
        spu.setTitle(spuVo.getTitle());
        spu.setSubTitle(spuVo.getSubTitle());
        spu.setSaleable(false);
        spu.setValid(true);
        spu.setCreateTime(nowtime);
        spu.setLastUpdateTime(new Date());
        spuMapper.insert(spu);


        //spu扩展表
        System.out.println(spuVo.getId()+"--------------------------------");
        SpuDetail spuDetail =spuVo.getSpuDetail();
        spuDetail.setSpuId(spu.getId());//id值 是spu的
        spuDetailMapper.insert(spuDetail);


        List<Sku> skus = spuVo.getSkus();
        skus.forEach(sku -> {
            sku.setSpuId(spu.getId());//id值 是spu的
            sku.setEnable(true);
            sku.setCreateTime(nowtime);
            sku.setLastUpdateTime(new Date());
            skuMapper.insert(sku);

            //库存
            Stock stock = new Stock();
            stock.setSkuId(sku.getId());
            stock.setStock(sku.getStock());
            stockMapper.insert(stock);
        });
    }


    public SpuDetail findSpuDetailBySpuId(Long spuId) {
        return spuDetailMapper.selectByPrimaryKey(spuId);
    }

    public void updateSpuDetail(SpuVo spuVo) {
        Date nowtime = new Date();
        spuVo.setSaleable(null);
        spuVo.setValid(null);
        spuVo.setCreateTime(null);
        spuVo.setLastUpdateTime(nowtime);
        spuMapper.updateByPrimaryKeySelective(spuVo);

        SpuDetail spuDetail = spuVo.getSpuDetail();
        spuDetail.setSpuId(spuVo.getId());
        spuDetailMapper.updateByPrimaryKeySelective(spuDetail);


        List<Sku> skus = spuVo.getSkus();
        skus.forEach(sku -> {
            sku.setEnable(false);
            skuMapper.updateByPrimaryKeySelective(sku);
            stockMapper.deleteByPrimaryKey(sku.getId());
        });

        List<Sku> skus1 = spuVo.getSkus();
        skus1.forEach(s -> {
            s.setSpuId(spuVo.getId());//id值 是spu的
            s.setEnable(true);
            s.setCreateTime(nowtime);
            s.setLastUpdateTime(new Date());
            skuMapper.insert(s);

            //库存
            Stock stock = new Stock();
            stock.setSkuId(s.getId());
            stock.setStock(s.getStock());
            stockMapper.insert(stock);
        });
    }

    public void deleteGoods(Long spuId) {
        List<Sku> skus = skuMapper.findSkuById(spuId);
        skus.forEach(s -> {
            s.setEnable(false);
           skuMapper.updateByPrimaryKeySelective(s);


            stockMapper.deleteByPrimaryKey(s.getId());
        });
        spuDetailMapper.deleteByPrimaryKey(spuId);
        spuMapper.deleteByPrimaryKey(spuId);

    }

    public Spu findSpuById(Long spuId) {
        return spuMapper.selectByPrimaryKey(spuId);
    }
}
