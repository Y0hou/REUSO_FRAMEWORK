public class Main {
    public static void main(String[] args) {
        // Testando InMemoryRepository
        InMemoryRepository<Produto> produtoRepo = new InMemoryRepository<>();
        Produto p1 = new Produto("Laptop", 3000.0);
        Produto p2 = new Produto("Mouse", 50.0);
        produtoRepo.save(p1);
        produtoRepo.save(p2);
        System.out.println("Lista de Produtos (InMemoryRepository):");
        for (Produto p : produtoRepo.findAll()) {
            System.out.println(p);
        }

        // Testando InFileRepository
        InFileRepository<Produto> produtoFileRepo = new InFileRepository<>("produtos.dat");
        produtoFileRepo.save(p1);
        produtoFileRepo.save(p2);
        System.out.println("Lista de Produtos (InFileRepository):");
        for (Produto p : produtoFileRepo.findAll()) {
            System.out.println(p);
        }
    }
}