# Instructions

## Tweak configuration files

Edit `docker-compose.override.yml` to bind your directories.
(I think the MCP server was not respecting case sensitivity in my dir names, confusing my model).

Edit `librechat.yaml` to use the target paths in the args. Optionally, get rid of the Obsidian MCP server.

## Start LibreChat

Start containers:
```sh
docker compose -f docker-compose.yml -f docker-compose.override.yml up -d
```

## Configuring in browser

1) Go to http://localhost:3080 in your browser and sign in.
2) In a new conversation switch from OpenAI/Anthropic/etc. to Agents
3) Reveal the right sidebar and select Agent Builder
4) Give the agent a name and select your model of choice
5) Under tools and actions, click Add Tools.
6) You should have a few pages of tools which include the tools provided by the MCP server(s) that were added. Make sure to add all desired and relevant tools!
7) Save the agent!

Now you should be able to select this agent in a conversation and prompt it.

