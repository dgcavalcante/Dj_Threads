import java.util.Scanner;

public class DjThreads {

    public static void menu(){
        System.out.println("1- Adicionar instrumento");
        System.out.println("2- Pausar instrumento");
        System.out.println("3- retomar instrumento");
        System.out.println("4- Encerrar mesa Dj");
    }

    public static void limparTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        while(true){
            menu();
            int numero = sc.nextInt();
            limparTerminal();

            switch(numero){

                case(1):{

                    break;
                }
                case(2):{

                    break;
                }
                case(3):{

                    break;
                }
                case(4):{

                    sc.close();
                    break;
                }
                default:
                    System.out.println("Número incorreto!");
            }
        }
    }
}