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
				<div>
					제목 : <input type="text" placeholder="제목" v-model="title">
				</div>
				<div>
					내용 : <textarea cols="30" row="5" v-model="contents"></textarea>
				</div>
				<button @click="fnSave(title, contents)">저장</button>
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
				title : "",
				contents : ""
				
            };
        },
        methods: {
            fnSave(title, contents){
				var self = this;
				var nparmap = {
		                        title: self.title,
		                        contents: self.contents
		                    };
					$.ajax({
						url:"board-add.dox", // 여기 주소는 컨트롤러에 존재 해야한다. DB와 상호작용용
						dataType:"json",	
						type : "POST", 
							data : nparmap,
							success : function(data) { 
							alert(data.message);
							if(data.result == "success"){
								
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