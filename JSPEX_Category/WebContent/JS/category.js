
$(document).ready(function(){
	
	loadParent();
	
})

// 페이지 로드되면 selectbox 살리고 안에 부모 설정하기
function loadParent(){
	$.ajax({
		url : "cate_list.ajax?&depth=1&parent=0"
		, type : "GET"
		, success : function(list, status){
			if(status == "success"){
				if(list.status == "SUCCESS"){
					var selectFirst = $("#mycate span:first-child select");
					
					selectFirst.attr("disabled", false);
					
					selectFirst.html(
							"<option>--선택하세요--</option>" +
							"<option data-parent='0'>" + list.list[0] + "</option>" + 
							"<option data-parent='0'>스포츠</option>" +
							"<option data-parent='0'>식품</option>"
					);
				}
			}
		}
	});
	
}
	
