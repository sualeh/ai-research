# Animate the UI

> Docker Image: ghcr.io/anthropics/anthropic-quickstarts:computer-use-demo-latest

1. Get API key from  https://console.anthropic.com/dashboard
2. In Docker terminal:
```sh
docker run -e ANTHROPIC_API_KEY=<insert-api_key> -v $HOME/.anthropic:/home/computeruse/.anthropic -p 5900:5900 -p 8501:8501 -p 6080:6080 -p 8080:8080 -it ghcr.io/anthropics/anthropic-quickstarts:computer-use-demo-latest
```
Or, start it using Docker compose:
  `docker-compose -f anthropic-computer-use-demo.yaml up -d`
3. Once the container is running simply navigate to http://localhost:8080 and give your instructions


Here are some sample instructions:
"Open Onbe's website, https://www.onbe.com/, and get support. You will get a customer service request form. Fill it out for Sal Fatuous, 123 Main St, Concord, NH. Do not submit the form. Detect and report on any errors, which will be shown as messages in red."
