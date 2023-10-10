package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
  public static void main(String[] args) {
    System.out.println("PROCESSO SELETIVO");
    System.out.println("CANDIDATOS APROVADOS");
    String [] candidatosSelecionados = {"PAULO", "MONICA", "BEATRIZ", "AUGUSTO", "FABRICIO"};
    for(String candidados : candidatosSelecionados){
      // System.out.println(candidados);
      entrarEmContato(candidados);
    }

  }
  static void entrarEmContato(String candidato){
    int tentativasRealizadas = 1;
    boolean continuarTentando = true;
    boolean atendeu = false;

    do {
      atendeu = atender();
      continuarTentando = !atendeu;
      if(continuarTentando) {
        tentativasRealizadas ++;
      }
      else{
        System.out.println("CONTATO REALIZADO COM SUCESSO");
      }
    }while(continuarTentando && tentativasRealizadas < 3);
      if(atendeu){
        System.out.println("CONSEGUIMOS ENTRAR EM CONTATO COM " + candidato + " NA " + tentativasRealizadas + " REALIZADAS");
      }
      else {
        System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO DE TENTATIVAS " + tentativasRealizadas + " REALIZADAS");
      }
  }

  static boolean atender(){
    return new Random().nextInt(3) == 1;
  }
  static void imprimirAprovados(){
    String [] candidatosSelecionados = {"PAULO", "MONICA", "BEATRIZ", "AUGUSTO", "FABRICIO"};
    System.out.println("LISTA DOS APROVADOS");
    for(int indice = 0;indice < candidatosSelecionados.length ; indice++) {
      System.out.println("O candidato(a) de Nº " + (indice + 1) + " é o " + candidatosSelecionados[indice]);
    }

  }
  static void selecaoCandidato(){
    String listaCandidatos [] = {"FELIPE", "MARCIA", "JULIA", "PAULO", "MONICA", "BEATRIZ", "AUGUSTO", "FABRICIO", "MIRELA", "JORGE"};

    int candidatosSelecionados = 0;
    int candidatoAtual = 0;
    double salarioBase = 2000.0;
    while(candidatosSelecionados < 5 && candidatoAtual < listaCandidatos.length){
      String candidato = listaCandidatos[candidatoAtual];
      double salarioPretendido = valorPretendido();

      System.out.println("O candidato(a) " + candidato + " Solicitou este valor de salário " + salarioPretendido);
      if (salarioBase > salarioPretendido) {
        candidatosSelecionados ++;
        System.out.println("O candidato(a) " + candidato + " foi selecionado.");
      }
      candidatoAtual ++;
    }
  }

  static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  static void analisarCandidato(double salarioPretendido) {
    double salarioBase = 2000.0;
    if(salarioBase > salarioPretendido) {
      System.out.println("LIGAR PARA O CANDIDATO");
    }
    else if(salarioBase == salarioPretendido) {
      System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
    }
    else {
      System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
    }
  }
}