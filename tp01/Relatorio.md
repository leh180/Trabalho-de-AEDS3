##🎁 PresenteFácil 1.0 🎁

_🧠 Algoritimos e Estrutura de Dados III — Trabalho Prático 01_

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

### 📸 Principais Telas

Abaixo estão as principais telas do sistema.

*Tela de Login de Usuário

![Tela Login](imagens/TelaLogin.png)

*Tela de Cadastro de Usuário

![Cadastro](imagens/Cadastro.png)

*Menu Principal

![Tela Inicial](imagens/TelaInical.png)

*Tela de criação de Lista

![Criar Lista](imagens/CriarLista.png) 

*Exibição de Listas do Usuário

![Minhas Listas](imagens/MinhasListas.png)

*Tela de Compartilhamento por NanoID

![Listas Outros](imagens/ListasOutro.png)

*Tela de Exibição dos Dados do Usuário

![Meus Dados](imagens/TelaDados.png) 

---
### ⚙️ Principais Classes 

O sistema foi estruturado por meio de diversas classes, as principais são:

* ***Usuario***: A classe representa a entidade "Usuário" no sistema. Ela cria o usuario, aplica HashExtensivel na senha e implementa a a interface 'Entidade' para ser compatível com o sistema de arquivos genérico
  
* ***CRUDUsuario***: A classe CRUDUsuario estende a classe genérica Arquivo e gere todas as operações de persistência para a entidade Usuário. Ela mantém um índice secundário por e-mail (Hash Extensível) para acelerar as buscas e o processo de login.
  
* ***Lista***: A classe representa a entidade "Lista de Presentes" no sistema. Ela implementa a interface 'Entidade' para ser compatível com o sistema de arquivos genérico e 'Comparable' para permitir a ordenação alfabética das listas pelo nome.

* ***CRUDLista***: A classe CRUDLista estende a classe genérica Arquivo e gere todas as operações de persistência para a entidade Lista. Ela mantém um índice secundário por código (Hash Extensível) para buscas públicas e um índice de relacionamento (Árvore B+) para ligar utilizadores às suas listas.

* ***ControleLista***: A classe é responsável por gerir toda a lógica de negócio relacionada às listas, atuando como o intermediário entre as classes de modelo (dados) e as classes de visão (interface com o utilizador).
  
* ***ControlePrincipal***: A classe é o ponto de entrada da aplicação. Ela é responsável por orquestrar o fluxo principal do sistema, gerindo o login, a criação de utilizadores e o acesso aos menus de funcionalidades após a autenticação.
  
* ***ControleUsuario***: A classe 'ControleUsuario' é responsável por gerenciar toda a lógica de negócio relacionada aos usuários, como autenticação, cadastro e gerenciamento de perfil. Ela atua como um mediador entre as classes de persistência (CRUD) e a interface com o usuário (VisaoUsuario).
  
* ***Arquivo***: classe de tipo genérico para salvar os registros.
  
* ***ArvoreBMais***: classe que implementa uma árvore B+ para índice no relacionamento 1:N.
  
* ***HashExtensivel***: classe que implementa uma tabela HashExtensivel.
  
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



