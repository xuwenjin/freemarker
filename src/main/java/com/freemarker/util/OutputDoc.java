package com.freemarker.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 生成doc文件工具类
 * 
 * @author xuwenjin
 */
public class OutputDoc {

	/**
	 * 生成doc文件
	 * 
	 * @param tempName
	 *            模板文件名
	 * @param docName
	 *            生成的doc文件名
	 * @param variables
	 *            变量
	 * @return
	 */
	public static void makeDoc(String tempName, String docName, Map<String, Object> variables) {
		String output = "uploadFiles" + File.separator + new SimpleDateFormat("yyyy/MM/dd").format(new Date())
				+ File.separator;
		File f = new File(output);
		if (!f.exists()) {
			f.mkdirs();
		}
		output = (output + docName + ".doc").replaceAll("\\\\", "/");
		try {
			Configuration cfg = FreemarkerConfig.getConfiguation();
			Template temp = cfg.getTemplate(tempName + ".ftl");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(output)), "UTF-8"));
			temp.process(variables, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Map<String, Object> variables = new HashMap<>();
		variables.put("name", "张三");
		variables.put("sex", "男");
		variables.put("age", "28");
		variables.put("phone", "1234567");
		variables.put("mail", "1234567@qq.com");
		variables.put("education", "本科");
		makeDoc("resume", "xuwenjin", variables);
	}

}
