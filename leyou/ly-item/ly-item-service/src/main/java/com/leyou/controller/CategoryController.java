package com.leyou.controller;

import com.leyou.pojo.Category;
import com.leyou.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("list")
    public List<Category> findCategory(@RequestParam("pid") Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return categoryService.findCategory(category);
    }

    @RequestMapping("id")
    public Object findCate() {

        return categoryService.findCate(6);
    }

    @RequestMapping("addCategory")
    public String add(@RequestBody Category category) {
        String result = "ok";
        try {
            System.out.println("ok");
            categoryService.addCategory(category);
        } catch (Exception e) {
            System.out.println("no");
            result = "no";
        }
        return result;
    }

    @RequestMapping("editCategory")
    public String update(@RequestBody Category category) {
        String result = "ok";
        try {
            System.out.println("xok");
            categoryService.updateCategory(category);
        } catch (Exception e) {
            System.out.println("xno");
            result = "no";
        }
        return result;
    }

    @RequestMapping("deleteById")
    public String delete(@RequestParam("id") Long id) {
        String result = "ok";
        try {
            System.out.println("xok");
            categoryService.deleteCategory(id);
        } catch (Exception e) {
            System.out.println("xno");
            result = "no";
        }
        return result;
    }
    @RequestMapping("findCategoryById")
    public Category findCategoryById(@RequestParam("id") Long id){
        return  categoryService.findCategoryById(id);
    }

    @RequestMapping("findCategoryByCids")
    public List<Category> findCategoryByCids(@RequestBody List<Long> ids){
        return categoryService.findCategoryByCids(ids);
    }
}
