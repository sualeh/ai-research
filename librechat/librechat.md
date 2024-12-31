# LibreChat

Running [LibreChat](https://github.com/danny-avila/LibreChat) locally, with MCP servers. See the []

## Running LibreChat Locally

### Configuration Files

- Create your own .env file with the API keys, based on [LibreChat .env.example](https://github.com/danny-avila/LibreChat/blob/main/.env.example) - however, your file needs to be called ".env"
- librechat-docker-compose.yaml is simply a copy of [LibreChat docker-compose.yml](https://github.com/danny-avila/LibreChat/blob/main/docker-compose.yml) - do not modify this file
- librechat-docker-compose-override.yaml is an override to load the LibreChat config file in the default expected location - you can also use it to run any Docker containers that provide non-stdio MCP servers
- librechat-config.yaml is additional LibreChat configuration, and can be used to specify MCP servers among other things


### Run LibreChat Locally

1. Change (cd) to the "librechat" folder
2. Run
```sh
docker-compose \
  -f .\libre-chat-docker-compose.yaml \
  -f .\libre-chat-docker-compose-override.yaml \
  up -d
```
3. Open a browser to http://localhost:3080 and create a new account if needed

To shut-down, run the same Docker Compose command with `down -t0` insted of `up -d`.



## Notes

1. The MCP server stdio protocol does not need to keep the server running at all times
2. If running an MCP server in Docker, this cannot be done as an command, since that would mean that the Docker container would need to run within the LibreChat container, which is not possible or desired


## MCP Servers

## Lists of MCP Servers
- https://github.com/punkpeye/awesome-mcp-servers
- https://github.com/wong2/awesome-mcp-servers

## Filesystem MCP Server Integration
- https://github.com/modelcontextprotocol/servers/tree/main/src/filesystem
