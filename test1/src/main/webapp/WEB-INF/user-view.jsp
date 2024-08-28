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
		제목 : {{info.userName}}<br>
		내용 : {{info.userId}}<br>
		이메일 : {{info.email}}
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				userId : '${userId}',
				info : {}
            };
        },
        methods: {
			fnGetInfo(){
				var self = this;
				var nparmap = {userId : self.userId};
				$.ajax({
					url:"user-view.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.info = data.info;
					}
				});
            }
        },
        mounted() {
			var self = this;
			self.fnGetInfo();
        }
    });
    app.mount('#app');
</script>