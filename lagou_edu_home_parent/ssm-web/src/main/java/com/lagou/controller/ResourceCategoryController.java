package com.lagou.controller;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourceCategoryVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();

        return  new ResponseResult(true,200,"查询所有分类信息成功",allResourceCategory);

    }

    @RequestMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategoryVO resourceCategoryVO){
        Integer id = resourceCategoryVO.getId();
        //如果id不等于null就是更新操作，如果是null则是新增操作
        if (id!=null){
            resourceCategoryService.updateResourceCategory(resourceCategoryVO);
            return new ResponseResult(true,200,"修改资源分类成功",null);
        }else {
            resourceCategoryService.saveResourceCategory(resourceCategoryVO);
            return new ResponseResult(true,200,"添加资源分类成功",null);
        }
    }

    @RequestMapping("/deleteResourceCategory")
    public ResponseResult deleteResourceCategory(Integer id){
        resourceCategoryService.deleteResourceCategory(id);
        return new ResponseResult(true,200,"删除资源分类成功",null);
    }
}
