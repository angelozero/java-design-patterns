# Adapter

O padrão Adapter é muito utilizado quando precisamos encaixar uma nova biblioteca de classes, adquirida de um fornecedor, em um sistema de software já existente, porém essas bibliotecas de classe do novo fornecedor são diferentes das bibliotecas de classes do fornecedor antigo. Como não temos o código do novo fornecedor e também não podemos alterá-la, o que pode ser feito é criar uma classe que faça essa adaptação, ou seja, ela é responsável por adaptar a interface do novo fornecedor ao formato que o sistema espera. O Adapter é muito utilizado para compatibilizar o seu sistema a outros frameworks ou APIs.

Portanto, o adaptador é um intermediador que recebe solicitações do cliente e converte essas solicitações num formato que o fornecedor entenda. O adaptador converte uma interface para outra, porém, também poderíamos ter um caso em que precisaríamos adaptar mais de uma classe, nesse caso entra em cena outro padrão de projeto chamado Facade (Fachada) que é discutido em outro artigo. Se a interface do fornecedor mudar novamente apenas o Adaptador necessitará ser modificado sem alterar o resto do sistema.

A definição oficial do padrão Adapter é: “O Padrão Adapter converte uma interface de uma classe para outra interface que o cliente espera encontrar. O Adaptador permite que classes com interfaces incompatíveis trabalhem juntas”.

O Diagrama de classe abaixo mostra mais detalhes sobre o funcionamento do padrão Adapter.


![Adapter](http://videos.web-03.net/artigos/Higor_Medeiros/PadraoAdapter_Java/PadraoAdapter_Java1.jpg)


No diagrama de classe acima tem-se o Client, que é quem acessa a interface do Adaptador e a partir desta interface ele fará uma solicitação ao adaptador. O Adaptador, por sua vez, implementa a interface alvo (Target) e comunica-se com o Adaptado (Adaptee). O Adaptado é a nova biblioteca do fornecedor que está sendo inserida no sistema. No exemplo ficará mais clara a função de cada um dos elementos explicitados no diagrama de classes acima.

#### Exemplo de Implementação

```java
public class TomadaDeDoisPinos {
	public void ligarNaTomadaDeDoisPinos() {
		System.out.println("Ligado na Tomada de Dois Pinos");
	}
}

public class TomadaDeTresPinos {
	public void ligarNaTomadaDeTresPinos() {
		System.out.println("Ligado na Tomada de Tres Pinos");
	}
}

public class AdapterTomada extends TomadaDeDoisPinos {
	private TomadaDeTresPinos tomadaDeTresPinos;

	public AdapterTomada(TomadaDeTresPinos tomadaDeTresPinos) {
		this.tomadaDeTresPinos = tomadaDeTresPinos;
	}

	public void ligarNaTomadaDeDoisPinos() {
		tomadaDeTresPinos.ligarNaTomadaDeTresPinos();
	}
}
```

Veja que nós temos uma classe TomadaDeDoisPinos mas nós queremos nos conectar a uma classe TomadaDeTresPinos que possui outros métodos e uma outra interface diferente. Assim criamos um Adapter para que possamos acessá-la. Veja que o Adaptador herda da classe que você possui (o seu Target como mostrado no diagrama de classes). Dentro do adaptador temos o que o cliente precisa que é o TomadaDeTresPinos que será chamado posteriormente no método ligarNaTomadaDeDoisPinos que na verdade está chamando o método ligarNaTomadaDeTresPinos do novo fornecedor.

Para executarmos o aplicativo de teste podemos usar a implementação abaixo:

```java
public class Teste {

	public static void main(String args[]) {
		TomadaDeTresPinos t3 = new TomadaDeTresPinos();
		
		AdapterTomada a = new AdapterTomada(t3);
		a.ligarNaTomadaDeDoisPinos();
	}

}
```

Nota-se que o cliente faz uma chamada normalmente usando a tomada de dois pinos, mas na realidade esta chamada está sendo adaptada para uma tomada de três pinos. Assim temos duas interfaces que não eram compatíveis entre si conversando normalmente.

fonte: [DevMedia](http://www.devmedia.com.br/padrao-de-projeto-adapter-em-java/26467)
