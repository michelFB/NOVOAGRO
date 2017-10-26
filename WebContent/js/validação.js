	function sonumeros(){
        if (event.keyCode < 48 || event.keyCode > 57){
                event.returnValue = false;
                return false;
        }
        return true;}
    function soLetras(){
            if ((event.keyCode<65 || event.keyCode>90)&(event.keyCode<97 || event.keyCode>122)&(event.keyCode =! 32) ){
                    event.returnValue = false;
                    return false;
            }
    return true;}
