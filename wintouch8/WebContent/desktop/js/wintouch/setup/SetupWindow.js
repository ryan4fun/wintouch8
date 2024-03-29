Ext.define('Wintouch.setup.SetupWindow', {
	extend : 'Ext.window.Window',
	alias : [ 'widget.setupwindow' ],
	requires : ['Wintouch.setup.TableDesignPanel'],
	title : 'Setup',
	closable : true,
	closeAction : 'hide',	
	floating : true,
	modal : true,
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
								text : 'Account',
								expanded : true,
								children :  [ {
									text : 'Table Definition',
									leaf : true,
									icon : 'images/database_table_16.png',
									actionType : 'Definition',
									tableName : 'Account'
								}, {
									text : 'Table Relationship',
									leaf : true,
									icon : 'images/table_relationship_16.png',
									actionType : 'Relationship',
									tableName : 'Account'
								} ]
							}]
						} ]
					}
				}),
				listeners : {
					itemclick : {
						fn : function(tree, record){
							if(record.raw.text == 'Create New Object'){
								tree.up('setupwindow').createNewObject();
							} else if(record.raw.actionType == 'Definition'){
								tree.up('setupwindow').editTableDefinition(record.raw.tableName);
							}
						},
						scope : this
					}
				}
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
		itemId : 'center',
		layout : 'fit',
		items : [],
		listeners : {
			beforeadd : function(panel){
				panel.removeAll(true);
				return true;
			}
		}
	} ],
	
	initComponent : function() {
	 	Ext.apply(this, {
	 		width: parseInt(viewport.getWidth() * 0.7),
	 	    height: parseInt(viewport.getHeight() * 0.8)
		});
		this.callParent(arguments);
		
		this.center = this.down('#center');
	},
	
	createNewObject : function(){
		this.center.add({
			xtype : 'tabledesignpanel'
		});
	},
	editTableDefinition : function(tableName){
		this.center.add({
			xtype : 'tabledesignpanel',
			tableName : tableName
		});
	}
});
