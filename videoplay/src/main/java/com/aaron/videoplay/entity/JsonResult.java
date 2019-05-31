package com.aaron.videoplay.entity;

public class JsonResult {
    private String code;

    private String msg;

    private Object data;


    public JsonResult() {
        this.setCode(ResultCode.SUCCESS);
        this.setMsg("成功！");
    }

    public JsonResult(ResultCode code) {
        this.setCode(code);
        this.setMsg(code.msg());
    }

    public JsonResult(ResultCode code, String message) {
        this.setCode(code);
        this.setMsg(message);
    }
    public JsonResult(ResultCode code, String message, Object data) {
        this.setCode(code);
        this.setMsg(message);
        this.setData(data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code.val();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
