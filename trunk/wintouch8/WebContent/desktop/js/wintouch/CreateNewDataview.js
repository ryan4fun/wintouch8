Ext.define('createnew_list_model', {
	extend : 'Ext.data.Model',
	fields : [ 'name', 'img' ]
});

Ext.define('Wintouch.CreateNewDataview', {
	extend : 'Ext.view.View',
	alias : [ 'widget.createnewdataview' ],
	selModel : {
		mode : 'SINGLE'
	},
	trackOver : true,
	tpl : [ '<tpl for=".">', '<div class="list-item">', '<img src="images/{img}"/>{name}', '</div>', '</tpl>' ],
	overItemCls : 'list-item-hover',
	selectedItemCls : 'list-item-selected',
	itemSelector : '.list-item',
	listeners : {
		itemclick : function(dataview, record) {
			if (record.data.name == 'Account') {

			}
		}
	},
	
	initComponent : function() {		
	 	this.store = Ext.create('Ext.data.Store', {
	 		model : 'createnew_list_model',
	 		data : []
	 	});
		this.callParent(arguments);	
	}
});
