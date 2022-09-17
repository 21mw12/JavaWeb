package com.MW.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.Writer;

public class ThymeleafUtil {
    private static final TemplateEngine engine;
    static  {
        engine = new TemplateEngine();
        ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
        r.setCharacterEncoding("UTF-8");  // 解决中文乱码问题
        engine.setTemplateResolver(r);
    }

    public static void process(String template, IContext context, Writer writer) {
        engine.process(template, context, writer);
    }
}
