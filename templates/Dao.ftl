package ${package_name}.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import ${package_name}.pojo.${table_name};

@Repository
public interface ${table_name}Dao {

	public List<${table_name}> get${table_name}List();

    public ${table_name} get${table_name}ById(String id);

    public void add${table_name}(${table_name} ${table_name_obj});

    public void update${table_name}(${table_name} ${table_name_obj});

    public void delete${table_name}ById(String id);

    public int  get${table_name}Count();

    }