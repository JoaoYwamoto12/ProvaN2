package br.senac.go.services;

import br.senac.go.domain.Sala;
import br.senac.go.generics.ISala;
import br.senac.go.repositories.SalaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class SalaService implements ISala<Sala, Integer> {

    private SalaRepository salaRepository;
    @Override
    public Sala create(Sala entity) {
        log.info("Método PessoaService.create invocado");
        log.debug("Valores informados PessoaService.create {}", entity);

        return this.salaRepository.save(entity);
    }

    @Override
    public Sala readById(Integer id) throws Exception {
        log.info("Metodo PessoaService.readByDd invocado");
        log.debug("Valores informados PessoaService.readById {}", id);

        Sala sala = this.salaRepository
                .findById(Long.valueOf(id))
                .orElseThrow(()-> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em PessoaService.readById são {}", sala);
        return sala;
    }

    @Override
    public Sala read(Sala entity) throws Exception {
        log.info("Método PessoaService.read invocado");
        log.debug("Valores informados PessoaService.read {}", entity);

        Example<Sala> pessoaAprocurar = Example.of(entity);
        Sala sala = this.salaRepository
                .findOne(pessoaAprocurar)
                .orElseThrow(() -> new Exception("Registro não encontrado."));
        log.debug("Valores recuperados em PessoaService.read são {}", sala);

        return sala;
    }

    @Override
    public Sala updatePatch(Sala entity, Integer id) throws Exception {
        log.info("Método PessoaService.updatePatch invocado");
        log.debug("Valores informados PessoaService.updatePatch {} {}", entity, id);
        Sala salaEncontrada = this.readById(id);

        salaEncontrada.setNomeSala(entity.getNomeSala());
        salaEncontrada.setDataInicio(entity.getDataInicio());
        salaEncontrada.setDataFim(entity.getDataFim());
        salaEncontrada.setNomeLocador(entity.getNomeLocador());

        return salaEncontrada;

    }

    @Override
    public Sala updatePut(Sala entity, Integer id) {
        return null;
    }

    @Override
    public Sala deleteById(Integer id) {
        return null;
    }

    @Override
    public Sala delete(Sala entity) {
        return null;
    }
}
