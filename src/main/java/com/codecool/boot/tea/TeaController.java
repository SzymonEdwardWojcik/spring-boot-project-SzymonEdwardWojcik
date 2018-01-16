package com.codecool.boot.tea;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/teas")
public class TeaController {

    private TeaRepository repository;

    public TeaController(TeaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "")
    public Iterable<Tea> index() {
        return this.repository.findAll();
    }

    @PostMapping(path = "")
    public Tea create(@RequestBody Tea tea) {
        this.repository.save(tea);
        return tea;
    }
}
