package ${package_name}.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ${package_name}.pojo.${table_name};
import ${package_name}.dao.${table_name}Dao;
import ${package_name}.sei.I${table_name}Service;



@Service
public class ${table_name}ServiceImpl implements I${table_name}Service {

	@Resource
    ${table_name}Dao  ${table_name_obj}Dao;


	@Override
	public List<${table_name}> get${table_name}List() {
       return  ${table_name_obj}Dao.get${table_name}List();
    }

    @Override
    public  ${table_name} get${table_name}ById(String id) {
        return  ${table_name_obj}Dao.get${table_name}ById(id);
    }

    @Override
    public void add${table_name}(${table_name} ${table_name_obj}) {
          ${table_name_obj}Dao.add${table_name}(${table_name_obj});
    }

    @Override
    public void update${table_name}(${table_name} ${table_name_obj}) {
          ${table_name_obj}Dao.update${table_name}ById(${table_name_obj});
    }

    @Override
    public void delete${table_name}ById(String id) {
          ${table_name_obj}Dao.delete${table_name}ById(id);
    }

    @Override
    public int  get${table_name}Count() {
        return  ${table_name_obj}Dao.get${table_name}Count();
    }

    }
