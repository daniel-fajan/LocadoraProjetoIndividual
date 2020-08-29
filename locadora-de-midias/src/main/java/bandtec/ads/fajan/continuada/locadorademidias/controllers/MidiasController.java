package bandtec.ads.fajan.continuada.locadorademidias.controllers;

import bandtec.ads.fajan.continuada.locadorademidias.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/midias")
public class MidiasController {

    private List<Midia> midias;

    public MidiasController() throws Exception {
        midias = new ArrayList();
        midias.add(new CD("Baroes da pisadinha", 2019, "CD Center"));
        midias.add(new CD("ForróBoys", 2018, "Universal Music"));
        midias.add(new DVD("Os Vingadores", 2010, "Disney"));
        midias.add(new DVD("Matrix", 1999, "Hollywood Films"));
        midias.add(new Jogo("Wolfenstein: The New Order", 2014, "Bethesda"));
        midias.add(new Jogo("Counter Strike: Global Offensive", 2010, "Valve"));
    }

    @GetMapping
    public List exibirTodos() {
        return midias;
    }

    @GetMapping("/buscar/peloId/{id}")
    public Midia buscar(@PathVariable int id) {
        return midias.get(--id);
    }

    @GetMapping("/buscar/peloNome/{parametro}")
    public Midia buscar(@PathVariable String parametro) {
        for (Midia m : midias)
            if (m.getNome().equals(parametro))
                return m;
        return null;
    }

    //Arrumar
    @PostMapping("/adicionar")
    public void adicionar(@RequestBody Midia midia) {
        midias.add(midia);
    }

    //Arrumar
    @PutMapping("/alterar/{id}")
    public void alterar(@PathVariable int id, @RequestBody Midia midia) {
        midias.set(--id, midia);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable int id) {
        midias.remove(--id);
    }
}
