package se.kilathaar.prototype.json_rpc;

import java.util.List;

@SuppressWarnings("WeakerAccess")
class Request {
    public String id;
    public String method;
    public List<String> params;
    public String jsonrpc;

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", method='" + method + '\'' +
                ", params=" + params +
                ", jsonrpc='" + jsonrpc + '\'' +
                '}';
    }
}
