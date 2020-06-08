package com.leyou.client;

import com.leyou.common.PageResult;
import com.leyou.pojo.Spu;
import com.leyou.pojo.SpuDetail;
import com.leyou.vo.SpuVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("spu")
public interface SpuClient1 {
    @RequestMapping("page")
    public PageResult<SpuVo> findbyPages(@RequestParam("key") String key,
                                         @RequestParam("page") Integer page,
                                         @RequestParam("rows") Integer rows,
                                         @RequestParam(required = false,value = "saleable") Integer saleable
    );

    @RequestMapping("detail/{spuId}")
    public SpuDetail findSpuDetailBySpuId(@PathVariable("spuId") Long spuId);

    @RequestMapping("findSpuById")
    public Spu findSpuById(@RequestParam("spuId") Long spuId);
}
