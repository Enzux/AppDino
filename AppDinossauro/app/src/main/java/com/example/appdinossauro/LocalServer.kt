package com.example.appdinossauro

import android.content.Context
import fi.iki.elonen.NanoHTTPD
import java.io.InputStream

class LocalServer(context: Context) : NanoHTTPD(8080) {
    private val appContext = context

    override fun serve(session: IHTTPSession): Response {
        val uri = session.uri
        val fileName = if (uri == "/") "fbx.html" else uri.substring(1)
        val assetStream: InputStream? = appContext.assets.open(fileName)

        return if (assetStream != null) {
            newChunkedResponse(Response.Status.OK, "text/html", assetStream)
        } else {
            newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "404 Not Found")
        }
    }
}