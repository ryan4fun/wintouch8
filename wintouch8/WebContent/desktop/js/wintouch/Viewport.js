Ext.define('Wintouch.Viewport', {
    extend: 'Ext.Viewport',
    alias: ['wintouch.viewport'],
    requires: ['Wintouch.TopBar', 'Wintouch.SideBar', 'Wintouch.MainFrame'],
    layout : {
		type : 'border',
		padding : 1
	},
	defaults : {
		split : true
	},
	items : [{
		xtype : 'topbar'
	}, {
		xtype : 'sidebar'		
	}, {
		xtype : 'mainframe'		
	}]
});