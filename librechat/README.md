# LibreChat

Running [LibreChat](https://github.com/danny-avila/LibreChat) locally, with MCP servers. See the [documentation](https://www.librechat.ai/docs)

## Configuration Files

- `.env` file with the API keys, based on [LibreChat .env.example](https://github.com/danny-avila/LibreChat/blob/main/.env.example) - however, your file needs to be called ".env"
- `docker-compose.yml` is simply a copy of [LibreChat docker-compose.yml](https://github.com/danny-avila/LibreChat/blob/main/docker-compose.yml) - do not modify this file
- `docker-compose.override.yml` is an override to load the LibreChat config file in the default expected location - you can also use it to run any Docker containers that provide non-stdio MCP servers
- `librechat-config.yaml` is additional LibreChat configuration, and can be used to specify MCP servers among other things

## Run LibreChat Locally

### Modify Configuration

- Create your own `.env` file with the API keys
- Edit `docker-compose.override.yml` to bind your directories and add any other configuration
  (the filesystem MCP server was not respecting case sensitivity in my directory names, confusing the AI model)
- Edit `librechat-config.yaml` to use the target paths in the args. Optionally, get rid of the Obsidian MCP server.

### Start LibreChat

1. Change (cd) to the "librechat" folder
2. Start containers:
  ```sh
  docker compose \
    -f docker-compose.yml \
    -f docker-compose.override.yml \
    up -d
  ```
  To shut-down, run the same Docker Compose command with `down -t0` insted of `up -d`.
3. Start a browser
  1. Go to [localhost:3080](http://localhost:3080) in your browser, create an account and sign in.
  2. In a new conversation switch from OpenAI/ Anthropic/ etc. to Agents.
  3. Reveal the right sidebar and select Agent Builder.
  4. Give the agent a name and select your model of choice.
  5. Under tools and actions, click Add Tools.
  6. You should have a few pages of tools which include the tools provided by the MCP server(s) that were added. Make sure to add all desired and relevant tools!
  7. Save the agent.
  Now you should be able to select this agent in a conversation and prompt it.



## Notes

### Notes
- The MCP server stdio protocol does not need to keep the server running at all times
- If running an MCP server in Docker, this cannot be done as an command, since that would mean that the Docker container would need to run within the LibreChat container, which is not possible or desired

### Lists of MCP Servers
- [punkpeye/awesome-mcp-servers](https://github.com/punkpeye/awesome-mcp-servers)
- [wong2/awesome-mcp-servers](https://github.com/wong2/awesome-mcp-servers)

### Filesystem MCP Server Integration
- [modelcontextprotocol/servers/filesystem code](https://github.com/modelcontextprotocol/servers/tree/main/src/filesystem)
