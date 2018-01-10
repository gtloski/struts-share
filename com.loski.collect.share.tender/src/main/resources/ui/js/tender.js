$(function() {
})

function addTender() {
	var htmlStr = '';
	htmlStr += '<tr>';
	htmlStr += '	<td>' + $("#enterpriseName").val() + '</td>';
	htmlStr += '	<td>' + $("#tenderPrice").val() + '</td>';
	htmlStr += '	<td>';
	htmlStr += '		<a data-target = "#editTender" data-toggle = "modal" onclick = "editTenderModal(this)">编辑</a>';
	htmlStr += '		<a data-target = "#delTender" data-toggle = "modal" onclick = "delTenderModal(this)">删除</a>';
	htmlStr += '	</td>';
	htmlStr += '</tr>';
	$("#tenderListBody").append(htmlStr);
	$('#addTender').modal('hide');
}

function addTenderModal() {
	$('#addTender')
			.on(
					'show.bs.modal',
					function() {
						var htmlStr = '';
						htmlStr += '<tr>';
						htmlStr += '	<td><input type="text" id = "enterpriseName" class = "form-control" name="enterpriseName" placeholder="请输入企业名称" /></td>';
						htmlStr += '	<td><input type="text" id = "tenderPrice" class = "form-control" name="tenderPrice" placeholder="请输入投标价格" /></td>';
						htmlStr += '</tr>';
						$("#addTenderBody").html(htmlStr);
					})
}

var delObject = null;

function delTenderModal(obj) {
	$('#delTender').on('show.bs.modal', function() {
		delObject = $(obj);
	})
}

function delTender() {
	$(delObject).parents("tr").remove();
	delObject = null;
	$('#delTender').modal('hide');
}

function editTender() {
	$(editObj).parents("tr").find("td").eq(0).html(
			$("#enterpriseEditName").val());
	$(editObj).parents("tr").find("td").eq(1).html($("#tenderEditPrice").val());
	editObj = null;
	$('#editTender').modal('hide');
}

var editObj = null;

function editTenderModal(obj) {
	$('#editTender')
			.on(
					'show.bs.modal',
					function() {
						var htmlStr = '';
						htmlStr += '<tr>';
						htmlStr += '	<td><input type="text" id = "enterpriseEditName"  name="enterpriseName" value = "'
								+ $(obj).parents("tr").find("td").eq(0).html()
								+ '" placeholder="请输入企业名称" /></td>';
						htmlStr += '	<td><input type="text" id = "tenderEditPrice"  name="tenderPrice" value = "'
								+ $(obj).parents("tr").find("td").eq(1).html()
								+ '" placeholder="请输入投标价格" /></td>';
						htmlStr += '</tr>';
						editObj = $(obj);
						$("#editTenderBody").html(htmlStr);
					})
}

function resultTrnder() {
	var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
	var trList = $("#tenderListBody").find("tr");
	var string = '[';
	for (var i = 0; i < trList.length; i++) {
		string += '{';
		string += '"enterpriseName" : "' + $(trList[i]).find("td").eq(0).html()
				+ '",';
		if (!reg.test($(trList[i]).find("td").eq(1).html())) {
			alert("你的报价不合法");
			return;
		}
		string += '"tenderPrice" : "' + $(trList[i]).find("td").eq(1).html()
				+ '"';
		string += '},';
	}
	string.substring(0, string.length - 1);
	string += ']';
	var data = {
		"jsonString" : string
	};
	var rs = sendAjaxRequest("/tender/tenderResult.jspx", "post", "json", data);
	if (rs.success) {
		$("#resultMsg").html(rs.result);
	}
}

function sendAjaxRequest(callUrl, callType, dataType, datas) {
	var result = null;
	$.ajax({
		cache : true,
		type : callType,
		url : callUrl,
		dataType : dataType,
		data : datas,
		async : false,
		success : function(data) {
			if (null != data) {
				result = data;
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			result = null;
		}
	});
	return result;
}
