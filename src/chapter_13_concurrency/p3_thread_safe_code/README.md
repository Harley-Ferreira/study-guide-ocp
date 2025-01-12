# Por que Thread-Safety é Importante?

### O termo thread-safe refere-se a um código, método ou classe que pode ser usado de forma segura por múltiplas threads simultaneamente, sem causar condições de corrida, inconsistências de dados ou erros inesperados.

#### Em ambientes multithreaded, várias threads podem tentar acessar e modificar os mesmos dados ou recursos ao mesmo tempo. Se não houver medidas adequadas de sincronização, isso pode levar a:

#### 1. Condições de Corrida (Race Conditions):

- Quando duas ou mais threads acessam os mesmos dados simultaneamente e pelo menos uma delas escreve nos dados, o
  resultado pode ser imprevisível.

#### 2. Deadlocks:

- Quando duas ou mais threads esperam indefinidamente por um recurso que outra thread está segurando.

#### 3. Inconsistência de Dados:

- Operações intercaladas podem deixar os dados em um estado inválido.

## 1. volatile

### O que é?

volatile é uma palavra-chave usada para garantir que a variável seja lida e escrita diretamente na memória principal (
RAM), em vez de usar caches de threads.
Ela assegura visibilidade entre threads, mas não garante atomicidade.

### Quando usar?

Quando múltiplas threads compartilham uma variável simples (ex.: boolean, int, etc.).
Quando você precisa garantir que todas as threads sempre leiam o valor mais recente.

- Sem volatile:
  Uma thread pode não "ver" a mudança em running feita por outra thread, pois o valor pode ser lido do cache da thread.
- Com volatile:
  Todas as threads veem a atualização de running imediatamente, porque ela será lida/escrita diretamente na memória
  principal.

## 2. Atomic Classes

### O que são?

Classes em java.util.concurrent.atomic que fornecem operações atômicas para variáveis compartilhadas.
Atomicidade significa que a operação é realizada de forma indivisível (ex.: leitura + escrita ocorre como um único
passo, sem interrupções).

### Quando usar?

Quando precisa realizar operações seguras e atômicas em variáveis compartilhadas (ex.: incremento, decremento ou
substituição condicional).

### Por que usar AtomicInteger?

Se duas threads chamarem increment() ao mesmo tempo, o AtomicInteger garantirá que o valor de count seja atualizado
corretamente, sem condições de corrida.

## 3. synchronized

### O que é?

synchronized é uma palavra-chave usada para criar seções críticas, ou seja, blocos ou métodos que só podem ser
acessados por uma thread por vez.
Garante tanto visibilidade quanto atomicidade.

### Quando usar?

Quando várias operações precisam ser realizadas juntas (como verificar e modificar um valor) e você quer garantir que
apenas uma thread execute esse código por vez.

### Por que usar synchronized?

Sem synchronized, duas threads poderiam interferir entre si, causando inconsistências (condições de corrida).
