function PageDate()
{
    currentDate = new Date()
    with (currentDate)
    {
        day=getDay()
        month=getMonth()+1
        this.document.write(getFullYear()+'-'+month+'-'+getDate()+'')
    }
    if (day==1){document.write(' 星期一')}
    if (day==2){document.write(' 星期二')}
    if (day==3){document.write(' 星期三')}
    if (day==4){document.write(' 星期四')}
    if (day==5){document.write(' 星期五')}
    if (day==6){document.write(' 星期六')}
    if (day==0){document.write(' 星期日')}
    document.write('')
}

PageDate()