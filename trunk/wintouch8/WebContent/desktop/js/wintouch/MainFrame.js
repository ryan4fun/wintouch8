Ext.define('Wintouch.MainFrame', {
	extend : 'Ext.tab.Panel',
	alias : [ 'widget.mainframe' ],
	region : 'center',
	items : [ {
		title : 'Home',
		layout : 'fit',
		items : []
	}, {
		title : '+',
		listeners : {
			beforeactivate : function(){
				var setupWindow = Ext.create('Wintouch.setup.SetupWindow', {
					
				});
				setupWindow.show();
				return false;
			}
		}
	} ]
});
