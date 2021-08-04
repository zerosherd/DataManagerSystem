package zerosherd.project.majestysystem.pojo;

import lombok.*;


@Data
@AllArgsConstructor // 无参构造
@NoArgsConstructor  // 有参构造
@Getter//获取
@Setter//设置
public class User {
    private Integer id;
    private String chineseName;
    private String email_login_name;
    private String emailpassword;
    private String authority;
    private Boolean ifVIP;
}
