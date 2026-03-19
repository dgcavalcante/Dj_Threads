package src;
public class Instrumento implements Runnable {
    private String nome;
    private String batida;
    private int intervalo;

    volatile boolean pausado = false;
    volatile boolean rodando = true;

    public Instrumento(String nome, String batida, int intervalo) {
        this.nome = nome;
        this.batida = batida;
        this.intervalo = intervalo;
    }

    @Override
    public void run() {
        while (rodando) {
            synchronized (this) {
                while (pausado) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            if (DjThreads.exibirSons) {
                System.out.println(nome + ": " + batida); 
                System.out.flush();
            }

            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(nome + " ENCERRADO.");
    }

    public synchronized void pausar() {
        pausado = true;
        System.out.printf("instrumento(%s) PAUSADO.%n",nome);
    }

    public synchronized void retomar() {
        pausado = false;
        notifyAll();
        System.out.printf("instrumento(%s) RETOMADO.%n",nome);
    }

    public synchronized void encerrar() {
        rodando = false;
        pausado = false;
        notifyAll();
        System.out.println(nome + " encerrando...");
    }

    public String getNome() {
        return nome;
    }
}