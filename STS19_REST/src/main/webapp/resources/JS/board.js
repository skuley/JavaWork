var page = 1; // 현재 페이지
var pageRows = 10; // 한 페이지에 보여지는 게시글 개수
var viewItem = undefined; // 가장 최근에 view 한 글 데이터

$(document).ready(function(){
	// 게시판 페이지 로딩이 완료후 실행되는 곳
	
	// 게시판 목록 1 페이지 로딩
	loadPage(page);
	
	// 글 작성 버튼 동작 (팝업)
	$("#btnWrite").click(function(){
		setPopup("write");
		$("#dlg_write").show();
	});
	// 모달 대화상자에서 close 버튼 누르면 닫기
	$(".modal .close").click(function(){
		$(this).parents(".modal").hide();
	});
	
	// 글 작성 submit 되면 
	$("#frmWrite").submit(function(){
		$(this).parents(".modal").hide();
		return chkWrite();
	});
	
	// 글 삭제 버튼 클릭
	$("#btnDel").click(function(){
		chkDelete();
	});
	
	// 글 읽기 (view) 대화상자에서 삭제버튼 누르면 해당 글 (1) 삭제 진행
	$("#viewDelete").click(function(){
		var uid = viewItem.uid;
		if(deleteUid(uid)){ // 해당 글 삭제 성공했따면
			$(this).parents(".modal").hide(); // 삭제 성공시 대화상자 닫기
		}
	});
	
	// 글 읽기(view) 대화상자에서 수정 버튼 누르면
	$("#viewUpdate").click(function(){
		setPopup("update");
		
	});
	
	// 글 수정 완료 버튼 누르면
	$("#updateOk").click(function(){
		chkUpdate();
	});
	
});

// 페이지 번째 page 로딩
function loadPage(page){
	$.ajax({
		url : "list.ajax?page=" + page + "&pageRows=" + pageRows
		, type : "GET"
		, cache : false
		, success : function(data, status){
			if(status == "success"){
				// alert("AJAX 성공 : 받아쮸~");
				
				if(updateList(data)){
					// 업데이트 된 list에 필요한 event 할당(가동)
					addViewEvent();
					// ※ 만약 위 코드를 (document).ready() 에 두면 동작 안할 것이다.
				}
			}
			
		}
	});
}; // loadPage()

function updateList(jsonObj){
	result = ""; // 최종 결과
	
	if(jsonObj.status == "OK"){
		// 성공한 케이스

		var count = jsonObj.count;
		
		// 전역 변수 update 
		window.page = jsonObj.page;
		window.pageRows = jsonObj.pagerows;
		
		var i;
		var items = jsonObj.data; // 배열
		
		for(i = 0; i < count; i++){
			result += "<tr>\n";
			result += "<td><input type='checkbox' name='uid' value='" + items[i].uid + "'></td>\n";
			result += "<td>" + items[i].uid + "</td>\n";
			result += "<td><span class='subject' data-uid='" + items[i].uid + "'>" + items[i].subject + "</span></td>\n";
			result += "<td>" + items[i].name + "</td>\n";
			result += "<td><span data-viewcnt='" + items[i].uid + "'>" + items[i].viewcnt + "</span></td>\n";
			result += "<td>" + items[i].regdate + "</td>\n";
			result += "</tr>\n";
		} // for
		
		$("#list tbody").html(result); // 테이블 업데이트
		
		// 페이지 정보 업데이트
		$("#pageinfo").text(jsonObj.page + "/" + jsonObj.totalpage + "페이지, " + jsonObj.totalcnt + "개의 글");
		
		// pageRows select
		var txt = "<select id='rows' onchange='changePageRows()'>\n";
		txt += "<option" + ((window.pageRows == 10)?" selected":"") + " value='10'>10개씩</option>\n";
		txt += "<option" + ((window.pageRows == 20)?" selected":"") + " value='20'>20개씩</option>\n";
		txt += "<option" + ((window.pageRows == 50)?" selected":"") + " value='50'>50개씩</option>\n";
		txt += "<option" + ((window.pageRows == 100)?" selected":"") + " value='100'>100개씩</option>\n";
		txt += "</select>\n";
		$("#pageRows").html(txt);
		
		// 페이징 업데이트
		var pagination = buildPagination(jsonObj.writepages, jsonObj.totalpage, jsonObj.page, jsonObj.pagerows);
		$("#pagination").html(pagination);
		
		
		return true;
	} else{
		alert(jsonObj.message);
		return false;
	}
	return false;
}; // updateList()

