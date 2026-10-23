package veterinaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import veterinaria.service.CitaService;

@Controller
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    @GetMapping("/citas")
    public String listar(Model model) {
        model.addAttribute("citas", service.listar());
        return "citas/lista";
    }
}
