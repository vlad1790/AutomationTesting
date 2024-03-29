package SpotifyTesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.event.WindowAdapter;
import java.sql.Time;

public class MainPageS extends BasePageS {

    private static Logger logger = LogManager.getLogger(MainPageS.class);


    public MainPageS(WebDriver driver){
        super(driver);
    }

    public boolean isHome(){
        By homeBy = By.xpath("//*[text()='Home']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(homeBy));
            return true;
        } catch (TimeoutException err){
            return false;
        }
    }

    public boolean isLogOut(){
        By logOutBy = By.xpath("//*[text()='Log in']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(logOutBy));
            return true;
        } catch (TimeoutException err){
            return false;
        }
    }

    ////////////////////////////////////////////// create a play list and assert that it was created! It worked!

    private WebElement getPlusButton(){
        By plusButtonBy = By.xpath("(//*[@class='IconWrapper__Wrapper-sc-16usrgb-0 dlqYDF'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(plusButtonBy));
        return driver.findElement(plusButtonBy);
    }


    private WebElement getCreatePlayList(){
        logger.info("Playlist was created!");

        By createBy = By.xpath("(//*[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line PDPsYDh4ntfQE3B4duUI'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(createBy));
        return driver.findElement(createBy);
        //class="Type__TypeElement-sc-goli3j-0 jqNXli J4xXuqyaJnnwS6s2p3ZB standalone-ellipsis-one-line"
    }

    public void created(){
        getPlusButton().click();
        getCreatePlayList().click();
    }

    public boolean isCreated(){
        By createBy = By.xpath("//div[@class='os-host os-host-foreign os-theme-spotify os-host-resize-disabled os-host-scrollbar-horizontal-hidden os-host-scrollbar-vertical-hidden os-host-transition']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(createBy));
            return true;
        } catch (TimeoutException err){
            return false;
        }
    }

    ////////////////////////////////////////////// open play list -> scroll to the song and play it! It worked!
    public void openPlayList() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        By openBy = By.xpath("(//*[@class='ufICQKJq0XJE5iiIsZfj  qEiVyQ28VnOKb0LeijqL'])[1]"); //(//span[@class='vBFTtFW3Co9F_yJ_HjF4'])[7] it works
        wait.until(ExpectedConditions.visibilityOfElementLocated(openBy));
        WebElement playList = driver.findElement(openBy);
        js.executeScript("arguments[0].scrollIntoView();", playList);

        Actions actions = new Actions(driver);
        actions.doubleClick(playList).perform();

        By buttonBy = By.xpath("(//span[@class='vBFTtFW3Co9F_yJ_HjF4'])[19]"); //(//span[@class='vBFTtFW3Co9F_yJ_HjF4'])[7]
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonBy));
        WebElement button = driver.findElement(buttonBy);
        js.executeScript("arguments[0].scrollIntoView();", button);
        button.click();

        By pauseBy = By.xpath("//*[@class='vnCew8qzJq3cVGlYFXRI']");
        wait.until(ExpectedConditions.elementToBeClickable(pauseBy));
        WebElement pause = driver.findElement(pauseBy);
        pause.click();

        // Right Click
        //Actions actions = new Actions(driver);
        //WebElement elementLocator = driver.findElement(By.id("ID"));
        //actions.contextClick(elementLocator).perform();
    }
///////////////////////////////////////////////////////////////////////////////////////// It worked!
public void renamePlayList(String newName) { // It worked successfully!
    logger.trace("Play List was renamed!");
    logger.info("Created Playlist with name -> " + newName);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    By openBy = By.xpath("(//*[@class='Areas__HeaderArea-sc-8gfrea-3 fInrEV'])[7]");
    wait.until(ExpectedConditions.visibilityOfElementLocated(openBy));
    WebElement playList = driver.findElement(openBy);
    js.executeScript("arguments[0].scrollIntoView();", playList);

    Actions actions = new Actions(driver);
    actions.contextClick(playList).perform();

    By editBy = By.xpath("(//*[@class='wC9sIed7pfp47wZbmU6m'])[3]");
    wait.until(ExpectedConditions.visibilityOfElementLocated(editBy));
    WebElement edit = driver.findElement(editBy);
    edit.click();

    WebElement editDetails = getEditDetails();
    editDetails.sendKeys(Keys.COMMAND + "A");
    editDetails.sendKeys(newName);
    editDetails.sendKeys(Keys.RETURN);

    WebElement save = driver.findElement(By.xpath("//span[@class='ButtonInner-sc-14ud5tc-0 ODKlM encore-inverted-light-set']"));
    save.click();
    logger.info("Save button was clicked successfully." + save);
}
 private WebElement getEditDetails(){
        By editDetailsBy = By.xpath("//*[@class='f0GjZQZc4c_bKpqdyKbq JaGLdeBa2UaUMBT44vqI']");
        wait.until(ExpectedConditions.elementToBeClickable(editDetailsBy));
        return driver.findElement(editDetailsBy);
    }