function buildPagination(writePages, totalPage, curPage, pageRows){
	
	
	var str = "";   // 최종적으로 페이징에 나타날 HTML 문자열 <li> 태그로 구성
	
	// 페이징에 보여질 숫자들 (시작숫자 start_page ~ 끝숫자 end_page)
    var start_page = ( (parseInt( (curPage - 1 ) / writePages ) ) * writePages ) + 1;
    var end_page = start_page + writePages - 1;

    if (end_page >= totalPage){
    	end_page = totalPage;
    }
    
    //■ << 표시 여부
	if(curPage > 1){
		str += "<li><a onclick='loadPage(1)' class='tooltip-top' title='처음'><i class='fas fa-angle-double-left'></i></a></li>\n";
	}
	
  	//■  < 표시 여부
    if (start_page > 1) 
    	str += "<li><a onclick='loadPage(" + (start_page - 1) +")' class='tooltip-top' title='이전'><i class='fas fa-angle-left'></i></a></li>\n";
    
    //■  페이징 안의 '숫자' 표시	
	if (totalPage > 1) {
	    for (var k = start_page; k <= end_page; k++) {
	        if (curPage != k)
	            str += "<li><a onclick='loadPage(" + k + ")'>" + k + "</a></li>\n";
	        else
	            str += "<li><a class='active tooltip-top' title='현재페이지'>" + k + "</a></li>\n";
	    }
	}
	
	//■ > 표시
    if (totalPage > end_page){
    	str += "<li><a onclick='loadPage(" + (end_page + 1) + ")' class='tooltip-top' title='다음'><i class='fas fa-angle-right'></i></a></li>\n";
    }

	//■ >> 표시
    if (curPage < totalPage) {
        str += "<li><a onclick='loadPage(" + totalPage + ")' class='tooltip-top' title='맨끝'><i class='fas fa-angle-double-right'></i></a></li>\n";
    }

    return str;

	
} // buildPagination

function changePageRows(){
	window.pageRows = $("#rows").val();
	
	loadPage(window.page);
}

// 새글 등록 처리
function chkWrite(){
	var data = $("#frmWrite").serialize(); // 해당 폼 안의 name 이 있는 것들을 끌고 들어옴 String 타입으로 리턴
	//alert(data);
	// ajax request
	$.ajax({
		url : "writeOk.ajax"
		, type : "POST"
		, cache : false
		, data : data // POST로 ajax request 하는 경우 parameter 담기
		, success : function(data, status){
			if(status == "success"){
				if(data.status == "OK"){
					alert("INSERT 성공" + data.count + " 개 : " + data.status);
					loadPage(1); // 첫 페이지 리로딩 ORDER BY DESC
				} else {
					alert("INSERT 실패 " + data.status + " : " + data.message);
				}
			}
		}
	});
	
	// request 후, form 에 입력된것 reset()
	$('#frmWrite')[0].reset();
	
	return false; // 페이지 reloading을 안하기 위해서 (form은 submit 되면 request가 발동되 reload가 자동적으로 발생된다)
} // chkWrite()

// check 된 uid 의 게시글들만 삭제하기
function chkDelete(){
	var uids = []; // 빈 배열 준비
	$("#list tbody input[name=uid]").each(function(){
		if($(this).is(":checked")){ // jQuery 에서 check 여부 확인 방법
			uids.push($(this).val()); // 배열에 uid 값 추가
		}
	});
	
	// alert(uids);
	if(uids.length == 0){
		alert("삭제할 글을 체크하세요");
	} else {
		if(!confirm(uids.length + "개의 글을 삭제하시겠습니까?")) return false;
		
		var data = $("#frmList").serialize();
		// uid=1010&uid=1011...
		
		$.ajax({
			url : "deleteOk.ajax"
			, type : "POST"
			, data : data
			, cache : false
			, success : function(data, status){
				if(status == "success"){
					if(data.status == "OK"){
						alert("DELETE 성공 " + data.count + " 개");
						// 현재 페이지 리로딩
						loadPage(window.page);
					} else{
						alert("DELETE 실패 " + data.message);
					}
				}
			}
		});
		
	}
} // chkDelete()

// 현재 글 목록 list 에 대해 event 등록
// - 제목(subject) 클릭하면 view 팝업화면 뜰수 있게 하기
function addViewEvent(){
	$("#list .subject").click(function(){
		// alert($(this).text() + " 클릭됨 " + $(this).attr('data-uid'));
		
		// 읽어오기
		$.ajax({
			url : "view.ajax?uid=" + $(this).attr("data-uid")
			, type : "GET"
			, cache : false
			, success : function(data, status){
				if(status == "success"){
					if(data.status == "OK"){
						
						// 읽어온 view 데이터를 전역변수에 세팅
						viewItem = data.data[0];
						
						// 팝업에 보여주기
						setPopup("view");
						$("#dlg_write").show();
						
						// list 상에 조회수 증가 시키기
						$("#list [data-viewcnt='" + viewItem.uid + "']").text(viewItem.viewcnt);
						
					} else {
						alert("VIEW 실패!" + data.message);
					}
				}
			}
			
		});
		
	});
} // addViewEvent()

