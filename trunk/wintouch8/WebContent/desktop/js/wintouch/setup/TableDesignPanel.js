Ext.define('Wintouch.setup.TableDesignPanel', {
	extend : 'Ext.panel.Panel',
	alias : [ 'widget.tabledesignpanel' ],	
	border : false,	
	title : 'Create New Object',
	layout : {
		type : 'fit'
	},	
	items : [],
	
	initComponent : function() {
	 	
		this.callParent(arguments);	
	}
});
