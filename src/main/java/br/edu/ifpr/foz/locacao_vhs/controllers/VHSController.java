package br.edu.ifpr.foz.locacao_vhs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpr.foz.locacao_vhs.models.VHS;
import br.edu.ifpr.foz.locacao_vhs.services.VHSService;

@Controller
@RequestMapping("/vhs")
public class VHSController {

    @Autowired
    VHSService vhsService;

    @GetMapping
    public String findAll(Model model){
        List<VHS> vhsList = vhsService.findAll();
        model.addAttribute("vhsList", vhsList);

        return "vhs-list";
    }
}
