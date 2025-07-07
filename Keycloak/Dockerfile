FROM quay.io/keycloak/keycloak:24.0.3

ENV KC_DB=dev
ENV KC_DB_URL_HOST=localhost
ENV KC_HOSTNAME_STRICT=false
ENV KC_HTTP_PORT=9091

# These are required for Render
ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true

RUN /opt/keycloak/bin/kc.sh build

EXPOSE 9091
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev", "--http-port=9091"]