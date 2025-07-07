FROM quay.io/keycloak/keycloak:24.0.3

# Set required environment variables FIRST
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin123
ENV KC_HOSTNAME_STRICT=false
ENV KC_HTTP_PORT=9091
ENV KC_DB=dev-file  # Use simple file-based H2 database for testing

# Then run build
RUN /opt/keycloak/bin/kc.sh build --db=dev-file

EXPOSE 9091
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev", "--http-port=9091"]