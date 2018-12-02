BeanFactoryBeanFactory

@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            boolean keepaLive = HttpUtil.isKeepAlive(request);
            System.out.println("method" + request.method());
            System.out.println("uri" + request.uri());
            String uri = request.uri().replace("/", "").trim();
            FullHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
            if (mapStatus.get(uri) != null) {
                httpResponse.setStatus(mapStatus.get(uri));
                httpResponse.content().writeBytes(mapStatus.get(uri).toString().getBytes());
            } else {
                httpResponse.content().writeBytes(content.getBytes());
            }
            //重定向处理
            if (httpResponse.status().equals(HttpResponseStatus.FOUND)) {
                httpResponse.headers().set(HttpHeaderNames.LOCATION, "https://www.baidu.com/");
            }
            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=UTF-8");
            httpResponse.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, httpResponse.content().readableBytes());
            if (keepaLive) {
                httpResponse.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
                ctx.writeAndFlush(httpResponse);
            } else {
                ctx.writeAndFlush(httpResponse).addListener(ChannelFutureListener.CLOSE);
            }
        }
    }
}