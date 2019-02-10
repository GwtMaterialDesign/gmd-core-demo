var cacheName = 'cache_154249091962847';

var filesToCache = [  
'favicon.ico',

'GmdCoreDemo/clear.cache.gif',

'GmdCoreDemo/css/animation.css',

'GmdCoreDemo/css/animation.min.css',

'GmdCoreDemo/css/fontawesome-all.css',

'GmdCoreDemo/css/fontawesome-all.min.css',

'GmdCoreDemo/css/material-icons.css',

'GmdCoreDemo/css/material-icons.min.css',

'GmdCoreDemo/css/materialize.blue.css',

'GmdCoreDemo/css/materialize.blue.min.css',

'GmdCoreDemo/css/materialize.css',

'GmdCoreDemo/css/materialize.min.css',

'GmdCoreDemo/font/material-icons/MaterialIcons-Regular.eot',

'GmdCoreDemo/font/material-icons/MaterialIcons-Regular.ttf',

'GmdCoreDemo/font/material-icons/MaterialIcons-Regular.woff',

'GmdCoreDemo/font/material-icons/MaterialIcons-Regular.woff2',

'GmdCoreDemo/font/roboto/Roboto-Bold.ttf',

'GmdCoreDemo/font/roboto/Roboto-Bold.woff',

'GmdCoreDemo/font/roboto/Roboto-Bold.woff2',

'GmdCoreDemo/font/roboto/Roboto-Light.ttf',

'GmdCoreDemo/font/roboto/Roboto-Light.woff',

'GmdCoreDemo/font/roboto/Roboto-Light.woff2',

'GmdCoreDemo/font/roboto/Roboto-Medium.ttf',

'GmdCoreDemo/font/roboto/Roboto-Medium.woff',

'GmdCoreDemo/font/roboto/Roboto-Medium.woff2',

'GmdCoreDemo/font/roboto/Roboto-Regular.ttf',

'GmdCoreDemo/font/roboto/Roboto-Regular.woff',

'GmdCoreDemo/font/roboto/Roboto-Regular.woff2',

'GmdCoreDemo/font/roboto/Roboto-Thin.ttf',

'GmdCoreDemo/font/roboto/Roboto-Thin.woff',

'GmdCoreDemo/font/roboto/Roboto-Thin.woff2',

'GmdCoreDemo/fontawesome-icons/fa-brands-400.eot',

'GmdCoreDemo/fontawesome-icons/fa-brands-400.ttf',

'GmdCoreDemo/fontawesome-icons/fa-brands-400.woff',

'GmdCoreDemo/fontawesome-icons/fa-brands-400.woff2',

'GmdCoreDemo/fontawesome-icons/fa-regular-400.eot',

'GmdCoreDemo/fontawesome-icons/fa-regular-400.ttf',

'GmdCoreDemo/fontawesome-icons/fa-regular-400.woff',

'GmdCoreDemo/fontawesome-icons/fa-regular-400.woff2',

'GmdCoreDemo/fontawesome-icons/fa-solid-900.eot',

'GmdCoreDemo/fontawesome-icons/fa-solid-900.ttf',

'GmdCoreDemo/fontawesome-icons/fa-solid-900.woff',

'GmdCoreDemo/fontawesome-icons/fa-solid-900.woff2',

'GmdCoreDemo/GmdCoreDemo.devmode.js',

'GmdCoreDemo/GmdCoreDemo.nocache.js',

'index.html',

'launcher-icons/launcher1x.png',

'launcher-icons/launcher2x.png',

'launcher-icons/launcher4x.png',

'launcher-icons/launcher5x.png',

'splash/font/Roboto-Regular.eot',

'splash/font/Roboto-Regular.ttf',

'splash/font/Roboto-Regular.woff',

'splash/font/Roboto-Regular.woff2',

'splash/splash.css',

'splash/splash.js'
    ];

self.addEventListener('install', function(e) {
    console.log('[ServiceWorker] Install');
    e.waitUntil(
        caches.open(cacheName).then(function(cache) {
            console.log('[ServiceWorker] Caching app shell');
            return cache.addAll(filesToCache);
        })
    );
});


self.addEventListener('activate', function(e) {
    console.log('[ServiceWorker] Activate');
    e.waitUntil(
        caches.keys().then(function(keyList) {
            return Promise.all(keyList.map(function(key) {
                console.log('[ServiceWorker] Removing old cache', key);
                if (key !== cacheName) {
                    return caches.delete(key);
                }
            }));
        })
    );
});

self.addEventListener('fetch', function(e) {
    console.log('[ServiceWorker] Fetch', e.request.url);
    e.respondWith(
        caches.match(e.request).then(function(response) {
            return response || fetch(e.request);
        })
    );
});
