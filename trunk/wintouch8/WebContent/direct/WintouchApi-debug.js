/**********************************************************************
 * 
 * Code generated automatically by DirectJNgine
 * Copyright (c) 2009, Pedro Agulló Soliveres
 * 
 * DO NOT MODIFY MANUALLY!!
 * 
 **********************************************************************/

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
        name: 'getGrid'/*(java.util.Map) => com.touchtone.direct.DataStore */,
        len: 1,
        formHandler: false
      }
    ]
  }
}

