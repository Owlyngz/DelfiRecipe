package shopTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WomenShopTest {

    //Выносим WebDriver на уровень класса, что бы он был доступен во всех методах этого класса
    private WebDriver driver;   // CHTO ETO BILO? CHTOB SNIZU PODRGRUZHALISJ (driver.findelemnt..)?

    private final String HOME_PAGE = "http://automationpractice.com";
    private final By MAIN_MENU_ITEMS = By.xpath(".//ul[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a");
    private final By FILTER_CHECK_BOX = By.xpath(".//ul[@class = 'col-lg-12 layered_filter_ul']/li/label");
    private final By COLOR_FILTER = By.xpath(".//ul[@class = 'col-lg-12 layered_filter_ul color-group']/li/label");
    private final By LOADER = By.xpath(".//ul[@class = 'product_list grid row']/p");
    private final By LIST_VIEW_ICON = By.className("icon-th-list");
    private final By Add1stItem = By.xpath(".//*[@class= 'button ajax_add_to_cart_button btn btn-default'][1]");
    private final By popupClose = By.xpath(".//div[@id= 'layer_cart' and contains(@style, 'display: block' )]");
    private final By Cross_close = By.xpath(".//span[@class= 'cross']");
    private final By Add2Item = By.xpath(".//*[@class= 'product_list row list']/li[2]//*[@class= 'button ajax_add_to_cart_button btn btn-default'][1]"); //pochemu srabloalo toljko dobaviv [1] ?
    private final By ProceedToCheckOut = By.xpath(".//*[@class= 'btn btn-default button button-medium']");
    private final By FirstDressPrice = By.xpath(".//tr[1]/td[@class='cart_total']/span");
    private final By SecondDressPrice = By.xpath(".//tr[2]/td[@class='cart_total']/span");
    private final By TotalSum = By.xpath(".//*[@class='cart_total_price'][3]/td[2]/span");

    private final Logger LOGGER = LogManager.getLogger(WomenShopTest.class);

    @Test
    public void dressesTest() {
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        //код, который потом может быть использован в других тестах, выносим в отдельный метод, который потом просто вызываем подавая параметры
        selectMenuItem("WOMEN");

        //здесь вызываем метод, который заселектит нужный нам чек бокс в определённом фильтре
        selectFilter("Dresses", FILTER_CHECK_BOX);
        waitLoad();

        selectFilter("Orange", COLOR_FILTER);
        waitLoad();

        driver.findElement(LIST_VIEW_ICON).click();
        driver.findElement(Add1stItem).click();
        waitPopup(popupClose);
        driver.findElement(Cross_close).click();
        driver.findElement(Add2Item).click();
        waitPopup(popupClose);
        driver.findElement(ProceedToCheckOut).click();
        String dressPrice1 = driver.findElement(FirstDressPrice).getText().substring(1); // получаем текст ($26.00) и убираем первый символ
        String dressPrice2 = driver.findElement(SecondDressPrice).getText().substring(1);
        String dressTotal = driver.findElement(TotalSum).getText().substring(1);
        countMethod(dressPrice1, dressPrice2, dressTotal);
        //
        //int num1 = 5;
        // int num2 = 10;
        //CombineSum(num1,num2);
        //int CombineSum(int num1, int num2){

    }

    //


       /* ((FirefoxDriver) driver).executeScript("arguments[0].setAttribute('class','cross xh-highlight hovered')",WebElement);
        WebElement Cross = driver.findElement(Cross_close);
        Cross.click();*/

    // driver.findElement(Cross).click();
    //webElement  = driver.findElement(ORANGE);  ETO TAKOJ ZHE SPOSOB ILI V CHEM RAZNICA?
    //webElement.click();


    //Этот метод может использоваться для выбора любого пункта основного менюб надо его только передать как параметр
    private void selectMenuItem(String menuItem) {
        List<WebElement> menuItems = driver.findElements(MAIN_MENU_ITEMS);

        //цикл: принимает 3 параметра: с какого элемента обходим, по какой элемент, с каким шагом
        //если не знаем количество элементов в списке - метод .size возвращает кол-во элементов
        for (int i = 0; i < menuItems.size(); i++) {                                                  //KAK ETO RABOTALO? V PLANE POOCHERJEDNOSTI I VSEH ZNAKOV
            //.equals - в случае работы со строками - проверяет на полное совпадение строк
            if (menuItems.get(i).getText().equals(menuItem)) {
                menuItems.get(i).click();
                break;
            }
        }
    }

    private void selectFilter(String filterName, By locator) {
        List<WebElement> filterItems = driver.findElements(locator);

        //аналог цикла for - данная запись должна быть использована если обходим все элементы списка
        //1. Указываем с какими объектами работаем - WebElement (именно из них состоит список, который обходим)
        //2. Указываем название - через это название мы раблтаем с каждым элементом списка
        //3. После двоеточия указываем какой список обходим
        for (WebElement filterItem : filterItems) {
            //.contains - в случае работы со строками - проверяет на частичное совпадение строк
            if (filterItem.getText().contains(filterName)) {
                filterItem.click();
                break;
            }
        }
    }

    //Ожидание, указываем "окно браузера" в котором ждём, таимаут - сколько максимум времени ждём, далее указываем условие которое ожидаем
    //Селениум будет постоянно проверять, выполнилось ли условие, если да - не ждём до конца - идём дальше - так экономим время
    private void waitLoad() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(LOADER));
    }
    private void waitPopup(By parameter) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(parameter));
        //        //new WebDriverWait(driver, 10).until();//ExpectedConditions.invisibilityOfElementLocated(parameter));
    }

    /*public static void main(String args[]) {
        float num1 = 26, num2 = (float) 28.98;
        float total = (float) 54.98;
        System.out.println(countMethod(num1, num2, total));

    }*/

    public static boolean countMethod(String num1, String num2, String total) {
        float number1 = Float.parseFloat(num1); // Перевод из текста в число флоат
        float number2 = Float.parseFloat(num2);
        float sum = Float.parseFloat(total);

        if (number1 + number2 == sum) {
            System.out.println(number1 + number2 + " = Sum is correct. In cart its " + sum);
            return true;
        } else {
            System.out.println(number1 + number2 + " = Sum is incorrect. In cart its " + sum);
            return false;
//nado bilo cherez Asserts
        }
    }
}


