Ext.define('Wintouch.MainFrame', {
	extend : 'Ext.tab.Panel',
	alias : [ 'widget.mainframe' ],
	region : 'center',
	items : [ {
		title : 'Home',
		layout : 'fit',
		items : []
	}, {
		title : 'Accounts'
	}, {
		title : 'Persons'
	}, {
		title : 'Calendar'
	}, {
		title : 'Opportunities'
	}, {
		title : 'Reports'
	}, {
		title : 'Dashboards'
	}, {
		title : '+'
	} ]
});
