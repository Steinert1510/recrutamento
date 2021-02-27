package br.com.proway.evento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import br.com.proway.evento.pessoas.AlunoNovo;

public class Testes {

	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	
	Sala1 sal = new Sala1();
    sal.setClassName("BlackYallow");
    
    Sala2 sal2 = new Sala2();
    sal2.setClassName("WhiteRed");
		
	AlunoNovo aluno = new AlunoNovo();
	aluno.setNome("");
    aluno.setSobrenome("");
	
	SalaNova nova = new SalaNova();
    nova.setNomeSalaNova("");
    
    CafeAdc cafe =new CafeAdc();
    cafe.setNome("");
    
    coffeeClassHired hired = new coffeeClassHired();
    hired.setSpaceName(" SPACE HIRED ");
    hired.setQtdMaxPeaple(8);
    hired.setQtdActualPeaple(0);
    
    coffeeClassVictory victory = new coffeeClassVictory();
    victory.setSpaceName(" SPACE  VICTORY ");
    victory.setQtdMaxPeaple(8);
    victory.setQtdActualPeaple(0);
    
    
    List<String> lista = new ArrayList<String>();
    
    lista.add("Maria Cloud");
    lista.add("Debora Sotu");
    lista.add("renato Sozinho");
    lista.add("Vitorino Vencedor");
    lista.add("Lutador venceslau");
    lista.add("Claudia Abelha");
    lista.add("Carlos fumaça");
    lista.add("Jean Gumer");
    lista.add("Roberto Grilo");
    lista.add("Marina Manhoso");
    lista.add("Renata Gafanhoto");
    
    Collections.shuffle(lista);
    
    
		int op=0;
		int num=0;  
		   
		while(op<=6) {
			   System.out.println("Evento seletivo");
			   System.out.println("1- Cadastro Pessoa 2- Cadastro sala 3- cadastro café 4-visualizar Sala 5-visualizar cafe 6- Sair");
				op=scan.nextInt();
			
			if(op==1) {
				
				System.out.println("Entre com o nome:");
				aluno.setNome(scan.next());
				System.out.println("Entre com o sobrenome:");
				aluno.setSobrenome(scan.next());
				System.out.println("Aluno adicionado Nome :" + aluno.getNome() 
				+" "+aluno.getSobrenome());
				
				
			}
			if(op==2) {
				int x=0;
				System.out.println("Deseja Adicionar sala 1-sim 2-não");
				x=scan.nextInt();
				if(x==1) {
					System.out.println("entre com o nome da sala");
		                nova.setNomeSalaNova(scan.next());	
		                System.out.println("Sala nova: "+ nova.getNomeSalaNova());
				}else {
					System.out.println();
				}
			}
			if(op==3) {
				
				int x1=0;
				System.out.println("Deseja Adicionar espaço café 1-sim 2-não");
				x1=scan.nextInt();
				if(x1==1) {
					System.out.println("entre com o nome do espaçoCafé");
		                cafe.setNome(scan.next());	
		                System.out.println("Espaço Café nome: "+ cafe.getNome());
				}else {
					System.out.println();
				}
				
			}
			if(op==4) {
				
				System.out.println("*****  SALA:"+sal.getClassName()+"  PARTICIPANTES ****");
				
				for(int i=0; i<=4; i++) {
					System.out.println(lista.get(i));
					//System.out.println("Espaço café "+ hired.getSpaceName());
				}
				System.out.println();
				System.out.println("*****  SALA:"+sal2.getClassName()+"  PARTICIPANTES ****");
				
				for(int j=5; j<=10; j++) {
					System.out.println(lista.get(j));
					//System.out.println("Espaço café : "+victory.getSpaceName());
			
				}
				System.out.println();
				//sorteio de pessoas
						
			}
			if(op==5) {
				while(num <=2) {
					System.out.println("1- Quantidade de pessoas 2- Nome das Pessoas 3- Sair");
					num=scan.nextInt();
					
					
				if(num==1) {
					
					System.out.println("informe a qtd da lista para sala 1");
				    hired.setQtdActualPeaple(scan.nextInt());
	     
				      if(hired.getQtdActualPeaple() <= hired.getQtdMaxPeaple()) {
				    	  System.out.println("Acesso permitido - bom coffeBreak");
				      }else {
				    	  System.out.println("Acesso negado- Excesso de pessoas!");
				      }
				    
					System.out.println("informe a quantidade da lista para sala 2");
					victory.setQtdActualPeaple(scan.nextInt());
					
					 if(victory.getQtdActualPeaple() <= victory.getQtdMaxPeaple()) {
				    	  System.out.println("Acesso permitido - bom coffeBreak");
				      }else {
				    	  System.out.println("Acesso negado- Excesso de pessoas!");
				      }
					
					System.out.println(victory.getQtdActualPeaple());
				
				}
				if(num==2) {
					System.out.println("*****  SPACE:"+hired.getSpaceName()+"   ****");
					
					for(int i=0; i<=4; i++) {
						System.out.println(lista.get(i));
					}
					System.out.println();
					System.out.println("*****  SPACE:"+victory.getSpaceName()+"  ****");
					
					for(int j=5; j <= 10; j++) {
						System.out.println(lista.get(j));
						
					}
				
				}
				
			}//fim do while if(num==5)
				
			}// fim do if(op==5)
		
		}//fim do while menu principal
		
	}
}
