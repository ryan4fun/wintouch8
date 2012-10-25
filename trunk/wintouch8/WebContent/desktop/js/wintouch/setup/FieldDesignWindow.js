Ext.define('Wintouch.setup.FieldDesignWindow', {
	extend : 'Ext.window.Window',
	alias : [ 'widget.fielddesignwindow' ],
	title : 'Field Properties',
	iconCls : 'properties-icon',
	closable : true,
	floating : true,
	modal : true,
	border : false,
	center : true,
	width : 600,
	height : 400,
	layout : 'fit',
	tools : [ {
		type : 'help'
	} ],
	buttons : [ {
		text : 'OK',
		icon : 'images/ok_16.png',
		handler : function(btn) {
			var onSaved = btn.up('fielddesignwindow').onSaved;
			var record = btn.up('fielddesignwindow').getBasicRecord();
			
			onSaved.fn.call(onSaved.scope, record);
			
			btn.up('fielddesignwindow').close();
		}
	}, {
		text : 'Cancel',
		icon : 'images/cancel_16.png',
		handler : function(btn) {
			btn.up('fielddesignwindow').close();
		}
	} ],
	items : [ {
		xtype : 'tabpanel',
		items : [ {
			xtype : 'form',
			title : 'Basic',
			iconCls : 'database-edit-icon',
			itemId : 'basicForm',
			layout : {
				type : 'vbox',
				align : 'center'
			},
			defaults : {
				width : '100%',
				xtype : 'panel',
				cls : 'section_panel',
				margin : 1,
				bodyPadding : 10
			},
			items : [ {
				title : 'Metadata',
				flex : 2,
				layout : {
					type : 'table',
					columns : 2
				},
				defaults : {
					xtype : 'textfield',
					labelAlign : 'right'
				},
				items : [ {
					xtype : 'combobox',
					name : 'DataType',
					fieldLabel : 'Data Type',
					editable : false,
					forceSelection : true,
					store : Ext.create('Ext.data.Store', {
						xtype : 'store',
						fields : [ 'text', 'value' ],
						data : [ {
							"text" : "Text",
							"value" : "Text"
						}, {
							"text" : "Decimal",
							"value" : "Decimal"
						} ]
					}),
					queryMode : 'local',
					displayField : 'text',
					valueField : 'value',
					width : 300
				}, {
					xtype : 'numberfield',
					name : 'Length',
					fieldLabel : 'Length',
					labelWidth : 60,
					width : 130,
					value: 10,
			        minValue: 1
				}, {
					name : 'FieldName',
					fieldLabel : 'Field Name',
					colspan : 2,
					width : 300
				}, {
					name : 'FieldLabel',
					fieldLabel : 'Field Label',
					colspan : 2,
					width : 300
				}, {
					name : 'DefaultValue',
					fieldLabel : 'Default Value',
					colspan : 2,
					width : 300
				}, {
					name : 'InputMask',
					fieldLabel : 'Input Mask',
					colspan : 2,
					width : 300
				} ]
			}, {
				title : 'Other',
				flex : 1,				
				defaults : {
					margin : 5
				},
				layout : {
					type : 'table',
					columns : 2
				},
				items : [ {
					name : 'Required',
					xtype : 'checkbox',
					boxLabel : 'This field is required.',
					width : 250
				}, {
					name : 'Readonly',
					xtype : 'checkbox',
					boxLabel : 'This field is readonly.',
					width : 250
				}, {
					name : 'Index',
					xtype : 'checkbox',
					boxLabel : 'Index this field as part of text search engine',
					width : 500,
					colspan : 2
				} ]
			} ]
		}, {
			title : 'Events',
			iconCls : 'events-icon',
			disabled : true
		}, {
			title : 'Validation',
			iconCls : 'validation-icon',
			disabled : true
		} ]
	} ],

	initComponent : function() {
		this.callParent(arguments);
		
		if(this.basicRecord){
			this.down('#basicForm').loadRecord(this.basicRecord);			
		}
	},
	
	getBasicRecord : function(){
		var record = Ext.create('FieldDefinition', this.down('#basicForm').getValues());
		
		return record;			
	}
});
