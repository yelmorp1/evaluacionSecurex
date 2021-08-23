package com.tickets.demotickets.controller;

import com.tickets.demotickets.model.Cajero;
import com.tickets.demotickets.model.Cola;
import com.tickets.demotickets.repository.CajeroRepository;
import com.tickets.demotickets.repository.ColaRepository;
import com.tickets.demotickets.service.ColaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CajeroController {

    @Autowired
    CajeroRepository cajeroRepository;

    @Autowired
    ColaRepository colaRepository;

    @Autowired
    ColaService colaService;

    @GetMapping("")
    public String listCajero(Model model) {
        model.addAttribute("colas", colaRepository.findAll());
        model.addAttribute("cajeros", cajeroRepository.findAll());
        return "index";
    }


    @GetMapping("/generar-ticket")
    public String updateExclusivoCajero(Model model, RedirectAttributes redirAttrs) {

        colaService.generarTicket();

        return "redirect:/";
    }

    @GetMapping("/update/exclusivo/{id}")
    public String updateExclusivoCajero(@PathVariable("id") int id, Model model, RedirectAttributes redirAttrs) {


        Cajero c = cajeroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cajero Id:" + id));

        c.setEsExclusivo(!c.isEsExclusivo());

        if(!colaService.canDisableCajero(id, cajeroRepository.findAllByEsExclusivoIsTrueOrEsNormalIsTrue())){
            System.out.println(c.isEsExclusivo());
            redirAttrs.addFlashAttribute("error", "No se puede tener menos de dos ventanillas activas, y almenos 1 Exclusiva y 1 Normal");
            return "redirect:/";
        }

        cajeroRepository.save(c);
        model.addAttribute("cajeros", cajeroRepository.findAll());
        return "redirect:/";
    }

    @GetMapping("/update/normal/{id}")
    public String updateNormalCajero(@PathVariable("id") int id, Model model, RedirectAttributes redirAttrs) {

        Cajero cajero = cajeroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cajero Id:" + id));

        cajero.setEsNormal(cajero.isEsNormal() ? false : true);

        if(!colaService.canDisableCajero(id, cajeroRepository.findAllByEsExclusivoIsTrueOrEsNormalIsTrue())){
            redirAttrs.addFlashAttribute("error", "No se puede tener menos de dos ventanillas activas, y almenos 1 Exclusiva y 1 Normal");
            return "redirect:/";
        }

        cajeroRepository.save(cajero);
        model.addAttribute("cajeros", cajeroRepository.findAll());
        return "redirect:/";
    }

    @GetMapping("/update/preferencial/{id}")
    public String updatePreferencialCajero(@PathVariable("id") int id, Model model) {

        Cajero cajero = cajeroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cajero Id:" + id));

        cajero.setEsPreferencial(cajero.isEsPreferencial() ? false : true);
        cajeroRepository.save(cajero);
        model.addAttribute("cajeros", cajeroRepository.findAll());
        return "redirect:/";
    }
}
