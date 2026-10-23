package veterinaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import veterinaria.domain.Servicio;
import veterinaria.service.ServicioService;
import veterinaria.service.TipoServicioService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioService service;
    private final TipoServicioService tipoService;

    public ServicioController(ServicioService service,
                              TipoServicioService tipoService) {
        this.service = service;
        this.tipoService = tipoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("servicios", service.listar());
        return "servicios/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("tipos", tipoService.listar());
        return "servicios/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Servicio servicio = service.buscar(id);

        if (servicio == null) {
            return "redirect:/servicios";
        }

        model.addAttribute("servicio", servicio);
        model.addAttribute("tipos", tipoService.listar());
        return "servicios/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Servicio servicio,
                          RedirectAttributes redirect) {

        boolean nuevo = servicio.getId() == null;
        service.guardar(servicio);

        redirect.addFlashAttribute("mensaje",
                nuevo ? "Servicio agregado correctamente"
                      : "Servicio modificado correctamente");

        return "redirect:/servicios";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id,
                           RedirectAttributes redirect) {

        service.eliminar(id);
        redirect.addFlashAttribute("mensaje",
                "Servicio eliminado correctamente");

        return "redirect:/servicios";
    }
}
