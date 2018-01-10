(function($) {
	/**
	 * 设置表单验证默认值
	 */
	$.extend(true, $.fn.formValidation.DEFAULT_OPTIONS, {
		// 国际化 中文
		locale: "zh_CN",
		// 默认表单UI框架 bootstrap
		framework: 'bootstrap',
		// 验证图标 className
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		}
	});
	$(function() {
		// 初始化表单
		$.fn.formValidation2 = function(){
			this.on('success.form.fv', function() {return false;}).formValidation.apply(this, arguments);
		};
		$('form[data-fv]').formValidation2();
	});
})(jQuery);
