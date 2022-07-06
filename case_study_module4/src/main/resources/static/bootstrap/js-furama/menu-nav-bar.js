function menu(url) {
    document.getElementById('loading').style.display = 'block';
    $.ajax({
        url: `/${url}`,
        type: "get",
        dataType: 'html',
        success: function(data) {
            $('#body').html(data);
            $('#body').children('meta,link,title,style').remove();
            document.getElementById('loading').style.display = 'none';
        },
    });
}