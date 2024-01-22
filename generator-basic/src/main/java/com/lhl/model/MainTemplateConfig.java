package com.lhl.model;

import lombok.Data;

/**
 * ACM静态模板配置
 */
@Data
public class MainTemplateConfig {

    /**
     * 作者
     */
    private String author = "lhl";

    /**
     * 输出信息
     */
    private String outputText = "输出结果";

    /**
     * 是否循环
     */
    private boolean loop;
}
