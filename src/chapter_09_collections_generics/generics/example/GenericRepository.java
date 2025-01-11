package chapter_09_collections_generics.generics.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericRepository<T, ID> {
    private List<T> database = new ArrayList<>();

    public void save(T entity) {
        database.add(entity);
        System.out.println("Saved: " + entity);
    }

    public List<T> findAll() {
        return database;
    }

    public Optional<T> findById(ID id) {
        // Apenas para simular, assumindo que os objetos implementam toString como ID.
        return database.stream()
                .filter(entity -> entity.toString().equals(id.toString()))
                .findFirst();
    }

    public void deleteById(ID id) {
        database.removeIf(entity -> entity.toString().equals(id.toString()));
        System.out.println("Deleted entity with ID: " + id);
    }
}
