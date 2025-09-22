<h2>🎁 PresenteFácil 1.0 🎁</h2>

---

### 📝 Descrição do Projeto

O **PresenteFácil** foi criado para simplificar a vida de quem quer centralizar seus desejos e compartilhá-los com amigos e familiares de uma maneira organizada. O sistema permite que **usuários cadastrados** criem e gerenciem listas de presentes para ocasiões como aniversários e casamentos, facilitando a troca de presentes e evitando duplicatas.

---

### 🧑‍💻 Equipe do Projeto

* Ana Clara Lonczynski
* Bruno Menezes Rodrigues Oliveira Vaz
* João Costa Calazans
* Letícia Azevedo Cota Barbosa 
* Miguel Pessoa Lima Ferreira

---

### 🚀 Funcionalidades Principais

* **Cadastro e Autenticação de Usuários**: Para usar o sistema, o usuário deve se cadastrar com nome, e-mail e uma senha (armazenada em formato de hash para segurança). O acesso é feito via e-mail e senha. Existe um mecanismo de recuperação de senha por meio de uma pergunta e resposta secretas.
* **Criação de Listas de Presentes**: Um usuário pode criar múltiplas listas, cada uma com um nome, descrição e, opcionalmente, uma data limite. Cada lista é vinculada a um único usuário.
* **Visualização e Compartilhamento**: Cada lista gerada possui um código compartilhável único e alfanumérico. Esse código permite que o criador da lista a compartilhe com outras pessoas, que poderão visualizar o conteúdo.
* **Gerenciamento de Listas**: Os usuários podem visualizar todas as suas listas cadastradas, alterar seus dados (nome, descrição, data limite) ou excluí-las. A navegação é intuitiva, utilizando menus textuais e um "rastro" (breadcrumb) para indicar a localização do usuário no sistema.

---

### ✅ Checklist

|Requisito|Status|
|---------|------|
|Há um CRUD de usuários (que estende a classe ArquivoIndexado, acrescentando Tabelas Hash Extensíveis e Árvores B+ como índices diretos e indiretos conforme necessidade) que funciona corretamente?|[✅]|
|Há um CRUD de listas (que estende a classe ArquivoIndexado, acrescentando Tabelas Hash Extensíveis e Árvores B+ como índices diretos e indiretos conforme necessidade) que funciona corretamente?|[✅]|
|As listas de presentes estão vinculadas aos usuários usando o idUsuario como chave estrangeira?|[✅]|
|Há uma árvore B+ que registre o relacionamento 1:N entre usuários e listas?|[✅]|
|Há um CRUD de usuários (que estende a classe ArquivoIndexado, acrescentando Tabelas Hash Extensíveis e Árvores B+ como índices diretos e indiretos conforme necessidade)?|[✅]|
|Há uma visualização das listas de outras pessoas por meio de um código NanoID?|[✅]|
|O trabalho compila corretamente?|[✅]|
|O trabalho está completo e funcionando sem erros de execução?|[✅]|
|O trabalho é original e não a cópia de um trabalho de outro grupo?|[✅]|



