function validar(reporte){
    if(reporte.id_lab.value.length < 10){
        alert("El ID del laboratorio debe de tener 10 caracteres por lo menos");
        reporte.id_lab.focus();
        return false;
    }

    if(reporte.id_reporte.value.length < 10){
        alert("El ID del reporte debe de tener 10 caracteres por lo menos");
        reporte.id_reporte.focus();
        return false;
    }

}