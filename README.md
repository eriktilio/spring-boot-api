# Spring Boot API

API RESTful para gerenciamento de usuários construída com Spring Boot. A API permite criar, ler, atualizar e excluir usuários, além de pesquisar usuários pelo nome.

## Executando o Projeto

Para executar este projeto, você precisa ter o Java e o Maven instalados. Siga os passos abaixo:

1. Clone o repositório
2. Navegue até o diretório do projeto:
3. Execute o projeto usando Maven:

   ```sh
   mvn spring-boot:run
   ```

A API estará disponível em http://localhost:8080.

## Endpoints

### Obter todos os usuários

- **URL**: `/user`
- **Método**: `GET`
- **Descrição**: Retorna uma lista de todos os usuários.

#### Exemplo de Resposta

```json
[
  {
    "id": 1,
    "name": "João Silva",
    "email": "joao.silva@example.com"
  },
  {
    "id": 2,
    "name": "Maria Oliveira",
    "email": "maria.oliveira@example.com"
  }
]
```

### Obter um usuário pelo ID

- **URL**: `/user/{id}`
- **Método**: `GET`
- **Descrição**: Retorna os detalhes de um usuário específico pelo ID.

#### Exemplo de Resposta

```json
{
  "id": 1,
  "name": "João Silva",
  "email": "joao.silva@example.com"
}
```

### Criar um novo usuário

- **URL**: `/user`
- **Método**: `POST`
- **Descrição**: Cria um novo usuário.

#### Exemplo de Requisição

```json
{
  "name": "Novo Usuário",
  "email": "novo.usuario@example.com"
}
```

#### Exemplo de Resposta

```json
{
  "id": 3,
  "name": "Novo Usuário",
  "email": "novo.usuario@example.com"
}
```

### Atualizar um usuário existente

- **URL**: `/user`
- **Método**: `PUT`
- **Descrição**: Atualiza as informações de um usuário existente.

#### Exemplo de Requisição

```json
{
  "id": 1,
  "name": "João Silva Atualizado",
  "email": "joao.silva.atualizado@example.com"
}
```

#### Exemplo de Resposta

```json
{
  "id": 1,
  "name": "João Silva Atualizado",
  "email": "joao.silva.atualizado@example.com"
}
```

### Deletar um usuário pelo ID

- **URL**: `/user/{id}`
- **Método**: `DELETE`
- **Descrição**: Deleta um usuário específico pelo ID.

#### Exemplo de Resposta

```css
HTTP 204 No Content
```

### Buscar um usuário pelo nome

- **URL**: `/user/search/{name}`
- **Método**: `GET`
- **Descrição**: Retorna os detalhes de um usuário específico pelo nome.

#### Exemplo de Resposta

```json
{
  "id": 1,
  "name": "João Silva",
  "email": "joao.silva@example.com"
}
```
