package com.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseResponseVO<T> implements Serializable {

	private String code;
	private String msg;
	private T data;

	public BaseResponseVO (String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
