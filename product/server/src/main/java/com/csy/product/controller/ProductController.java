package com.csy.product.controller;

import com.csy.product.dataobject.ProductCategory;
import com.csy.product.dataobject.ProductInfo;
import com.csy.product.service.CategoryService;
import com.csy.product.service.ProductService;
import com.csy.product.VO.ProductInfoVO;
import com.csy.product.VO.ProductVO;
import com.csy.product.VO.ResultVO;
import com.csy.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品
 * Created by 廖师兄
 * 2017-12-09 21:13
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();

        return ResultVOUtil.success(productVOList);
    }

}