////////////////////////////////////////////////////////////////////////////////////////// add song to play list and play it

 public void addSongToPlayList(String name){
     JavascriptExecutor js = (JavascriptExecutor) driver;

     By searchBy = By.xpath("(//*[@class='Type__TypeElement-sc-goli3j-0 bhIkbK'])[2]");
     wait.until(ExpectedConditions.visibilityOfElementLocated(searchBy));
     WebElement search = driver.findElement(searchBy);
     search.click();

     By searchFieldBy = By.xpath("//input[@class='Type__TypeElement-sc-goli3j-0 eMzEmF QO9loc33XC50mMRUCIvf']");
     wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldBy));
     WebElement searchField = driver.findElement(searchFieldBy);
     searchField.click();
     searchField.sendKeys(name);

     By imageBy = By.xpath("//div[@class='eITFAR9yPwhjL_2gxB09']");
     wait.until(ExpectedConditions.elementToBeClickable(imageBy));
     WebElement image = driver.findElement(imageBy);
     js.executeScript("arguments[0].scrollIntoView();", image);
     image.click();

     By heartBy = By.xpath("//*[@class='RbsCNNM9a0WkFCM2UzBA']"); // It clicked on the heart //*[@class='RbsCNNM9a0WkFCM2UzBA']
     wait.until(ExpectedConditions.visibilityOfElementLocated(heartBy));
     WebElement heart = driver.findElement(heartBy);
     heart.click();
 }

     public boolean isHeart(){ //catching when song was added to library by clicking on the Heart button!
        By heartBy = By.xpath("//*[@class='RbsCNNM9a0WkFCM2UzBA SPC4uzYXJmknkCGKpxHw']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(heartBy));
            return true;
        } catch (TimeoutException error){
            return false;
        }
     }
 ////////////////////////////////////////////////////
    public void favoritesSong(){ //It worked
        JavascriptExecutor js = (JavascriptExecutor) driver;

        By accountBy = By.xpath("//*[@class='KdxlBanhDJjzmHfqhP0X m95Ymx847hCaxHjmyXKX']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountBy));
        WebElement account = driver.findElement(accountBy);
        account.click();

        WebElement profile = driver.findElement(By.xpath("//a[@href='/user/31vlqyr2pevkjmw2vbblanl3h6au']"));
        profile.click();

        By imageBy = By.xpath("(//div[@class='tsv7E_RBBw6v0XTQlcRo'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(imageBy));
        WebElement image = driver.findElement(imageBy);
        image.click();

        By playBy = By.xpath("(//span[@class='Type__TypeElement-sc-goli3j-0 hkczJp VrRwdIZO0sRX1lsWxJBe'])[5]"); //This Xpath worked to play a song!
        wait.until(ExpectedConditions.visibilityOfElementLocated(playBy));
        WebElement play = driver.findElement(playBy);
        js.executeScript("arguments[0].scrollIntoView();", play);
        play.click();

    }

    public void openMyPlayListSong(){ //It worked
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);


        By playListBy = By.xpath("(//*[@class='Areas__HeaderArea-sc-8gfrea-3 fInrEV'])[4]");
        wait.until(ExpectedConditions.elementToBeClickable(playListBy));
        WebElement playList = driver.findElement(playListBy);
        js.executeScript("arguments[0].scrollIntoView();", playList);
        actions.doubleClick(playList).perform();

        By playBy = By.xpath("(//span[@class='Type__TypeElement-sc-goli3j-0 hkczJp VrRwdIZO0sRX1lsWxJBe'])[22]"); //This Xpath worked to play a song!
        wait.until(ExpectedConditions.visibilityOfElementLocated(playBy));
        WebElement play = driver.findElement(playBy);
        js.executeScript("arguments[0].scrollIntoView();", play);
        play.click();

    }

    public void clickOnThreeDots() { //It worked after I hover over whole line and then three dots showed up, and I clicked on them!
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By playListBy = By.xpath("(//*[@class='Areas__HeaderArea-sc-8gfrea-3 fInrEV'])[4]");
        wait.until(ExpectedConditions.elementToBeClickable(playListBy));
        WebElement playList = driver.findElement(playListBy);
        js.executeScript("arguments[0].scrollIntoView();", playList);
        actions.doubleClick(playList).perform();

        By allBy = By.xpath("(//*[@class='h4HgbO_Uu1JYg5UGANeQ wTUruPetkKdWAR1dd6w4'])[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allBy));
        WebElement all = driver.findElement(allBy);
        actions.moveToElement(all).perform();

        By threeDotsBy = By.xpath("(//*[@class='T0anrkk_QA4IAQL29get mYN_ST1TsDdC6q1k1_xs'])[2]"); //(//*[@class='T0anrkk_QA4IAQL29get mYN_ST1TsDdC6q1k1_xs'])[1]
        wait.until(ExpectedConditions.elementToBeClickable(threeDotsBy));
        WebElement threeDots = driver.findElement(threeDotsBy);
        //js.executeScript("arguments[0].scrollIntoView(true);", threeDots);
        threeDots.click();

        WebElement artist = driver.findElement(By.xpath("(//*[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line PDPsYDh4ntfQE3B4duUI'])[3]"));
        artist.click();
    }

    public boolean isJahKhalib(){
        By confirmedBy = By.xpath("//*[@class='Type__TypeElement-sc-goli3j-0 fLMRCf']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(confirmedBy));
            return true;
        } catch (TimeoutException error){
            return false;
        }
    }
    public void openArtist() { //----It worked!--------
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By playListBy = By.xpath("(//*[@class='Areas__HeaderArea-sc-8gfrea-3 fInrEV'])[4]");
        wait.until(ExpectedConditions.elementToBeClickable(playListBy));
        WebElement playList = driver.findElement(playListBy);
        js.executeScript("arguments[0].scrollIntoView();", playList);
        actions.doubleClick(playList).perform();

        By allBy = By.xpath("(//*[@class='h4HgbO_Uu1JYg5UGANeQ wTUruPetkKdWAR1dd6w4'])[7]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allBy));
        WebElement all = driver.findElement(allBy);
        actions.moveToElement(all).perform();

        By threeDotsBy = By.xpath("(//*[@class='T0anrkk_QA4IAQL29get mYN_ST1TsDdC6q1k1_xs'])[7]");
        wait.until(ExpectedConditions.elementToBeClickable(threeDotsBy));
        WebElement threeDots = driver.findElement(threeDotsBy);
        threeDots.click();

        WebElement goToArtist = driver.findElement(By.xpath("(//*[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line PDPsYDh4ntfQE3B4duUI'])[2]"));
        js.executeScript("arguments[0].scrollIntoView();", goToArtist);
        goToArtist.click();
    }

    public boolean isArtist(){
        By artistBy = By.xpath("//*[@class='Type__TypeElement-sc-goli3j-0 fLMRCf']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(artistBy));
            return true;
        } catch (TimeoutException error){
            return false;
        }
    }

    public void adding_thePodcast_toThePlayList(String name){ //It worked
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By searchBy = By.xpath("(//*[@class='Type__TypeElement-sc-goli3j-0 bhIkbK'])[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBy));
        WebElement search = driver.findElement(searchBy);
        search.click();

        By searchFieldBy = By.xpath("//input[@class='Type__TypeElement-sc-goli3j-0 eMzEmF QO9loc33XC50mMRUCIvf']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldBy));
        WebElement searchField = driver.findElement(searchFieldBy);
        searchField.click();
        searchField.sendKeys(name);

        By imageBy = By.xpath("//div[@class='_gB1lxCfXeR8_Wze5Cx9']");
        wait.until(ExpectedConditions.elementToBeClickable(imageBy));
        WebElement image = driver.findElement(imageBy);
        image.click();

        By allBy = By.xpath("(//div[@class='TT1tIewS2iI8Uz8kLuQB te8hrsPnSvx9SUkzV0ME'])[10]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allBy));
        WebElement all = driver.findElement(allBy);
        actions.moveToElement(all).perform();

        By threeDotsBy = By.xpath("(//*[@class='T0anrkk_QA4IAQL29get'])[12]");
        wait.until(ExpectedConditions.elementToBeClickable(threeDotsBy));
        WebElement threeDots = driver.findElement(threeDotsBy);
        threeDots.click();

        By addToPlayListBy = By.xpath("(//*[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToPlayListBy));
        WebElement addToPlayList = driver.findElement(addToPlayListBy);
        actions.moveToElement(addToPlayList).perform();

        WebElement picasso = driver.findElement(By.xpath("(//span[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line PDPsYDh4ntfQE3B4duUI'])[11]"));
        picasso.click();
    }

    public void removePodcast(){ //it worked
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By playListBy = By.xpath("(//*[@class='Areas__HeaderArea-sc-8gfrea-3 fInrEV'])[4]");
        wait.until(ExpectedConditions.elementToBeClickable(playListBy));
        WebElement playList = driver.findElement(playListBy);
        js.executeScript("arguments[0].scrollIntoView();", playList);
        actions.doubleClick(playList).perform();

        By allBy = By.xpath("(//*[@class='h4HgbO_Uu1JYg5UGANeQ wTUruPetkKdWAR1dd6w4'])[3]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allBy));
        WebElement all = driver.findElement(allBy);
        actions.moveToElement(all).perform();

        By threeDotsBy = By.xpath("(//*[@class='T0anrkk_QA4IAQL29get mYN_ST1TsDdC6q1k1_xs'])[4]");
        wait.until(ExpectedConditions.elementToBeClickable(threeDotsBy));
        WebElement threeDots = driver.findElement(threeDotsBy);
        threeDots.click();

        WebElement remove = driver.findElement(By.xpath("(//span[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line PDPsYDh4ntfQE3B4duUI'])[3]"));
        remove.click();
    }



    ////////////////////////////////////////////////









/////////////////////////////////////////////////////

}
