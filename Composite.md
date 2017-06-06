# Composite

A intenção do padrão Composite é compor objetos em estruturas de árvore para representar hierarquia partes-todo.
Por exemplo, em interfaces gráficas, um elemento gráfico pode ser formado pela composição de vários outros elementos. Uma página de internet pode conter um ou mais ícones, além de caixas de texto e vários outros elementos. Considerando que uma determinada hierarquia de classes indica um Elemento Gráfico como, portanto, a super-classe - comum à todas classes que representam elementos gráficos atômicos. Assim, a "página" pode ser representada tanto como uma classe que contém zero ou mais elementos gráficos. Veja diagrama a seguir.
Outro exemplo são as linguagens de programação. A hierarquia de classes é utilizada para representar os comandos da linguagem. Supondo que a super-classe seria "Comando", teríamos, pois, uma classe de atribuição, além de o comando While e o comando composto - constituído por uma lista de outros comandos normalmente delimitados por indicadores como { e } ou palavras reservadas como begin, end, etc -. Normalmente são representados utilizando o padrão composite. Também representado pelo diagrama abaixo.
Vale ressaltar que é fundamental implementar cada método do objeto composto para ser aplicável à lista de objetos que possui. Logo, um objeto "cliente" faz necessário ativar o método desenha() de um objeto do tipo "Janela". Este método deverá ser capaz de ativar o " desenha() " de objeto que o contém. Desta maneira, será possível interagir com uma composição de objetos da mesma forma que interage-se com objetos individuais.

![Composite](https://upload.wikimedia.org/wikipedia/commons/f/f8/ElementoGrafico.jpg)

Outro exemplo:


Um atributo estático na classe base Entity pode ser manipulado por cada objeto Box para controlar a indentação.

```java
abstract class Entity {
    protected static StringBuffer indent = new StringBuffer();
    protected static int level = 1;

    public abstract void traverse(int[] levels);

    protected boolean printThisLevel(int[] levels) {
        for (int value : levels) {
            if (level == value) {
                return true;
            }
        }
        return false;
    }
}

class Product extends Entity {
    private int value;
    public Product(int value) {
        this.value = value;
    }

    public void traverse(int[] levels) {
        if (printThisLevel(levels)) {
            System.out.println(indent.toString() + value);
        }
    }
}

class Box extends Entity {
    private List children = new ArrayList();
    private int value;
    public Box(int val) {
        value = val;
    }

    public void add(Entity c) {
        children.add(c);
    }

    public void traverse(int[] levels) {
        if (printThisLevel(levels)) {
            System.out.println(indent.toString() + value);
            indent.append( "   " );
        }
        level++;
        for (Object child : children) {
            ((Entity)child).traverse(levels);
        }
        level--;
        if (printThisLevel(levels)) {
            indent.setLength(indent.length() - 3);
        }
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        Box root = initialize();
        int[] levels = new int[args.length];
        for (int i=0; i < args.length; i++) {
            levels[i] = Integer.parseInt(args[i]);
        }
        root.traverse( levels );
    }

    private static Box initialize() {
        Box[] nodes = new Box[7];
        nodes[1] = new Box( 1 );
        int[] waves = {1, 4, 7};
        for (int i=0; i < 3; i++) {
            nodes[2] = new Box(21+i);
            nodes[1].add(nodes[2]);
            int level = 3;
            for (int j=0; j < 4; j++) {
                nodes[level-1].add( new Product(level*10 + waves[i]));
                nodes[level] = new Box(level*10 + waves[i]+1);
                nodes[level-1].add(nodes[level]);
                nodes[level-1].add(new Product(level*10 + waves[i]+2));
                level++;
            }
        }
        return nodes[1];
    }
}

```

### Output
```sh
args -> 2 4 6
21
   41
   42
      61
      62
      63
   43
22
   44
   45
      64
      65
      66
   46
23
   47
   48
      67
      68
      69
   49

args -> 3 6
31
32
   61
   62
   63
33
34
35
   64
   65
   66
36
37
38
   67
   68
   69
39

args -> 1 2 3 4 5 6
1
   21
      31
      32
         41
         42
            51
            52
               61
               62
               63
            53
         43
      33
   22
      34
      35
         44
         45
            54
            55
               64
               65
               66
            56
         46
      36
   23
      37
      38
         47
         48
            57
            58
               67
               68
               69
            59
         49
      39
```
