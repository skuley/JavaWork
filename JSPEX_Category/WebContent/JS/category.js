
$(document).ready(function(){
	
	loadParent();
	
	optionListSecond();
	

	
})

// 페이지 로드되면 selectbox 살리고 안에 부모 설정하기
function loadParent(){
	$.ajax({
		url : "cate_list.ajax?&depth=1&parent=0"
		, type : "GET"
		, success : function(data, status){
			if(status == "success"){
				optionsList(data);
			} // if(status)
		}
	});
	
}

function optionsList(data){
	if(data.status == "SUCCESS"){
		var selectFirst = $("#mycate span:first-child select");
		var options = "<option>--선택해주세요--</option>";
		var i;
		for(i = 0; i < data.count; i++){
			options += "<option data-depth='" + data.list[i].depth + "' value='" + data.list[i].uid + "'>" + data.list[i].name + "</option>";
		}
		selectFirst.html(options);
		selectFirst.attr("disabled", false);
	} else {
		alert(data.status);
		return false;
	}
	return false;
} 

function optionListSecond(){
	$("#mycate span:first-child select option").change(function(){
		
		var firstOption = $(this).val();
		alert(firstOption);
		alert($(this).text())
		alert("cate_list.ajax?depth=" + $(this).child().attr("data-depth") + "&parent=" + firstOption);
		$.ajax({
			url : "cate_list.ajax?depth=" + $(this).attr("data-depth") + "&parent=" + firstOption 
			, type : "POST"
			, cache : false
			, success : function(data, status){
				if(status == "success"){
					if(data.status == "success"){
						$("#mycate span:nth-child(2) select").attr("disabled", false);
						
					}
				}
			}
		})
		
	});
}

	
	
