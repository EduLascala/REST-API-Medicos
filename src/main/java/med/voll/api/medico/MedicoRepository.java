package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

// Define uma interface chamada 'MedicoRepository'
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // Esta interface estende 'JpaRepository', que é uma interface do Spring Data JPA
    // 'JpaRepository' fornece métodos para operações de CRUD (criar, ler, atualizar, deletar) e outras operações comuns de banco de dados
    // 'Medico' é a entidade que esta interface gerencia e 'Long' é o tipo da chave primária da entidade
}
