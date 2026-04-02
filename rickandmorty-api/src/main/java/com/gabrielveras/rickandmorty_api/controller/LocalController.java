package com.gabrielveras.rickandmorty_api.controller;

import com.gabrielveras.rickandmorty_api.dto.ApiResponseDTO;
import com.gabrielveras.rickandmorty_api.dto.LocalDTO;
import com.gabrielveras.rickandmorty_api.service.LocalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locais")
public class LocalController {

    private final LocalService service;

    public LocalController(LocalService service) {
        this.service = service;
    }

    // GET /api/locais?page=1
    @GetMapping
    public ResponseEntity<ApiResponseDTO<LocalDTO>> listar(
            @RequestParam(defaultValue = "1") int page) {
        return ResponseEntity.ok(service.listarLocais(page));
    }

    // GET /api/locais/1
    @GetMapping("/{id}")
    public ResponseEntity<LocalDTO> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}