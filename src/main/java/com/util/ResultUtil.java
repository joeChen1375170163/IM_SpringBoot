package com.util;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil {
	/**
	 * ajax返回成功编码
	 */
	public static final String AJAX_RESULT_CODE = "code";
	/**
	 * ajax返回成功编码
	 */
	public static final String AJAX_RESULT_CODE_SUCCESS = "20000";
	/**
	 * ajax返回失败编码
	 */
	public static final String AJAX_RESULT_CODE_FAIL = "500";

	/**
	 * ajax返回编码
	 */
	public static final String AJAX_RESULT_MSG = "msg";
	/**
	 * ajax返回数据编码
	 */
	public static final String AJAX_RESULT_DATA = "data";

	/**
	 * ajax操作成功提示信息
	 */
	public static final String AJAX_RESULT_MSG_SUCCESS = "操作成功!";
	/**
	 * ajax操作失败提示信息
	 */
	public static final String AJAX_RESULT_MSG_FAIL = "操作失败，请重试！";

	/**
	 * AJAX处理失败 返回错误信息
	 *
	 * @return
	 */
	public static Map<String, Object> failResult(Object o) {
		Map result = new HashMap();
		result.put(AJAX_RESULT_CODE, AJAX_RESULT_CODE_FAIL);
		result.put(AJAX_RESULT_DATA, o);
		return result;
	}

	/**
	 * AJAX处理失败 返回错误信息
	 *
	 * @param errorMessage
	 * @return
	 */
	public static Map<String, Object> failResult(String errorMessage) {
		Map result = new HashMap();
		result.put(AJAX_RESULT_CODE, AJAX_RESULT_CODE_FAIL);
		result.put(AJAX_RESULT_MSG, errorMessage);
		return result;
	}

	/**
	 * AJAX处理失败
	 *
	 * @return
	 */
	public static Map<String, Object> failResult() {
		Map result = new HashMap();
		result.put(AJAX_RESULT_CODE, AJAX_RESULT_CODE_FAIL);
		result.put(AJAX_RESULT_MSG, AJAX_RESULT_MSG_FAIL);
		return result;
	}

	/**
	 * AJAX处理成功 返回成功信息
	 *
	 * @param o
	 * @param successMessage
	 * @return
	 */
	public static Map<String, Object> successResult(Object o, String... successMessage) {
		Map result = new HashMap();
		result.put(AJAX_RESULT_CODE, AJAX_RESULT_CODE_SUCCESS);
		result.put(AJAX_RESULT_MSG, successMessage);
		result.put(AJAX_RESULT_DATA, o);
		return result;
	}

	/**
	 * AJAX处理成功 返回成功信息
	 *
	 * @param o
	 * @param successMessage
	 * @return
	 */
	public static Map<String, Object> successResult(Object o, String successMessage) {
		Map result = new HashMap();
		result.put(AJAX_RESULT_CODE, AJAX_RESULT_CODE_SUCCESS);
		result.put(AJAX_RESULT_MSG, successMessage);
		result.put(AJAX_RESULT_DATA, o);
		return result;
	}

	/**
	 * AJAX处理成功
	 *
	 * @param o
	 * @return
	 */
	public static Map<String, Object> successResult(Object o) {
		Map result = new HashMap();
		result.put(AJAX_RESULT_CODE, AJAX_RESULT_CODE_SUCCESS);
		result.put(AJAX_RESULT_MSG, AJAX_RESULT_MSG_SUCCESS);
		result.put(AJAX_RESULT_DATA, o);
		return result;
	}

	public static BaseResponseVO<String> successWithMsg(String data) {
		BaseResponseVO<String> result = new BaseResponseVO<>();
		result.setCode(AJAX_RESULT_CODE_SUCCESS);
		result.setMsg(AJAX_RESULT_MSG_SUCCESS);
		result.setData(data);
		return result;
	}

	public static BaseResponseVO<String> failedWithMsg(String msg) {
		BaseResponseVO<String> result = new BaseResponseVO<>();
		result.setCode(AJAX_RESULT_CODE_FAIL);
		result.setMsg(msg);
		return result;
	}

	public static BaseResponseVO<String> failed(String data) {
		BaseResponseVO<String> result = new BaseResponseVO<>();
		result.setCode(AJAX_RESULT_CODE_FAIL);
		result.setMsg(AJAX_RESULT_MSG_FAIL);
		result.setData(data);
		return result;
	}
}
