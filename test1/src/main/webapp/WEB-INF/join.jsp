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
		<div>
			아이디 : <input placeholder="아이디" v-model="userId">
			<button @click="fnIdCheck()">중복체크</button>
			비밀번호 : <input placeholder="비밀번호" v-model="userPw">
			이름 : <input placeholder="이름" v-model="userName">
			이메일 : <input placeholder="이메일" v-model="userEmail">
			핸드폰번호 : <input placeholder="핸드폰번호" v-model="userPhone">
			성별 : <input placeholder="성별" v-model="userGender">
			<button @click="fnJoin()">회원가입</button>
			
		</div>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				userId: "",
				userPw: "",
				userName : "",
				userEmail: "",
				userPhone : "",
				userGender : ""
            };
        },
        methods: {
			fnIdCheck(){
				var self = this;
				var nparam = {userId : self.userId};
				$.ajax({
					url:"idCheck.dox",
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