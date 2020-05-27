package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista() {
        // Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação")); // -> CRIA NO BD EM MEMÓRIA

        List<Topico> topicos = topicoRepository.findAll();
        return TopicoDTO.converter(topicos);
    }

}