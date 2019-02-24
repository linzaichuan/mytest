package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.IOrdersService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Orders> ordersList = ordersService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("order-list");
        mv.addObject("ordersList", ordersList);
        return mv;
    }

    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell1 = row.createCell(0);
        XSSFCell cell2 = row.createCell(1);
        XSSFCell cell3 = row.createCell(2);
        XSSFCell cell4 = row.createCell(3);
        XSSFCell cell5 = row.createCell(4);
        XSSFCell cell6 = row.createCell(5);
        cell1.setCellValue("ID");
        cell2.setCellValue("订单编号");
        cell3.setCellValue("订单出行人数");
        cell4.setCellValue("产品编号");
        cell5.setCellValue("产品名称");
        cell6.setCellValue("产品价格");

        int index = 1;

        List<Orders> list = ordersService.findAll();
        for (Orders order : list) {
             row = sheet.createRow(index++);
             row.createCell(0).setCellValue(order.getId());
             row.createCell(1).setCellValue(order.getOrderNum());
             row.createCell(2).setCellValue(order.getPeopleCount());
             row.createCell(3).setCellValue(order.getProduct().getId());
             row.createCell(4).setCellValue(order.getProduct().getProductName());
             row.createCell(5).setCellValue(order.getProduct().getProductPrice());
        }
      String fileName = URLEncoder.encode("产品表.xlsx","utf8" );
        response.setCharacterEncoding("utf8");
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("content-disposition","attachement;filename="+fileName);
        workbook.write(outputStream);
        workbook.close();

    }

    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(defaultValue = "1") int pageNum ,@RequestParam(defaultValue = "2") int pageSize){

        PageInfo<Orders> pageInfo = ordersService.findByPage(pageNum, pageSize);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("order-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

}
