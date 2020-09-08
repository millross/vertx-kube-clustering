package com.millross.vertx.http

import io.vertx.core.AbstractVerticle
import io.vertx.ext.web.Router

class WebVerticle: AbstractVerticle() {
    override fun start() {
        super.start()
        var server = vertx.createHttpServer()

        var router = Router.router(vertx)

        router.route().handler({ routingContext ->

            // This handler will be called for every request
            var response = routingContext.response()
            response.putHeader("content-type", "text/plain")

            // Write to the response and end it
            response.end("Hello World from Vert.x-Web!")
        })

        server.requestHandler(router).listen(8080)
    }

}