package com.lhl.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.lhl.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.lang.reflect.Field;

@Data
@CommandLine.Command(name = "config", description = "动态文件的配置信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名：" + field.getName());
            System.out.println("字段类型：" + field.getType());
        }
    }
}
