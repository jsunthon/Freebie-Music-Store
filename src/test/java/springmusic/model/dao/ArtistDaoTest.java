package springmusic.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "ArtistDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ArtistDaoTest
        extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private ArtistDao artistDao;

    @Test
    public void getArtistsTest() {
        assert artistDao.getArtists().size() == 5;
    }

    @Test
    public void getArtistTest() {
        assert artistDao.getArtist(1).getName().equals("Bonobo");
    }

    @Test
    public void getAlbumTest() {
        assert artistDao.getArtist(1).getAlbums().size() == 2;
    }

    @Test
    public void deleteArtistTest() {
        artistDao.delete(artistDao.getArtist(1));
        assert artistDao.getArtists().size() == 4;
    }

}
