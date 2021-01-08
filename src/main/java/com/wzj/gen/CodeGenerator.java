package com.wzj.gen;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.java.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器
 */
@Log
public class CodeGenerator {

    /** 项目存储位置 */
    public static String PROJECT_GENERATE_DISK = "/Users/wzj/work/temp/java/code-2";
    /** 包名 */
    public static String PARENT_PACKAGE_NAME = "com.yizu.obcase.modules";
    /** 包名 */
    public static String PACKAGE_NAME = "website";
    /** 数据库地址 */
    //public static String DB_URL = "jdbc:mysql://192.168.31.150:3306/obcase-dev?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
    public static String DB_URL = "jdbc:mysql://localhost:3306/obcase-bak?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
    /** 数据库实例名 */
    public static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    /** 数据库用户 */
    public static String USER = "root";
    /** 数据库密码 */
    //public static String PASSWORD = "Yizu#12345";
    public static String PASSWORD = "123456";
    /** 数据库schema */
    //public static String SCHEMA = "obcase-dev";
    public static String SCHEMA = "obcase-bak";
    /** 要查询的表名 */
    public static String[] TABLE_NAMES = new String[]{"t_act_boxfighting_box"};
    /** 表名前缀 */
    public static String[] TABLE_PREFIXS = new String[]{"t_act", "t_", "sys_", "biz_"};
    /** 创建人 */
    public static String AUTHOR = "wangzj";
    /** 是否强制带上注解 */
    public static boolean ENABLE_TABLE_FIELD_ANNOTATION = false;
    /** 生成的注解带上IdType类型 */
    public static IdType TABLE_IDTYPE = null;
    /** 生成的Service 接口类名是否以I开头 默认是以I开头  user表 -> IUserService, UserServiceImpl */
    public static boolean SERVICE_CLASS_NAME_START_WITHI = false;
    /** 是否使用Swagger */
    public static boolean ENABLE_SWAGGER = false;

    /**
     * 全局配置
     */
    private static GlobalConfig GlobalGenerate() {
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)// 不需要ActiveRecord特性的请改为false
                .setIdType(TABLE_IDTYPE)
                .setEnableCache(false)// XML 二级缓存
                .setAuthor(AUTHOR)
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(false)// XML columList
                .setOutputDir(PROJECT_GENERATE_DISK + File.pathSeparator + "java" )
                .setFileOverride(true)
                .setControllerName("%sController" );//自定义文件命名，注意 %s 会自动填充表实体属性！

        if (!SERVICE_CLASS_NAME_START_WITHI) {
            config.setServiceName("%sService" );
        }
        return config;
    }

    /**
     * 数据源配置
     */
    private static DataSourceConfig DaoSourceGenerate() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        DbType type = DbType.MYSQL;
        dataSourceConfig.setDbType(type)//数据库类型
                .setUrl(DB_URL)//数据库地址
                .setUsername(USER)//数据库用户名
                .setPassword(PASSWORD)//数据库密码
                .setDriverName(DRIVER_CLASS_NAME)//实例名
                .setSchemaName(SCHEMA);
        return dataSourceConfig;
    }

    /**
     * 策略配置
     */
    private static StrategyConfig StrategyGenerate() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setVersionFieldName("version")
                .setCapitalMode(true)// 全局大写命名 ORACLE 注意
                .setEntityLombokModel(false)
                .setRestControllerStyle(true) // controller使用@RestController注解
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                .entityTableFieldAnnotationEnable(ENABLE_TABLE_FIELD_ANNOTATION)
                .setTablePrefix(TABLE_PREFIXS) // 此处可以修改为您的表前缀
                .setInclude(TABLE_NAMES) //修改替换成你需要的表名，多个表名传数组
                .setEntityColumnConstant(false)// 【实体】是否生成字段常量（默认 false）public static final String ID = "test_id";
                .setEntityBuilderModel(true);// 【实体】是否为构建者模型（默认 false）public User setName(String name) {this.name = name; return this;}
        return strategyConfig;
    }

    /**
     * 自定义模板配置
     */
    private static TemplateConfig TemplateGenerate() {
        TemplateConfig templateConfig = new TemplateConfig()
                .setController("/vm/controller.java" )
                .setService("/vm/service.java" )
                .setServiceImpl("/vm/serviceImpl.java" )
                .setMapper("/vm/mapper.java" )
                .setEntity("/vm/entity.java")
                .setXml("/vm/xml");
        return templateConfig;
    }

    private static final String MODULE_NAME = "sysRoleMenu";

    private static final String CLASS_NAME = "SysRoleMenu";

    private static final String class_name = "sysRoleMenu";

    /**
     * 自定义文件及key
     */
    private static InjectionConfig FileGenerate() {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {//自定义参数
                Map<String, Object> map = new HashMap<String, Object>();
                //这些自定义的值在vm模板的语法是通过${cfg.xxx}来调用的。
                map.put("moduleName", MODULE_NAME);
                map.put("ClassName", CLASS_NAME);
                map.put("className", class_name);
                map.put("packageName", PARENT_PACKAGE_NAME + "." + PACKAGE_NAME);
                map.put("author", AUTHOR);
                map.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

                map.put("entityLombokModel", true);
                map.put("enableSwagger", ENABLE_SWAGGER);
                this.setMap(map);
            }
        };
        return injectionConfig;
    }

    /**
     * 包配置
     */
    public static PackageConfig PackageGenerate() {
        PackageConfig pc = new PackageConfig()
                .setParent(PARENT_PACKAGE_NAME)
                .setModuleName(PACKAGE_NAME)
                .setController("controller")
                .setEntity("entity")
                .setMapper("dao")
                .setXml("mapper");
        return pc;
    }

    public static void main(String[] args) {
        //全局配置
        GlobalConfig config = GlobalGenerate();
        //配置数据源
        DataSourceConfig dataSourceConfig = DaoSourceGenerate();
        //配置策略
        StrategyConfig strategyConfig = StrategyGenerate();
        //配置模板
        TemplateConfig templateConfig = TemplateGenerate();
        //自定义值
        InjectionConfig injectionConfig = FileGenerate();
        //配置包
        PackageConfig packageConfig = PackageGenerate();
        //生成代码
        new AutoGenerator().setGlobalConfig(config)
                .setTemplate(templateConfig)//自定义模板路径
                .setCfg(injectionConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .execute();
    }
}
