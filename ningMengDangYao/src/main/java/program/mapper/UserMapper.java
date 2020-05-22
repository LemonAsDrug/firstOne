package program.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import program.entity.user;


@Mapper
public interface UserMapper extends BaseMapper<user> {
}
