(function(){
	// IE 5678
	if (!(/MSIE [5|6|7|8]/.test(navigator.userAgent))) return;

	var link = document.createElement('link');
	link.rel = 'stylesheet';
	window.attachEvent('onload', function () {
		document.getElementsByTagName('head')[0].appendChild(link);
		var domain = getCurScriptDomain();

		var xs = domain + '/wro/bootstrap-ie-xs.css';
		var sm = domain + '/wro/bootstrap-ie-sm.css';
		var md = domain + '/wro/bootstrap-ie-md.css';
		var lg = domain + '/wro/bootstrap-ie-lg.css';

		window.attachEvent('onresize', (function onresize(){
			var w = document.body.offsetWidth;
			if (w >= 1200){
				link.href = lg;
			} else if (w >= 992){
				link.href = md;
			} else if (w >= 768){
				link.href = sm;
			} else {
				link.href = xs;
			}
			return onresize;
		})());
	});

	function getCurScriptDomain() {
		var domain = '';
		var jsName = '/wro/sp.jquery.bootstrap.js';
		var scripts = document.getElementsByTagName('script');
		for (var i = 0; i < scripts.length; i++) {
			var src = scripts[i].src;
			if (!src) {
				continue;
			}
			if (new RegExp(jsName.replace(/\//g, '\\/').replace(/\./g, '\\.')).test(src)){
				domain = getOrigin(src);
				break;
			}
		}
		return domain;
	}

	function getOrigin(s) {
		var protocol = s.substr(0, s.indexOf('://') + 3);
		s = s.substr(protocol.length);
		return protocol + s.substr(0, s.indexOf('/'));
	}
})();