package com.du.feheadstudio.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/6 16:02
 */
@Configuration
@MapperScan("com.du.feheadstudio.mapper")
public class MysqlConfig {
}
