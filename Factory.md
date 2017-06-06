# Factory

De forma geral todos os padrões Factory (Simple Factory, Factory Method, Abstract Factory) encapsulam a criação de objetos. O padrão Factory Method por sua vez encapsula a criação de objetos, no entanto, a diferença é que neste padrão encapsula-se a criação de objetos deixando as subclasses decidirem quais objetos criar.

O Diagrama de classe abaixo mostra mais detalhes sobre o funcionamento do padrão Factory Method.

![Factory](http://videos.web-03.net/artigos/Higor_Medeiros/PadraoFactoryMethod/PadraoFactoryMethod1.jpg)

No diagrama de classe acima temos a classe de criador abstrata que é a Creator que define um método fábrica abstrata que as subclasses implementam para criar um produto (factoryMethod) e pode possuir um ou mais métodos com seus devidos comportamentos que chamarão o factoryMethod. Normalmente o método factoryMethod do Creator também possui um Product abstrato que é produzido por uma subclasse (ConcreteCreator). Nota-se que cada ConcreteCreator produzirá seu próprio método de criação.

Segundo o GOF (Group Of Four) o padrão Factory Method é: “Um padrão que define uma interface para criar um objeto, mas permite às classes decidirem qual classe instanciar. O Factory Method permite a uma classe deferir a instanciação para subclasses”.

Exemplo de Implementação
Segue abaixo um exemplo de implementação em Java utilizando o Padrão Factory Method. Inicialmente define-se abaixo os produtos abstratos e concretos que serão usados pela factory.

 - Listagem 1: Exemplo de implementação dos produtos

```java
public abstract class Pessoa {

	public String nome;
	public String sexo;

}

class Homem extends Pessoa {
	
	public Homem(String nome) {
		this.nome = nome;
		System.out.println(“Olá Senhor ” + this.nome);
	}
}

class Mulher extends Pessoa {
	
	public Mulher(String nome) {
		this.nome = nome;
		System.out.println(“Olá Senhora ” + this.nome);
	}

}
```

Acima temos a implementação da primeira parte do padrão Factory Method. Nesse exemplo criou-se os Produtos (abstratos e concretos) que executam a decisão tomada na factory.

Em tempo de execução não sabemos quem será chamado, ao invés de termos if’s e else’s no cliente, temos toda a lógica de decisão na factory que é mostrada abaixo.

- Listagem 2: Exemplo de implementação do Method Factory

```java
class FactoryPessoa {

	public Pessoa getPessoa(String nome, String sexo) {
		if (sexo.equals(“M”))
			return new Homem(nome);
		if (sexo.equals(“F”))
			return new Mulher(nome);
	}

}
```

Abaixo segue um exemplo de execução desse padrão descrito acima:

 - Listagem 3: Exemplo de implementação do Factory Method em Java

```java
public class TesteApp {
	
	public static void main(String args[]) {
		FactoryPessoa factory = new FactoryPessoa();
		String nome = “Carlos”;
		String sexo = “M”;
		factory.getPessoa(nome, sexo);
	}
}
```

Acima criou-se uma factory com os dados acima. Baseado na condição “sexo” temos a criação do objeto Homem que faz a saudação correta. Veja que toda a parte de decisão, ou a sujeira, fica tudo na fábrica para que ela possa decidir o que fazer.
