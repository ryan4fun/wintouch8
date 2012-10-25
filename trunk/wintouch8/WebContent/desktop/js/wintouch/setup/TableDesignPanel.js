Ext.define('FieldDefinition', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'FieldName',
		type : 'string'
	}, {
		name : 'FieldLabel',
		type : 'string'
	}, {
		name : 'DataType',
		type : 'string'
	}, {
		name : 'IntergrationName',
		type : 'string'
	} ],
	idProperty : 'list_id'
});

Ext.define('Wintouch.setup.TableDesignPanel', {
	extend : 'Ext.form.Panel',
	alias : [ 'widget.tabledesignpanel' ],
	requires : ['Wintouch.setup.FieldDesignWindow'],
	border : false,
	bodyBorder : false,
	title : 'Create New Object',
	layout : {
		type : 'vbox',
		align : 'center'
	},
	defaults : {
		width : '100%',
		margin : 1
	},
	dockedItems : [{
		xtype : 'toolbar',
		dock : 'top',		
		style : {
			'background-color': 'white',
			'background-image': 'none'
		},
		items : ['->', {
			icon : 'images/ok_16.png',
			text : 'Create',
			tooltip : 'Create',
			handler : function(btn) {
				
			}
		}]
	}],
	items : [ {
		xtype : 'panel',
		title : 'Object Property',
		collapsible : true,
		flex : 1,
		bodyPadding : 5,
		layout : {
			type : 'table',
			columns : 1
		},
		defaults : {
			xtype : 'textfield',
			labelAlign : 'right',
			labelWidth : 100
		},
		items : [ {
			fieldLabel : 'Singular Name'
		}, {
			fieldLabel : 'Plural Name'
		}, {
			xtype : 'textarea',
			fieldLabel : 'Description'
		} ]
	}, {
		xtype : 'gridpanel',
		title : 'Fields',
		flex : 2,
		layout : 'fit',
		columns : [ {
			text : 'Field Name',
			dataIndex : 'FieldName',
			flex : 1
		}, {
			text : 'Field Label',
			dataIndex : 'FieldLabel',
			flex : 1
		}, {
			text : 'Data Type',
			dataIndex : 'DataType',
			flex : 1
		}, {
			text : 'Intergration Name',
			dataIndex : 'IntergrationName',
			flex : 1
		} ],
		dockedItems : [ {
			xtype : 'toolbar',
			dock : 'top',
			style : {
				'background-color': 'white',
				'background-image': 'none'
			},
			defaults : {
				
			},
			items : [ {
				itemId : 'add_btn',
				icon : 'images/add1_16.gif',
				text : 'Add',
				tooltip : 'Add',
				width : 65,
				handler : function(btn) {
					var fieldWindow = Ext.create('Wintouch.setup.FieldDesignWindow', {
						
					});
					
					fieldWindow.show();
				}
			}, '->', {
				itemId : 'prop_btn',
				icon : 'images/properties_16.png',
				text : 'Properties',
				tooltip : 'Properties',			
				disabled : true,
				handler : function(btn) {
					
				}
			}, {
				itemId : 'delete_btn',
				icon : 'images/delete1_16.gif',
				text : 'Delete',
				tooltip : 'Delete',			
				disabled : true,
				handler : function(btn) {
					
				}
			} ]
		} ]
	} ],

	initComponent : function() {

		this.callParent(arguments);
	}
});
