package com.BookStore.service;

import com.BookStore.model.Category;
import com.BookStore.model.Store;
import com.BookStore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public
    Category createType(Category category){
        return categoryRepository.save(category);
    }
    public
    Optional<Category> findById(Long typeId){
        return categoryRepository.findById(typeId);

    }
    public
    Iterable<Category> allTypes(){
        return categoryRepository.findAll();
    }

    public
    Category updateType(Category category,Long typeId){
        Optional<Category> existingCategoryOptional = categoryRepository.findById(typeId);

        Category existingCategory = existingCategoryOptional.get();

        existingCategory.setBookType(category.getBookType());

        return categoryRepository.save(existingCategory);
    }

    public void removetype(Long id){
            categoryRepository.deleteById(id);
    }
}
