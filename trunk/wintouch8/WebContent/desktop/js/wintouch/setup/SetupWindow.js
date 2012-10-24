Ext.define('Wintouch.setup.SetupWindow', {
	extend : 'Ext.window.Window',
	alias : [ 'widget.setupwindow' ],
	title : 'Setup',
	closable : true,
	closeAction : 'hide',	
	floating : true,
	border : false,
	center : true,
	layout : {
		type : 'border'
	},
	tools : [{
		type : 'help'
	}],
	buttons : [ {
		text : 'Cancel',
		icon : 'images/cancel_16.png',
		handler : function(btn) {
			btn.up('setupwindow').close();
		}
	} ],
	items : [ {
		region : 'west',
		width : 260,
		split : true,
		collapsible : false,
		split : true,
		width : 210,
		layout : {
			type : 'accordion',
			multi : true
		},
		defaults : {
			xtype : 'panel',
			layout : {
				type : 'fit'
			},
			border : true,
			defaults : {
				autoScroll : true
			}
		},
		items : [ {
			title : 'Personal Setup',
			layout : 'fit',
			items : [ {
				xtype : 'treepanel',
				border : false,
				rootVisible : false,
				store : Ext.create('Ext.data.TreeStore', {
					root : {
						expanded : true,
						children : []
					}
				})
			} ]
		}, {
			title : 'Application Setup',
			items : [ {
				xtype : 'treepanel',
				border : false,
				rootVisible : false,
				store : Ext.create('Ext.data.TreeStore', {
					root : {
						expanded : true,
						children : [ {
							text : 'Customize',
							expanded : true,
							icon : 'images/customize_16.png',
							children : [{
								text : 'Create New Object',
								leaf : true,
								icon : 'images/add1_16.gif'
							}, {
								text : 'Accounts',
								expanded : true,
								children :  [ {
									text : 'Data',
									leaf : true,
									icon : 'images/database_table_16.png'						
								} ]
							}]
						} ]
					}
				})
			}]
		}, {
			title : 'Administrator Setup',
			items : [ {
				xtype : 'treepanel',
				border : false,
				rootVisible : false,
				store : Ext.create('Ext.data.TreeStore', {
					root : {
						expanded : true,
						children : []
					}
				})
			}]
		} ]
	}, {
		region : 'center',
		xtype : 'panel',
		layout : 'fit',
		items : []
	} ],
	
	initComponent : function() {
	 	Ext.apply(this, {
	 		width: parseInt(viewport.getWidth() * 0.7),
	 	    height: parseInt(viewport.getHeight() * 0.8)
		});
		this.callParent(arguments);	
	}
});