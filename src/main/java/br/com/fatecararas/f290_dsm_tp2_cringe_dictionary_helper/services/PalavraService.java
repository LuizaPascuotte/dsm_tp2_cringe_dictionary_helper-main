package br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.model.Palavra;
import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.repositories.PalavraRepository;

@Service
public class PalavraService {

    @Autowired
    private PalavraRepository repository;

    public void adicionar(Palavra palavra) {
        repository.save(palavra);
    }

    public List<Palavra> obterTodas() {
        return repository.findAll();
    }

    public Palavra obterPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    public void editar(Palavra palavra) {
        repository.save(palavra);
    }
}
