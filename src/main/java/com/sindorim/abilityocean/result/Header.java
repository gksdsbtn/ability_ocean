
package com.sindorim.abilityocean.result;


public class Header
{

    public Header()
    {
        status = "9999";
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    private String status;
    private String message;
}
