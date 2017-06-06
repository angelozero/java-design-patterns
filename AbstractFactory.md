# Abstract Factory

O padrão de projeto Abstract Factory define uma interface para criar famílias de objetos sem especificar suas classes concretas.
Veja o seu diagrama de classes e código Java que implementam o padrão:

![Abstract Factory](http://cdn.matera.com/br/wp-content/uploads/2015/05/abstract-factory-01.png)


```java
public interface ProdutoAbstrato {
}

public class ProdutoConcretoA implements ProdutoAbstrato {
}

public class ProdutoConcretoB implements ProdutoAbstrato {
}

public abstract class FabricaAbstrata {
  public abstract ProdutoAbstrato criarProduto();
}

public class FabricaConcretaA extends FabricaAbstrata {
  public ProdutoAbstrato criarProduto() {
    return new ProdutoConcretoA();
  }
}

public class FabricaConcretaB extends FabricaAbstrata {
  public ProdutoAbstrato criarProduto() {
    return new ProdutoConcretoB();
  }
}
```
Os elementos participantes desse padrão são:

##### FabricaAbstrata

Como o nome já diz, é uma “Fábrica Abstrata”. Pode ser uma classe — de preferência abstrata, ou uma interface. Seu objetivo é declarar métodos de criação de objetos do tipo ProdutoAbstrato, que são implementados por uma classe do tipo FabricaConcreta, que estende ou implementa a FabricaAbstrata.

##### FabricaConcreta

Estende ou implementa a FabricaAbstrata. Podem ser definidas várias classes desse tipo, de acordo com o cenário do problema de projeto a ser resolvido. Na verdade só da necessidade de se utilizar esse padrão, pelo menos duas classes desse tipo são definidas. Aqui o esforço é implementar os métodos declarados em FabricaAbstrata, criando um objeto do tipo ProdutoConcreto e retornando-o como um ProdutoAbstrato (polimorfismo!). Veremos logo mais, que é comum existir mais de uma classe do tipo ProdutoConcreto assim como ocorre com a classe do tipo FabricaConcreta. Na verdade, a quantidade de classes do tipo FabricaConcreta está diretamente ligada com a quantidade de classes do tipo ProdutoConcreto.

##### ProdutoAbstrato

Pode ser uma classe — de preferência abstrata, ou uma interface. Declara os métodos que são implementados por classes do tipo ProdutoConcreto. Como já explicado, um método de FabricaConcreta, cria internamente um objeto do tipo ProdutoConcreto mas esse objeto é retornado como um ProdutoAbstrato. Um objeto consumidor de Abstract Factory, não sabe qual ProdutoConcreto está sendo criado — e nem precisa saber —, mas sabe quais métodos do produto ele pode utilizar, e esses métodos são definidos aqui!

##### ProdutoConcreto

Estende ou implementa a classe ProdutoAbstrato. Nessa classe são implementados os métodos declarados em ProdutoAbstrato. Pode-se dizer que essa classe é a causa de toda essa brincadeira. Pensando em um cenário real, é o conteúdo dessa classe que estaria fazendo algo em algum lugar em um aplicativo, se não estivesse sendo aplicado esse padrão de projeto. Como já foi dito antes, é comum existir mais de uma classe do tipo ProdutoConcreto no projeto. Essa quantidade está diretamente ligada com a quantidade de classes do tipo FabricaConcreta: para cada FabricaConcreta, há pelo menos um ProdutoConcreto.


fonte: [Matera](http://www.matera.com/br/2015/02/25/design-patterns-abstract-factory/)

[Bryan Hansen GitHub](https://github.com/bh5k)
