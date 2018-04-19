语法规则：基本与el差不多 ${}


<!--freemarker-->
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
             <version>2.3.23</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>



1.对于pojo与el一致，${student.name}

2.对于List元素，<#list 集合名 as 循环变量>(<#list studentList as student>)  =>  ${student.name}

3.对已List元素，取下标<student_index>,0开始

4.<#if student_index % 2 ==0> 语句  <#else>  语句 </#if>

5.对于传进来的是日期类型${student.birthday?date}  date可以换成time|datetime

6.若想自定义日期类型${student.birthday?string("yyyy/MM/dd HH:mm:ss")}

7.对于null值${student.name!} 若想设置默认值${student.name!"这是空值"}

8.引入模板<#include "模板名称">


#与spring整合文件：https://github.com/SuperCourierYangyufan/e3/blob/master/e3-item-web/src/main/resources/spring/springmvc.xml

#详细代码：https://github.com/SuperCourierYangyufan/e3/blob/master/e3-item-web/src/main/java/cn/e3/item/Listener/HtmlGenLisener.java

#ftl文件：

后续思路：将生成的文件统一放置，将css.js.image文件放入生成的html的文件目录上级。在将nginx开启，设置默认路径为该目录下。在代码流程下，controller模块中  return "redirect:123.206.32.230/item/123456789.html";

