package se.kilathaar.prototype.json_rpc;

class EchoEndpoint {
    Response process(Request request) {
        Response response = new Response();
        response.id = request.id;
        response.result = request.params.get(0);
        response.jsonrpc = request.jsonrpc;

        return response;
    }
}
