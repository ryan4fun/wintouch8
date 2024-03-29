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
		name : 'Length',
		type : 'number'
	}, {
		name : 'DefaultValue',
		type : 'string'
	}, {
		name : 'InputMask',
		type : 'string'
	}, {
		name : 'Required',
		type : 'boolean'
	}, {
		name : 'ReadOnly',
		type : 'boolean'
	}, {
		name : 'Index',
		type : 'boolean'
	} ],
	idProperty : 'FieldName'
});

Ext.define('Wintouch.setup.TableDesignPanel', {
	extend : 'Ext.form.Panel',
	alias : [ 'widget.tabledesignpanel' ],
	requires : ['Wintouch.setup.FieldDesignWindow'],
	border : false,
	bodyBorder : false,
	layout : {
		type : 'vbox',
		align : 'center'
	},
	defaults : {
		width : '100%',
		margin : 1,
		cls : 'section_panel',
		border : false,
		bodyBorder : false
	},
	dockedItems : [{
		xtype : 'toolbar',
		dock : 'top',		
		style : {
			'background-color': 'white',
			'background-image': 'none'
		},
		items : ['->', {
			itemId : 'ok',
			icon : 'images/ok_16.png',			
			width : '80',
			handler : function(btn) {
				
			}
		}]
	}],
	items : [ {
		xtype : 'panel',
		title : 'Object Property',
		collapsible : true,
		flex : 1,
		bodyPadding : 8,
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
			flex : 2
		}, {
			text : 'Field Label',
			dataIndex : 'FieldLabel',
			flex : 2
		}, {
			text : 'Data Type',
			dataIndex : 'DataType',
			flex : 1
		}, {
			text : 'Length',
			dataIndex : 'Length',
			flex : 1
		}, {
			text : 'Required',
			dataIndex : 'Required',
			flex : 1
		}, {
			text : 'ReadOnly',
			dataIndex : 'ReadOnly',
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
					btn.up('tabledesignpanel').openFieldDesignWindow(true);
				}
			}, '->', {
				itemId : 'prop_btn',
				icon : 'images/properties_16.png',
				text : 'Properties',
				tooltip : 'Properties',			
				disabled : true,
				handler : function(btn) {
					btn.up('tabledesignpanel').openFieldDesignWindow();
				}
			}, {
				itemId : 'delete_btn',
				icon : 'images/delete1_16.gif',
				text : 'Delete',
				tooltip : 'Delete',			
				disabled : true,
				handler : function(btn) {
					btn.up('tabledesignpanel').deleteField();
				}
			} ]
		} ]
	} ],

	initComponent : function() {
		this.callParent(arguments);
		
		if(this.tableName){
			this.setTitle(this.tableName + ' --- Table Definition');
			this.getDockedComponent(1).getComponent('ok').setText('Save');
		} else {
			this.setTitle('Create New Object');
			this.getDockedComponent(1).getComponent('ok').setText('Create');
		}
		
		this.fieldGrid = this.down('gridpanel');
		this.fieldGrid.on('selectionchange', this.resetButtonStatus, this);
		this.fieldGrid.on('itemdblclick', function(grid, record){
			 this.openFieldDesignWindow(false);
		}, this);
	},
	
	openFieldDesignWindow : function(isNew){
		var basicRecord;
		if(!isNew){
			basicRecord = this.fieldGrid.getSelectionModel().getSelection()[0];
		}
		var fieldWindow = Ext.create('Wintouch.setup.FieldDesignWindow', {
			basicRecord : basicRecord,
			onSaved : {
				fn : function (basicRecord){
					this.fieldGrid.store.loadData([basicRecord], true);
				},
				scope : this
			}
		});
		
		fieldWindow.show();
	},
	
	deleteField : function(){
		var record = this.fieldGrid.getSelectionModel().getSelection()[0];
		
		this.fieldGrid.store.remove(record);
	},
	
	resetButtonStatus : function(selectionModel, selectedRecords){
		if(selectedRecords.length == 1){
			this.down('#prop_btn').enable();
			this.down('#delete_btn').enable();
		} else {
			this.down('#prop_btn').disable();
			this.down('#delete_btn').disable();
		}
	}
});
