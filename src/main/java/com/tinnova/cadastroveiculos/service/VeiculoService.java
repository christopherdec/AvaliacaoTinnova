package com.tinnova.cadastroveiculos.service;

import com.tinnova.cadastroveiculos.model.Marca;
import com.tinnova.cadastroveiculos.model.Veiculo;
import com.tinnova.cadastroveiculos.repository.MarcaRepository;
import com.tinnova.cadastroveiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    public Veiculo salvar(Veiculo veiculo) {
        Marca marca = marcaRepository.findById(veiculo.getMarca().getId())
                .orElseThrow(EntityNotFoundException::new);
        veiculo.setMarca(marca);
        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizar(Long veiculoId, Veiculo veiculo) {

        Veiculo veiculoAtual = veiculoRepository.findById(veiculoId)
                .orElseThrow(EntityNotFoundException::new);

        /* Melhor seria usar o ModelMapper para fazer as atualizações, eu não lembro como utilizá-lo, então implementei
         *  dessa forma não escalonável porque estou com pouco tempo para realização desta tarefa, peço desculpas.
         */
        if (veiculo.getMarca() != null) {
            Marca marca = marcaRepository.findById(veiculo.getMarca().getId())
                    .orElseThrow(EntityNotFoundException::new);
            veiculoAtual.setMarca(marca);
        }
        if (veiculo.getVeiculo() != null)
            veiculoAtual.setVeiculo(veiculo.getVeiculo());
        if (veiculo.getAno() == 0)
            veiculoAtual.setAno(veiculo.getAno());
        if (veiculo.getDescricao() != null)
            veiculoAtual.setDescricao(veiculo.getDescricao());
        if (veiculo.getCreated() != null)
            veiculoAtual.setCreated(veiculo.getCreated());
        if (veiculo.getUpdated() != null)
            veiculoAtual.setUpdated(veiculo.getUpdated());

        return veiculoRepository.save(veiculoAtual);
    }

    public void excluir(Long veiculoId) {
        veiculoRepository.deleteById(veiculoId);
    }

    public List<Veiculo> buscar(String nomeMarca, Integer ano, String cor) {

        List<Veiculo> veiculos;
        if (nomeMarca != null) {
            Marca marca = marcaRepository.findByNome(nomeMarca);
            if (marca == null)
                throw new EntityNotFoundException();
            veiculos = veiculoRepository.findByMarca(marca);
        } else {
            veiculos = veiculoRepository.findAll();
        }

        // TODO: criar uma implementação de VeiculoRepository chamada "findByMarcaAnoCor", que realize esta query
        if (ano != null)
            veiculos.removeIf(v -> v.getAno() != ano);
        if (cor != null)
            veiculos.removeIf(v -> !Objects.equals(v.getCor(), cor));

        return veiculos;
    }

    public List<Veiculo> buscar() {
        return veiculoRepository.findAll();
    }
}
