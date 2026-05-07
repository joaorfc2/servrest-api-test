# Estrutura do Projeto:

src/
└── main/
└── java/
├── asserts/
├── client/
├── constants/
├── dto/
├── factory/
└── util/

test/
└── java/
├── aceitacao/
├── contrato/
└── funcional/

# Responsabilidades dos Packages:

### asserts

Responsável pelas validações dos testes.

As classes de assert devem:

Centralizar validações
Reduzir duplicação
Melhorar legibilidade dos testes
Validar status code, payload e regras de negócio

Exemplo:

public void validaLoginComErro(LoginRequest bodyLogin) {

    loginResponse = servRestClient.postLogin(bodyLogin)
            .then()
            .statusCode(401)
            .extract()
            .as(LoginResponse.class);

    assertThat(loginResponse.getMessage(),
            containsString("Email e/ou senha inválidos"));
}

Regras:

Não realizar construção de payload
Não conter lógica de request
Não conter massa de teste

### client

Responsável pelas chamadas HTTP utilizando RestAssured.

As classes client devem:

Centralizar endpoints
Centralizar headers
Centralizar autenticação
Abstrair chamadas REST

Regras:

Não conter asserts
Não conter regras de negócio
Apenas comunicação HTTP

### constants

Responsável pelas constantes do projeto.

Exemplos:

Endpoints
Paths
Tokens fixos
Headers
Mensagens reutilizáveis

### dto

Responsável pelos objetos de request/response.

Os DTOs representam:

Payloads de entrada
Payloads de saída
Contratos da API

Regras:

Não conter lógica
Apenas estrutura de dados

### factory

Responsável pela criação de objetos utilizando Builder Pattern.

Objetivos:

Facilitar criação de massa
Reutilização
Reduzir duplicidade

Exemplo:

UsuarioFactory
LoginFactory

Regras:

Não executar requests
Não conter asserts

### util

Responsável por:

BaseTest
Configurações globais
Helpers
Métodos utilitários

Exemplos:

Configuração RestAssured
Serialização
Geração de massa dinâmica

# Estrutura dos Testes

Os testes ficam fora do src/main.

test/java

### aceitacao

Testes end-to-end da jornada principal do usuário.

Objetivo:

Validar fluxo completo
Validar comportamento esperado

### contrato

Responsável pela validação de schema/contrato.

Exemplos:

JSON Schema
Estrutura de response
Campos obrigatórios

### funcional

Responsável pelas regras funcionais da API.

Exemplos:

Cenários positivos
Cenários negativos
Regras de negócio
Validações específicas

# Padrões do Projeto

### Builder Pattern

Toda massa de teste deve ser criada via factory utilizando Lombok Builder.

Exemplo:

LoginRequest.builder()
.email("teste@email.com")
.password("123456")
.build();

### Centralização de Assert

Os testes não devem conter asserts diretamente quando possível.

Preferir:

loginAssert.validaLoginComErro(body);

### Separação de Responsabilidades

Cada camada deve possuir responsabilidade única.

client → comunicação HTTP
asserts → validações
dto → estrutura de dados
factory → massa de teste
util → suporte técnico
tests → cenários

### Convenções

Nome de métodos

Utilizar padrão:

deve[ComportamentoEsperado][Condicao]

Exemplo:

deveRealizarLoginComSucesso
deveRetornarErroAoInformarSenhaInvalida