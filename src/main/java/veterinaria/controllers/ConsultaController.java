package veterinaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ConsultaController {

    @GetMapping("/consultas")
    public String mostrarFormulario() {
        return "consultas";
    }

    @PostMapping("/consultas")
    public String enviarConsulta(
            @RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam String mascota,
            @RequestParam String mensaje,
            RedirectAttributes redirect) {

        redirect.addFlashAttribute("mensaje",
                "Gracias por su consulta, " + nombre);

        return "redirect:/consultas";
    }
}
