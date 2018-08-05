package com.freemarker.util;

import com.freemarker.bean.Resume;
import freemarker.template.Configuration;

public class FreemarkerConfig {

	private static Configuration configuration = null;

	static {
		configuration = new Configuration(Configuration.VERSION_2_3_0);
		configuration.setDefaultEncoding("UTF-8");

		configuration.setClassForTemplateLoading(Resume.class, "/com/freemarker/template");
		// configuration.setTemplateLoader(new FileTemplateLoader(new
		// File("F:/temp/")));
	}

	public static Configuration getConfiguation() {
		return configuration;
	}

}
