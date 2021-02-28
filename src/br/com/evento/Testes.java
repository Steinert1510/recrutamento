package br.com.evento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Testes {

	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	
	Sala1 sal = new Sala1();
    sal.setClassName("BlackYallow");
    sal.setQtdPessoas(6);
    
    Sala2 sal2 = new Sala2();
    sal2.setClassName("WhiteRed");
    sal2.setQtdPessoas(5);
		
	AlunoNovo aluno = new AlunoNovo();
	aluno.setFirstName("");
    aluno.setLastName("");
	
	SalaNova nova = new SalaNova();
	nova.setId(0);
    nova.setClassName("");
    nova.setQtdPessoas(0);
    
    CafeAdc cafe =new CafeAdc();
    cafe.setId(0);
    cafe.setSpaceName("");
    cafe.getQtdMaxPeaple();
    cafe.getQtdActualPeaple();
    
    coffeeClassHired hired = new coffeeClassHired();
    hired.setSpaceName(" SPACE HIRED ");
    hired.setQtdMaxPeaple(8);
    hired.setQtdActualPeaple(0);
    
    coffeeClassVictory victory = new coffeeClassVictory();
    victory.setSpaceName(" SPACE  VICTORY ");
    victory.setQtdMaxPeaple(8);
    victory.setQtdActualPeaple(0);
    
    
      
    
    List<Pessoas> lista = new ArrayList<Pessoas>();
    Pessoas pessoa = new Pessoas();
     pessoa.setFirstName("Lucas");
     pessoa.setLastName("Lima");
     lista.add(pessoa);
     
     Pessoas pessoa1 = new Pessoas();
     pessoa1.setFirstName("Irineu");
     pessoa1.setLastName("Steinert");
     lista.add(pessoa1);
     
     Pessoas pessoa2 = new Pessoas();
     pessoa2.setFirstName("Maria");
     pessoa2.setLastName("Dormingo");
     lista.add(pessoa2);
     
     Pessoas pessoa3 = new Pessoas();
     pessoa3.setFirstName("Rosa ");
     pessoa3.setLastName("Florinda");
     lista.add(pessoa3);
     
     Pessoas pessoa4 = new Pessoas();
     pessoa4.setFirstName("Diones");
     pessoa4.setLastName("Calado");
     lista.add(pessoa4);
     
     Pessoas pessoa5 = new Pessoas();
     pessoa5.setFirstName("Claudia");
     pessoa5.setLastName("Ferrari");
     lista.add(pessoa5);
     
     Pessoas pessoa6 = new Pessoas();
     pessoa6.setFirstName("Robson");
     pessoa6.setLastName("Gole");
     lista.add(pessoa6);
     
     Pessoas pessoa7 = new Pessoas();
     pessoa7.setFirstName("Margarida");
     pessoa7.setLastName("Jardim");
     lista.add(pessoa7);
     
     Pessoas pessoa8 = new Pessoas();
     pessoa8.setFirstName("Silvestre");
     pessoa8.setLastName("Estalonge");
     lista.add(pessoa8);
     
     Pessoas pessoa9 = new Pessoas();
     pessoa9.setFirstName("Morgan");
     pessoa9.setLastName("Fria");
     lista.add(pessoa9);
     
     Pessoas pessoa10 = new Pessoas();
     pessoa10.setFirstName("Violeta");
     pessoa10.setLastName("Grilo");
     lista.add(pessoa10);
     
     Pessoas pessoa11 = new Pessoas();
     pessoa11.setFirstName("Rodrigo");
     pessoa11.setLastName("Senfaro");
     lista.add(pessoa11);
       
    
		int op=0;
		int num=0;  
		   
		while(op<=6) {
			   System.out.println("Evento seletivo");
			   System.out.println(localWeb.eventoCompleto);
			   System.out.println("1-Cadastro Pessoa 2- Cadastro sala 3- cadastro café 4-Salas 5-visualizar cafe 6- Sair");
				op=scan.nextInt();
			
			if(op==1) {
				
				System.out.println("Entre com o nome:");
				aluno.setFirstName(scan.next());
				System.out.println("Entre com o sobrenome:");
				aluno.setLastName(scan.next());
				System.out.println("Aluno adicionado Nome :" + aluno.getFirstName() 
				+" "+aluno.getLastName());
				
				
			}
			if(op==2) {
				int x=0;
				System.out.println("Deseja Adicionar sala 1-sim 2-não");
				x=scan.nextInt();
				if(x==1) {
					System.out.println("entre com o nome da sala");
		                nova.setClassName(scan.next());	
		                System.out.println("Sala nova: "+ nova.getClassName());
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
		                cafe.setSpaceName(scan.next());	
		                System.out.println("Espaço Café nome: "+ cafe.getSpaceName());
				}else {
					System.out.println();
				}
				
			}
			if(op==4) {
				
				System.out.println("*****  SALA:"+sal.getClassName()+"  PARTICIPANTES ****");
				
				for(int i=0; i<=4; i++) {
					System.out.println("Nome: "+lista.get(i).getFirstName()+" "+lista.get(i).getLastName());
					
				}
				System.out.println();
				System.out.println("*****  SALA:"+sal2.getClassName()+"  PARTICIPANTES ****");
				
				for(int j=5; j<=10; j++) {
					System.out.println("Nome: "+lista.get(j).getFirstName()+" "+lista.get(j).getLastName());
					
					
			
				}
				System.out.println();
				//sorteio de pessoas
						
			}
			if(op==5) {
				while(num <=3) {
					System.out.println("1-Acesso ao cafe 2- Nome das Pessoas 3-TrocaSala 4- Sair");
					num=scan.nextInt();
					
					
				if(num==1) {
				      // ACESSO AO ESPAÇO CAFÉ 1
					
					  System.out.println("informe a qtd para space 1");
				      hired.setQtdActualPeaple(scan.nextInt());
	     
				      if(hired.getQtdActualPeaple() <= hired.getQtdMaxPeaple()) {
				    	  System.out.println("Acesso permitido - bom coffeBreak");
				      }else {
				    	  System.out.println("Acesso negado- Excesso de pessoas!");
				      }
				      
				   // ACESSO PARA O ESPAÇO CAFÉ 2
					System.out.println("informe a quantidade da lista para sala 2");
					victory.setQtdActualPeaple(scan.nextInt());
					
					 if(victory.getQtdActualPeaple() <= victory.getQtdMaxPeaple()) {
				    	  System.out.println("Acesso permitido - bom coffeBreak");
				      }else {
				    	  System.out.println("Acesso negado- Excesso de pessoas!");
				      }
					
					   System.out.println(victory.getQtdActualPeaple());
				
				}// BUSCA POR  PESSOAS NAS SALAS CAFES
				if(num==2) {
					
					System.out.println("1-lista 2- por nome");
					int r = scan.nextInt();
					// LISTA NA SALA 1 
					
					if(r==1) {
					System.out.println("*****  SPACE:"+hired.getSpaceName()+"   ****");
					
					for(int i=0; i<=4; i++) {
						System.out.println(lista.get(i).getFirstName()+ lista.get(i).getLastName());
						
				  // LISTA  NA SALA 2
					}
					System.out.println();
					System.out.println("*****  SPACE:"+victory.getSpaceName()+"  ****");
					
					for(int j=5; j <= 10; j++) {
						System.out.println(lista.get(j).getFirstName()+ lista.get(j).getLastName());
						
					}
					}//fim do if(r==1)
					// CONSULTA POR NOME
					
					if(r==2) {
					
						
						System.out.println("Entre com o sobrenome do aluno");
						String candidato2=scan.next();
						
						int idPessoa = 0;
						for(int i=0; i<lista.size();i++) {
							if (candidato2.equals(lista.get(i).getLastName())) {
								idPessoa = i ;
							
								
							}
							
							System.out.println(lista.contains(pessoa11));break;
						}
						
					}
				}// TROCA DE SALAS 
				if(num==3) {
					
					System.out.println("*****  SALA:"+sal.getClassName()+"  PARTICIPANTES ****");
					
					for(int i=5; i<=10; i++) {
						
						System.out.println(lista.get(i).getFirstName()+lista.get(i).getLastName());
						
					}
					System.out.println();
					System.out.println("*****  SALA:"+sal2.getClassName()+"  PARTICIPANTES ****");
					
					for(int j=0; j<=4; j++) {
						System.out.println(lista.get(j).getFirstName()+lista.get(j).getLastName());
						
				
					}
					
					System.out.println();
						
					}
//					if(num==4) {
//						
//					}
				
				}
				
				
			}//fim do while if(num==5)
				
			}// fim do if(op==5)
		
		
		}//fim do while menu principal
	   
	}

