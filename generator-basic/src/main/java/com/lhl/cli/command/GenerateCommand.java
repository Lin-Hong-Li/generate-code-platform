package com.lhl.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.lhl.generator.MainGenerator;
import com.lhl.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Data
@CommandLine.Command(name = "generate",description = "生成文件", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {
    /**
     * 作者
     */
    @CommandLine.Option(names = { "-a", "--author"}, description = "作者名称", arity = "0..1", interactive = true, prompt = "请输入作者名称：")
    private String author = "lhl";

    /**
     * 输出信息
     */
    @CommandLine.Option(names = { "-o", "--outputText"}, description = "输出结果", arity = "0..1", interactive = true, prompt = "请输入输出结果：")
    private String outputText = "输出结果";

    /**
     * 是否循环
     */
    @CommandLine.Option(names = { "-l", "--loop"}, description = "是否循环", arity = "0..1", interactive = true, prompt = "是否循环：")
    private boolean loop;

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
