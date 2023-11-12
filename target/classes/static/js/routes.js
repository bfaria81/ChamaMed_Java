function controleDeRotas(url){
    switch(url){
        case "/logout":
            gerarSwal(url);
            break;
        case "/showUsuarioAtivo":
//            Renderizar Tela
//            $.get(url, function(data){
//            //Renderizar Tela
//            $('#mainContainer').html(data);
//            Definir as ações dos componentes
//            $("#enviar").click(enviaCadastroNotebook);
            window.location.href = "/showUsuarioAtivo"

            break;
        case "/showInterruptor":
            window.location.href = "/showInterruptor"
            break;

        case "/chamados":
                    function carregarPaginaChamados() {
                        // Redirecione o navegador para a página "/chamados"
                        window.location.href = "/chamados";
                    }

                    // Chame a função para redirecionar o navegador uma vez.
                    carregarPaginaChamados();

                    // Configurar um intervalo para atualizar a div "content" a cada 1 segundo.
                    setInterval(function() {
                        $.ajax({
                            url: '/chamados', // Substitua pelo URL real da sua div
                            type: 'GET',
                            success: function (data) {
                                // Atualize o conteúdo da div com a lista de chamados
                                $('#content').html(data);
                            }
                        });
                    }, 1000);
                    break;


        case "/relatorio":
                            $.get(url, function(data){
                                $('#mainContainer').html(data);

                                    $(document).ready( function () {
                                    $('#relatorioTable').DataTable();
                                });
                            });
                            break;

    }
}



