import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qgzx.entity.Job;
import com.qgzx.mapper.JobMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/17 18:04
 * @modified By:
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QgzxApplaicationTest {
    // 测试分页查询
    @Resource
    JobMapper jobMapper;
    @Test
    public void testPage(){
        // 参数一：当前页
        // 参数二：页面大小
        Page<Job> page = new Page<>(1,1);
        jobMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }
}
