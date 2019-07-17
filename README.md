# Prototyp: JSON RPC-Server

Prototyp för att demonstrera kommunikation via socket över protokollet [JSON RPC](https://www.jsonrpc.org/specification).
Jag har *"hittat på"* kommandot `echo` som returnerar första parametern.

## Starta server via Gradle
`gradle run`

## Starta server via docker-compose
1. `gradle build jar`
1. `docker build -t kilathaar/server .; docker system prune -f`
1. `docker-compose up`

## Kommunicera med server
Ubuntu har en generell TCP/UDP-klient som heter nc man kan använda som klient mot SocketServer.

Klistra in andra raden nedan som är en request och servern svarar med tredje raden som är ett response.

```bash
$ nc 127.0.0.1 56789
{"id":"1","method":"echo","params":["Hello world!"],"jsonrpc":"2.0"}
{"id":"1","result":"Hello world!","jsonrpc":"2.0"}
```

