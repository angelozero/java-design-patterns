# Template Method

O padrão Template Method basicamente oferece um método que define um algoritmo (uma sequência de passos) que pode, por sua vez, ser definido como abstrato para posteriormente ser implementado por uma subclasse. Pode-se notar que a estrutura do algoritmo fica inalterada mesmo com as subclasses fazendo parte da implementação.

O Diagrama de classe abaixo mostra mais detalhes sobre o funcionamento do padrão Template Method.

![Template](http://videos.web-03.net/artigos/Higor_Medeiros/PadraoTemplateMethod_Java/PadraoTemplateMethod_Java1.jpg)

No diagrama de classe acima temos a classe AbstractClass contendo o método “templateMethod()” que possui o algoritmo e quel define os métodos “primitiveOperation1()” e “primitiveOperation2()” que são abstratos. As classes concretas Concrete1 e Concrete2 implementam os métodos abstratos que serão chamados quando “templateMethod()” precisar delas. Vale salientar que o método “templateMethod()” é final, ou seja, ele não pode ser sobrescrito, seu algoritmo não pode ser mexido. Já os métodos “primitiveOperation1()” e “primitiveOperation2()” podem ser sobrescritos. Além disso, ainda poderíamos ter um método concreto ou ainda um método final que não poderia ser sobrescrito e seria utilizado no algoritmo do templateMethod(). Isso ficará mais claro no exemplo de implementação abaixo.

### Exemplo de Implementação

Segue abaixo um exemplo de implementação em Java utilizando o Padrão Template Method.

 - Listagem 1: Exemplo de implementação do Padrão Template Method
 
 ```java
 public abstract class Treinos {

	final void treinoDiario() {
		preparoFisico();
		jogoTreino();
		treinoTatico();
	}

	abstract void preparoFisico();
	abstract void jogoTreino();
		
	final void treinoTatico() {
		System.out.println("Treino Tatico");
	}

}

class TreinoNoMeioDaTemporada extends Treinos {

	void preparoFisico() {
		System.out.println("Preparo Fisico Intenso.");
	}

	void jogoTreino() {
		System.out.println("Jogo Treino com Equipe Reserva.");
	}
}

class TreinoNoInicioDaTemporada extends Treinos {

	void preparoFisico() {
		System.out.println("Preparo Fisico Leve.");
	}

	void jogoTreino() {
		System.out.println("Jogo Treino com Equipe Junior.");
	}

} 
```

No exemplo acima temos a classe principal “Treinos” que tem o método “treinoDiario()” que tem como principal finalidade ser um algoritmo a ser seguido por todas as outras classes que estenderem essa classe. Este método é final e não pode ser alterado, todos os treinos devem seguir estas etapas. No entanto, as classes “TreinoNoMeioDaTemporada” e “TreinoNoInicioDaTemporada” implementam os métodos abstratos “preparoFisico()” e “jogotreino()”. Ambos estes métodos podem ser alterados dependendo se o treino está sendo feito no inicio de uma temporada ou no meio dela. Assim, cada método é implementado por sua classe especifica, mas sempre seguindo o algoritmo. O método “treinoTatico()” é definido pelo algoritmo e pela classe base, este método é concreto e final, portanto não pode ser alterado e é seguido por todos os treinamentos. Nada impede também de termos métodos concretos que podem ser sobrescritos nas subclasses ou que simplesmente podem ser usados da sua classe base.


### Utilização do Template Method nas API’s Java

O Padrão Template Method também é utilizado nas API’s do Java, como na API Swing onde a classe JFrame define o método paint() como abstrato para ser implementado nas subclasses que estendem JFrame. A substituição do conteúdo de paint() permite que você se conecte ao algoritmo de JFrame para exibir sua área da tela e incorporar a sua própria saída gráfica ao JFrame. Os Applets também utilizam o padrão Template Method através dos métodos init(), start(), stop(), destroy(), e outros.

fonte: [Devmedia](http://www.devmedia.com.br/padrao-de-projeto-template-method-em-java/26656)

