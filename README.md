# VoxReal

**VoxReal** é um sistema de votação em tempo real desenvolvido com Java e Spring Boot. Este projeto permite a criação de votações, adição de opções, registro de votos, e consulta de resultados. É um backend robusto e bem estruturado, projetado para ser utilizado como base em sistemas que necessitem de funcionalidades de votação.

---

## 📂 Estrutura do Projeto

A estrutura do projeto segue as boas práticas recomendadas:

```
VoxReal
├── src
│   ├── main
│   │   ├── java/com/voxreal
│   │   │   ├── config        # Configurações do sistema
│   │   │   ├── controllers   # Controladores da aplicação
│   │   │   ├── models        # Entidades do sistema
│   │   │   ├── repositories  # Interfaces de acesso ao banco de dados
│   │   │   ├── services      # Regras de negócio
│   │   └── resources
│   │       ├── application.properties # Configuração do Spring Boot
│   │       
│   ├── test
│       └── java/com/voxreal
│           └── controllers    # Testes dos controladores
├── build.gradle               # Configurações do Gradle
└── README.md                  # Documentação do projeto
```

---

## ✨ Funcionalidades

- **Gerenciamento de Votações:**
  - Criar votações com status inicial "ATIVA".
  - Adicionar múltiplas opções às votações.
  - Registrar votos em opções específicas.

- **Consultas:**
  - Listar todas as votações e suas opções associadas.
  - Exibir resultados parciais e finais das votações.

- **Testes Automatizados:**
  - Testes para validação dos endpoints do backend.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **H2 Database** (banco de dados em memória para testes)
- **Gradle** (gerenciador de build)
- **JUnit** (framework para testes unitários)

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/O-Farias/VoxReal.git
   cd VoxReal
   ```

2. **Execute o projeto:**
   ```bash
   ./gradlew bootRun
   ```

3. **Acesse a aplicação:**
   - Endereço padrão: `http://localhost:8080`

---

## 🧪 Testes

Execute os testes automatizados com o comando:
```bash
./gradlew test
```

---

## 🌟 Endpoints

### Votações
- **GET** `/votacoes` - Lista todas as votações.
- **POST** `/votacoes` - Cria uma nova votação.

### Opções
- **GET** `/opcoes/{votacaoId}` - Lista as opções de uma votação.
- **POST** `/opcoes/{votacaoId}` - Adiciona uma nova opção a uma votação.
- **POST** `/opcoes/{id}/votar` - Registra um voto em uma opção.

---

## 📄 Licença

Este projeto é licenciado sob a [MIT License](LICENSE).

---

## 💡 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests. Vamos construir algo incrível juntos!

---


