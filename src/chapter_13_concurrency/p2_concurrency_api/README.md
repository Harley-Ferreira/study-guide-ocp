# Concurrency

#### O uso do ExecutorService no Java é geralmente preferido em relação à criação e gerenciamento manual de threads devido a várias razões que envolvem eficiência, facilidade de uso, e melhores práticas para o desenvolvimento de aplicações concorrentes. Aqui estão os motivos mais relevantes:

1. ### Gerenciamento Automático de Threads
   - Manual: Ao criar threads manualmente, o programador precisa gerenciá-las, incluindo iniciá-las, monitorá-las e
   finalizá-las.
   - ExecutorService: Gerencia um pool de threads automaticamente, reutilizando threads existentes e evitando a criação
   excessiva, o que reduz a sobrecarga.
2. ### Reutilização de Recursos
   - Manual: Threads criadas manualmente geralmente são usadas uma única vez e descartadas, resultando em desperdício de
   recursos.
   - ExecutorService: Reutiliza threads em um pool, o que melhora o desempenho em aplicações com um grande número de
   tarefas curtas ou recorrentes.
3. ### Controle de Concorrência
   - Manual: É difícil limitar manualmente o número de threads em execução simultânea, o que pode levar a problemas de
   desempenho (e.g., consumo excessivo de memória ou CPU).
   - ExecutorService: Permite especificar o número máximo de threads por meio de pools, como newFixedThreadPool(int) ou
   newCachedThreadPool().
4. ### Abstração e Facilidade de Uso
   - Manual: Criar, iniciar e juntar threads manualmente requer código repetitivo e complexo.
   - ExecutorService: Oferece métodos de alto nível como:
     - submit(): Para enviar tarefas.
     - invokeAll(): Para executar múltiplas tarefas.
     - shutdown(): Para encerrar o pool de forma controlada.
5. ### Melhor Tratamento de Exceções
   - Manual: Se uma exceção não for tratada adequadamente dentro de uma thread, ela pode terminar abruptamente sem
   notificação.
   - ExecutorService: Combina tarefas com objetos Future, permitindo verificar se uma exceção ocorreu e tratá-la.
6. ### Escalabilidade
   - Manual: Gerenciar um grande número de threads é complicado e pode levar a problemas como thread starvation e
   deadlocks.
   - ExecutorService: Implementa estratégias de escalabilidade, como aumentar ou diminuir dinamicamente o número de
   threads em newCachedThreadPool().
7. ### Suporte a Operações Assíncronas
   - Manual: Implementar chamadas assíncronas com threads requer código complexo e não é intuitivo.
   - ExecutorService: Combinado com Future e CompletableFuture, facilita a execução de operações assíncronas e a
   composição de tarefas.
8. ### Encerramento Controlado
   - Manual: Encerrar threads manualmente pode ser arriscado se não for feito corretamente, resultando em threads zumbis.
   - ExecutorService: Permite encerrar o pool com métodos como shutdown() e shutdownNow().
