let NameColum = ['ID', 'Mã SV', 'Họ Và Tên', "Địa Chỉ"]
let attribute = 'date';
let tagName = ['name', 'age', 'address']
$(function() {
    $("tbody").html("");
});

function xmlLoad() {
    $.ajax({
        url: 'xml/news.xml',
        type: 'get',
        dataType: 'xml',
        timeout: 1000,
        success: parse_xml
    });
}

function parse_xml(xml, status) {
    // var s = '<tr>'
    // NameColum.forEach(str => {
    //     s = s + '<th>' + str + '</th>'
    // });
    // s = s + '</tr>';

    // $(s).appendTo('table.tbl tbody');
    // if (status != 'success') return;
    $(xml).find('item ').each(disp);
}

function disp() {
    var $id = $(this)[0].getAttribute(attribute)
        // var row = [];
        // tagName.forEach(element => {
        //     var content = $(this).find(element).text();
        //     row.push(content)
        // });
    let s = '<div>'
    s = s + '<h1>' + $id + '</h1>'
    let title = $(this).find("title").text()
    let srcImage = $(this).find("image").text()
    let link = $(this).find("link").text()
    let auhour = $(this).find("author").text()
    s = s + '<h2>' + title + '</h2>'
    s = s + '<a href="' + link + '"><img src="' + srcImage + '"></a>'
    s = s + '<h2><i>' + auhour + '</i></h2>'
    s = s + '</div>'
    s = s + '<hr>'
    console.log(s)
        // row.forEach(element => {
        //     s = s + '<td>' + element + '</td>';
        // });
        // s = s + '</tr>';
    $(s).appendTo('body');
}

$(function() {
    xmlLoad();
});