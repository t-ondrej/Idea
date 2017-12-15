package sk.upjs.ics.errorhandling;

public class ErrorMessage {

    private int status;
    private String error;

    public ErrorMessage(int status, String error) {
        this.status = status;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}