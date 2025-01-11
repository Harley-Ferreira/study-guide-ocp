package chapter_09_collections_generics.generics.example;

public class Main {
    public static void main(String[] args) {
        // Criando repositório para Clientes
        GenericRepository<Customer, String> clienteRepository = new GenericRepository<>();

        // Salvando clientes
        clienteRepository.save(new Customer("1", "João"));
        clienteRepository.save(new Customer("2", "Maria"));

        // Listando todos os clientes
        System.out.println("Todos os clientes:");
        clienteRepository.findAll().forEach(customer ->
            System.out.println("ID: " + customer.getId() + ", Nome: " + customer.getName())
        );

        // Procurando cliente pelo ID
        System.out.println("\nProcurando cliente com ID 1:");
        clienteRepository.findById("1")
            .ifPresent(customer -> System.out.println("Encontrado: " + customer.getName()));

        // Deletando cliente
        clienteRepository.deleteById("2");
        System.out.println("\nApós deletar cliente com ID 2:");
        clienteRepository.findAll().forEach(customer ->
            System.out.println("ID: " + customer.getId() + ", Nome: " + customer.getName())
        );
    }
}
