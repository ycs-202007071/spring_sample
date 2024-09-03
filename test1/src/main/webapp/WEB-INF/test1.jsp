<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<title>view 기본 세팅 파일</title>
</head>
<style>
</style>
<body>
	<div id="app">
		<button @click="fnGetList">버튼</button>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				
            };
        },
        methods: {
			fnGetList(){
				var self = this;
				var nparam = {
					userId: 1
				};
				$.ajax({
					url:"test1.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						console.log(data);
					}
				});
			}

        },
        mounted() {
			
        }
    });
    app.mount('#app');
</script>