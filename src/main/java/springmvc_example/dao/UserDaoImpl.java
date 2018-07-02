package springmvc_example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import springmvc_example.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<User> listAllUsers() {
        String sql = "select user_id, name, surname, mail from user";

        List<User> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());

        return null;
    }

    private SqlParameterSource getSqlParameterByModel(User user) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        if(user != null) {
            paramSource.addValue("user_id", user.getUser_id());
            paramSource.addValue("name", user.getName());
            paramSource.addValue("surname", user.getSurname());
            paramSource.addValue("mail", user.getMail());
        }
        return paramSource;
    }

    private static final class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs,int rowNum) throws SQLException {
            User user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setMail(rs.getString("mail"));
            return user;
        }
    }

    public void addUser(User user) {
        String sql = "insert into user(name, surname, mail) values(:name, :surname, :mail);";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
    }

    public void updateUser(User user) {
        String sql = "update user set name = :name, surname = :surname, mail = :mail where id = :id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
    }

    public void deleteUser(int id) {
        String sql = "delete from user where id = :id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new User(id)));
    }

    public User findUserById(int id) {
        String sql = "select * from user where id = :id";

        return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new User(id)), new UserMapper());
    }
}
