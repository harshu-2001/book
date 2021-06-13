package com.example.book;

public class LoginRecieve {
    private String responseCode;
    private String message;
    private String token;

    public LoginRecieve(String responseCode,String message,String token){
        this.responseCode=responseCode;
        this.message=message;
        this.token=token;


    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
    public String toprint(){
        String str="responseCode:"+responseCode.toString()+"\nmessage:"+message.toString()+"\ntoken:"+token.toString();

        return str;
    }
}
