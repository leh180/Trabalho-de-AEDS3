<h2>🎁 PresenteFácil 1.0 🎁</h2>

---

### 📝 Descrição do Projeto

O **PresenteFácil** foi criado para simplificar a vida de quem quer centralizar seus desejos e compartilhá-los com amigos e familiares de uma maneira organizada. [cite_start]🎉 O sistema permite que **usuários cadastrados** criem e gerenciem listas de presentes para ocasiões como aniversários e casamentos, facilitando a troca de presentes e evitando duplicatas. [cite: 9, 10]

---

### 🧑‍💻 Equipe do Projeto

* Ana Clara Lonczynski
* Bruno Menezes Rodrigues Oliveira Vaz
* João Costa Calazans
* Letícia Azevedo Cota Barbosa 
* Miguel Pessoa Lima Ferreira

---

### 🚀 Funcionalidades Principais

* **Cadastro e Autenticação de Usuários**: Faça seu cadastro com nome, e-mail e uma senha segura (armazenada em hash). [cite_start]O acesso é feito via e-mail e senha, e a recuperação de senha é garantida por meio de uma pergunta secreta. [cite: 12, 13, 21]
* **Criação de Listas de Presentes**: Crie várias listas, cada uma com seu próprio nome, descrição e, opcionalmente, uma data limite. [cite_start]Cada lista é vinculada a um único usuário. [cite: 14, 15]
* **Visualização e Compartilhamento**: Cada lista recebe um código alfanumérico único. [cite_start]Você pode compartilhar este código com quem quiser para que eles possam visualizar o conteúdo da sua lista. [cite: 16, 17, 116]
* [cite_start]**Gerenciamento de Listas**: Gerencie todas as suas listas de forma intuitiva, podendo visualizar, editar (nome, descrição, data limite) ou excluí-las a qualquer momento. [cite: 18, 19]

---

### 💻 Estrutura Técnica

O sistema foi desenvolvido com uma arquitetura robusta para garantir a segurança e o bom desempenho:

* [cite_start]**CRUDs Completos**: Possui operações completas de **C**riar, **L**er, **A**tualizar e **D**eletar (CRUD) tanto para usuários quanto para listas. [cite: 105, 106]
* **Armazenamento e Indexação**: Para otimizar o acesso e a segurança dos dados, o projeto utiliza:
    * [cite_start]**Tabelas Hash Extensíveis** e **Árvores B+** como índices diretos e indiretos. [cite: 105]
    * [cite_start]A senha é armazenada como um **hash** para sua segurança. [cite: 12, 23]
* [cite_start]**Relacionamento 1:N**: A relação entre usuários e listas é implementada com o `idUsuario` como chave estrangeira, usando uma **Árvore B+** para registrar o relacionamento 1:N. [cite: 109, 111]

---

### ✅ Checklist

|Requisito|Status|
|---------|------|
|Há um CRUD de usuários (que estende a classe ArquivoIndexado, acrescentando Tabelas Hash Extensíveis e Árvores B+ como índices diretos e indiretos conforme necessidade) que funciona corretamente?|[✅]|
|Há um CRUD de listas (que estende a classe ArquivoIndexado, acrescentando Tabelas Hash Extensíveis e Árvores B+ como índices diretos e indiretos conforme necessidade) que funciona corretamente?|[✅]|

