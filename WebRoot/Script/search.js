
var $$ = function (name) {
    return document.getElementsByName(name)
};
String.prototype.trim = function () {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
var $Show = function (id) {
    if ($('#' + id)[0].style.display == 'none') {
        $('#' + id).css('display', '');
        return false;
    }
    return true;
};
var $hidden = function (id) {
    if ($('#' + id)[0].style.display == '') {
        $('#' + id).css('display', 'none');
        return false;
    }
    return true;
};

//增加一组检索条件框
function addQueryCondition() {
    if ($Show('s1')) {
        $('#redqbtn').show();
        if ($Show('s2')) {
            if ($Show('s3')) {
                if ($Show('s4')) {
                    if ($Show('s5')) {
                        $Show('s6');
                        $('#addqbtn').hide();
                    }
                }
            }
        }
    }
}
//删除一组检索条件框
function reduceQueryCondition() {
    $('#addqbtn').show();
    if ($hidden('s6')) {
        if ($hidden('s5')) {
            if ($hidden('s4')) {
                if ($hidden('s3')) {
                    if ($hidden('s2')) {
                        $('#redqbtn').hide();
                    }
                }
            }
        }
    }
}
function addQueryConditiont() {
    if ($Show('t1')) {
        $('#redqbtn').show();
        if ($Show('t2')) {
            if ($Show('t3')) {
                if ($Show('t4')) {
                    if ($Show('t5')) {
                        $Show('t6');
                        $('#addqbtn').hide();
                    }
                }
            }
        }
    }
	//alert("sssaaa");
}
function reduceQueryConditiont() {
    $('#addqbtn').show();
    if ($hidden('t6')) {
        if ($hidden('t5')) {
            if ($hidden('t4')) {
                if ($hidden('t3')) {
                    if ($hidden('t2')) {
                        $('#redqbtn').hide();
                    }
                }
            }
        }
    }
}



















