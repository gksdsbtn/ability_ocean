package com.sindorim.abilityocean.result;
// Referenced classes of package kr.tengs.ktw.result:
//            Header

public class JsonResult
{

    public JsonResult()
    {
        header = new Header();
    }

    public Header getHeader()
    {
        return header;
    }

    public void setHeader(Header header)
    {
        this.header = header;
    }

    public Object getBody()
    {
        return body;
    }

    public void setBody(Object body)
    {
        this.body = body;
    }

    private Header header;
    private Object body;
}
