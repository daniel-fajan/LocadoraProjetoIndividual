package bandtec.ads.fajan.continuada.locadorademidias.controllers;

import bandtec.ads.fajan.continuada.locadorademidias.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
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
    public ResponseEntity exibirTodos() {
        if (midias.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(midias);
    }

    @GetMapping("/{tipoDeMidia}")
    public ResponseEntity exibirTodos(@PathVariable String tipoDeMidia) {
        List<Midia> midiasFiltradas = new ArrayList();
        for (Midia m : midias) {
            if (tipoDeMidia.equals("cd")) {
                if (m instanceof CD)
                    midiasFiltradas.add(m);
            } else if (tipoDeMidia.equals("dvd")) {
                if (m instanceof DVD)
                    midiasFiltradas.add(m);
            } else if (tipoDeMidia.equals("jogo")) {
                if (m instanceof Jogo)
                    midiasFiltradas.add(m);
            } else return ResponseEntity.badRequest().build();
        } if (midiasFiltradas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(midiasFiltradas);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity buscar(@PathVariable int id) {
        if (id > 0) {
            if (midias.size() >= id)
                return ResponseEntity.ok(midias.get(--id));
            return ResponseEntity.noContent().build();
        } return ResponseEntity.badRequest().build();
    }

    @PostMapping("/cd")
    public ResponseEntity adicionar(@RequestBody CD cd) {
        midias.add(cd);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/dvd")
    public ResponseEntity adicionar(@RequestBody DVD dvd) {
        midias.add(dvd);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/jogo")
    public ResponseEntity adicionar(@RequestBody Jogo jogo) {
        midias.add(jogo);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/cd/{id}")
    public ResponseEntity editar(@PathVariable int id, @RequestBody CD cd) {
        if (id > 0) {
            if (midias.size() >= id && midias.get(--id) instanceof CD) {
                midias.set(--id, cd);
                return ResponseEntity.ok().build();
            } return ResponseEntity.notFound().build();
        } return ResponseEntity.badRequest().build();
    }

    @PutMapping("/dvd/{id}")
    public ResponseEntity editar(@PathVariable int id, @RequestBody DVD dvd) {
        if (id > 0) {
            if (midias.size() >= id && midias.get(--id) instanceof DVD) {
                midias.set(--id, dvd);
                return ResponseEntity.ok().build();
            } return ResponseEntity.notFound().build();
        } return ResponseEntity.badRequest().build();
    }

    @PutMapping("/jogo/{id}")
    public ResponseEntity editar(@PathVariable int id, @RequestBody Jogo jogo) {
        if (id > 0) {
            if (midias.size() >= id && midias.get(--id) instanceof Jogo) {
                midias.set(id, jogo);
                return ResponseEntity.ok().build();
            } return ResponseEntity.notFound().build();
        } return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id) {
        if (id > 0) {
            if (midias.size() >= id) {
                midias.remove(--id);
                return ResponseEntity.ok().build();
            } return ResponseEntity.notFound().build();
        } return ResponseEntity.badRequest().build();
    }
}
