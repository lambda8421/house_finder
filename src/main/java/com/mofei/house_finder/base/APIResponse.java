package com.mofei.house_finder.base;

public class APIResponse {

    private int code;
    private String message;
    private Object data;
    private boolean more;

    public APIResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    public APIResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static APIResponse ofMessage(int code, String message){
        return new APIResponse(code,message,null);
    }

    public static APIResponse ofSuccess(Object data){
        return new APIResponse(Status.SUCCESS.getCode(),
                Status.SUCCESS.getStandardMessage(),data);
    }

    public static APIResponse ofStatus(Status status){
        return new APIResponse(Status.SUCCESS.getCode(),
                Status.SUCCESS.getStandardMessage(),null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public enum Status{
        SUCCESS(200,"OK"),
        BAD_REQUEST(400,"Bad Request"),
        NOT_FOUND(404,"Not Found"),
        INTERAL_SERVER_ERRO(500,"INTERAL_SERVER_ERRO"),
        NOT_VALID_PARAM(40005,"NOT_VALID_PARAM"),
        NOT_SUPPORTED_OPERATION(40006,"NOT_SUPPORTED_OPERATION"),
        NOT_LOGIN(50000,"NOT_LOGIN");

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }

}
