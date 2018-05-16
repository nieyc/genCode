package ${package_name}.sei;

import java.util.List;
import ${package_name}.pojo.${table_name};

public interface  I${table_name}Service {

	/**
	 * 查询所有记录
	 * @author nyc
	 * @date ${date}
	 * @return 
	 * @since 0.1
	 * @see
	 */
	public List<${table_name}> get${table_name}List();

    /**
    *根据Id获取对象
    * @author nyc
    * @date ${date}
    * @param id
    * @return 
    * @since 0.1
    * @see
    */
    public ${table_name} get${table_name}ById(String id);


   /**
    *增加
    * @author nyc
    * @date ${date}
    * @param id
    * @return 
    * @since 0.1
    * @see
    */
    public void add${table_name}(${table_name} ${table_name_obj});

    /**
    *修改
    * @author nyc
    * @date ${date}
    * @param
    * @return 
    * @since 0.1
    * @see
    */
    public void update${table_name}(${table_name} ${table_name_obj});


    /**
    *删除
    * @author nyc
    * @date ${date}
    * @param id
    * @return 
    * @since 0.1
    * @see
    */
   public void delete${table_name}ById(String id);


   /**
    *获取所有记录
    * @author nyc
    * @date ${date}
    * @return 
    * @since 0.1
    * @see
    */
   public int  get${table_name}Count();


   }
