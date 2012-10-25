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
	layout : 'fit',
	tools : [{
		type : 'help'
	}],
	buttons : [ {
		text : 'OK',
		icon : 'images/ok_16.png',
		handler : function(btn) {
			btn.up('fielddesignwindow').close();
		}
	}, {
		text : 'Cancel',
		icon : 'images/cancel_16.png',
		handler : function(btn) {
			btn.up('fielddesignwindow').close();
		}
	} ],
	items : [{
		xtype : 'tabpanel',
		items : [{
			title : 'Basic',
			iconCls : 'database-edit-icon'
		}, {
			title : 'Events',
			iconCls : 'events-icon'
		}, {
			title : 'Validation',
			iconCls : 'validation-icon'
		}]
	}],
	
	initComponent : function() {
	 	Ext.apply(this, {
	 		width: parseInt(viewport.getWidth() * 0.6),
	 	    height: parseInt(viewport.getHeight() * 0.7)
		});
		this.callParent(arguments);
	},
});
