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
			<button @click="fnIdCheck">중복체크</button>
			주소 : <input placeholder="주소" v-model="addr" @change="fnResult(roadFullAddr)">
			<button @click="fnAddr">주소검색</button>
		</div>
	</div>
</body>
</html>
<script>
function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail, roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
	if (window.vueAppInstance) {
		window.vueAppInstance.fnResult(roadFullAddr, roadAddrPart1, addrDetail, roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo);
	} else {
		console.error("Vue app instance is not available.");
	}
}
    const app = Vue.createApp({
        data() {
            return {
				userId : "",
				addr : ""
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
						if(data.info == undefined){
							alert("사용 가능한 아이디!");
						} else {
							alert("이미 사용중인 아이디");
						}
					}
				});
			},
			fnAddr(){
				var nparam = {};
				var self = this;
				var option = "width = 500, height = 500, top = 100, left = 200, location = no"
				window.open("addrLinkUrl.do", "addr", option);
				$.ajax({
					url:"addrLink.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						}
					});
				},
			fnResult(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
				var self = this;
				self.roadFullAddr = roadFullAddr;
				self.addr = roadFullAddr;
				// 콘솔 통해 각 변수 값 찍어보고 필요한거 가져다 쓰면 됩니다.
				console.log(roadFullAddr);
				console.log(roadAddrPart1);
				console.log(addrDetail);
				console.log(engAddr);
			}
        },
        mounted() {
			window.vueAppInstance = this;
        }
    });
    app.mount('#app');
</script>