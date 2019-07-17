package se.kilathaar.prototype.json_rpc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class JsonRpcRunnable implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(JsonRpcRunnable.class);

    private final Socket socket;

    JsonRpcRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        LOG.info("Ansluten: {}", socket);

        ObjectMapper objectMapper = new ObjectMapper();

        try (var in = new Scanner(socket.getInputStream());
             var out = new PrintWriter(socket.getOutputStream(), true)) {
            while (in.hasNextLine()) {
                Request request = objectMapper.readValue(in.nextLine(), Request.class);

                Response response = null;
                if (request.method.equals("echo")) {
                    response = new EchoEndpoint().process(request);
                }
                objectMapper.writeValue(out, response);
            }
        } catch (Exception e) {
            LOG.error("Error: {}", socket, e);
        }
    }
}
