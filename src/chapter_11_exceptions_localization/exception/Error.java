package chapter_11_exceptions_localization.exception;

/**
 * Error means something went so horribly wrong that your program should not
 * attempt to recover from it. For example the disk "disappeared or the program ran out of memory
 * *
 * Definição e Hierarquia
 * A classe Error está localizada no pacote java.lang e herda diretamente de Throwable.
 * Ela é separada das exceções (Exception) porque indica problemas que não são recuperáveis pelo programa.
 * *
 * Hierarquia simplificada:
 * java.lang.Object
 *    ↳ java.lang.Throwable
 *          ↳ java.lang.Error
 *          ↳ java.lang.Exception
 * *
 * Características de Error
 * - Irrecuperáveis: Os erros representam situações críticas que o programa não consegue corrigir ou recuperar,
 *                   como esgotamento de memória ou falhas internas da JVM.
 * - Não Deve Ser Tratado: Em geral, você não deve tentar capturar um Error com um bloco try-catch.
 *                         Esses erros indicam problemas que precisam ser corrigidos no ambiente ou no código.
 * *
 * Exemplos Comuns de Error:
 * - OutOfMemoryError: Memória Heap da JVM esgotada.
 * - StackOverflowError: Estouro da pilha devido a chamadas recursivas infinitas.
 * - InternalError: Problema interno da JVM.
 * - UnknownError: Erro desconhecido.
 */
public class Error {


    /*
    ---- Commons Error ----
    ExceptionInInitializerError
    StackOverflowError
    NoClassDefFoundError
     */
}
