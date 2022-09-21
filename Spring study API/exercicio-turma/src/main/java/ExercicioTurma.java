import java.util.Scanner;

public class ExercicioTurma {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        String[] turma1 = new String[10];   // vetor da turma T1
        String[] turma2 = new String[10];   // vetor da turma T2
        String nome, turma;

        int indT1 = 0;   // indica a posição onde entrará o próx aluno
                         // da turma1 e tb representa qtos alunos tem
                         // na turma1
        int indT2 = 0;   // indica a posição onde entrará o próx aluno
                        // da turma2 e tb representa qtos alunos tem
                        // na turma2

        // Loop para ler 10 nomes de alunos
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o nome de um aluno");
            nome = leitor.next();
            // Leitura e validação da turma - só aceita T1 ou T2
            do {
                System.out.println("Digite a turma do aluno: T1 ou T2");
                turma = leitor.next();
            } while (!(turma.equalsIgnoreCase("T1") ||
                       turma.equalsIgnoreCase("T2")));
            // Atribui o nome do aluno para o vetor correspondente à turma
            if (turma.equalsIgnoreCase("T1")) {
                turma1[indT1++] = nome;
            }
            else {
                turma2[indT2++] = nome;
            }
        }

        // Exibe a quantidade e os nomes dos alunos da T1
        if (indT1 == 0) {
            System.out.println("Não há alunos na T1");
        }
        else {
            System.out.println("Há " + indT1 + " alunos na T1:");
            for (int i = 0; i < indT1; i++) {
                System.out.println(turma1[i]);
            }
        }

        // Exibe a quantidade e os nomes dos alunos da T2
        if (indT2 == 0) {
            System.out.println("Não há alunos na T2");
        }
        else {
            System.out.println("Há " + indT2 + " alunos na T2:");
            for (int i = 0; i < indT2; i++) {
                System.out.println(turma2[i]);
            }
        }
    }
}
