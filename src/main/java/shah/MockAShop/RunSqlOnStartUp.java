package shah.MockAShop;

import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

@Component
public class RunSqlOnStartUp {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void runNativeSql() {
        ClassPathResource resource = new ClassPathResource("../../resources/custom-query.sql");
        try(Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, resource);
        } catch (SQLException | ScriptException e) {
            //LOG
        }
    }
}