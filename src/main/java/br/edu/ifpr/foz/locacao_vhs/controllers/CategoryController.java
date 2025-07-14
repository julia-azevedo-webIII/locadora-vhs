package br.edu.ifpr.foz.locacao_vhs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import br.edu.ifpr.foz.locacao_vhs.models.Category;
import br.edu.ifpr.foz.locacao_vhs.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public String findAll(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category-list";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-form";
    }
    
    @PostMapping
    public String save(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id).orElse(null);
        model.addAttribute("category", category);
        return "category-form";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "redirect:/categories";
    }
}
