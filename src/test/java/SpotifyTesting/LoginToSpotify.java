package SpotifyTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToSpotify extends BaseTestS {

    @Test
    public void logIn_toSpotify_correctCredentials() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username, password);
        Assert.assertTrue(mainPageS.isHome());
    }

    @Test
    public void logIn_toSpotify_incorrectCredentials() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username, "asdasd");
        Assert.assertTrue(loginToPageS.isError());
    }

    @Test
    public void logout_fromSpotify_successfully() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username, password);
        loginToPageS.logOut();
        Assert.assertTrue(mainPageS.isLogOut());
    }

    @Test
    public void search_theSong_andPlayIt_successfully() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username, password);
        loginToPageS.playTheSong("STAY");
    }

    @Test
    public void delete_thePlayList_Successfully() { //It worked successfully!
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username, password);
        loginToPageS.deletePlayList();
    }

    @Test
    public void play_podcast() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username, password);
        loginToPageS.PlayPodcast();
    }

    @Test
    public void search_ufc_inGoogle() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.google();
        loginToPageS.googleSearch("ufc.com");
    }

    @Test
    public void ufc_search_inGoogle1() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.google();
        loginToPageS.googleSearch1("ufc.com");
        Assert.assertTrue(loginToPageS.isMainEvent());
    }

    @Test
    public void ufc_search_inGoogle2() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.google();
        loginToPageS.googleSearch2("ufc.com", "When's the next UFC event?");
        Assert.assertTrue(loginToPageS.searchResult());
    }

    @Test
    public void ufc_search_inGoogle3() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.google();
        loginToPageS.googleSearch3("ufc.com");
        Assert.assertTrue(loginToPageS.isRead());
    }

    @Test
    public void ufc_search_inGoogle4() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.google();
        loginToPageS.googleSearch4("ufc.com");
    }

    @Test
    public void ufc_search_inGoogle5() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.google();
        loginToPageS.ufcTest("ufc.com", "When's the next UFC event?");
        Assert.assertTrue(loginToPageS.searchResult());
    }

    @Test
    public void ufc_Search_Website1() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.ufc();
        loginToPageS.ufcSearch();
        Assert.assertTrue(loginToPageS.filters());
    }

    @Test
    public void ufc_Search_Website2() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.ufc();
        loginToPageS.ufcSearch2();
    }
    @Test
    public void ufc_Search_Website3() { // logged in and refreshed the page!
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.ufc();
    }
    @Test
    public void ufc_Search_Website4() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.ufc();
        loginToPageS.ufcSearch4();
    }

    @Test
    public void ufc_Search_Website5() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.ufc();
        loginToPageS.ufcSearch5();
        Assert.assertTrue(loginToPageS.imageFightPass());
    }
    @Test
    public void ufc_Search_Website6() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.ufc();
        loginToPageS.ufcSearch6("What is Conor McGregor's reach?");
        Assert.assertTrue(loginToPageS.viewAll());
    }

}



