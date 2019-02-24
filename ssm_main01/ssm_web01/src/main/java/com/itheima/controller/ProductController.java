package com.itheima.controller;

import com.itheima.domain.PageBean;
import com.itheima.service.IProductService;
import com.itheima.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Product> productList = productService.findAll();
            ModelAndView mv = new ModelAndView();
            mv.setViewName("product-list");
            mv.addObject("productList",productList);
            return mv;
    }

    @RequestMapping("/save")
    public String save(Product product){
            productService.save(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/toUpdate")
    public ModelAndView findById(Integer id){
      Product product = productService.findById(id);
      ModelAndView mv = new ModelAndView();
      mv.setViewName("product-update");
      mv.addObject("product",product);
      return mv;
    }

    @RequestMapping("/update")
    public String update(Product product){
        productService.update(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/delete")
    public String delete(String productIds){
       productService.delete(productIds);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(defaultValue = "1") int pageNum ,@RequestParam(defaultValue = "2") int pageSize){
        PageBean<Product> pageBean = productService.findByPage(pageNum, pageSize);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product-list");
        mv.addObject("pageBean",pageBean);
        return mv;
    }

}
