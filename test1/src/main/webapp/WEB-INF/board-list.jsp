<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<title>첫번째 페이지</title>
</head>
<style>
</style>
<body>
	<div id="app">
		<style>
			table, tr, th, td{
				border : 1px solid black;
				padding : 5px 5px;
			}
		</style>
		<body>
			<div id="app">
				<input type="text" placeholder="학번" v-model="search">
						<button @click="fnSearch()">검색</button>
				<table>
					<tr>
						<th>게시글 번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
						<th></th>
					</tr>
					<tr v-for="item in list">
						<td>{{item.boardNo}}</td>
						<td>{{item.title}}</td>
						<td>{{item.userId}}</td>
						<td>{{item.hit}}</td>
						<td>{{item.cdateTime}}</td>
						<td><button @click="fnRemove(item.boardNo)">삭제</button></td>
					</tr>
				</table>
		<br>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
                name : "홍길동",
				list : {},
				search : ""
				
            };
        },
        methods: {
            fnGetList(){
				var self = this;
				var nparmap = {};
				$.ajax({
					url:"board-list.dox", // 여기 주소는 컨트롤러에 존재 해야한다. DB와 상호작용용
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.list = data.list;
					}
				});
            },
			fnRemove(num){
				var self = this;
				var nparmap = {boardNo : num};
				$.ajax({
					url:"board-add.dox", // 여기 주소는 컨트롤러에 존재 해야한다. DB와 상호작용용
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						alert(data.message);
						self.fnGetList();
					}
				});
			}
        },
        mounted() {
            var self = this;
			self.fnGetList();
        }
    });
    app.mount('#app');
</script>