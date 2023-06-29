package dev.project.backend.dto;

public class Message {
    private String text;
    private int status;

    public Message(){}

    public Message(String text, int status) {
        this.status = status;
        this.text = text;
    }
    public void set(String text, int status) {
        this.text = text;
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
