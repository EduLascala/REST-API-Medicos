package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping ("medicos") // Define a rota base para este controlador como "/medicos" (serve para salvar, atualizar ou excluir informações do banco)
public class MedicoController {

    @Autowired // Injeta automaticamente uma instância de MedicoRepository
    private MedicoRepository repository;

    @PostMapping // Define que este método deve ser chamado para requisições POST
    @Transactional
    public void cadastrar (@RequestBody @Valid DadosCadastroMedico dados){ // @RequestBody indica que os dados devem vir no corpo da requisição
        repository.save(new Medico(dados)); // Cria um novo Medico com os dados recebidos e salva no banco de dados
    }

    @GetMapping
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }

}