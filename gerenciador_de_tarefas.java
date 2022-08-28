import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class GenrenciadorTarefas {
    public static void main(String[] args) {
        InputStreamReader tec = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(tec);

        ArrayList<String> lista = new ArrayList<String>();
        String status = "Pendente";

        while (true) {
            String tarefa = "";  
            int op = 0, i, posicao;
            
            System.out.println("\nEscola uma opção: \n1 - Adicionar tarefa\n2 - Editar tarefa\n3 - Excluir tarefa\n4 - Listar tarefas\n0 - Sair\n");
            try{
                op = Integer. parseInt(buff.readLine());
            }catch(IOException ioe){
                System.out.println("Entrada inválida!\n");
            }

            // sair da lista
            if (op == 0) {
                System.out.println("Desligando gerenciador de tarefas...\n");
                break;
            }

            // adicionar tarefa na lista
            if (op == 1){
                System.out.printf("Digite a tarefa a ser adicionada: \n");
                try{
                    tarefa = buff.readLine();
                    lista.add("{Tarefa: '" + tarefa + "'; " + "Status: '" + status + "'}");
                }catch(IOException ioe){
                    System.out.println("Entrada inválida!\n");
                }                
            }

            // editar tarefa da lista
            if (op == 2){
                try{
                    System.out.printf("\nInforme a posição a ser editada:\n");
                    posicao = Integer.parseInt(buff.readLine());            

                    System.out.printf("\nInforme a tarefa:\n");
                    tarefa = buff.readLine();

                    System.out.printf("\nInforme o status da tarefa:\n");
                    status = buff.readLine();

                    lista.set(posicao, "{Tarefa: '" + tarefa + "'; " + "Status: '" + status + "'}");
                    
                    System.out.println("Tarefa editada com sucesso!\n");
                }catch(IOException ioe){
                    System.out.println("Entrada inválida!\n");
                }  
            }

            // excluir tarefa da lista
            if (op == 3){
                System.out.printf("\nInforme a posição a ser excluída:\n");
                try{
                    posicao = Integer.parseInt(buff.readLine());                    
                    lista.remove(posicao--);
                    System.out.println("Tarefa excluida com sucesso!");
                }catch(IOException ioe){
                    System.out.println("Entrada inválida!\n");
                }
            }

            // listar tarefas da lista
            if (op == 4){
                for (i=0; i < lista.size(); i++) {
                    System.out.printf("Posição %d- %s\n", i, lista.get(i));
                }
            }

        }
    }
}
