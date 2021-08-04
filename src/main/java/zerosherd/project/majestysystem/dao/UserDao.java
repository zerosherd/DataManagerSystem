package zerosherd.project.majestysystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import zerosherd.project.majestysystem.pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserDao {

    public static int id;
    private static HashMap<Integer, User> users = new HashMap<Integer, User>();
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private User user = new User();

    public HashMap<Integer, User> getAllUsers() {
        String sql = "select * from User";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        for (int i = 0; i < list_maps.size(); i++) {
            User userInfo = new User();
            userInfo.setId(Integer.valueOf((Integer) list_maps.get(i).get("id")));
            userInfo.setChineseName((String) list_maps.get(i).get("chineseName"));
            userInfo.setEmail_login_name((String) list_maps.get(i).get("email_login_name"));
            userInfo.setEmailpassword((String) list_maps.get(i).get("emailpassword"));
            userInfo.setAuthority((String) list_maps.get(i).get("authority"));
            userInfo.setIfVIP((Boolean) list_maps.get(i).get("ifVIP"));
            users.put(i, userInfo);
        }
        return users;
    }

    public Boolean isValidUser(String username, String password) {
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);

        for (int i = 0; i < list_maps.size(); i++) {
            User user = new User();
            String a = (String) list_maps.get(i).get("email_login_name");
            String b = (String) list_maps.get(i).get("emailpassword");
            Integer c = (Integer) list_maps.get(i).get("id");
            if (a.equals(username) && b.equals(password)) {
                this.id = c;
                return true;
            }
        }
        return false;
    }
}
