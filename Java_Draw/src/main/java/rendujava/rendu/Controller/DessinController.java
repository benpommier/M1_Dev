package rendujava.rendu.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rendujava.rendu.Model.Dessin;
import rendujava.rendu.Repository.DessinRepository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class DessinController {
    private DessinRepository repo;
    private static Logger log;
    private DessinController(DessinRepository repository) {
        this.repo = repository;
    }

    @GetMapping("/dessins")
    public ResponseEntity<List<Dessin>> getalldessin() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/dessin")
    public ResponseEntity<Dessin> getdessinbyid(@RequestParam(value = "id", required = true) Integer id) {
        Optional<Dessin> dessin = repo.findById(id);
        if (dessin.isPresent()) {
            return ResponseEntity.ok(dessin.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/dessin/{name}")
    public ResponseEntity<Dessin> getdessinbyname(@PathVariable("name") String name) {
        Optional<Dessin> dessin = repo.findByName(name);
        if (dessin.isPresent()) {
            return ResponseEntity.ok(dessin.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/dessins", consumes = "application/json")
    public ResponseEntity<Dessin> postdessin(@RequestBody Dessin image) {
        repo.save(image);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/dessins/{id}")
    public ResponseEntity<Dessin> putdessin(@PathVariable("id") Integer id, @RequestBody Dessin image) {
        Optional<Dessin> olddessin = repo.findById(id);
        if (olddessin.isPresent()) {
            olddessin.get().setName(image.getName());
            olddessin.get().setWidth(image.getWidth());
            olddessin.get().setHeight(image.getHeight());
            olddessin.get().setDescription(image.getDescription());
            repo.save(olddessin.get());
        }
        return ResponseEntity.accepted().build();
    }
}
