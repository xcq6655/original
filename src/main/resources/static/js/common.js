$(document).ready(function(){
	// var md=
	// 	'<!-- 模态框（Modal） -->                                                                                          '    +
	// 	'<div class="modal fade" id="msg" tabindex="-1" role="dialog" aria-labelledby="msgLabel" aria-hidden="true">   '    +
	// 	'    <div class="modal-dialog">                                                                                    '    +
	// 	'        <div class="modal-content">                                                                               '    +
	// 	'            <div class="modal-header">                                                                            '    +
	// 	'                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>      '    +
	// 	'                <h4 class="modal-title" id="msgLabel">提示信息</h4>                                '    +
	// 	'            </div>                                                                                                '    +
	// 	'            <div class="modal-body" id="msgBody">提示:</div>                                                      '    +
	// 	'            <div class="modal-footer">                                                                            '    +
	// 	'                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>                  '    +
	// 	'            </div>                                                                                                '    +
	// 	'        </div><!-- /.modal-content -->                                                                            '    +
	// 	'    </div><!-- /.modal -->                                                                                        '    +
	// 	'</div>';
	// $("body").append(md);
	//
	// var cm=
	// 	'<!-- 模态框（Modal） -->                                                                                          '    +
	// 	'<div class="modal fade" id="confirmMsg" tabindex="-1" role="dialog" aria-labelledby="msgLabel2" aria-hidden="true">   '    +
	// 	'    <div class="modal-dialog">                                                                                    '    +
	// 	'        <div class="modal-content">                                                                               '    +
	// 	'            <div class="modal-header">                                                                            '    +
	// 	'                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>      '    +
	// 	'                <h4 class="modal-title" id="msgLabel2">确认操作</h4>                                '    +
	// 	'            </div>                                                                                                '    +
	// 	'            <div class="modal-body" id="msgBody2">请确认是否操作</div>                                                      '    +
	// 	'            <div class="modal-footer">                                                                            '    +
	// 	'                <button type="button" class="btn btn-primary" onclick="_ok()" data-dismiss="modal">确认操作</button>                  '    +
	// 	'                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>                  '    +
	// 	'            </div>                                                                                                '    +
	// 	'        </div><!-- /.modal-content -->                                                                            '    +
	// 	'    </div><!-- /.modal -->                                                                                        '    +
	// 	'</div>';
	// $("body").append(cm);
	//
});

//获取url参数
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

function showMsg(msg){
	 $("#msg").modal('show');
	 $("#msgBody").text(msg);
    setTimeout('hideMsg()',1000);

}
function  hideMsg() {
    $("#msg").modal('hide');
}
var _cb=null;
function confirmAction(msg,cb){
	 $("#confirmMsg").modal('show');
	 $("#msgBody2").text(msg);
	 _cb=cb;
}

function _ok(){
	_cb.call();
}

function ajaxReq(url, reqdata,callback) {
		var param = reqdata==null?"":reqdata;
		$.ajax({
			type : "POST",
			dataType : "json",
			url : url,
			data : param,
			success : function(msg) {
				if (msg.responseCode == "success") {
					callback(msg.data);
				}else if(msg.responseCode == "auth_login_failed"){
					showMsg(msg.responseMsg);
					window.location.href="/";
				} else {
					showMsg(msg.responseMsg);
				}
			}
		});
	}

function setFormIdVal(fm,rsp){
	 for (prop in rsp) {
          var val = rsp[prop];
          if(val!=null && val!=""){
       	   if($("#"+fm+" [name='"+prop+"']").attr("type")=="radio"){
       		   //alert($("input[name='"+prop+"'][valu*e='"+val+"']").size());
					$("input[name='"+prop+"'][value='"+val+"']").prop("checked",true);
       	   }else{
       		   $("#"+fm+" [name='"+prop+"']").val(val); 
       	   }
          		
          	
          }
   }
}

function setFormText(id,rsp){
	 for (prop in rsp) {
          var val = rsp[prop];
          if(val!=null && val!=""){
       		   $("[#"+id+" [name='"+prop+"']").text(val); 
          }
   }
}

