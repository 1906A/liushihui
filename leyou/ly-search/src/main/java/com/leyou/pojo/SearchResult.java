package com.leyou.pojo;

import com.leyou.common.PageResult;
import com.leyou.item.Goods;

import java.util.List;
import java.util.Map;

public class SearchResult extends PageResult<Goods> {
    private List<Brand>brandList;
    private List<Category>categoryList;
    private List<Map<String, Object>> paramList;

    public List<Map<String, Object>> getParamList() {
        return paramList;
    }

    public void setParamList(List<Map<String, Object>> paramList) {
        this.paramList = paramList;
    }

    public SearchResult(Long total, List<Goods> items, Integer totalPage, List<Brand> brandList, List<Category> categoryList, List<Map<String, Object>> paramList) {
        super(total, items, totalPage);
        this.brandList = brandList;
        this.categoryList = categoryList;
        this.paramList = paramList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public SearchResult(Long total) {
        super(total);
    }

    public SearchResult(Long total, List<Goods> items) {
        super(total, items);
    }

    public SearchResult(Long total, List<Goods> items, Integer totalPage) {
        super(total, items, totalPage);
    }
}

