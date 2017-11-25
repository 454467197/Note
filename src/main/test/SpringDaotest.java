import com.javalei.dao.DetailedMapper;
import com.javalei.pojo.Detailed;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SpringDaotest  extends BaseTest{

    @Autowired
    private DetailedMapper detailedMapper;

    @Test
    public  void Testselect(){

        List<Detailed> list= detailedMapper.selectDetailedList();
       // System.out.println(list.size());
        for (Detailed detailed : list) {
            System.out.println(detailed.toString());
        }
    }
}
