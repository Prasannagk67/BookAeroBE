FROM quay.io/keycloak/keycloak:24.0.3

# Use in-memory dev DB instead of removed 'dev'
ENV KC_DB=dev-mem

RUN /opt/keycloak/bin/kc.sh build

EXPOSE 9091

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev", "--http-port=9091", "--hostname-strict=false"]
