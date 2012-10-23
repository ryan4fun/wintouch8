Ext.define('Wintouch.SideBar', {
	extend : 'Ext.panel.Panel',
	alias : [ 'widget.sidebar' ],
	requires : [ 'Wintouch.CreateNewDataview', 'Wintouch.RecentDataview' ],
	region : 'west',
	title : 'Side Bar',
	split : true,
	border : true,
	tools : [ {
		type : 'help'
	} ],
	layout : {
		type : 'accordion',
		multi : true
	},
	width : 190,
	minWidth : 150,
	maxWidth : 400,
	collapsible : true,
	animCollapse : false,
	titleCollapse : true,
	collapseMode : 'header',
	items : [ {
		xtype : 'panel',
		title : 'Create New',
		iconCls : 'add-icon',
		flex : 3,
		border : false,
		layout : {
			type : 'fit'
		},
		defaults : {
			autoScroll : true
		},
		items : [ {
			xtype : 'createnewdataview'
		} ]
	}, {
		xtype : 'panel',
		title : 'Recent Items',
		flex : 3,
		iconCls : 'history-icon',
		bodyCls : 'recent-view',
		border : true,
		layout : {
			type : 'fit'
		},
		defaults : {
			autoScroll : true
		},
		items : [ {
			xtype : 'recentdataview'
		} ]
	} ]
});
