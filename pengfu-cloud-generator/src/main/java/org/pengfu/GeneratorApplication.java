package org.pengfu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.TemplateType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/29 19:35
 */
public class GeneratorApplication {

    private static final String URL
            = "jdbc:mysql://127.0.0.1:3306/pengfu-cloud?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, "root", "root")
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("PrideZH") // 设置作者名
                            .enableSwagger() // 启用Swagger
                            .outputDir(System.getProperty("user.dir") + "/pengfu-cloud-generator/src/main/java") // 指定输出目录
                            .disableOpenDir(); // 不打开资源管理器
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("org.pengfu") // 设置父包名
                            .entity("domain.po"); // 实体层名称
                })
                // 策略配置
                .strategyConfig((scanner, builder) -> {
                    builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                            // Service策略
                            .serviceBuilder()
                            .formatServiceFileName("%sService");
                })
                // 模板配置
                .templateConfig(builder -> {
                    builder.disable(TemplateType.XML, TemplateType.SERVICE_IMPL); // 禁用XML文件和Service类
                })
                .execute();
    }

    /**
     * 处理 all 情况
     */
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

}
