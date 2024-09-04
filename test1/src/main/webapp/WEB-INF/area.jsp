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
		<select v-model="si" @change="fnArea()">
			<option value ="si">::선택::</option>
			<option v-for="item in siList" :value="item.si">{{item.si}}</option>
		</select>
		<select v-model="gu" @change="fnArea()">
			<option value ="gu" >::선택::</option>
			<option v-for="item in guList" :value="item.gu">{{item.gu}}</option>
		</select>
		<select v-model="dong" @change="fnArea()">
			<option value ="dong" >::선택::</option>
			<option v-for="item in dongList" :value="item.dong">{{item.dong}}</option>
		</select>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				si : "",
				siList : [],
				gu : "",
				guList : [],
				dongList : []
            };
        },
        methods: {
			fnArea(){
				var self = this;
				if(self.si == ""){
					self.guList = [];
				}
				var nparam = {
					si : self.si,
					gu : self.gu
				};
				$.ajax({
					url:"area-list.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						console.log(self.si);
						if (self.si=="") {
							self.siList = data.list;
						} else if (self.gu=="") {
							self.guList = data.list;
						} else {
							self.dongList = data.list;
						}
						
					}
				});
			}
        },
        mounted() {
			var self = this;
			self.fnArea();
        }
    });
    app.mount('#app');
</script>