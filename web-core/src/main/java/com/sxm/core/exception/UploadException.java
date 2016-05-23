/*
 * 
 *
 * 
 */
package com.sxm.core.exception;

/**
 * 文件上传异常.
 * 
 * @author sxm
 * @version 2013-6-26
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2013-6-26
 */
public class UploadException extends SystemException {

	private static final long serialVersionUID = 3108425277661334216L;

	public UploadException() {
		super("文件上传失败!");
	}

	public UploadException(String message) {
		super(message + "文件上传失败!");
	}

	public UploadException(Throwable cause) {
		super("文件上传失败!", cause);
	}

	public UploadException(String message, Throwable cause) {
		super(message + "文件上传失败!", cause);
	}

}
