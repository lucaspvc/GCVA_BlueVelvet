# 🎵 BlueVelvet Music Store

##  Nome do Projeto
**BlueVelvet Music Store**

---

##  Descrição do Projeto
A **BlueVelvet Music Store** é uma aplicação web voltada para venda de produtos musicais. O objetivo principal é desenvolver habilidades em novas tecnologias, boas práticas arquiteturais e gestão de requisitos funcionais e não funcionais.

A BlueVelvet é uma plataforma **E-commerce gratuita, colaborativa e open source**, criada para incentivar e apoiar diretamente artistas fora do mainstream.

---

##  Ferramentas Utilizadas
- **IDE:** IntelliJ IDEA Ultimate  
- **Controle de Versão:** Git + GitHub  
- **Gerenciamento Ágil:** Jira  
- **Testes de API:** Swagger e Postman  
- **Banco de Dados:** Supabase / PostgreSQL  

---

##  Tecnologias e Frameworks
- **Spring Boot** — Framework principal do backend  
- **Spring Data JPA** — Persistência com Hibernate  
- **Spring MVC / REST** — Criação de APIs RESTful  
- **Thymeleaf** — Renderização de páginas (opcional caso haja frontend separado)  
- **Maven** — Gerenciamento de dependências  
- **PostgreSQL** — Banco de dados relacional  
- **React + Vite** — Frontend moderno e performático  

---

##  Linguagens Utilizadas
- **Java 17+**  
- **JavaScript (React + Vite)**  

---

## 📁 Estrutura do Projeto

```bash
src/main/java/com/musicstore/BlueVelvet/
│
├── api/
│   ├── controller/
│   │   ├── CategoryController.java
│   │   └── ProductController.java
│   │
│   ├── entity/
│   │   ├── Category.java
│   │   ├── Product.java
│   │   ├── ProductDetail.java
│   │   └── ProductDimension.java
│   │
│   ├── repository/
│   │   ├── CategoryRepository.java
│   │   └── ProductRepository.java
│   │
│   ├── request/
│   │   ├── CategoryRequest.java
│   │   ├── ProductRequest.java
│   │   ├── ProductDetailRequestDTO.java
│   │   └── ProductDimensionRequestDTO.java
│   │
│   ├── response/
│   │   ├── CategoryResponse.java
│   │   ├── ProductResponse.java
│   │   ├── ProductDetailResponse.java
│   │   └── ProductDimensionResponse.java
│   │
│   ├── service/
│   │   ├── CategoryService.java
│   │   └── ProductService.java
│   │
│   └── BlueVelvetApplication.java
│
└── resources/
    ├── application.properties
    ├── static/
    ├── templates/
    ├── schema.sql
    └── data.sql
```

## Instalação e Configuração

### Pré-requisitos
Antes de começar, você precisará ter instalado:
- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Gadle](https://gadle.apache.org/download.cgi)
- [PostGree ](https://dev.mysql.com/downloads/mysql/) (opcional, pode usar H2)
- [Git](https://git-scm.com/)
- IDE (IntelliJ, Eclipse, VS Code ou outra de sua preferência)

---

### Passoa de compilação

#### 1. Clone o repositório
```bash
git clone https://github.com/seuusuario/bluevelvet-music-store.git
cd bluevelvet-music-store
```
#### 2. Configure o banco de dados
#### 3. Instale as dependências
#### 4. Execute o projeto

##  Ambiente de Produção
Pode ser implantado em qualquer nuvem gratuita, como:
    Render
    Railway
    Vercel (para frontend estático)
    Fly.io
    Heroku (caso disponível)

##  Time de Desenvolvimento
- Abner Gomes Guimarães
- Lucas Pessoa Oliveira Alves
- Heloisa Pimentel De Souza
- Jorran Luka Andrade dos Santos
- Pamela Oliveira Silva

---
