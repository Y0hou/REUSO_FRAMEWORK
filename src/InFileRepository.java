import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InFileRepository<T extends Serializable> implements CrudRepository<T> {
    private String filename;
    private List<T> entities;

    public InFileRepository(String filename) {
        this.filename = filename;
        this.entities = new ArrayList<>();
        loadFromFile();
    }

    @Override
    public void save(T entity) {
        entities.add(entity);
        saveToFile();
    }

    @Override
    public T findById(int id) {
        if (id < 0 || id >= entities.size()) {
            return null;
        }
        return entities.get(id);
    }

    @Override
    public void update(T entity) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).equals(entity)) {
                entities.set(i, entity);
                saveToFile();
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        if (id < 0 || id >= entities.size()) {
            return;
        }
        entities.remove(id);
        saveToFile();
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities);
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(entities);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            entities = (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            entities = new ArrayList<>();
        }
    }
}