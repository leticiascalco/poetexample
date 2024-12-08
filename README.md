# PoetExample 🎨✨

Este é um projeto desenvolvido para demonstrar o uso do **KotlinPoet**, uma poderosa biblioteca para geração de código Kotlin, em um cenário real. O objetivo principal é criar classes Kotlin automaticamente a partir de templates JSON e usá-las para construir strings posicionais compatíveis com sistemas legados, como mainframes.

---

## 🌟 O que este projeto faz?

1. **Geração Automática de Código**:  
   Cria classes Kotlin dinamicamente com base em templates JSON, tornando o processo de desenvolvimento mais eficiente e fácil de manter.

2. **String Posicional Personalizada**:  
   Gera uma string no formato posicional, chamada **trancode**, que contém campos fixos definidos pelo template JSON, além de um campo coringa (`xFiller`) para valores adicionais.

3. **Flexibilidade**:  
   O projeto permite que novos campos e regras sejam adicionados facilmente no template JSON, simplificando a adaptação para diferentes sistemas.

---

## 🛠️ Tecnologias Utilizadas

- **KotlinPoet** 🎨: Para geração dinâmica de código.
- **Spring Boot** 🚀: Para expor o endpoint que retorna a string gerada.
- **Gradle** 🛠️: Para gerenciamento de dependências e execução de tarefas.
- **Kotlin** ❤️: Linguagem principal do projeto.

---

Para instalar e rodar o projeto, você precisará ter o JDK 17+ ☕, Gradle 7.6+ 🛠️ e Git 🌐 configurado no seu ambiente. 

Primeiro, clone o repositório usando o comando git clone git@github.com:leticiascalco/poetexample.git e navegue até o diretório do projeto com cd poetexample. 
Certifique-se de que o Gradle está configurado corretamente no seu ambiente executando o comando ./gradlew --version. 
Em seguida, instale todas as dependências necessárias com ./gradlew clean build.

O arquivo message-trancode.json, que define os campos e regras para geração de código, está localizado em src/main/resources/templates. 
Para gerar as classes Kotlin automaticamente com base neste template, use a task personalizada do Gradle executando o comando ./gradlew generateTrancode. 
As classes geradas estarão disponíveis no diretório src/main/kotlin/com/br/poetexample/application/core/dto.

Depois disso, compile e rode o projeto com os comandos ./gradlew clean build e ./gradlew bootRun. 
Com o servidor rodando, você poderá acessar o endpoint http://localhost:8080/trancode no navegador ou em ferramentas como o Postman para visualizar a string posicional gerada.
