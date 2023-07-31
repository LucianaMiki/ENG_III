# ENGIII

# 1º Passo
Clone o repositório em uma pasta vazia.
Exemplo: clonar numa pasta chamada "ESIII"

# 2º Passo
Baixe o eclipse.
Para baixar o eclipse: https://www.eclipse.org/downloads/

# 3º Passo
Adicione o projeto ao eclipse
Seguindo nosso exemplo:
  -Abra o eclipse
  -Clique em "File"
  -Clique em "Open Projects from File System..."
  -Clique em "Directory"
  -Selecione a pasta "ESIII" (criada no 1º passo)
  -Selecione o projeto quando ele aparecer no maior quadro branco da tela
  -Clique em Finish

# 4º Passo
 Adicione o server
  -Clique em "File"
  -Clique em "New"
  -Clique em "Other"
  -Clique em "Server"
  -Selecione "Server"
  -Clique em "Next"
  -Escolha o Tomcat que quiser (se não tiver o Tomcat, baixe por https://tomcat.apache.org/download-90.cgi)
  -Clique em "Finish"
 
# 5º Passo
Adicione o projeto ao server
  -Clique em "Window"
  -Clique em "Show view"
  -Clique em "Other"
  -Selecione "Server"
  -Clique em "Open"
  -Quando aparecer la embaixo, clique com o botão direito em cima do Tomcat
  -Clique em "Add and Remove"
  -Selecione o projeto e passe ele de "Available" para "Configured", selecionando ele e clicando em "Add"
  -Se ele não aparecer:
      -Clique com o botão direito do mouse em cima da pasta do projeto no lado esquerdo
      -Clique em "Properties"
      -Clique em "Project Facets"
      -Tique as box "Dynamic Web Module","Java" e "Javascript"
      -Do lado direito, clique em "Runtime"
      -Tique o Tomcat
      -Clique em "Apply and Close"
      -Verifique se apareceu agora, repetindo aqueles passos para adicionar ao server
      

# 6º Passo
Ligue o server
  -Clique com o botão direito no Tomcat la embaixo
  -Clique em "Start"
  -Va para o Browser e acesse "http://localhost:8000/ESIIItest/index.jsp"
      -nota: pode ser que você tenha que mudar a porta
