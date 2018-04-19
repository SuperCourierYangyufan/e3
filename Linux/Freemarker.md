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

