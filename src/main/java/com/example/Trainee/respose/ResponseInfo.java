package com.example.Trainee.respose;

public class ResponseInfo {
	private int status;
    private String acknowledgement;
    private String message;
    private String path;
 
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getAcknowledgement() {
        return acknowledgement;
    }
    public void setAcknowledgement(String acknowledgement) {
        this.acknowledgement = acknowledgement;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public ResponseInfo(int status, String acknowledgement, String message, String path) {
        super();
        this.status = status;
        this.acknowledgement = acknowledgement;
        this.message = message;
        this.path = path;
    }
    @Override
    public String toString() {
        return "ResponseInfo [status=" + status + ", acknowledgement=" + acknowledgement + ", message=" + message
                + ", path=" + path + "]";
    }
}
