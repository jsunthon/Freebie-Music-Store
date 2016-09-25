package springmusic.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "AlbumDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AlbumDaoTest
        extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private AlbumDao albumDao;

    @Test
    public void getAlbumsTest1() {
        assert albumDao.getAlbums().size() == 5;
    }

    @Test
    public void getAlbumTest() {
        assert albumDao.getAlbum(1).getName().equals("Black Sands");
    }

    @Test
    public void deleteTest() {
        albumDao.delete(albumDao.getAlbum(1));
        assert albumDao.getAlbums().size() == 4;
    }
}
