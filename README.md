# 🎵 BlueVelvet Music Store

## 🧩 Nome do Projeto
**BlueVelvet Music Store**

---

## 📖 Descrição do Projeto
A **BlueVelvet Music Store** é uma aplicação web desenvolvida para uma empresa fictícia brasileira chamada *Blue Velvet*.  
A loja tem como objetivo **vender músicas, vinis, CDs, mp3s e produtos relacionados a artistas independentes** — como camisetas, bonés, livros e acessórios.  

Diferente de grandes plataformas comerciais (como Amazon, Americanas, Magalu, Submarino e Netshoes), a BlueVelvet é **gratuita, colaborativa e de código aberto**, incentivando o apoio direto a artistas fora do mainstream.

---

## 🧰 Ferramentas Utilizadas
- **IDE:** IntelliJ IDEA Ultimate (sugestão)  
- **Versionamento:** Git + GitHub  
- **Gerenciamento Ágil:** Jira, KanbanFlow ou GitHub Projects  
- **Testes de API:** Postman ou Insomnia  
- **Banco de Dados:** MySQL (produção) / H2 (desenvolvimento)

---

## ⚙️ Tecnologias Principais
- **Spring Boot** — Framework principal para o backend Java  
- **Spring Data JPA** — Persistência de dados com Hibernate  
- **Spring MVC / REST** — Criação de endpoints RESTful  
- **Thymeleaf** — Renderização de páginas no lado servidor (ou uso de frontend separado em HTML/CSS/JS)  
- **Maven** — Gerenciamento de dependências e build  
- **MySQL** — Banco de dados relacional principal  

---

## 💻 Linguagens Utilizadas
- **Java 17+** (backend)
- **HTML5 / CSS3 / JavaScript** (frontend básico)

---

## 🧱 Estrutura do Projeto (Exemplo)
```bash
bluevelvet-music-store/
│
├── src/
│ ├── main/
│ │ ├── java/com/bluevelvet/
│ │ │ ├── controllers/ # Controladores REST / MVC
│ │ │ ├── models/ # Entidades JPA (Product, Artist, User, etc.)
│ │ │ ├── repositories/ # Interfaces do Spring Data JPA
│ │ │ ├── services/ # Regras de negócio
│ │ │ └── BlueVelvetMusicStoreApplication.java
│ │ └── resources/
│ │ ├── static/ # Arquivos estáticos (CSS, JS, imagens)
│ │ ├── templates/ # Páginas Thymeleaf
│ │ ├── application.properties
│ │ └── data.sql / schema.sql
│ └── test/ # Testes automatizados
│
├── pom.xml # Arquivo de configuração do Maven
├── README.md
└── .gitignore
```

## ⚙️ Instalação e Configuração

### 🪶 Pré-requisitos
Antes de começar, você precisará ter instalado:
- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/mysql/) (opcional, pode usar H2)
- [Git](https://git-scm.com/)
- IDE (IntelliJ, Eclipse, VS Code ou outra de sua preferência)

---

### 🧭 Passos para rodar o projeto localmente

#### 1️⃣ Clone o repositório
```bash
git clone https://github.com/seuusuario/bluevelvet-music-store.git
cd bluevelvet-music-store
```
#### 2️⃣ Configure o banco de dados
#### 3️⃣ Instale as dependências
#### 4️⃣ Execute o projeto

## 🌍 Ambiente de Produção
Pode ser implantado em qualquer nuvem gratuita, como:
    Render
    Railway
    Vercel (para frontend estático)
    Fly.io
    Heroku (caso disponível)

## 👥 Contribuição

## 🧾 Licença
Este projeto é livre e de código aberto.

## 💙 Créditos

BlueVelvet Music Store — projeto acadêmico e open source criado para fins de estudo e prática de desenvolvimento com Java Spring Boot e arquitetura em camadas.
