package com.colourful.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colourful.domain.data.CategoryDetail;
import com.colourful.domain.entity.mapper.CategoryEntityMapper;

@Service
public class CategoryService {
    @Autowired
    private CategoryEntityMapper categoryEntityMapper;

    public List<CategoryDetail> getAllCategories() {
	return categoryEntityMapper.getAllCategories();
    }
}
