package com.codecool.boot.tea;

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

    @PostMapping(path = "")
    public Tea create(@RequestBody Tea tea) {
        this.service.save(tea);
        return tea;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.service.deleteById(id);
    }
}
