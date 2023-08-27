import java.util.Stack;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LPF 
{
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== LPF ====");
        int opcao = 0;
        do 
        {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Fila");
            System.out.println("2 - Pilha");
            System.out.println("3 - Lista");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            switch (opcao) 
            {
                case 1:
                    System.out.println("==== FILA ====");
                    Fila.main(args);
                    break;
                case 2:
                    System.out.println("==== PILHA ====");
                    pilha.main(args);
                    break;
                case 3:
                    System.out.println("==== LISTA ====");
                    lista.main(args);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();
    }


//==============FILA================
    public class Fila 
    {
            private LinkedList<Integer> fila;
            
            public Fila() {
                fila = new LinkedList<>();
            }
            
            public void enfileirar(int valor) {
                fila.add(valor);
            }
            
            public void enfileirarComScanner() {
                Scanner sc = new Scanner(System.in);
                System.out.print("Digite um valor para enfileirar: ");
                int valor = sc.nextInt();
                enfileirar(valor);
            }
            
            public int desenfileirar() {
                if (!fila.isEmpty()) {
                    return fila.removeFirst();
                }
                throw new RuntimeException("A fila está vazia!");
            }
            
            public int tamanho() {
                return fila.size();
            }
            
            public boolean vazia() {
                return fila.isEmpty();
            }
            
            public void mostrarFila() {
                if (fila.isEmpty()) {
                    System.out.println("Fila vazia!");
                    return;
                }
                
                System.out.print("Fila:[ ");
                fila.forEach(valor -> System.out.print(valor + " "));
                System.out.print("]");
                System.out.println();
            }

            
            public int primeiro() {
                if (!fila.isEmpty()) {
                    return fila.getFirst();
                }
                throw new RuntimeException("A fila está vazia!");
            }

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("==== FILA ====");
                Fila f = new Fila();
                int opcao = 0;
                do {
                    System.out.println("\nEscolha uma opção:");
                    System.out.println("1 - Enfileirar");
                    System.out.println("2 - Desenfileirar");
                    System.out.println("3 - Mostrar fila");
                    System.out.println("4 - Tamanho da fila");
                    System.out.println("5 - Verificar se a fila está vazia");
                    System.out.println("6 - Consultar o primeiro elemento da fila");
                    System.out.println("0 - Sair");
                    opcao = sc.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.print("Digite um valor para enfileirar na fila: ");
                            int valorEnfileirar = sc.nextInt();
                            f.enfileirar(valorEnfileirar);
                            System.out.println("Valor " + valorEnfileirar + " enfileirado com sucesso!");
                            break;
                        case 2:
                            try {
                                int valorDesenfileirado = f.desenfileirar();
                                System.out.println("Valor " + valorDesenfileirado + " desenfileirado com sucesso!");
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 3:
                            f.mostrarFila();
                            break;
                        case 4:
                            System.out.println("Tamanho da fila: " + f.tamanho());
                            break;
                        case 5:
                            System.out.println("A fila está vazia? " + f.vazia());
                            break;
                        case 6:
                            try {
                                int primeiro = f.primeiro();
                                System.out.println("O primeiro elemento da fila é: " + primeiro);
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while (opcao != 0);
                sc.close();
            }
    } 
//============PILHA================
    

public class pilha 
{
   private Stack<Integer> pilha;

   public pilha() 
   {
      pilha = new Stack<Integer>();
   }

   public void empilhar() {
      Scanner sc = new Scanner(System.in);
      System.out.print("Digite um valor para empilhar na pilha: ");
      int valor = sc.nextInt();
      pilha.push(valor);
   }

   public int desempilhar() {
      if (!pilha.isEmpty()) {
         return pilha.pop();
      }
      throw new RuntimeException("A pilha está vazia!");
   }

   public int tamanho() {
      return pilha.size();
   }

   public boolean vazia() {
      return pilha.isEmpty();
   }

   public int topo() {
      if (!pilha.isEmpty()) {
         return pilha.peek();
      }
      throw new RuntimeException("A pilha está vazia!");
   }

   public void mostrarPilha() {
    System.out.println("Pilha atual :");
    for (int i = pilha.size() - 1; i >= 0; i--) {
       System.out.println(pilha.get(i));
    }
 }


   public static void main(String[] args)
   {
    Scanner sc = new Scanner(System.in);
    System.out.println("==== PILHA ====");
    pilha p = new pilha();
    int n;
    System.out.println("Digite o tamanho da pilha: ");
    n = sc.nextInt();

    for (int i = 0; i < n; i++) 
    {
        p.empilhar();
    }

    System.out.println("Tamanho da pilha: " + p.tamanho()); // 3
    System.out.println("Topo da pilha: " + p.topo()); // último valor inserido

    p.desempilhar();

    System.out.println("Tamanho da pilha: " + p.tamanho()); // 2
    System.out.println("Topo da pilha: " + p.topo()); // novo último valor inserido

    p.mostrarPilha();
   }
}

//========LISTA========
 
public class lista 
{
    private No inicio;

    private static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public void inserirInicio(int valor) {
        No novoNo = new No(valor);
        novoNo.proximo = inicio;
        inicio = novoNo;
    }

    public void inserirFim(int valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public void remover(int posicao) 
    {
        if (posicao < 0)
            throw new IllegalArgumentException("Posição inválida!");

        if (inicio == null)
            throw new RuntimeException("Lista vazia!");

        if (posicao == 0) {
            inicio = inicio.proximo;
            return;
        }

        No anterior = null;
        No atual = inicio;
        int indice = 0;

        while (atual != null && indice < posicao) {
            anterior = atual;
            atual = atual.proximo;
            indice++;
        }

        if (atual == null)
            throw new IllegalArgumentException("Posição inválida!");

        anterior.proximo = atual.proximo;
    }

    public void inserir(int valor, int posicao) {
        if (posicao < 0)
            throw new IllegalArgumentException("Posição inválida!");

        if (posicao == 0) {
            inserirInicio(valor);
            return;
        }

        No novoNo = new No(valor);
        No atual = inicio;
        int indice = 0;

        while (atual != null && indice < posicao - 1) {
            atual = atual.proximo;
            indice++;
        }

        if (atual == null)
            throw new IllegalArgumentException("Posição inválida!");

        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
    }
    
    public void mostrarLista() {
        No atual = inicio;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=0, n=0, z=0;
        System.out.println("Digite o tamanho da lista: ");
        n = sc.nextInt();
        lista lista = new lista();

        System.out.println("Inserir valores em ordem:");
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            lista.inserirFim(x);
        }

        lista.mostrarLista();

        System.out.println("Inserir valor no início:");
        int valor = sc.nextInt();
        lista.inserirInicio(valor);

        System.out.println("Inserir valor no fim:");
        valor = sc.nextInt();
        lista.inserirFim(valor);

        System.out.println("Inserir valor [] na posição[]:");
        valor = sc.nextInt();
        int posicao = sc.nextInt();
        lista.inserir(valor, posicao);

        System.out.println("Remover valor da posição:");
        z = sc.nextInt();
        lista.remover(z);

        lista.mostrarLista();
    }
}
    
}
