package springmusic.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "TrackDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TrackDaoTest  extends AbstractTransactionalTestNGSpringContextTests{
    
    @Autowired
    private TrackDao trackDao;
    
    @Test
    public void getTracksTest() {
        assert trackDao.getTracks().size() == 12;
    }
    
    @Test
    public void getTrackTest() {
        assert trackDao.getTrack(1).getName().equals("Prelude");
    }
    
    @Test
    public void delete() {
        trackDao.delete(trackDao.getTrack(1));
    }
}
