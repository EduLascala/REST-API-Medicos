package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos") // Define o nome da tabela como "medicos"
@Entity(name = "Medico") // Define o nome da entidade como "Medico"
@Getter // Gera automaticamente getters para todos os campos
@NoArgsConstructor // Gera automaticamente um construtor sem argumentos
@AllArgsConstructor // Gera automaticamente um construtor com todos os argumentos
@EqualsAndHashCode(of = "id") // Define que a igualdade/hashcode será baseada apenas no campo 'id'
public class Medico {

    @Id // Define este campo como a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O valor deste campo será gerado automaticamente
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING) // Define que este campo é um Enum e será persistido como String
    private Especialidade especialidade;

    @Embedded // Define que este campo é um tipo incorporado
    private Endereco endereco;

    // Construtor que cria um novo 'Medico' a partir de um objeto 'DadosCadastroMedico'
    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
}