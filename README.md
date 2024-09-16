# Not all routes are started

## With Camel 4.6.0
```log
2024-09-16T11:08:53.813Z  INFO 99393 --- [           main] o.a.c.impl.engine.AbstractCamelContext   : Routes startup (total:4 rest-dsl:2)
2024-09-16T11:08:53.813Z  INFO 99393 --- [           main] o.a.c.impl.engine.AbstractCamelContext   :     Started route2 (direct://authenticate)
2024-09-16T11:08:53.813Z  INFO 99393 --- [           main] o.a.c.impl.engine.AbstractCamelContext   :     Started route3 (direct://data)
2024-09-16T11:08:53.813Z  INFO 99393 --- [           main] o.a.c.impl.engine.AbstractCamelContext   :     Started data (rest://post:/data/graphql:/)
2024-09-16T11:08:53.813Z  INFO 99393 --- [           main] o.a.c.impl.engine.AbstractCamelContext   :     Started route1 (rest-api://v3/api-docs)
```

## With Camel 4.8.0
```log
2024-09-16T11:10:15.350Z  INFO 99411 --- [           main] o.a.c.impl.engine.AbstractCamelContext   : Routes startup (total:2 rest-dsl:2)
2024-09-16T11:10:15.350Z  INFO 99411 --- [           main] o.a.c.impl.engine.AbstractCamelContext   :     Started route2 (rest://post:/data/graphql:/)
2024-09-16T11:10:15.350Z  INFO 99411 --- [           main] o.a.c.impl.engine.AbstractCamelContext   :     Started route1 (rest-api://v3/api-docs)
```
