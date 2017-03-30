package com.aotu.exception;

public class OperationErrorException extends RuntimeException {	

	private static final long serialVersionUID = -89966695248875908L;

	public OperationErrorException(){
		super("操作异常");
	}
    public OperationErrorException(String msg)
    {
        super(msg);
    }

    public OperationErrorException(String msg,Exception ex)
    {
        super(msg+"\r\n"+ex.getMessage());
    }
}
