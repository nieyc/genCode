<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC
        "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package_name}.dao.${table_name}Dao">

    <resultMap id="${table_name}Map" type="${package_name}.pojo.${table_name}">

        <#if model_column?exists>
            <#list model_column as model>
                <result property = "${model.changeColumnName?uncap_first}" column = "${model.columnName}"/>
            </#list>
        </#if>

    </resultMap>


    <insert id="add${table_name}" parameterType="${package_name}.pojo.${table_name}" >
        insert into ${table_name_small}(
        <#assign insertField>
         <#if model_column?exists>
             <#list model_column as model>
               ${model.columnName},
             </#list>
         </#if>
        </#assign>
    ${insertField?substring(0, insertField?last_index_of(","))}
        )values(
        <#assign insertJavaField>
         <#if model_column?exists>
             <#list model_column as model>
                 ${"#"}{${model.changeColumnName?uncap_first}},
             </#list>
         </#if>
        </#assign>
    ${insertJavaField?substring(0, insertJavaField?last_index_of(","))}
        )
    </insert>

    <update id="update${table_name}ById" parameterType="${package_name}.pojo.${table_name}">
        update  ${table_name_small} set
          <#assign updateField>
              <#if model_column?exists>
              <#list model_column as model>
                  ${model.columnName}=  ${"#"}{${model.changeColumnName?uncap_first}},
              </#list>
            </#if>
          </#assign>
       ${updateField?substring(0, updateField?last_index_of(","))}
        WHERE id = ${"#"}{id}
    </update>

    <delete id="delete${table_name}ById" parameterType="String" >
        delete from  ${table_name_small}  where id=${"#"}{id}
    </delete>

    <select id="get${table_name}ById" parameterType="String"  resultMap="${table_name}Map">
        select * from ${table_name_small} where id=${"#"}{id}
    </select>

    <select id="get${table_name}List"   resultMap="${table_name}Map">
    select * from ${table_name_small}
   </select>


    <select id="get${table_name}Count"   resultClass="int">
        select count(*) from ${table_name_small}
    </select>



</mapper>