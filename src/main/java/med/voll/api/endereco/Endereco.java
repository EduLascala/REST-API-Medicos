package med.voll.api.endereco;

//Imports
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable // Indica que esta classe pode ser incorporada em outras entidades
@Getter // Gera automaticamente getters para todos os campos
@NoArgsConstructor // Gera automaticamente um construtor sem argumentos
@AllArgsConstructor // Gera automaticamente um construtor com todos os argumentos
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    // Construtor que cria um novo 'Endereco' a partir de um objeto 'DadosEndereco'
    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }
}