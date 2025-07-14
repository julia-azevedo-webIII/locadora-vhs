package br.edu.ifpr.foz.locacao_vhs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifpr.foz.locacao_vhs.TapeStatus;
import br.edu.ifpr.foz.locacao_vhs.models.VHS;
import br.edu.ifpr.foz.locacao_vhs.services.CategoryService;
import br.edu.ifpr.foz.locacao_vhs.services.VHSService;

@Controller
@RequestMapping("/vhs")
public class VHSController {

    @Autowired
    VHSService vhsService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String findAll(Model model){
        List<VHS> vhsList = vhsService.findAll();
        model.addAttribute("vhsList", vhsList);

        return "vhs-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("vhs", new VHS());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("statusOptions", TapeStatus.values());
        return "vhs-form";
    }
    
    @PostMapping
    public String save(@ModelAttribute VHS vhs) {
        vhsService.save(vhs);
        return "redirect:/vhs";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        VHS vhs = vhsService.findById(id).orElse(null);
        model.addAttribute("vhs", vhs);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("statusOptions", TapeStatus.values());
        return "vhs-form";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        vhsService.deleteById(id);
        return "redirect:/vhs";
    }
    
    @GetMapping("/available")
    public String findAvailable(Model model) {
        List<VHS> vhsList = vhsService.findAvailable();
        model.addAttribute("vhsList", vhsList);
        return "vhs-list";
    }
    
    @PostMapping("/rent/{id}")
    public String rent(@PathVariable Long id) {
        vhsService.rent(id);
        return "redirect:/vhs";
    }
    
    @PostMapping("/return/{id}")
    public String returnVHS(@PathVariable Long id) {
        vhsService.returnVHS(id);
        return "redirect:/vhs";
    }
    
    @GetMapping("/search")
    public String search(@RequestParam(required = false) String title, 
                        @RequestParam(required = false) Long categoryId,
                        Model model) {
        List<VHS> vhsList;
        
        if (title != null && !title.isEmpty()) {
            vhsList = vhsService.findByTitle(title);
        } else if (categoryId != null) {
            vhsList = vhsService.findByCategory(categoryId);
        } else {
            vhsList = vhsService.findAll();
        }
        
        model.addAttribute("vhsList", vhsList);
        model.addAttribute("categories", categoryService.findAll());
        return "vhs-list";
    }
}
