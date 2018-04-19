语法规则：基本与el差不多 ${}


<!--freemarker-->
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
             <version>2.3.23</version>
        </dependency>



1.对于pojo与el一致，${student.name}

2.对于List元素，<#list 集合名 as 循环变量>(<#list studentList student>)  =>  ${student.name}

3.
