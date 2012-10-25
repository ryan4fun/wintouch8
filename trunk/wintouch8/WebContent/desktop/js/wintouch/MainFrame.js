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
				
				return false;
			}
		}
	} ]
});
