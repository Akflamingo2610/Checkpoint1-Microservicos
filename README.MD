
*CHECKPOINT 1*

*API JAVA PARA CONSULTA DE PACIENTES*

*RM550909 PEDRO LOTÉRIO DOS SANTO*
*RM98048 LUCAS THOMAZETTE BENVENUTO*



Documentação - Sistema de Agendamento de Consultas

Introdução

Este sistema foi desenvolvido em Java com Spring Boot para gerenciar o cadastro de pacientes em um sistema de agendamento de consultas. Ele permite a criação, leitura, atualização e exclusão de pacientes por meio de uma API REST.

Tecnologias Utilizadas

Java 17/18

Spring Boot 3.4

Maven

Spring Web

Spring DevTools

SpringDoc OpenAPI (Swagger)

Estrutura do Projeto

O projeto é dividido nas seguintes camadas:

Model - Contém a classe Paciente, que representa os pacientes do sistema.

Service - Contém a classe PacienteService, que gerencia a lógica de negócio.

Controller - Contém a classe PacienteController, que expõe os endpoints REST.

Endpoints da API

1. Criar Paciente

Rota: POST /pacientes

Request Body:

{
    "nome": "João da Silva",
    "endereco": "Rua das Flores, 123",
    "bairro": "Centro",
    "email": "joao@email.com",
    "telefoneCompleto": "11987654321"
}

Resposta: 201 Created

{
    "id": 1,
    "nome": "João da Silva",
    "endereco": "Rua das Flores, 123",
    "bairro": "Centro",
    "email": "joao@email.com",
    "telefoneCompleto": "11987654321"
}

2. Listar Todos os Pacientes

Rota: GET /pacientes

Resposta: 200 OK

[
    {
        "id": 1,
        "nome": "João da Silva",
        "endereco": "Rua das Flores, 123",
        "bairro": "Centro",
        "email": "joao@email.com",
        "telefoneCompleto": "11987654321"
    }
]

3. Buscar Paciente por ID

Rota: GET /pacientes/{id}

Exemplo: GET /pacientes/1

Resposta: 200 OK

{
    "id": 1,
    "nome": "João da Silva",
    "endereco": "Rua das Flores, 123",
    "bairro": "Centro",
    "email": "joao@email.com",
    "telefoneCompleto": "11987654321"
}

Erro: 404 Not Found (Se o paciente não existir)

4. Atualizar Paciente

Rota: PUT /pacientes/{id}

Exemplo: PUT /pacientes/1

Request Body:

{
    "nome": "João Pedro da Silva",
    "endereco": "Rua Nova, 456",
    "bairro": "Jardins",
    "email": "joao.pedro@email.com",
    "telefoneCompleto": "11999999999"
}

Resposta: 200 OK

{
    "id": 1,
    "nome": "João Pedro da Silva",
    "endereco": "Rua Nova, 456",
    "bairro": "Jardins",
    "email": "joao.pedro@email.com",
    "telefoneCompleto": "11999999999"
}

Erro: 404 Not Found (Se o paciente não existir)

5. Deletar Paciente

Rota: DELETE /pacientes/{id}

Exemplo: DELETE /pacientes/1

Resposta: 204 No Content (Se o paciente foi deletado com sucesso)

Erro: 404 Not Found (Se o paciente não existir)

EXECUTAR A API: *mvn spring boot : run*

Testando a API no Swagger

Execute a aplicação Spring Boot.

Acesse o Swagger UI: http://localhost:8080/swagger-ui.html

Escolha o endpoint que deseja testar.

Clique em "Try it out" para inserir os dados.

Execute a requisição e verifique a resposta.

