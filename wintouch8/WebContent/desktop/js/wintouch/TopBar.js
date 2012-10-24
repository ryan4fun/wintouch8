Ext.define('Wintouch.TopBar', {
    extend: 'Ext.Container',
    alias: ['widget.topbar'],    
    region : 'north',
	split : false,
	layout : {
		type : 'border'
	},
	height : 45,
	items : [ {
		region : 'west',
		width : 205,				
		xtype : 'container',
		html : '<img src="images/wintouch_205x48.png" style="width:205px;height:45px;" />'
	}, {
		region : 'center',
		xtype : 'container',
		defaults : {
			border : false
		},
		items : [ {
			xtype : 'toolbar',
			height : 45,
			style : {
				backgroundImage : 'none',
				backgroundColor : 'transparent'
			},
			defaults : {
				xtype : 'tbtext',
				style : {
					color : '#00a',
					textDecoration : 'underline',
					cursor : 'pointer'
				}
			},
			items : [{
				xtype : 'tbspacer',
				width : 50
			}, {
				xtype : 'textfield',
				width : 180,		
				emptyText : 'Search Objects'
			}, {
				xtype : 'combo',
				width : 100,
				value : 'All'
			}, {
				xtype : 'button',
				icon : 'images/search_16.png',
				style : {
					
				}
			}, '->',  {
				xtype : 'button',					
				text : '<span style="color:#00a">Hello Mete</span>',
				menu : {
					xtype : 'menu',
					items : [{
						text : 'My Profile'
					}, {
						text : 'Setup',
						listeners : {
							click : function(menu, item) {
								var setupWindow = Ext.create('Wintouch.setup.SetupWindow', {
									
								});
								setupWindow.show();
							}
						}
					}, {
						text : 'Preference',
						listeners : {
							click : function(menu, item) {
								
							}
						}
					}, {
						text : 'Admin Tools',
						menu : {
							items : [{
								text : 'Drop Down Manager'
							}, {
								text : 'Transfer Activities'
							}, {
								text : 'Work Flow Script Designer'
							}, {
								text : 'URL Scripts Designer'
							}, {
								text : 'Web Form Designer'
							}]
						}
					}]
				}
			}, '-', {
				xtype : 'button',
				text : 'Critical <span style="color:red;">(6)<span>',
				icon : 'images/alarm_16.png',
				menu : {
					xtype : 'menu'
				}
			}, '-', {
				text : 'Help Center'
			}, '-', {
				text : 'Sign off'
			} ]
		}]
	} ]
});