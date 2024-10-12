<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>       
cafeInsertForm.jsp<br>
<style>
   .err {
      color: red;
      font-weight: bold;
   }
   table{
      border-collapse: collapse;
      margin: 5 auto;
   }
   td, th{
      border: 1px solid black;
      padding: 5 15;
   }
   th{
      background: #3CB371
   }
   body{
      text-align: center
   }
</style>

<script>
   var f_selbox = new Array('커피','논커피','티');
   
   var s_selbox = new Array();
   s_selbox[0] = new Array('아메리카노','카페라떼','카푸치노');
   s_selbox[1] = new Array('녹차라떼', '초콜릿', '토피넛라떼');
   s_selbox[2] = new Array('유자차', '페퍼민트', '얼그레이');

   var selectCategory;
   
   function init(mc, mm) {
      document.myform.first.options[0] = new Option("구분 선택하세요","");
      document.myform.second.options[0] = new Option("메뉴 선택하세요","");
      for(i=0; i<f_selbox.length; i++) {
         document.myform.first.options[i+1] = new Option(f_selbox[i],f_selbox[i]);
         if(document.myform.first.options[i+1].value == mc){
        	 document.myform.first.options[i+1].selected = true;
        	 selectCategory = i; 
         }
      }//for
      
      for(var j=0;j<s_selbox[selectCategory].length;j++){
    	  document.myform.second.options[j+1] = new Option(s_selbox[selectCategory][j]);
    	  if(document.myform.second.options[j+1].value == mm){
         	 document.myform.second.options[j+1].selected = true;
          }
      }//for
   }//init
   
   function firstChange() {
      var index = document.myform.first.selectedIndex; 
      
      for(i=document.myform.second.length-1; i>0; i--) {
         document.myform.second.options[i] = null;
      } 
      
      for(i=0; i<s_selbox[index-1].length; i++) {
         document.myform.second.options[i+1] = new Option(s_selbox[index-1][i]);
      }  
   } //firstChange

   function handleReqNone() {
      var reqNone = document.getElementById("reqNone");
      var otherReqs = document.getElementsByClassName("req");

      if (reqNone.checked) {
         for (var i = 0; i < otherReqs.length; i++) {
            otherReqs[i].checked = false;
         }
      }
   }

   function handleOtherReqs() {
      var reqNone = document.getElementById("reqNone");
      var otherReqs = document.getElementsByClassName("req");

      for (var i = 0; i < otherReqs.length; i++) {
         if (otherReqs[i].checked) {
            reqNone.checked = false;
            break;
         }
      }
   }
</script>

<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function() { 
	//alert(1);
	
	var use;
	var isCheck = false;
	
	$('#title_check').click(function(){ // 중복체크 클릭
		//alert(2);
		isCheck = true;
		
		$.ajax({
			url : "title_check_proc.mv",
			type : "post",
			data : ({
				inputtitle : $('input[name=title]').val() // inputtitle=배트맨
			}),
			success :function(data){
				
				if($('input[name=title]').val() ==""){
					$('#titleMessage').html("<font color=red>title 입력 누락</font>");
					$('#titleMessage').show();
					
				}else if(data == 'YES'){
					$('#titleMessage').html("<font color=blue>사용가능합니다.</font>");
					$('#titleMessage').show();
					use = "possible";
				}else{
					$('#titleMessage').html("<font color=red>이미 등록한 제목입니다.</font>");
					use = "impossible";
					$('#titleMessage').show();
				}
			}
		});
	}); // 중복체크 click
	
	$('input[name=title]').keydown(function(){
		isCheck = false;
		use = "";
		$('#titleMessage').css('display','none');
	});
	
	$('#btnSubmit').click(function(){
		if(use == "impossible"){
			alert("이미 사용중인 제목입니다.");
			return false;
		}else if(isCheck == false){
			alert("중복체크를 하세요");
			return false;
		}
	}); // btnSubmit click
});
</script>
<%
String[] categoryList = {"커피","논커피","티"};
String[][] menuList = {
							{"아메리카노","카페라떼","카푸치노"},
							{"녹차라떼", "초콜릿", "토피넛라떼"},
							{"유자차", "페퍼민트","얼그레이"},
						};

