var cacheName = '{{cacheName}}';

var filesToCache = [  {{#each filesToCache}}
'{{.}}'{{#unless @last}},{{/unless}}
    {{/each}}
    ]


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
