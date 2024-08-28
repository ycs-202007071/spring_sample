<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<title>user 리스트 출력</title>
</head>
<style>
</style>
<body>
	<div id="app">

		<button @click="fnBoardList()">게시글 목록</button>
		<br>
		<input placeholder = "검색" v-model="keyword"></input>
		<button @click="fnUserList">검색</button> 
		<table>
			<tr>
				<th>아이디</th>
				<th>이름 </th>
				<th>이메일</th>
				<th>삭제</th>
			</tr>
			<tr v-for="item in userList">
				<td><a href="#" @click="fnUserView(item.userId)">{{item.userId}}</a></td>
				<td>{{item.userName}}</td>
				<td>{{item.email}}</td>
				<td><button @click="fnRemove(item.userId)">삭제</button></td>
			</tr>
		</table>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				userList : [],
				keyword : ""				
            };
        },
        methods: {
			fnUserList(){
				var self = this;
				var nparam = {keyword : self.keyword};
				$.ajax({ 
					url:"user-list.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						console.log(data);
						self.userList = data.list;
					}
						
				});
			},
			fnBoardList(){
				var self = this;
				var nparam = {};
				$.ajax({ 
					url:"board-list-user.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						console.log(data);
					}
						
				});
			},
			fnRemove(userId){
				var self = this;
				var nparam = {userId : userId};
				$.ajax({ 
					url:"user-delete.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						console.log(data);
						self.fnUserList();
					}
						
				});

				
			},			
			fnRemove(userId){
				var self = this;
				var nparam = {userId : userId};
				if(!confirm("삭제하시겠습니까?")){
					return;
				}
				$.ajax({ 
					url:"user-delete.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						console.log(data);
						self.fnUserList();
					}
						
				});

				
			},			
			fnUserView(userId){
				// key : boardNo, value : 내가 누른 게시글의 boardNo(pk)
				$.pageChange("user-view.do", {userId : userId});
			}
 		   },					
			
        mounted() {
			var self=this;
			self.fnUserList();
        }
    });
    app.mount('#app');
</script>
​