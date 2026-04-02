package com.gabrielveras.rickandmorty_api;

import com.gabrielveras.rickandmorty_api.client.RickAndMortyClient;
import com.gabrielveras.rickandmorty_api.dto.ApiResponseDTO;
import com.gabrielveras.rickandmorty_api.dto.PersonagemDTO;
import com.gabrielveras.rickandmorty_api.service.PersonagemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonagemServiceTest {

    @Mock
    private RickAndMortyClient client;

    @InjectMocks
    private PersonagemService service;

    private PersonagemDTO personagem;
    private ApiResponseDTO<PersonagemDTO> response;

    @BeforeEach
    void setUp() {
        personagem = new PersonagemDTO();
        personagem.setId(1);
        personagem.setName("Rick Sanchez");
        personagem.setStatus("Alive");
        personagem.setSpecies("Human");

        response = new ApiResponseDTO<>();
        response.setResults(List.of(personagem));
    }

    @Test
    void deveListarPersonagensComSucesso() {
        when(client.listarPersonagens(1)).thenReturn(response);

        ApiResponseDTO<PersonagemDTO> resultado = service.listarPersonagens(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getResults().size());
        assertEquals("Rick Sanchez", resultado.getResults().get(0).getName());
        verify(client, times(1)).listarPersonagens(1);
    }

    @Test
    void deveBuscarPersonagemPorIdComSucesso() {
        when(client.buscarPorId(1)).thenReturn(personagem);

        PersonagemDTO resultado = service.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Rick Sanchez", resultado.getName());
        verify(client, times(1)).buscarPorId(1);
    }

    @Test
    void deveLancarExcecaoQuandoIdInvalido() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.buscarPorId(0));

        assertEquals("ID deve ser maior que zero", ex.getMessage());
        verify(client, never()).buscarPorId(anyInt());
    }

    @Test
    void deveBuscarPersonagemPorNomeComSucesso() {
        when(client.buscarPorNome("Rick")).thenReturn(response);

        ApiResponseDTO<PersonagemDTO> resultado = service.buscarPorNome("Rick");

        assertNotNull(resultado);
        assertEquals("Rick Sanchez", resultado.getResults().get(0).getName());
        verify(client, times(1)).buscarPorNome("Rick");
    }

    @Test
    void deveLancarExcecaoQuandoNomeVazio() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.buscarPorNome(""));

        assertEquals("Nome nao pode ser vazio", ex.getMessage());
        verify(client, never()).buscarPorNome(anyString());
    }

    @Test
    void deveFiltrarPorStatusComSucesso() {
        when(client.filtrarPorStatus("alive", 1)).thenReturn(response);

        ApiResponseDTO<PersonagemDTO> resultado = service.filtrarPorStatus("alive", 1);

        assertNotNull(resultado);
        verify(client, times(1)).filtrarPorStatus("alive", 1);
    }

    @Test
    void deveLancarExcecaoQuandoStatusInvalido() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.filtrarPorStatus("invalido", 1));

        assertEquals("Status invalido. Use: alive, dead ou unknown", ex.getMessage());
        verify(client, never()).filtrarPorStatus(anyString(), anyInt());
    }
}
