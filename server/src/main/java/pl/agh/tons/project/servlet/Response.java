package pl.agh.tons.project.servlet;

/**
 * Object that is used to communicate between client and server
 */
class Response<T> {
    private boolean success;
    private String msg;
    private T content;

    public Response() {}

    public Response(T content) {
        if (content == null) {
            this.success = false;
            this.msg = "Nieprawidlowe dane uzytkownika!";
        } else {
            this.success = true;
            this.msg = "Twoje wypozyczone ksiazki:";
        }

        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
