function validar(registroequipo){
    if(registroequipo.etiqueta.value.length < 10){
        alert("El ID del equipo debe de tener 10 caracteres por lo menos");
        registroequipo.etiqueta.focus();
        return false;
    }

    if(registroequipo.teclado.value.length < 10){
        alert("El ID del teclado debe de tener 10 caracteres por lo menos");
        registroequipo.teclado.focus();
        return false;
    }

    if(registroequipo.mouse.value.length < 10){
        alert("El ID del mouse debe de tener 10 caracteres por lo menos");
        registroequipo.mouse.focus();
        return false;
    }

    if(registroequipo.idmarca.value.length < 10){
        alert("El ID de la marca debe de tener 10 caracteres por lo menos");
        registroequipo.idmarca.focus();
        return false;
    }

    if(registroequipo.monitor.value.length < 10){
        alert("El ID del monitor debe de tener 10 caracteres por lo menos");
        registroequipo.monitor.focus();
        return false;
    }
    
}