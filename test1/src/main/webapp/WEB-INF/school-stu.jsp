<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<title>첫번째 페이지</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />
</head>
<style>
	table {
		margin : 20px;
	}
	table, tr, th, td {
		border : 1px solid black;
		padding : 5px 5px;
		border-collapse: collapse;
	}
	
</style>
<body>
	<div id="app">
		<div style="margin : 20px;"> 
		</div>
		<i class="fa-solid fa-meteor"></i> 
		<i class="fa-solid fa-star-of-david"></i>
		<span class="material-symbols-outlined">
		favorite
		</span>
		<select v-model = "pageSize" @change="fnGetList(1)">
			<option value="5">5개씩</option>
			<option value="10">10개씩</option>
			<option value="20">20개씩</option>
		</select>	
		<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>아이디</th>
				<th>학년</th>
				<th>주민번호</th>
				<th>삭제</th>
			</tr>
			<tr v-for = "item in list">
				<td><a href="#" @click="fnView(item.stuNo)">{{item.stuNo}}</a></td>
				<td>{{item.name}}</td>
				<td>{{item.id}}</td>
				<td>{{item.grade}}</td>
				<td>{{item.jumin}}</td>
				<td><button @click="fnRemove(item.stuNo)">삭제</button></td>
			</tr>	
		</table>
		<div>
			<button @click = "fninsert()">등록</button>
		</div>
		<div class="pagination">
		    <button v-if="currentPage > 1" @click="fnGetList(currentPage-1)">이전</button>
		    <button v-for="page in totalPages" :class="{active: page == currentPage}" @click ="fnGetList(page)">
		        {{ page }}
		    </button>
		    <button v-if="currentPage < totalPages" @click="fnGetList(currentPage+1)">다음</button>
		</div>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				list : [],
				currentPage: 1,      
				pageSize: 5,        
				totalPages: ""
            };
        },
        methods: {
            fnGetList(page){
				var self = this;
				var startIndex = (page-1) * self.pageSize;
				var outputNumber = self.pageSize;
				self.currentPage = page;
				var nparmap = {
					startIndex : startIndex,
					outputNumber : outputNumber
				};
				$.ajax({
					url:"school-stu.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : (data)=> { 
						this.list = data.list;
						this.totalPages = Math.ceil(data.count / this.pageSize);
					}
				});
            },
			fnView(stuNo){
				// key : boardNo, value : 내가 누른 게시글의 boardNo(pk)
				$.pageChange("school-view.do", {stuNo : stuNo});
			},
			fnRemove(num) {
				var self = this;
				var nparmap = {stuNo : num};
				$.ajax({
					url:"school-remove.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						alert(data.message);
						self.fnGetList(1);
					}
				});
			},
			fninsert(userId){
				location.href="/school-insert.do";
			},
        },
        mounted() {
            var self = this;
			self.fnGetList(1);
        }
    });
    app.mount('#app');
</script>