String[] req = {"없음","얼음적게","얼음많이","시럽추가","덜달게","많이뜨겁게"};
String[] amount = {"1", "2", "3","4"};
String[] temp = {"아이스","핫"}; 
%>

<c:set var="cList" value="<%= categoryList %>"/>
<c:set var="mList" value="<%= menuList %>"/>
<body onLoad="init('${ cafe.category }','${ cafe.menu }')"> 
   <form:form commandName="cafe" name="myform" action="insert.cf" method="post">
   <h2>메뉴 주문</h2>
   <table>
		<tr>
            <th>구분</th>
            <td>
               <select id="first" name="category" onChange="firstChange()" style="width: 150px">
                 <option value="">구분 선택하세요</option>
                  
                  <c:forEach var="i" begin="0" end="${ fn:length(cList)-1 }">
                  		<option value="${ cList[i] }" <c:if test="${ cafe.category eq cList[i]}">selected</c:if>>${ cList[i] }
                  </c:forEach>
               </select>
               <form:errors path="category" cssClass="err" />
            </td>
         </tr>
         <tr>
            <th>메뉴</th>
            <td>
               <select id="second" name="menu" style="width: 150px">
                	<option value="">메뉴 선택하세요</option>
                	<c:forEach var="i" begin="0" end="${fn:length(cList)-1 }">
	                	<c:if test="${ cafe.category eq cList[i]}">
	                		<c:forEach var="j" begin="0" end="${ fn:length(mList[i])-1 }">
								<option value="${ mList[i][j] }" <c:if test="${ cafe.menu eq mList[i][j]}">selected</c:if>>${ mList[i][j] }
							</c:forEach>
	              		</c:if>
                	</c:forEach>
               </select>
               <form:errors path="menu" cssClass="err" />
            </td>
         </tr>
   
         <tr>
            <th>온도</th>
            <td>          
               <c:forEach var="temp" items="<%= temp %>">
                  <input type="radio" name="temp" value="${ temp }" <c:if test="${cafe.temp eq temp}">checked</c:if>>${ temp }
               </c:forEach>
               <form:errors path="temp" cssClass="err" />
            </td>
         </tr>
         <tr>
            <th>수량</th>
            <td>
            		<select name = "amount">
			<option value = ""> 선택하세요 </option>
			
	<c:set var = "amount" value = "<%= amount %>"/>
 		<c:forEach var = "i" begin = "0" end = "${ fn:length(amount) -1 }">
			<option value = "${ amount[i] }" <c:if test = "${ cafe.amount eq amount[i] }">selected</c:if> >${ amount[i] } </option>
		</c:forEach> 
	</select>
	<form:errors path = "amount" cssClass = "err"></form:errors>
            </td>
         </tr>
         
         <tr>
            <th>요청사항</th>
            <td>
              
               <c:forEach var="req" items="<%= req %>">
                  <c:choose>
                     <c:when test="${ req eq '없음' }">
                        <input type="checkbox" id="reqNone" name="req" value="${ req }" <c:if test="${ fn:contains(cafe.req, req) }">checked</c:if> onChange="handleReqNone()">${ req }
                     </c:when>
                     <c:otherwise>
                        <input type="checkbox" class="req" name="req" value="${ req }" <c:if test="${ fn:contains(cafe.req, req) }">checked</c:if> onChange="handleOtherReqs()">${ req }
                     </c:otherwise>
                  </c:choose>
               </c:forEach>
               <form:errors path="req" cssClass="err" />
            </td>
         </tr>
   
         <tr>
            <td colspan="2" align="center">
               <input type="submit" value="주문하기" id="btnsubmit">
               <input type="button" value="목록보기" onClick="location='list.cf?pageNumber=${ param.pageNumber }&whatColumn=${ param.whatColumn }&keyword=${ param.keyword }'">
            </td>
         </tr>
   </table>
   </form:form>
</body>