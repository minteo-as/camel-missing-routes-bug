package org.example.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.hc.client5.http.HttpHostConnectException;

public abstract class MainRoutes extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    this.onException(HttpHostConnectException.class)
        .handled(true)
        .setHeader(Exchange.HTTP_RESPONSE_CODE, this.constant(503))
        .setHeader("Retry-After", this.constant(60))
        .setBody(this.constant("The service is temporarily not available! Please try again later!"))
        .to("log:org.example?level=ERROR&showHeaders=true")
        .end();
  }
}