function setFormVal(rsp){
	 for (prop in rsp) {
           var val = rsp[prop];
           if(val!=null && val!=""){
        	   if($("[name='"+prop+"']").attr("type")=="radio"){
        		   //alert($("input[name='"+prop+"'][valu*e='"+val+"']").size());
					$("input[name='"+prop+"'][value='"+val+"']").prop("checked",true);
        	   }else{
        		   $("[name='"+prop+"']").val(val); 
        	   }
           		
           	
           }
    }
}

function setFormText(rsp){
	 for (prop in rsp) {
          var val = rsp[prop];
          if(val!=null && val!=""){
       	   if($("[name='"+prop+"']").attr("type")=="radio"){
       		   //alert($("input[name='"+prop+"'][valu*e='"+val+"']").size());
					$("input[name='"+prop+"'][value='"+val+"']").prop("checked",true);
       	   }else{
       		   $("[id='"+prop+"']").text(val); 
       	   }
          		
          	
          }
   }
}


/**
 * 浏览器地址取值
 * var str ="www.jb51.net/index.htm?a=1&b=1&c=测试测试";
 * alert(str.getQuery("a"));
 * alert(str.getQuery("b"));　　
 */
String.prototype.getQuery = function(name){
   var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
   var r = this.substr(this.indexOf("?")+1).match(reg);
   if (r!=null) return unescape(r[2]); return null;
}

/**
 * 防止表单重复提交：
 * 1、前端js判断是否重复请求；
 * 2、后台获取token并将token和表单数据一起请求到后台
 * @param url
 * @param reqdata
 * @param callback
 * @returns
 */
function sendRequest(url, reqdata,callback) {
	var _this = this;
	if(!_this.container){
		_this.container = {};
	}
	var hashcode = hashCode(url, reqdata)+"";
	var param_t = "";
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/pos/getToken",
		data : param_t,
		beforeSend:function(){
			if(_this.container[hashcode]){
				showMsg("请求正在处理中...");
				return false;
			}else{
				_this.container[hashcode] = true;
			}
			return true;
		},
		success : function(result) {
			if (result.responseCode == "success") {
				var param = reqdata==null?"":reqdata+"&token="+result.data;
				$.ajax({
					type : "POST",
					dataType : "json",
					url : url,
					data : param,
					success : function(msg) {
						if (msg.responseCode == "success") {
							callback(msg.data);
						}else if(msg.responseCode == "auth_login_failed"){
							showMsg(msg.responseMsg);
							window.location.href="/";
						} else {
							showMsg(msg.responseMsg);
						}
					}
				});
			} else {
				showMsg(result.responseMsg);
			}
		}
	});
}

/**
 * 获取请求地址和参数的hashCode
 */
hashCode = function(){
	var vurl = arguments[0];
	var values = arguments[1];
	var str = "";
	if(vurl){
		if(typeof str === "object"){
			str = JSON.stringify(str);
		}else{
			str = vurl;
		}
	}
	if(values){
		if(typeof values === "object"){
			str += JSON.stringify(values);
		}else{
			str += values;
		}
	}
	var h = 0;
	var len = str.length;
	var t = 2147483648;
	for (var i = 0; i < len; i++) {
		h = 31 * h + str.charCodeAt(i);
		if(h > 2147483647){
			h %= t;
		}
	}
	return h;
};

// 以下代码是common2.js 中所有js
$.extend({
    contentsA : {},
    xcq : {
        ajaxPost : function(url, data, isAsync, callback) {
            $.ajax({
                url :url,
                type : "post",
                data : data,
                async : isAsync,
                success : callback
            });
        },
        ajaxGet : function(url, data, isAsync, callback) {
            $.ajax({
                url :url,
                type : "get",
                data : data,
                async : isAsync,
                success : callback
            });
        },
        ajaxPostT : function(url, data, isAsync, callback) {
            $.ajax({
                url :url,
                contentType : "application/json;charset=utf-8",
                type : "post",
                data : data,
                async : isAsync,
                success : callback
            });
        },
        /* 获取地址栏某个参数的值 */
        getUrlParam : function(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null)
                return unescape(r[2]);
            return null;
        }
    }
});
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function(fmt) { // author: meizz
    var o = {
        "M+" : this.getMonth() + 1, // 月份
        "d+" : this.getDate(), // 日
        "h+" : this.getHours(), // 小时
        "m+" : this.getMinutes(), // 分
        "s+" : this.getSeconds(), // 秒
        "q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
        "S" : this.getMilliseconds()
        // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for ( var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
                : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};
