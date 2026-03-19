# 🎛️ Dj_Threads

> Simulação de uma mesa de DJ usando multithreading em Java. Cada faixa musical roda em sua própria thread de forma independente, e o usuário controla o sistema via comandos de texto — pausando e retomando cada instrumento sem interromper os demais.

---

## 📌 Sobre o projeto

O **DJ_threads** foi desenvolvido como trabalho prático da disciplina de **Infraestrutura de Software**. O objetivo é aplicar conceitos fundamentais de programação concorrente, simulando uma mesa de DJ onde cada instrumento (Bateria, Baixo, Synth, etc.) é uma thread independente rodando em loop contínuo.

O DJ interage com o sistema através de comandos de texto no terminal, controlando cada faixa individualmente de forma segura — sem race conditions e sem encerrar o programa abruptamente.

---

## 🧠 Conceitos aplicados

- **Multithreading** — cada instrumento é uma thread independente
- **Sincronização** — uso de `synchronized` para proteger o estado compartilhado
- **Comunicação entre threads** — `wait()` / `notify()` para pausar e retomar faixas
- **Variáveis voláteis** — uso de `volatile` para garantir visibilidade entre threads
- **Controle de execução** — `sleep()` e `interrupt()` para gerenciar o ciclo de vida das threads

---

## 🛠️ Tecnologias utilizadas

| Tecnologia | Versão | Uso |
|---|---|---|
| Java | 25 | Linguagem principal |
| JDK | 25 | Compilação e execução |
| Git | — | Versionamento |

---

## 🚀 Como rodar o projeto

### Pré-requisitos

- Java 25
- Git instalado

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/Dj_Threads.git

# Acesse a pasta do projeto
cd Dj_Threads

# Compile o projeto
javac -d bin src/DjThreads.java src/Instrumento.java

# Execute
java -cp bin DjThreads
```

---

## 🎮 Menu disponível

Após iniciar o programa, você pode escolher os seguintes comandos no terminal:

```
1.adicionar <instrumento>    → adiciona um instrumento na mesa
2.pausar <instrumento>   → Pausa a faixa especificada
3.retomar <instrumento>    → Retoma o item especificado
4.ver mesa Dj             → exibe o estado dos instrumentos e mostra eles tocando em paralelo
5.encerrar mesa Dj           → Encerra todos os instrumentos e fecha o programa
```

--

## 👥 Participantes

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/dgcavalcante">
        <img src="https://github.com/dgcavalcante.png" width="80px" style="border-radius: 50%"/><br>
        <sub><b>Diogo Cavalcante</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://https://github.com/PvssDev">
        <img src="https://github.com/PvssDev.png" width="80px" style="border-radius: 50%"/><br>
        <sub><b>Pedro Vinicius</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/SergioGSF">
        <img src="https://github.com/SergioGSF.png" width="80px" style="border-radius: 50%"/><br>
        <sub><b>Sergio Gonçalves</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/duduhnrq">
        <img src="https://github.com/duduhnrq.png" width="80px" style="border-radius: 50%"/><br>
        <sub><b>Eduardo Henrique</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/MarcosFraga0">
        <img src="https://github.com/MarcosFraga0.png" width="80px" style="border-radius: 50%"/><br>
        <sub><b>Marcos Taveira</b></sub>
      </a>
    </td>
  </tr>
</table>

---

