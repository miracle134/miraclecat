sample = {};
sample.script = function() {
	return {
		
		/**
			$.getAjax
			$.postAjax 
			$.multiPartAjax
			$.putAjax 등록
			$.patchAjax 업데이트
			$.deleteAjax 삭제
			(데이터, 경로, 성공콜백, 실패콜백, 비동기여부 true:비동기 false: 동기)
		 */

		// 국가코드 변경 KOR
		changeKor : function (){
			$.getAjax(null,'/changeKor', sample.script.changeKorSuccess, sample.script.errorCallback);
		},
		changeKorSuccess : function(data){
			location.reload();
		},
		
		// 국가코드 변경 ENG
		changeEng : function (){
			var param = {};
			param.sSeq = "1";
			param.sName = "테스트";
			
			$.postAjax(param,'/changeEng', sample.script.changeEngSuccess, sample.script.errorCallback);
		},
		changeEngSuccess : function(data){
			location.reload();
		},
		
		// Mybatis DB1 조회
		getListMybatis : function (){
			var param = {};
			param.sSeq = "1";
			param.sName = "테스트";
			
			$.postAjax(param,'/selectMybatisDB1', sample.script.getListMybatisSuccess, sample.script.errorCallback);
		},
		getListMybatisSuccess : function(data){
			console.log(data);
		},
		
		// Mybatis DB2 조회
		getListMybatis2 : function (){
			var param = {};
			param.sSeq = "1";
			param.sName = "테스트";
			
			$.postAjax(param,'/selectMybatisDB2', sample.script.getListMybatisSuccess, sample.script.errorCallback);
		},
		getListMybatisSuccess : function(data){
			console.log(data);
		},
		
		// JPA 조회
		getList : function (){
			
			$.postAjax(null,'/selectListData', sample.script.getListSuccess, sample.script.errorCallback);
			
		},
		getListSuccess : function(data){
			console.log(data);
		},
		
		// JPA 상세 조회
		getDetail : function (){
			var param = {};
			param.sSeq = "1";
			param.sName = "아이유";
			
			$.postAjax(param,'/selectDetail', sample.script.getDetailSuccess, sample.script.errorCallback);
		},
		getDetailSuccess : function(data){
			console.log(data);
		},
		
		// JPA 등록
		save : function(){
			var param = {};
			param.sName = "아이유";
			param.sPassword = "1234";
			param.sMessage = "가수";
			param.sRegId = "관리자";
			
			$.putAjax(param,'/sampleSave', sample.script.saveSuccess, sample.script.errorCallback);
		},
		saveSuccess : function(data){
			console.log(data);
		},
		
		// JPA 수정
		update : function(){
			var param = {};
			param.sSeq = "30";
			param.sName = "테스트";
			param.sPassword = "테스트";
			param.sMessage = "테스트";
			
			$.patchAjax(param,'/sampleUpdate', sample.script.updateSuccess, sample.script.errorCallback);
		},
		updateSuccess : function(data){
			console.log(data);
		},
		
		// JPA 삭제
		del : function(){
			var param = {};
			param.sSeq = "3";
			
			$.deleteAjax(param,'/sampleDelete', sample.script.delSuccess, sample.script.errorCallback);
		},
		delSuccess : function(data){
			console.log(data);
		},

		// 에러 콜백
		errorCallback : function(data){
			console.log(data);
			alert('에러');
		},

		
		
	};
}();