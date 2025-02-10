import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T> implements CrudRepository<T> {
    private Map<Integer, T> repository = new HashMap<>();
    private int nextId = 1;

    @Override
    public void save(T entity) {
        repository.put(nextId++, entity);
    }

    @Override
    public T findById(int id) {
        return repository.get(id);
    }

    @Override
    public void update(T entity) {
        for (Map.Entry<Integer, T> entry : repository.entrySet()) {
            if (entry.getValue().equals(entity)) {
                repository.put(entry.getKey(), entity);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(repository.values());
    }
}