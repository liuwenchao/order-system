var Ajax;
if (Ajax && (Ajax != null)) {
	Ajax.Responders.register({
	  onCreate: function() {
        if($('spinner') && Ajax.activeRequestCount>0)
          Effect.Appear('spinner',{duration:0.5,queue:'end'});
	  },
	  onComplete: function() {
        if($('spinner') && Ajax.activeRequestCount==0)
          Effect.Fade('spinner',{duration:0.5,queue:'end'});
	  }
	});
}

function yuiloader_insert(require, callback) {
    if (!YAHOO.lang.isArray(require)) {
        require = [ require ];
    }

    for (var i = 0; i < require.length;) {
        if (YAHOO.lang.hasOwnProperty(yui, require[i])) {
            require.splice(i, 1);
        } else {
            i ++;
        }
    }

    if (require.length) {
        var loader = new YAHOO.util.YUILoader({
            base : location.protocol + '//ajax.googleapis.com/ajax/libs/yui/2.8.0r4/build/',
            onProgress: function() { YAHOO.lang.augmentObject(yui, loader.inserted); },
            onSuccess : callback, require: require,
            onFailure : function() { showSimpleDialog('Failed to load following YUI 2 module(s): ' + YAHOO.lang.dump(require)); }
        });
        
        loader.insert();
    } else {
        callback();
    }

    return false;
}
