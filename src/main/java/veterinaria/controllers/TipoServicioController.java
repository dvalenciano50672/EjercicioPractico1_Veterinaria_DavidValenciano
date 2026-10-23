package veterinaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import veterinaria.domain.TipoServicio;
import veterinaria.service.TipoServicioService;

@Controller
@RequestMapping("/tipos")
public class TipoServicioController {

    private final TipoServicioService service;

    public TipoServicioController(TipoServicioService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tipos", service.listar());
        return "tipos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("tipoServicio", new TipoServicio());
        return "tipos/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        TipoServicio tipo = service.buscar(id);

        if (tipo == null) {
            return "redirect:/tipos";
        }

        model.addAttribute("tipoServicio", tipo);
        return "tipos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute TipoServicio tipoServicio,
                          RedirectAttributes redirect) {

        boolean nuevo = tipoServicio.getId() == null;
        service.guardar(tipoServicio);

        redirect.addFlashAttribute("mensaje",
                nuevo ? "Tipo de servicio agregado correctamente"
                      : "Tipo de servicio modificado correctamente");

        return "redirect:/tipos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id,
                           RedirectAttributes redirect) {

        service.eliminar(id);
        redirect.addFlashAttribute("mensaje",
                "Tipo de servicio eliminado correctamente");

        return "redirect:/tipos";
    }
}
