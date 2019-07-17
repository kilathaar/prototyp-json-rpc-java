package se.kilathaar.prototype.json_rpc;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class DTO {
    public String identity;
    public String command;
    public List<Object> parameters;

    public DTO() {
    }

    public DTO(String identity, String command, List<Object> parameters) {
        this.identity = identity;
        this.command = command;
        this.parameters = parameters;
    }
}
