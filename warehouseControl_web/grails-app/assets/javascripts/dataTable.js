$.noConflict()
jQuery(document).ready(function($) {
    var table = $('#tableTax').DataTable({
        
        "paging": true,
        "lengthMenu": [[10, 30, 50, -1], [10, 30, 50, "Todos"]],
        "language":{
            "lengthMenu": "Mostrar _MENU_ ",
            "info": "Pagina _PAGE_ - _PAGES_",
            "search": "Buscar",
            "paginate": {
                "first":      "Primero",
                "last":       "Ultimo",
                "next":       ">>",
                "previous":   "<<"
            },
            "infoFiltered":   "(Total de registros _MAX_ )",
            "zeroRecords":    "No hay registros",
            "infoEmpty":      "No hay registros"
        },
        "pagingType": "full_numbers",
        "info": false,
        "searching": true,
        "lengthChange": false,
        "dom":  "<'row'<'col-lg-12'tr>>" +
                "<'row'<'col-lg-4'i><'col-lg-8'p>>"
                /*  Iniciales para mostrar elementos del plugin
                    t: Table
                    r: Processing display element
                    i: Table information summary
                    p: Pagination control
                */
        
    });

    //Permite buscar desde una entrada alterna
    $('#searchTax').on( 'keyup', function () {
        table.search(this.value).draw();
    } );
    
    manageSearchTable("tableTax","searchTax");
} );

function manageSearchTable(tableID, inputID,$) {
    $('#searchTax').hide()
    console.log(`#${tableID} #${inputID}`)
}