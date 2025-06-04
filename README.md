
# IgniteShield - Sistema de Monitoramento de Focos de Queimadas

🚀 Um sistema desenvolvido em Java com Spring Boot e banco de dados Oracle para monitorar focos de incêndio e auxiliar equipes de agentes ambientais no combate a queimadas.

---

## 📂 Estrutura do Projeto

```
📦 ignite-shield
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java
 ┃ ┃ ┃ ┣ 📂 com.fiap.queimadas.monitoramentos
 ┃ ┃ ┃ ┃ ┣ 📂 config
 ┃ ┃ ┃ ┃ ┣ 📂 controller
 ┃ ┃ ┃ ┃ ┣ 📂 service
 ┃ ┃ ┃ ┃ ┣ 📂 domain.model
 ┃ ┃ ┃ ┃ ┣ 📂 dto
 ┃ ┃ ┃ ┃ ┣ 📂 mapper
 ┃ ┃ ┃ ┃ ┣ 📂 repository
 ┃ ┃ ┃ ┃ ┗ 📂 service
 ┃ ┃ ┣ 📂 resources
 ┃ ┃ ┃ ┣ 📜 application.properties
 ┣ 📜 README.md
```

---

## 📌 Funcionalidades Implementadas

✅ **CRUD Completo para Regiões, Sensores, Focos de Incêndio, Alertas e Agentes Ambientais**  
✅ **Validações com Spring Boot**  
✅ **Autenticação e Autorização com Spring Security (BasicAuth)**  
✅ **Migração automática de banco de dados com Flyway**  
✅ **Documentação para testes via Insomnia**

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Security**
- **Oracle Database**
- **Flyway**
- **Insomnia** para testes de API

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/ignite-shield.git
   cd ignite-shield
   ```

2. **Importe a coleção Insomnia (arquivo `.json`):**
   - Abra o Insomnia
   - Clique em **Importar** > **De arquivo**
   - Selecione o arquivo `queimadas-collection.json` gerado
   - Teste todos os endpoints!

---

## 🔒 Acesso Autenticado

Para acessar os endpoints protegidos:
- **Usuário**: admin
- **Senha**: admin123

> Configure esses dados em `application.properties` caso necessário.

---

## 🧩 Justificativas Técnicas

✅ **Padrão REST** para organização de endpoints e separação de responsabilidades.  
✅ **DTOs** foram utilizados para isolar a camada de dados e facilitar o versionamento.  
✅ **Flyway** garante versionamento e controle de alterações do banco de dados.  
✅ **Spring Security (BasicAuth)** foi escolhido pela simplicidade para demonstração, sendo possível migrar para JWT ou OAuth futuramente.  
✅ **Enum** para severidade e status de alertas, garantindo valores consistentes.  
✅ **Mapper** centralizado para conversão entre entidades e DTOs, evitando duplicação de código.
