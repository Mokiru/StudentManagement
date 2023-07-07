
// 定义CSS选择器
const cssSelector = '.sign-form .form-row-captcha>img' ;
// 根据 CSS 选择器选择匹配于该选择器的第一个元素
const img = document.querySelector( cssSelector );
// 为 img 设置 title 属性
img.setAttribute( "o" , "点我刷新")

const type = 'click' ;

const listener = {
    handleEvent( event ){
        // 通过事件对象可以获得事件目标 (即被点击的图片)
        let target = event.target ;
        // 获取 img 元素的 src 属性值
        let src = target.getAttribute( 'src' );
        let index = src.indexOf( "?" ) ;
        if( index != -1 ) {
            // 从 src 中截取 [ 0 , index ) 之间的内容
            src = src.substring( 0 , index );
        }
        let url = src + "?time=" + Date.now();
        // 重新设置 img 元素的 src 属性取值
        target.setAttribute( 'src' , url );
    }
}

const capture = true ;

// 为 img 添加 鼠标左键单击事件 对应的监听器
img.addEventListener( type , listener , capture );