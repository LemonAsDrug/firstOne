//ppackage chong.web.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import javax.servlet.http.HttpServletResponse;
//
//@Configuration
//public class MyConfiguration {
//
//    @Bean
//    public HttpServletResponse HttpServletResponse(HttpServletResponse response){
//
//        // 允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加'/'
//        response.setHeader("Access-Control-Allow-Origin", "http://192.168.1.39");
//
//        // 允许前端带认证cookie：启用此项后，上面的域名不能为'*'，必须指定具体的域名，否则浏览器会提示
//        response.setHeader("Access-Control-Allow-Credentials", "true");
////        response.setHeader("Access-Control-Allow-Credentials","false");
//
//        // 提示OPTIONS预检时，后端需要设置的两个常用自定义头
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
//        return response;
//    }
//}