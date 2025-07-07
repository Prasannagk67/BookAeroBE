FROM quay.io/keycloak/keycloak:24.0.3

# Set up dev DB (in-memory)
ENV KC_DB=dev-mem

# Set Keycloak admin credentials
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin

RUN /opt/keycloak/bin/kc.sh build

EXPOSE 9091

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev", "--http-port=9091", "--hostname-strict=false", "--hostname-strict-https=false", "--http-host=0.0.0.0"]
