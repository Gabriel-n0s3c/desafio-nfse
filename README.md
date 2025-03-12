# 🧾 NFSe API & Frontend

Este projeto consiste em uma API para consulta de NFSe e um frontend.
A API, desenvolvida em **Java + Spring Boot**, permite consultar créditos e registrar eventos de auditoria via Kafka.
O frontend, feito em **Angular 15**, oferece uma interface responsiva para acesso aos dados.
A persistência é feita em MariaDB, e a aplicação pode ser executada via Docker, facilitando a configuração do ambiente.
## 📂 Estrutura do Projeto
```
├── nfse-api/        # API backend
├── nfse-estatico/   # Frontend Angular
├── docker-compose.yml  # Configuração Docker
└── README.md        # Documentação
```

## 🚀 Tecnologias Utilizadas

- **Backend**: Java 17, Spring Boot, Kafka, MariaDB, JUnit, Mockito
- **Frontend**: Angular
- **Banco de Dados**: MariaDB (local)
- **Mensageria**: Apache Kafka
- **Orquestração**: Docker Compose

## 📦 Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- [Docker](https://www.docker.com/get-started) (versão mínima recomendada: 20.10) versão utilizada 27.5.1
- [Docker Compose](https://docs.docker.com/compose/install/) (versão mínima recomendada: 1.29) versão utilizada 2.32.4


## 🔧 Configuração

### 1️⃣ Configurar Variáveis de Ambiente
Crie um arquivo `.env` na raiz do projeto, onde se encontra o arquivo `docker-compose.yml`, e configure as seguintes variáveis:

```ini
DB_URL=url do banco ex: `jdbc:mariadb://host.docker.internal:3306/desafio_nfse_db`
DB_USER=root
DB_PASSWORD="" 
KAFKA_SERVER=kafka:29092
TOPICO_CREDITO_KAFKA=credito-request
```

> **Nota**: O banco de dados está sendo utilizado localmente, lembre-se de iniciar o serviço.

### 2️⃣ Rodar o Projeto
Para subir todos os serviços, execute:

```sh
docker-compose up --build
```

Caso queira rodar em segundo plano:
```sh
docker-compose up -d --build
```

Isso iniciará os seguintes serviços:
- **Backend**: Disponível em `http://localhost:8080`
- **Frontend**: Disponível em `http://localhost:80`
- **Kafka & Zookeeper**
- **Kafdrop** (opcional, para visualizar as mensagens do Kafka)

### 3️⃣ Acessar o Kafdrop (Opcional)
Se desejar visualizar as mensagens enviadas ao Kafka, ative o serviço Kafdrop no `docker-compose.yml` (remova os comentários):

```yaml
kafdrop:
  container_name: kafdrop
  image: obsidiandynamics/kafdrop:latest
  depends_on:
    - zookeeper
    - kafka
  ports:
    - "19000:9000"
  environment:
    KAFKA_BROKERCONNECT: kafka:29092
```

Após isso, acesse [http://localhost:19000](http://localhost:19000).

## 🛑 Parar os Serviços
Para parar e remover os contêineres:
```sh
docker-compose down
```

## ⚠️ Observações Importantes
- Antes de iniciar o projeto, **verifique se o Docker está sendo executado corretamente**.
- O banco de dados **não está no Docker** e deve ser executado localmente.
- O **Kafdrop** pode ser utilizado para acompanhar as mensagens no Kafka.

---



