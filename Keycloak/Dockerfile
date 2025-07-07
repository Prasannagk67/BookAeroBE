FROM quay.io/keycloak/keycloak:24.0.3

ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin123
ENV KC_HOSTNAME_STRICT=false
ENV KC_DB=dev-file
ENV PORT=10000

RUN /opt/keycloak/bin/kc.sh build --db=dev-file

EXPOSE ${PORT}

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD start-dev --http-port=${PORT} --http-host=0.0.0.0 --hostname=keycloak-service --admin=admin --password=admin123
