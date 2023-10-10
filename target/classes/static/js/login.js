//atribui a funcao para o botao castrar
$("#login").click(enviarDadosLogin);
$("#matricula").focus();

$("#matricula").keyup(function(event){
    if(event.key === "Enter"){
        $("#senha").focus();
    }
});

$("#senha").keyup(function(event){
    if(event.key === "Enter"){
        enviarDadosLogin();
    }
})

function enviarDadosLogin(){
    let matricula = $("#matricula").val();
    let senha = $("#senha").val();

    $.ajax({
        type: "POST",
        url: "/login",
        data: {
            matricula: matricula,
            senha: senha
        },
        success: function(data){
            if(data){
                window.location.href="/home";
            }else{
            alert("Login e Senha Inválidos!");
            }
        },
        error: function(){
            alert("Falha ao enviar dados");
        }
    });
}



