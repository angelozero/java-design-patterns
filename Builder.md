# Builder

O padrão Builder é muito útil quando lidamos com a construção de objetos complexos, com construtores que requerem muitos parâmetros ou com múltiplos construtores. Veremos que o padrão também é útil quando temos métodos com parâmetros demais (ao ponto de dificultar a manutenção do código).

Neste post, vamos ver uma abordagem do padrão seguindo a linha do que foi descrito no livro "Effective Java", do Joshua Bloch. Essa abordagem também é feita no ótimo post do Dustin Marx sobre o pattern.

Vale lembrar que não existe uma maneira "certa" ou "errada" de se implementar o padrão. No final do post, na parte de Referências, estão alguns posts que gostei sobre o assunto, e é possível ver implementações ligeiramente diferentes, mas com o mesmo propósito.

#### Como o Builder funciona?

Vamos considerar como exemplo a classe Usuario a seguir:

```java
public class Usuario  
{
    private String nome;
    private String cpf; 
    private Calendar dataNascimento;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String informacoes;

    public Usuario(String nome, String cpf,
        Calendar dataNascimento, String endereco,
        String bairro, String cidade,
        String estado, String informacoes)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.informacoes = informacoes;
    }
}
```
Observe o construtor da classe, veja como fica complicado escrever tantos parâmetros. É aí que o Builder vai nos ajudar. :)

O Builder será uma classe separada responsável pela construção do nosso objeto. Conforme mencionei anteriormente, não existe uma maneira certa ou errada para escrever esse Builder, então você pode optar pelo que preferir: escrever uma classe em outro arquivo .java OU criar uma classe interna (nested class). Neste exemplo, vou escrever uma classe interna.

A classe Usuario, juntamente com a classe interna UsuarioBuilder ficaria da seguinte forma:

```java
public class Usuario  
{
    //atributos obrigatorios
    private String nome;
    private String cpf;
    //atributos opcionais
    private String dataNascimento;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String informacoes;

    private Usuario(UsuarioBuilder builder)
    {
        this.nome = builder.nome;
        this.cpf = builder.cpf;
        this.dataNascimento = builder.dataNascimento;
        this.endereco = builder.endereco;
        this.bairro = builder.bairro;
        this.cidade = builder.cidade;
        this.estado = builder.estado;
        this.informacoes = builder.informacoes;
    }

    public static class UsuarioBuilder
    {
        private String nome;
        private String cpf;
        private String dataNascimento;
        private String endereco;
        private String bairro;
        private String cidade;
        private String estado;
        private String informacoes;

        public UsuarioBuilder(String nome, String cpf)
        {
            this.nome = nome;
            this.cpf = cpf;
        }

        public UsuarioBuilder dataNascimento(String dataNascimento)
        {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public UsuarioBuilder endereco(String endereco)
        {
            this.endereco = endereco;
            return this;
        }

        public UsuarioBuilder bairro(String bairro)
        {
            this.bairro = bairro;
            return this;
        }

        public UsuarioBuilder cidade(String cidade)
        {
            this.cidade = cidade;
            return this;
        }

        public UsuarioBuilder estado(String estado)
        {
            this.estado = estado;
            return this;
        }

        public UsuarioBuilder informacoes(String informacoes)
        {
            this.informacoes = informacoes;
            return this;
        }

        public Usuario build()
        {
            return new Usuario(this);
        }
    }
}
```

O exemplo é grande, mas fique calmo: o código é bem simples. Repare que os atributos obrigatórios (nome e cpf) foram passados no construtor do Builder. Isso garante com que o objeto criado esteja sempre em um estado válido.

Ok, mas como uso esse Builder? Como vou criar um usuário?

Veja o método abaixo, que retorna um usuário, utilizando o Builder que criamos:

```java
public Usuario getUsuario()  
{
    return new Usuario.UsuarioBuilder("Dollynho", "11133344409")
        .dataNascimento("01/09/1979")
        .endereco("Rua do Amiguinho, 1000")
        .bairro("Guaranalandia")
        .cidade("Guaranazinho do Sul")
        .estado("Acre")
        .informacoes("Cuidado com o sol!")
        .build();
}
```

Perceba como ficou muito mais simples ler e criar nosso objeto. O builder possui uma Fluent Interface para tornar o código mais legível.

fonte: [Stefan Teixeira](http://stefanteixeira.com.br/2015/07/29/design-patterns-para-melhorar-seus-testes-parte-1-builder-fluent-interfaces/)
