FROM quay.io/keycloak/keycloak:24.0.3

# Set required environment variables
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin123
ENV KC_HOSTNAME_STRICT=false
ENV KC_DB=dev-file

# Use Render-provided port (default is 10000 unless overridden)
ENV PORT=10000

# Build Keycloak with H2
RUN /opt/keycloak/bin/kc.sh build --db=dev-file

# EXPOSE Render port
EXPOSE ${PORT}

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev", "--http-port=${PORT}", "--http-host=0.0.0.0"]
