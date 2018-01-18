package com.codecool.boot.tea;

import com.codecool.boot.common.exceptions.NoSuchIdException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/teas")
public class TeaController {

    private TeaService service;

    public TeaController(TeaService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public Iterable<Tea> index() {
        return this.service.findAll();
    }

    @GetMapping(path = "/{id}")
    public Tea show(@PathVariable Integer id) throws NoSuchIdException {
        return this.service.findOne(id);
    }

    @PostMapping(path = "")
    public Tea create(@RequestBody Tea tea) {
        this.service.save(tea);
        return tea;
    }

    @PutMapping(path = "")
    public Tea put(@RequestBody Tea tea) {
        return this.service.put(tea);
    }

    @Deprecated
    public void delete(@PathVariable Integer id) {
        this.service.deleteById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void archive(@PathVariable Integer id) {
        this.service.archive(id);
    }
}
