$(function(){
    listar();
    crear();
    eliminar();
    mostarEditar();
    editar();
});

function listar(){
    let url = 'http://localhost:81/api/user/all';
    $.getJSON(url).done(function(data){
        //console.log(data):
        tbody = $('#tabla-usuario tbody');
        $.each(data, function(index,item){
            let row = `
            <tr data-id=${item.identity}>
                <td>${item.nombre5}</td>
                <td>${item.direccion5}</td>
                <td>${item.celular5}</td>
                <td>${item.correo5}</td>
                <td>${item.clave5}</td>
                <td>${item.tipoUsuario}</td>
                <td>${item.sector}</td>
                <td> <button type="button" class="login100-form-btn editar" style="height: auto; ">Editar</button></td>
                <td><button type="button" class="login100-form-btn eliminar" style="height: auto; ">Eliminar</button></td>
            </tr>`;
            
            tbody.append(row);
        });
    });
}

function crear(){
    $("add-btn").on('click',function(ev){
        ev.prevenDefault();
        let inputidentity = $('#identity').val();
        let inputnombre5 = $('#nombre5').val();
        let inputdireccion5 = $('#direccion5').val();
        let inputcelular5 = $('#celular5').val();
        let inputcorreo5 = $('correo5').val();
        let inputclave5 = $('clave5').val();
        let inputtipoUsuario = $('tipoUsuario').val();
        let inputsector = $('sector').val();

        if (
            inputidentity == "" ||
            inputnombre5 == "" ||
            inputdireccion5 == "" ||
            inputcelular5 == "" ||
            inputcorreo5 == "" ||
            inputclave5 == "" ||
            inputtipoUsuario == "" ||
            inputsector == ""
        ){
            alert("Debe diligenciar todos los campos")
            return
        }else{
            let url = 'http://localhost:81/api/user/new';
            $.ajaxSetup({
                contentType: "application/json; charset=utf-8"
            });

            $.post(url,JSON.stringify({identity: inputidentity, 
                nombre5: inputnombre5, direccion5: inputdireccion5, celular5: inputcelular5,
            correo5: inputcorreo5, clave5: inputclave5, tipoUsuario: inputtipoUsuario, sector: inputsector }))
            .done(function(item){
                alert("Usuario creado con exito!")
                window.location.reload()
            })
            .fail(function(){
                alert("ERROR! el usuario no se pudo crear correctamente");
            });
        }
    });
}

function eliminar(){

    $("#tabla-usuario tbody").on('click','.eliminar',function(ev){
        ev.preventDefault();
        let tr = $(this).closest('tr');
        let id = tr.data('id');
        console.log(id);
        let myurl = 'http://localhost:81/api/user/'+id;
        $.ajax({
            url:myurl,
            type:'DELETE',
            success:function(result){
                tr.remove();
            }
        });
    });
}

function mostarEditar(){
    $('#tabla-usuario tbody').on('click', '.editar',function(ev){
        ev.preventDefault();
        let tr = $(this).closest('tr');
        let id = tr.data('id');
        let myurl = 'http://localhost:81/api/user/'+id;

        $.getJSON(myurl)
        .done(function(data){

            $('#einputID2').val(data.identity);
            $('#enombre5').val(data.nombre5);
            $('#edireccion5').val(data.direccion5);
            $('#celular5').val(data.celular5);
            $('#correo5').val(data.correo5);
            $('#clave5').val(data.clave5);
            $('#tipoUsuario').val(data.tipoUsuario);
            $('#sector').val(data.sector);

            var myModal = new bootstrap.Modal(document.getElementById('ModalEditar'));
            myModal.show()
        });
    });
}

function editar(){
    $("#edit-btn").on('click',function(ev){
        let myurl = 'http://localhost:81/api/user/update';

        let inputidentity = $('#einputID2').val();
        let inputnombre5 = $('#enombre5').val();
        let inputdireccion5 = $('#direccion5').val();
        let inputcelular5 = $('#celular5').val();
        let inputcorreo5 = $('#correo5').val();
        let inputclave5 = $('#clave5').val();
        let inputtipoUsuario = $('#etipoUsuario').val();
        let inputsector = $('#esector').val();

        if (
            inputidentity == "" ||
            inputnombre5 == "" ||
            inputdireccion5 == "" ||
            inputcelular5 == "" ||
            inputcorreo5 == "" ||
            inputclave5 == "" ||
            inputtipoUsuario == "" ||
            inputsector == ""
        ){
            alert("Debe dilegenciar todos los campos")
            return
        }else{
            $.ajax({
                url:myurl,
                type: 'PUT',
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify({identity: inputidentity, 
                nombre5: inputnombre5, direccion5: inputdireccion5, celular5: inputcelular5,
                correo5: inputcorreo5, clave5: inputclave5, tipoUsuario: inputtipoUsuario, sector: inputsector}),
                success:function(result){
                    alert("Edicion realizada con exito!")
                    window.location.reload()
                }
                
            });
        }
    });
}