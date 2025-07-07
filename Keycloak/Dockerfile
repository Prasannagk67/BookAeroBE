FROM quay.io/keycloak/keycloak:24.0.3

ENV KC_DB=dev
ENV KC_DB_URL_HOST=localhost

RUN /opt/keycloak/bin/kc.sh build

EXPOSE 9091
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev", "--http-port=9091", "--hostname-strict=false"]