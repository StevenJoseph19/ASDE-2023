package com.acme.books.controller;

import com.acme.books.model.Category;
import com.acme.books.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(assignableTypes = {MainController.class})
public class CategoryControllerAdvice {
    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute
    public void injectCategory(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
    }
}
