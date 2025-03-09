package com.br.demo.service;

import com.br.demo.dto.request.CategoriaRequestDTO;
import com.br.demo.dto.response.CategoriaResponseDTO;
import com.br.demo.model.Categoria;
import com.br.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    public List<CategoriaResponseDTO> listarCategorias(){
        return categoriaRepository.findAll().stream()
                .map(c->new CategoriaResponseDTO(c.getId(),c.getNome()))
                .collect(Collectors.toList());
    }
    public CategoriaResponseDTO buscarPorId(Long id){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return new CategoriaResponseDTO(categoria.getId(),categoria.getNome());
    }

    public CategoriaResponseDTO criarCategoria(CategoriaRequestDTO categoriaRequestDTO){
        Categoria novaCategoria = new Categoria(null,categoriaRequestDTO.getNome(),categoriaRequestDTO.getDescricao());
        Categoria categoriaSalva = categoriaRepository.save(novaCategoria);
        return new CategoriaResponseDTO(categoriaSalva.getId(),categoriaSalva.getNome());
    }
    public CategoriaResponseDTO atualizarCategoria(Long id, CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        categoriaExistente.setNome(categoriaRequestDTO.getNome());
        categoriaExistente.setDescricao(categoriaRequestDTO.getDescricao());
        Categoria categoriaAtualizada = categoriaRepository.update(categoriaExistente);
        return new CategoriaResponseDTO(categoriaExistente.getId(),categoriaExistente.getDescricao());
    }
    public void excluirCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
