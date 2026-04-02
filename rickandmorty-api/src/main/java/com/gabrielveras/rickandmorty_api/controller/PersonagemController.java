package com.gabrielveras.rickandmorty_api.controller;

import com.gabrielveras.rickandmorty_api.dto.ApiResponseDTO;
import com.gabrielveras.rickandmorty_api.dto.PersonagemDTO;
import com.gabrielveras.rickandmorty_api.service.PersonagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller de personagens - expõe endpoints próprios que consomem a API externa.
@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {

    private final PersonagemService service;

    public PersonagemController(PersonagemService service) {
        this.service = service;
    }

    // GET /api/personagens?page=1
    // Lista todos os personagens com paginação
    @GetMapping
    public ResponseEntity<ApiResponseDTO<PersonagemDTO>> listar(
            @RequestParam(defaultValue = "1") int page) {
        return ResponseEntity.ok(service.listarPersonagens(page));
    }

    // GET /api/personagens/1
    // Busca personagem especifico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // GET /api/personagens/buscar?nome=Rick
    // Busca personagens pelo nome
    @GetMapping("/buscar")
    public ResponseEntity<ApiResponseDTO<PersonagemDTO>> buscarPorNome(
            @RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    // GET /api/personagens/filtrar?status=alive&page=1
    // Filtra personagens por status: alive, dead ou unknown
    @GetMapping("/filtrar")
    public ResponseEntity<ApiResponseDTO<PersonagemDTO>> filtrarPorStatus(
            @RequestParam String status,
            @RequestParam(defaultValue = "1") int page) {
        return ResponseEntity.ok(service.filtrarPorStatus(status, page));
    }
}