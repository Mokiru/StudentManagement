$("document").ready(function(){
    $("#loginBtn").click(function(){
        let username = $("#username").val();
        let password = $("#password").val();
        $.ajax({
            url:"/login/make",
            contentType:"application/x-www-form-urlencoded",
            type:"post",
            data:{
                username:username,
                password:password
            },
            success:function(res){
                if (res['status']=="OK") {
                    window.location.href="/kiruya/mainpage.html";
                } else {
                    $("#message").text(res['message']);
                }
            }
        });
    });
});

document.getElementById('Password').addEventListener('click', function () {
    var title = document.querySelector('.title');
    var loginBtn = document.getElementById('loginBtn');
    var rememberMeLabel = document.querySelector('.Remember');
    var passwordBtn = document.getElementById('Password');
    // if (title.innerText === 'Login') {
    title.innerText = 'Register';
    loginBtn.value = 'Register';
    rememberMeLabel.style.opacity = '0';
    passwordBtn.innerText = '去登录';
    document.getElementById('username').value = '';
    document.getElementById('password').value = '';
    document.getElementById('username').placeholder = 'New Username';
    document.getElementById('password').placeholder = 'New Password';
    document.getElementById('password').type = 'password';
    // } else {
    //     title.innerText = 'Login';
    //     loginBtn.value = 'Login';
    //     rememberMeLabel.style.opacity = '1';
    //     passwordBtn.innerText = '去注册';
    //     document.getElementById('username').placeholder = 'Username';
    //     document.getElementById('password').placeholder = 'Password';
    //     document.getElementById('password').type = 'password';
    // }

});