package com.lagou.service.impl;

import com.lagou.dao.ResourceCategoryMapper;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourceCategoryVO;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;


    @Override
    public List<ResourceCategory> findAllResourceCategory() {

        List<ResourceCategory> allResourceCategory = resourceCategoryMapper.findAllResourceCategory();

        return allResourceCategory;
    }

    @Override
    public void saveResourceCategory(ResourceCategoryVO resourceCategoryVO) {
        ResourceCategory rc = new ResourceCategory();
        rc.setName(resourceCategoryVO.getName());
        rc.setSort(resourceCategoryVO.getSort());
        Date date = new Date();
        rc.setCreatedTime(date);
        rc.setUpdatedTime(date);
        rc.setCreatedBy("system");
        rc.setUpdatedBy("system");
        resourceCategoryMapper.saveResourceCategory(rc);
    }

    @Override
    public void updateResourceCategory(ResourceCategoryVO resourceCategoryVO) {
        ResourceCategory rc = new ResourceCategory();
        rc.setId(resourceCategoryVO.getId());
        rc.setName(resourceCategoryVO.getName());
        rc.setSort(resourceCategoryVO.getSort());
        rc.setUpdatedTime(new Date());
        rc.setUpdatedBy("system");
        resourceCategoryMapper.updateResourceCategory(rc);
    }

    @Override
    public void deleteResourceCategory(Integer id) {
        resourceCategoryMapper.deleteResourceCategory(id);
    }


}
