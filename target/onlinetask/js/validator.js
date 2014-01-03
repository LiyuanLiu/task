var login_validator = function(){
    $('#loginForm').validate({
        rules:{
            userName:{
                required:true
            },
            userPassword:{
                required:true
            }
        },
        messages:{
            userName:"用户名不允许为空",
            userPassword:"密码不允许为空"
        },
        errorClass:"invalid_validate_class",
        debug:true,
        highlight:function(element,errorClass){
            $(element).fadeOut(function(){
                $(element).fadeIn();
            });
        }

    });
}