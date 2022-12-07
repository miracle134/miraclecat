common = {};
common.script = function() { 
	return {
		
		// 기본 실행 init 함수
		init : function() {

			// form submit 방지 스크립트
			$('input[type="text"]').keydown(function() {
			    if (event.keyCode === 13) {
			        event.preventDefault();
			    }
			});
			
		},	
		
	};
}();