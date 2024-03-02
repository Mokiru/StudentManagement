window.onload = function(){
    var box = document.getElementById("addinfo");
    var box1=document.getElementById("h4");
    box1.onmousedown = function(){
        document.onmousemove = function(event){
            event = event || window.event;
            var left = event.clientX;
            var top = event.clientY;
            box.style.left = left +"px";
            box.style.top = top +"px";

            document.onmouseup = function(){
                document.onmousemove = null;
                document.onmouseup = null;
            };
        };
    };
};
//----清除添加信息框的内容-----
function cleanAddInput(){
    document.getElementById('xueyuan').value='';
    document.getElementById('banji').value='';
    document.getElementById('name').value='';
    document.getElementById('num').value='';
    document.getElementById('bid').value='';
}
//----清除添加信息框的内容-----

//----显示添加信息框-----
function showAddInput(){
    document.getElementById('addinfo').style="display:block-inline" ;
    document.getElementById('btn_add').style="display:block-inline" ;
    document.getElementById('btn_update').style="display:none" ;
    cleanAddInput();
}
//----显示添加信息框-----

//----隐藏添加信息框-----
function hideAddInput(){
    document.getElementById('addinfo').style="display:none" ;
}
//----隐藏添加信息框-----



//----根据行号修改信息-----
function updateRow(r){
    console.log(r);
    showAddInput(); //显示修改表单
    //提交按钮替换
    document.getElementById('btn_add').style="display:none" ;
    document.getElementById('btn_update').style="display:block-inline" ;
    document.getElementById('xueyuan').value = document.getElementById("rowsfa" + r).innerHTML;
    document.getElementById('banji').value = document.getElementById("rowscl" + r).innerHTML;
    document.getElementById('name').value = document.getElementById("rowstea" + r).innerHTML;
    document.getElementById('num').value = document.getElementById("rowsnum" + r).innerHTML;
    document.getElementById('bid').value = r;
}
//----根据行号修改信息-----

