Ext.namespace( 'Wintouch.app');

Wintouch.app.PROVIDER_BASE_URL=window.location.protocol + '//' + window.location.host + '/' + (window.location.pathname.split('/').length>2 ? window.location.pathname.split('/')[1]+ '/' : '')  + 'djn/directprovider';

Wintouch.app.POLLING_URLS = {
}

Wintouch.app.REMOTING_API = {
  url: Wintouch.app.PROVIDER_BASE_URL,
  type: 'remoting',
  actions: {
    TestAction: [
      {
        name: 'getGrid',
        len: 1,
        formHandler: false
      }
    ]
  }
}

