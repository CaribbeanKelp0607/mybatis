import model.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtil;

import java.util.List;

public class UserTest {

    SqlSession sqlSession ;
    @Test
    public void insertPerson(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 12;
        String userName = "test_12";
        int age = 18;
        String mobilePhone = "18000000000";
        Person person = new Person();
        person.setId(id);
        person.setAge(age);
        person.setUserName(userName);
        person.setMobilePhone(mobilePhone);
        try{
            sqlSession.insert("insertPerson",person);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 10000;
        try{
            Person person = sqlSession.selectOne("queryById",id);

//            sqlSession.commit();
            System.out.println(person.getUserName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryByUserName(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 10000;
        try{
            List<Person> persons = sqlSession.selectList("queryByUserNames","test");

//            sqlSession.commit();
            for(int i=0;i<persons.size();i++){
                System.out.println(persons.get(i).getUserName());
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }
}