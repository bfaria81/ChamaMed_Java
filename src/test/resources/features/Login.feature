#language: pt
Funcionalidade: Realizar Login no aplicativo ChamaMed
  Cenário: Teste de login bem sucedido
    Dado que estou na tela de login
    E digito no campo matrícula o número "12"
    E digito no campo senha a senha "1234"
    Quando clico no botão login
    Então eu entro na aplicação

  Cenário: Teste de login mal sucedido
    Dado que estou na tela de login
    E digito no campo matrícula o nome "1234"
    E digito no campo senha a senha "2345"
    Quando clico no botão login
    Então a mensagem erro é exibida


