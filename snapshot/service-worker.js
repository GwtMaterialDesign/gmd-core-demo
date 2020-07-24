var cacheName = 'cache_1595579091620';

var filesToCache = [  
'/gmd-core-demo/snapshot/',

'GmdCoreDemo/EA16E7DDB0789CCDBC934525982C3CD1.cache.js',

'GmdCoreDemo/GmdCoreDemo.devmode.js',

'GmdCoreDemo/GmdCoreDemo.nocache.js',

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

'images/addins-logo.png',

'images/animations-banner.png',

'images/build-banner.png',

'images/charts-logo.png',

'images/datatable-logo.png',

'images/gmd-logo.png',

'images/jquery-banner.png',

'images/setup-banner.png',

'images/snapshots-banner.png',

'images/style-banner.png',

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


/**
 * The install event is your chance to cache everything you need before being able to control clients. The promise you
 * pass to event.waitUntil() lets the browser know when your install completes, and if it was successful.
 */
self.addEventListener('install', e => {
    e.waitUntil(
        caches.open(cacheName).then(cache => {
            return cache.addAll(filesToCache)
                .then(() => self.skipWaiting());
        })
    );
 });

/**
 * Once your service worker is ready to control clients and handle functional events like push and sync, you'll get an
 * activate event. But that doesn't mean the page that called .register() will be controlled.
 */
self.addEventListener('activate', event => {
    event.waitUntil(
        caches.keys().then(function(cacheNames) {
            return Promise.all(
                cacheNames.map(function(oldCache) {
                    if (oldCache !== cacheName) {
                        console.log('ServiceWorker : Deleting old cache:', oldCache);
                        return caches.delete(oldCache);
                    }
                })
            );
        }).then(function() {
            console.log('ServiceWorker : Claiming clients for version', cacheName);
            return self.clients.claim();
        })
    );
});

/**
 * It contains information about the fetch, including the request and how the receiver will treat the response.
 * It provides the event.respondWith() method, which allows us to provide a response to this fetch.
 */
self.addEventListener('fetch', event => {
    if (event.request.method !== 'GET') {
    /* If we don't block the event as shown below, then the request will go to
       the network as usual.
    */
    return;
}
event.respondWith(
    caches.open(cacheName)
        .then(cache => cache.match(event.request, {ignoreSearch: true}))
    .then(response => {
    return response || fetch(event.request);
        })
    );
});