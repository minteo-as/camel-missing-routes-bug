package org.example.routes;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class DataRoutes extends MainRoutes {
  private static final String DIRECT_DATA = "direct:data";

  @Override
  public void configure() throws Exception {
    super.configure();

    this.rest("/data/graphql")
        .tag("data")
        .post("/")
        .id("data")
        .description("GraphQL data endpoint")
        .consumes("application/json")
        .produces("application/json")
        .to(DIRECT_DATA);

    this.from(DIRECT_DATA)
        .to(AuthenticateRoutes.DIRECT_AUTHENTICATE)
        .removeHeader(Exchange.HTTP_PATH)
        .to("log:org.example?level=INFO&showHeaders=true");
  }
}
