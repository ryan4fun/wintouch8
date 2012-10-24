Ext.onReady(function() {
	Ext.Loader.setConfig({
		enabled : true,
		disableCaching : true,
		paths : {
			'Wintouch' : 'js/wintouch'
		}
	});

	var viewport = Ext.create('Wintouch.Viewport', {});
	
	window.viewport = viewport;
});