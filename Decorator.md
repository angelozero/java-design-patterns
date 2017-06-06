# Decorator

Decorator adiciona funcionalidades ao objeto em tempo de execução. Note bem que, ao contrário da herança que aplica funcionalidades a todos os objetos dela, o padrão decorator permite aplicar funcionalidades apenas a um objeto específico.

Justamente devido a essa propriedade é que o padrão Decorator possui uma flexibilidade maior que a herança estática. Além disso, como o Decorator aplica apenas as funcionalidades necessárias ao objeto nós evitamos o problema de classes sobrecarregadas, que possuem funcionalidade que nunca são utilizadas.

Vamos ver qual a Intenção do padrão Decorator:

“Dinamicamente, agregar responsabilidades adicionais a objetos. Os Decorators fornecem uma alternativa flexível ao uso de subclasses para extensão de funcionalidades.” [1]

Perfeito, exatamente a solução do nosso problema! Queremos que, dado um objeto Coquetel, seja possível adicionar funcionalidades a ele, e somente a ele, em tempo de execução. Vamos ver a arquitetura sugerida pelo padrão:

![Decorator](https://brizeno.files.wordpress.com/2011/08/decorator-exemplo-certo1.png)

Vamos ver qual a Intenção do padrão Decorator:

“Dinamicamente, agregar responsabilidades adicionais a objetos. Os Decorators fornecem uma alternativa flexível ao uso de subclasses para extensão de funcionalidades.” [1]

Perfeito, exatamente a solução do nosso problema! Queremos que, dado um objeto Coquetel, seja possível adicionar funcionalidades a ele, e somente a ele, em tempo de execução. Vamos ver a arquitetura sugerida pelo padrão:



Certo, então todos os objetos possuem o mesmo tipo Coquetel, esta classe define o que todos os objeto possuem e é igual a classe já feita antes. As classes de bebidas concretas definem apenas os dados relativos a ela. Como exemplo vejamos o código da bebida Cachaça:

```java
public class Cachaca extends Coquetel {
    public Cachaca() {
        nome = "Cachaça";
        preco = 1.5;
    }
}
```

Todas as classes de bebidas possuirão a mesma estrutura, apenas definem os seus atributos. A classe Decorator abstrata define que todos os decoradores possuem um objeto Coquetel, ao qual decoram, e um método que é aplicado a este objeto. Vejamos o código para exemplificar:

```java
public abstract class CoquetelDecorator extends Coquetel {
    Coquetel coquetel;
 
    public CoquetelDecorator(Coquetel umCoquetel) {
        coquetel = umCoquetel;
    }
 
    @Override
    public String getNome() {
        return coquetel.getNome()  + " + " + nome;
    }
 
    public double getPreco() {
        return coquetel.getPreco() + preco;
    }
}
```

Lembre-se de que como o decorador também é um Coquetel ele herda os atributos nome e preço. Nas classes concretas apenas definimos os modificadores que serão aplicados, de maneira semelhante as classes de bebidas concretas, vejamos o exemplo do adicional Refrigerante:

```java
public class Refrigerante extends CoquetelDecorator {
 
    public Refrigerante(Coquetel umCoquetel) {
        super(umCoquetel);
        nome = "Refrigerante";
        preco = 1.0;
    }
 
}
```

Perceba que no construtor do decorador é necessário passar um objeto Coquetel qualquer, este objeto pode ser tanto uma bebida quanto outro decorador. Ai está o conceito chave para o padrão Decorator. Vamos acrescentando vários decoradores em qualquer ordem em uma bebida. Vamos ver agora como o padrão seria utilizado, veja o seguinte código do método main:

```java
public static void main(String[] args) {
        Coquetel meuCoquetel = new Cachaca();
        System.out.println(meuCoquetel.getNome() + " = "
                + meuCoquetel.getPreco());
 
        meuCoquetel = new Refrigerante(meuCoquetel);
        System.out.println(meuCoquetel.getNome() + " = "
                + meuCoquetel.getPreco());
    }
```

Perceba que o tipo do coquetel varia de acordo com o decorador aplicado. Então, quando chamamos o método getNome ou getPreco o primeiro método chamado é o método do último decorador aplicado.

O método do decorador por sua vez chama o método da classe mãe, este método então chama o método do Coquetel ao qual ele decora. Se esse coquetel for outro decorador o pedido é repassado até chegar a um coquetel que é uma bebida de fato e finalmente responde a requisição sem repassar a nenhum outro objeto.

De maneira semelhante a recursão, os valores calculados vão sendo retornados até chegar no último decorador aplicado e então são repassados ao objeto. É como se os decoradores englobassem tanto outros decoradores quanto o componente em si.


fonte: [Brizeno Wordpress](https://brizeno.wordpress.com/category/padroes-de-projeto/decorator/)
