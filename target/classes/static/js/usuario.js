function validaCampoVazio(campo){
    if(campo.trim() == ''){
        return true;
    }else{
        return false;
    }
}

function createToastArea(){
    if($(".toaster").length == 0){
        $("body").prepend(''+
            '<div aria-live="polite" aria-atomic="true"'+
            'class="position-absolute top-0 end-0 erros">'+
                '<div class="toaster position-absolute top-0 end-0">'+
                '</div>'+
            '</div>');
    }
}

function showToast(alerta) {
    createToastArea();

    let tipo
    if(alerta.sucesso){
        tipo = ' bg-success ';
    }else{
        tipo = ' bg-danger ';
    }
    const toastElement = $('<div class="mt-1 toast align-items-center'+tipo+'text-white border-0" role="alert" aria-live="assertive" aria-atomic="true">'+
                                '<div class="d-flex">'+
                                    '<div class="toast-body">'+
                                        alerta.mensagem+
                                        '</div>'+
                                    '<button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>'+
                                '</div>'+
                            '</div>');

    toastElement.on('hidden.bs.toast', function () {
        $(this).remove();
    });

    $(".toaster").append(toastElement);
    const newToast = new bootstrap.Toast(toastElement);
    newToast.show();
}

$("#enviar").click(validaEnvio);
function validaEnvio(){
    let podeEnviar = true;
    let nome = $("#nome").val();
    let cargo = $("#cargo option:selected").val();
    let matricula = $("#matricula").val();

    $("#errorMessage").text("");
    $(".error-field").removeClass("error-field");

    if(validaCampoVazio(nome)){
        podeEnviar = false;
        showToast({sucesso: podeEnviar, mensagem: "O Nome precisa ser preenchido!"});
        $(".gNome").addClass("error-field");
    }

    if(validaCampoVazio(cargo)){
        podeEnviar = false;
        showToast({sucesso: podeEnviar, mensagem: "O cargo precisa ser selecionado!"});
        $(".gCargo").addClass("error-field");
    }

    if(validaCampoVazio(matricula)){
        podeEnviar = false;
        showToast({sucesso: podeEnviar, mensagem: "A matrícula precisa ser selecionada!"});
        $(".gMatricula").addClass("error-field");
    }


    if(podeEnviar){
        $.ajax({
            type: "POST",
            url: "/New_Usuario/new_usuario",
            data:{
                nome:nome,
                cargo:cargo,
                matricula:matricula,

            },
            success: function(data){
                $("#errorMessage").text("");
                if(data.sucesso){
                    window.location.href="/showUsuario";
                }else{
                    showToast(data);
                }

            },
            error: function(){
                $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
            }
        });
    }
}


//$("#enviar").click(cadastrarUsuario);
//
//function cadastrarUsuario(){
//    let nome = $("#nome").val();
//    let cargo = $("#cargo option:selected").val();
//    let matricula = $("#matricula").val();
//
//    $.ajax({
//        type: "POST",
//        url: "/New_Usuario/new_usuario",
//        data:{
//            nome : nome,
//            cargo : cargo,
//            matricula : matricula,
//
//        },
//        success: function(data){
//            alert(data);
//        },
//        error: function(){
//            alert("Falha na comunicação com o servidor!");
//        }
//    });
//}
//
