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
		학번 : {{info.stuNo}}<br>
		이름 : {{info.name}}<br>
		학부 : {{info.d2dname}}<br>
		학과 : {{info.d1dname}}<br>
		담당교수 : {{info.pname}}<br>
		<button @click="fnRemove">삭제</button>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				stuNo : '${stuNo}',
				info : {}
            };
        },
        methods: {
			fnGetInfo(){
				var self = this;
				var nparmap = {stuNo : self.stuNo};
				console.log(nparmap);
				$.ajax({
					url:"school-view.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						self.info = data.info;
					}
				});
            },
			fnp(){
				alert("adsd");
			},
			fnRemove() {
				var self = this;
				var nparmap = {stuNo : self.info.stuNo};
				console.log(nparmap)
				$.ajax({
					
					url:"school-remove.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						alert(data.message);
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