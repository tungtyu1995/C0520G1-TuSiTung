package vn.codegym.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.blog.model.Category;
import vn.codegym.blog.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ModelAndView show() {
        List<Category> categoryList = categoryService.findAllCategory();
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @GetMapping("/category/create")
    public ModelAndView viewCreate() {
        return new ModelAndView("category/create", "category", new Category());
    }

    @PostMapping("/category/create")
    public ModelAndView create(@ModelAttribute Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("message", "Create Category Successful!!!");
        modelAndView.addObject("category", new Category());
        return modelAndView;

    }
}