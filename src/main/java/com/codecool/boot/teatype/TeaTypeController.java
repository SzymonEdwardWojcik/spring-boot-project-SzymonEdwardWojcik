package com.codecool.boot.teatype;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/types")
public class TeaTypeController {

    private TeaTypeService service;

    public TeaTypeController(TeaTypeService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public Iterable<TeaType> index() {
        return this.service.findAll();
    }

    @GetMapping(path = "/{id}")
    public TeaType show(@PathVariable Integer id) {
        return this.service.findOne(id);
    }

    @PostMapping(path = "")
    public TeaType create(@RequestBody TeaType teaType) {
        this.service.save(teaType);
        return teaType;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.service.deleteById(id);
    }
}
