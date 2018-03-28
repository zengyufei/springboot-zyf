var toUrl = function(uri) {
    if(!uri.startsWith("/")) {
        uri = "/" + uri;
    }else if(uri.startsWith("//")) {
        uri = uri.substring(1);
    }
    window.location.href = window.location.origin + uri;
}

var arr = "qwertyuioplkjhgfdsazxcvbnm";

var getText = function() {
    var result = [];
    var randomForNumber = ~~(Math.random() * 15) + 6; // 随机 6 ~ 20 的数
    for(var i=0;i<randomForNumber;i++) {
        var index = ~~(Math.random() * arr.length); // 随机 0 ~ (ran-1) 的数
        result.push(arr.charAt(index));
    }
    return result.join("");
}
var getNumber = function(start, end) {
    return ~~(Math.random() * end) + start; // 随机 6 ~ 20 的数
}

var getDate = function() {
    // 2018-03-24 23:28:41
    var now = new Date(Math.ceil(Math.random()*new Date().getTime())) ;
    return now.getFullYear().toString()
                    .concat("-",
                    (now.getMonth()+1)>9?(now.getMonth()+1):"0".concat((now.getMonth()+1)),
                    "-",
                    now.getDate()>9?now.getDate():"0".concat(now.getDate()),
                    " ",
                    now.getHours()>9?now.getHours():"0".concat(now.getHours()),
                    ":",
                    now.getMinutes()>9?now.getMinutes():"0".concat(now.getMinutes()),
                    ":",
                    now.getSeconds()>9?now.getSeconds():"0".concat(now.getSeconds()),
                    );
}

// 将从 form 中通过 $('#form').serialize() 获取的值转成 json
var formToJson = function (data) {
   data=data.replace(/&/g,"\",\"");
   data=data.replace(/=/g,"\":\"");
   data="{\""+data+"\"}";
   data = data.replace(/\+/g," ");
   return decodeURIComponent(data);
}

function getUrlParam(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}