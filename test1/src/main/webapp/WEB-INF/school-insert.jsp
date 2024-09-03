<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
    <script src="https://cdn.quilljs.com/1.3.6/quill.min.js"></script>
	<title>view 기본 세팅 파일</title>
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
	#editor{
		height : 300px;
	}
	#title{
		width : 400px;
	}
	#btn {
		margin-left : 20px;
	}
</style>
<body>
	<div id="app">
		<table>
			<tr>
				<th>학번</th>
				<td><input id="stuNo" v-model="stuNo"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input id="name" v-model="name"></td>
			</tr>
			<tr>
				<th>id</th>
				<td><input id="id" v-model="id"></td>
			</tr>
			<tr>
				<th>grade</th>
				<td><input id="grade" v-model="grade"></td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><input id="jumin" v-model="jumin"></td>
			</tr>
			<tr>
				<th>학과번호</th>
				<td><input id="deptno1" v-model="deptno1"></td>
			</tr>
		</table>
		<button id="btn" @click="fnSave">저장</button>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				stuNo : "",
				name : "",
				id : "",
				grade : "",
				jumin : "",
				deptno1 : ""
            };
        },
        methods: {
			fnSave (){
				var self = this;
				var nparam = {
					stuNo : self.stuNo, 
					name : self.name,
					id : self.id,
					grade : self.grade,
					jumin : self.jumin,
					deptno1 : self.deptno1
				};
				$.ajax({
					url:"school-add.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						alert(data.message);
						if(data.result == "success"){
							location.href = "school-stu.do"
						}
					}
				});
			}
        },
		  mounted() {
		            var self = this;
		        }
		    });
		    app.mount('#app');
</script>
​