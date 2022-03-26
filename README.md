
## Todo API

Este é um projeto open source para fins de estudo.

## Tecnologias Utilizadas:


* Spring Boot + Spring Framework
* Java
* H2 Database
* JPA
* Hibernate
## Documentação da API

#### Retorna os todos em aberto

```http
  GET /todos/open
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `open` | `string` |  Retorna uma page  |

#### Retorna os todos finalizado

```http
  GET /todos/close
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `close`      | `string` | Retorna uma page |

#### Retorna os todos abertos e finalizados

```http
  GET /todos
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `-`      | `string` | Retorna um lista |

#### Retorna um todo pelo pelo ID

```http
  GET /todos/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer passar com parâmetro na requisição |

#### Inserindo um novo todo 

```http
  POST /todos
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `-`      | `string` | **Obrigatório** Uma corpo de requisição JSON. 

#### Deleta um todo pelo pelo ID

```http
  DELETE /todos/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer passar na requisição |

#### Atualiza um todo pelo pelo ID

```http
  PUT /todos/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer passar na requisição |




## Autor

- GitHub: [@rafaelsouuza](https://www.github.com/rafaelsouuza)
- Linkedin: [@rafaelsouuza](https://www.linkedin.com/in/rafaelsouuza/)

