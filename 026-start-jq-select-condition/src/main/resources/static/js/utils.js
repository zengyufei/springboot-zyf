var toUrl = function (uri) {
    if (!uri.startsWith('/')) {
        uri = '/' + uri;
    } else if (uri.startsWith('//')) {
        uri = uri.substring(1);
    }
    window.location.href = window.location.origin + uri;
};

var arr = 'qwertyuioplkjhgfdsazxcvbnm';

var getText = function () {
    var result = [];
    var randomForNumber = ~~(Math.random() * 15) + 6; // 随机 6 ~ 20 的数
    for (var i = 0; i < randomForNumber; i++) {
        var index = ~~(Math.random() * arr.length); // 随机 0 ~ (ran-1) 的数
        result.push(arr.charAt(index));
    }
    return result.join('');
};
var getNumber = function (start, end) {
    return ~~(Math.random() * end) + start; // 随机 6 ~ 20 的数
};

var getDate = function () {
    // 2018-03-24 23:28:41
    var now = new Date(Math.ceil(Math.random() * new Date().getTime()));
    return now.getFullYear().toString()
        .concat('-',
            (now.getMonth() + 1) > 9 ? (now.getMonth() + 1) : '0'.concat((now.getMonth() + 1)),
            '-',
            now.getDate() > 9 ? now.getDate() : '0'.concat(now.getDate()),
            ' ',
            now.getHours() > 9 ? now.getHours() : '0'.concat(now.getHours()),
            ':',
            now.getMinutes() > 9 ? now.getMinutes() : '0'.concat(now.getMinutes()),
            ':',
            now.getSeconds() > 9 ? now.getSeconds() : '0'.concat(now.getSeconds()),
        );
};

// 将从 form 中通过 $('#form').serialize() 获取的值转成 json
var formToJson = function (data) {
    data = data.replace(/&/g, '","');
    data = data.replace(/=/g, '":"');
    data = '{"' + data + '"}';
    data = data.replace(/\+/g, ' ');
    return decodeURIComponent(data);
};

function getUrlParam(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

//验证字符串是否是数字
function isNumber(theObj) {
  var reg = /^[0-9]+.?[0-9]*$/;
  if (reg.test(theObj)) {
    return true;
  }
  return false;
}
/*
  序列化表单数据到 JSON 对象 
 */
(function ($) {
    $.fn.serializeJson = function () {

        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(isNumber(this.value) ? +this.value : this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], isNumber(this.value) ? +this.value : this.value];
                }
            } else {
                serializeObj[this.name] = isNumber(this.value) ? +this.value : this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);

var appendTD = function (key) {
    return '<td>' + key + '</td>';
};
var createTR = function () {
    return $('<tr></tr>');
};
var page = function (pageParams) {
    var pageDiv = $('#' + pageParams.id);
    var page = pageParams.page;
    var onclick = pageParams.onclick;
    // {pageFirst, pageEnd, pager, page, onclick}
    // 分页器
    var pageCurrent = page.current;
    var pageSize = page.size;
    var pageTotal = page.total;
    var pageTotalPages = page.pages;
    var method = function (args) {
        return onclick.replace(/%s/, args);
    };

    pageDiv.attr('style', 'float: right;height: 40px;');

    var pageFirstDiv = $('<div style="display: inline-block;"></div>');
    var pager = $('<div style="display: inline-block;" id="pager"></div>');
    var pageEndDiv = $('<div style="display: inline-block;"></div>');
    var pageFirst = $('<input type="button" class="hide" id="pager_first" onclick="' + method(1) + '" value="首页"/>');
    var pageEnd = $('<input type="button"  class="hide" id="pager_end" value="尾页"/>');
    pageFirstDiv.append(pageFirst);
    pageEndDiv.append(pageEnd);

    if (pageTotalPages <= 1) {
        pager.append('<div style="display: inline-block; margin: 0 5px;width: 21px;height: 19px;border: 1px solid #000;font-size: 13px;text-align: center;">1</div>');
    } else {
        pager.empty();
        for (var i = 1; i <= pageTotalPages; i++) {
            if (pageCurrent === i) {
                pager.append('<div style="display: inline-block; margin: 0 5px;width: 21px;height: 19px;border: 1px solid #000;font-size: 13px;text-align: center;">' + i + '</div>');
            } else {
                var numberP = '<input type="button" style="margin: 0 5px;" value="' + i + '" onclick="' + method(i) + '"/>';
                pager.append(numberP);
            }
        }
        pageEnd.attr('onclick', method(pageTotalPages));
        if (pageCurrent === 1) {
            pageEnd.show();
            pageFirst.hide();
        } else if (pageCurrent === pageTotalPages) {
            pageEnd.hide();
            pageFirst.show();
        } else {
            pageFirst.show();
        }
    }
    pageDiv.empty();
    pageDiv.append(pageFirstDiv);
    pageDiv.append(pager);
    pageDiv.append(pageEndDiv);
};

function start(obj) {
    return new Promise((resolve, reject) => {
        resolve(obj);
    });
}