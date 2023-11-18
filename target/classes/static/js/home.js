$('a').click(function(event){
    event.preventDefault();
    controleDeRotas($(this).attr("href"));
});

function gerarSwal(urlSucesso){
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success me-2',
            cancelButton: 'btn btn-danger ms-2'
        },
        buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
        title: 'Sair?',
        text: "Você realmente deseja sair?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: '<i class="fa-solid fa-thumbs-up"></i> Sim!',
        cancelButtonText: '<i class="fa-solid fa-thumbs-down"></i> Não!',
        reverseButtons: false
    }).then((result) => {
        if (result.isConfirmed) {
        window.location.href = urlSucesso;
        }
    });
}


 $(document).ready(function () {
        // Use jQuery para carregar o conteúdo da parcial view
        $(".mainContainer").load("/relatorio", function () {
            // Esta função é chamada após o carregamento da parcial view
            // Você pode aplicar seus estilos aqui
            $(".container").css({
                "background-color": "#fff",
                "padding": "20px",
                "border-radius": "5px",
                "box-shadow": "0 0 10px rgba(0, 0, 0, 0.1)"
            });
        });
    });