// 대화상자 setup
function setPopup(mode){
	
	// 글작성 모드
	if(mode == "write"){
		$("#frmWrite")[0].reset(); // form 안의 기존 내용 reset (reset() 함수는 javascript 함수)
		$("#dlg_write .title").text("새글 작성");
		$("#dlg_write .btn_group_header").hide();
		$("#dlg_write .btn_group_write").show();
		$("#dlg_write .btn_group_view").hide();
		$("#dlg_write .btn_group_update").hide();
		
		$("#dlg_write input[name='subject']").attr("readonly", false);
		$("#dlg_write input[name='subject']").css("border", "1px solid #ccc");
		
		$("#dlg_write input[name='name']").attr("readonly", false);
		$("#dlg_write input[name='name']").css("border", "1px solid #ccc");
		
		$("#dlg_write textarea[name='content']").attr("readonly", false);
		$("#dlg_write textarea[name='content']").css("border", "1px solid #ccc");
		
	}
	
	// 글 읽기 모드
	if(mode == "view"){
		$("#frmWrite")[0].reset(); // form 안의 기존 내용 reset (reset() 함수는 javascript 함수)
		$("#dlg_write .title").text("글 읽기");
		$("#dlg_write .btn_group_header").show();
		$("#dlg_write .btn_group_write").hide();
		$("#dlg_write .btn_group_view").show();
		$("#dlg_write .btn_group_update").hide();
		
		$("#dlg_write #viewcnt").text("#" + viewItem.uid + " - 조회수 : " + viewItem.viewcnt);
		$("#dlg_write #regdate").text(viewItem.regdate);
		
		$("#dlg_write input[name='uid']").val(viewItem.uid); // 나중에 삭제/수정을 위해 필요
		
		$("#dlg_write input[name='subject']").val(viewItem.subject);
		$("#dlg_write input[name='subject']").attr("readonly", true);
		$("#dlg_write input[name='subject']").css("border", "none");
		
		$("#dlg_write input[name='name']").val(viewItem.name);
		$("#dlg_write input[name='name']").attr("readonly", true);
		$("#dlg_write input[name='name']").css("border", "none");
		
		$("#dlg_write textarea[name='content']").val(viewItem.content);
		$("#dlg_write textarea[name='content']").attr("readonly", true);
		$("#dlg_write textarea[name='content']").css("border", "none");
	}
	
	// 글 수정 모드
	if(mode == "update"){
		$("#frmWrite")[0].reset(); // form 안의 기존 내용 reset (reset() 함수는 javascript 함수)
		$("#dlg_write .title").text("글 수정");
		$("#dlg_write .btn_group_header").show();
		$("#dlg_write .btn_group_write").hide();
		$("#dlg_write .btn_group_view").hide();
		$("#dlg_write .btn_group_update").show();
		
		$("#dlg_write input[name='subject']").attr("readonly", false);
		$("#dlg_write input[name='subject']").css("border", "1px solid #ccc");
		
		$("#dlg_write input[name='name']").val(viewItem.name);
		$("#dlg_write input[name='name']").attr("readonly", true);
		$("#dlg_write input[name='name']").css("border", "none");
		
		$("#dlg_write textarea[name='content']").attr("readonly", false);
		$("#dlg_write textarea[name='content']").css("border", "1px solid #ccc");
		
	}
	
	
	
} // setPopup()

// 특정 uid 의 글 삭제하기
function deleteUid(uid){
	if(!confirm(uid + "글을 삭제하시겠습니까?")) return false;
	
	// POST 방식으로 request
	$.ajax({
		url : "deleteOk.ajax"
		, type : "POST"
		, data : "uid=" + uid
		, cache : false
		, success : function(data, status){
			if(status == "success"){
				if(data.status == "OK"){
					
					alert("DELETE 성공 : " + data.count + "개");
					
					loadPage(page); // 현재 페이지 리로딩
					
				} else {
					alert("DELETE 실패 " + data.message);
					return false;
				}
			}
		}
	});
	
	return true;

} // deleteUid()

// 글 수정
function chkUpdate(){
	var data = $("#frmWrite").serialize();
	
	$.ajax({
		url : "updateOk.ajax"
		, type : "POST"
		, data : data
		, cache : false
		, success : function(data, status){
			if(status == "success"){
				if(data.status == "OK"){
					alert("UPDATE 성공! : " + data.count + "개");
					loadPage(page); // 현재 페이지 리로딩
				} else {
					alert("UPDATE 실패! : " + data.status + "<br>" +  data.message);
				}
				$("#dlg_write").hide(); // 현재 팝업 닫기
			} // if(status)
		}
	})
} // chkUpdate()



































