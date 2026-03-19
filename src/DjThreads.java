package src;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DjThreads {

    static Map<String, Instrumento> instrumentos = new HashMap<>();
    static volatile boolean exibirSons = false;

    public static void menu() {
        System.out.println("1- Adicionar instrumento");
        System.out.println("2- Pausar instrumento");
        System.out.println("3- retomar instrumento");
        System.out.println("4- Ver Mesa Dj");
        System.out.println("5- Encerrar mesa Dj");
    }

    public static void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            menu();
            System.out.print("Qual seria a opção escolhida pelo número: ");
            int numero = sc.nextInt();
            sc.nextLine();
            limparTerminal();

            switch (numero) {

                case (1): {
                    System.out.print("Informe o nome do instrumento: ");
                    String nome = sc.nextLine();
                    System.out.print("Informe o som que o instrumento emite: ");
                    String batida = sc.nextLine();
                    System.out.print("Informe o intervalo que o instrumento vai tocar(ms): ");
                    int intervalo = sc.nextInt();
                    sc.nextLine();

                    Instrumento instr = new Instrumento(nome, batida, intervalo);
                    instrumentos.put(nome, instr);
                    Thread t = new Thread(instr);
                    System.out.println(nome + " adicionado!");
                    t.start();
                    limparTerminal();
                    break;
                }
                case (2): {
                    System.out.println("Nome do instrumento que deseja pausar: ");
                    String nome = sc.nextLine();
                    Instrumento instr = instrumentos.get(nome);

                    if (instr != null) {
                        instr.pausar();
                    } else {
                        System.out.println("instrumento não encontrado!");
                    }

                    limparTerminal();
                    break;
                }
                case (3): {
                    System.out.println("Nome do instrumento que deseja retomar: ");
                    String nome = sc.nextLine();
                    Instrumento instr = instrumentos.get(nome);

                    if (instr != null) {
                        instr.retomar();
                    } else {
                        System.out.println("instrumento não encontrado!");
                    }

                    limparTerminal();
                    break;
                }

                case (4): {
                    exibirSons = true;
                    limparTerminal();

                    while (true) {

                        System.out.print("\033[H\033[2J"); // limpa tudo e vai pro topo
                        System.out.flush();

                        System.out.println("╔══════════════════════════════╗");
                        System.out.println("║         MESA DJ              ║");
                        System.out.println("╠══════════════════════════════╣");

                        Instrumento[] instr = instrumentos.values().toArray(new Instrumento[0]);
                        for (int i = 0; i < instr.length; i++) {
                            String estado = instr[i].pausado ? "⏸ PAUSADO" : "▶ TOCANDO";
                            System.out.printf("║ %-10s  %-15s ║%n", instr[i].getNome(), estado);
                        }

                        System.out.println("╠══════════════════════════════╣");
                        System.out.println("║ ENTER para voltar ao menu    ║");
                        System.out.println("╚══════════════════════════════╝");
                        System.out.println();

                        try {
                            if (System.in.available() > 0) {
                                System.in.read();
                                exibirSons = false;
                                limparTerminal();
                                break;
                            }
                            Thread.sleep(2000);
                        } catch (IOException | InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }
                    break;
                }

                case (5): {
                    Instrumento[] array = instrumentos.values().toArray(new Instrumento[0]);

                    for (int i = 0; i < array.length; i++) {
                        array[i].encerrar();
                    }

                    sc.close();
                    rodando = false;
                    System.out.println("Mesa Dj encerrada!");
                    break;
                }
                default:
                    System.out.println("Número incorreto!");
                    break;
            }
        }
    }
}