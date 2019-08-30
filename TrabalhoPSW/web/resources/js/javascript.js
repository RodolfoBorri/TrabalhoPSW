function validarIdade(valor) {
    if (valor.trim() !== "") {
        var regra = /^[0-9]+$/;
        if (valor.match(regra)) {
        alert("Confirma idade do cliente como : " + valor + "?");
        } 
        else{
            alert("Permitido somente números");
        }
    }
}
function formataCPF(evt) {
   vr = (navigator.appName === 'Netscape')? evt.target.value : evt.srcElement.value;
            if(vr.length === 3) vr = vr+".";
            if(vr.length === 7) vr = vr+".";
            if(vr.length === 11) vr = vr+"-";

    return vr;
}
function formataData(evt) {
   vr = (navigator.appName === 'Netscape')? evt.target.value : evt.srcElement.value;
            if(vr.length === 2) vr = vr+"/";
            if(vr.length === 5) vr = vr+"/";
    return vr;
}
