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
		<ul style="margin : 20px;">
			<li><a href="#" @click="fnCategory('')">전체</a></li>
			<li><a href="#" @click="fnCategory('1')">공지사항</a></li>
			<li><a href="#" @click="fnCategory('2')">자유게시판</a></li>
			<li><a href="#" @click="fnCategory('3')">질문게시판</a></li>
		</ul>
		<div style="margin : 20px;"> 
			<select style="margin-right : 5px;" v-model="searchOption">
				<option value="all">:: 전체 ::</option>
				<option value="title">제목</option>
				<option value="name">작성자</option>
			</select>
			<input placeholder="검색어" v-model="keyword">
			<button @click="fnGetList(1)">검색</button>
		</div> 
		<select v-model = "pageSize" @change="fnGetList(1)">
			<option value="5">5개씩</option>
			<option value="10">10개씩</option>
			<option value="15">15개씩</option>
		</select>	
		<table>
			<tr>
				<th>게시글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
				<th>이메일</th>
				<th>삭제</th>
			</tr>
			<tr v-for="item in list">
				<td>{{item.boardNo}}</td>
				<td><a href="#" @click="fnView(item.boardNo)">{{item.title}}</a></td>
				<td>{{item.userName}}</td>
				<td>{{item.hit}}</td>
				<td>{{item.cdateTime}}</td>
				<td>{{item.email}}</td>
				<td><button @click="fnRemove(item.boardNo)" v-if= "sessionEmail == item.email || sessionStatus == 'A'">삭제</button></td>
			</tr>	
		</table>
		<div class="pagination">
		    <button v-if="currentPage > 1" @click="fnGetList(currentPage-1)">이전</button>
		    <button v-for="page in totalPages" :class="{active: page == currentPage}" @click ="fnGetList(page)">
		        {{ page }}
		    </button>
		    <button v-if="currentPage < totalPages" @click="fnGetList(currentPage+1)">다음</button>
		</div>
		
		<div>
			<button @click = "fninsert()">등록</button>
		</div>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				list : [],
				keyword : "",
				searchOption : "all",
				category : "",
				sessionEmail : '${sessionEmail}',
				sessionStatus : '${sessionStatus}',
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
					keyword : self.keyword,
					searchOption : self.searchOption,
					category : self.category,
					startIndex : startIndex,
					outputNumber : outputNumber
				};
				$.ajax({
					url:"board-list.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.list = data.list;
						console.log(self.sessionEmail);
						self.totalPages = Math.ceil(data.count / self.pageSize);
					}
				});
            },
			fnRemove(num) {
				var self = this;
				var nparmap = {boardNo : num};
				$.ajax({
					url:"board-remove.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						alert(data.message);
						self.fnGetList();
					}
				});
			},
			fnView(boardNo){
				// key : boardNo, value : 내가 누른 게시글의 boardNo(pk)
				$.pageChange("board-view.do", {boardNo : boardNo});
			},			
			fninsert(userId){
				// key : boardNo, value : 내가 누른 게시글의 boardNo(pk)
				location.href="/board-insert.do";
			},
			fnCategory(category){
				var self = this;
				self.category = category;
				self.fnGetList();
			}
        },
        mounted() {
            var self = this;
			self.fnGetList(1);
        }
    });
    app.mount('#app');
</script>