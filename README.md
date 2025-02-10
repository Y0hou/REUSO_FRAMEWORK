# Framework de Gerenciamento de Entidades Genéricas em Java

Framework em Java para a disciplina de Reuso de Software - UFC Quixadá.

## Funcionalidades
- **CRUD Genérico**: Permite criar, ler, atualizar e deletar entidades de qualquer tipo.
- **Armazenamento em Memória**: Implementação `InMemoryRepository` para armazenar entidades temporariamente em memória.
- **Armazenamento em Arquivo**: Implementação `InFileRepository` para persistir entidades em um arquivo.
- **Reutilização de Código**: Uso de Generics para permitir a reutilização de código para diferentes tipos de entidades.

## Estrutura do Projeto
O projeto está organizado da seguinte forma:

```
src/
│
├── CrudRepository.java       # Interface genérica para operações CRUD
├── InMemoryRepository.java   # Implementação em memória do repositório
├── InFileRepository.java     # Implementação em arquivo do repositório
├── Produto.java              # Entidade de exemplo (Produto)
├── Main.java                 # Programa principal para demonstração
```

## Como Executar
### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior.
- Git (opcional, para clonar o repositório).

### Passos
1. Clone o repositório (ou baixe o código-fonte):
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd seu-repositorio
   ```

3. Compile o projeto:
   ```bash
   javac -d bin src/*.java
   ```

4. Execute o programa principal:
   ```bash
   java -cp bin Main
   ```

## Exemplo de Saída
Ao executar o programa principal, você verá uma saída semelhante a esta:

```bash
Lista de Produtos (InMemoryRepository):
Produto{nome='Laptop', preco=3000.0}
Produto{nome='Mouse', preco=50.0}

Lista de Produtos (InFileRepository):
Produto{nome='Laptop', preco=3000.0}
Produto{nome='Mouse', preco=50.0}
```

## Como Testar
O programa principal (`Main.java`) já inclui testes básicos para as implementações `InMemoryRepository` e `InFileRepository`. Você pode modificar o código para adicionar mais entidades ou testar outras funcionalidades.

### Exemplo de Teste
Para testar a atualização de uma entidade, adicione o seguinte código ao `Main.java`:

```java
Produto p3 = new Produto("Teclado", 100.0);
produtoRepo.save(p3);
System.out.println("Produto adicionado: " + p3);

p3 = new Produto("Teclado Mecânico", 150.0);
produtoRepo.update(p3);
System.out.println("Produto atualizado: " + p3);
```
